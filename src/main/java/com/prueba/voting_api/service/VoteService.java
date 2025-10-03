package com.prueba.voting_api.service;
import com.prueba.voting_api.model.Candidate;
import com.prueba.voting_api.model.Vote;
import com.prueba.voting_api.model.Voter;
import com.prueba.voting_api.repository.CandidateRepository;
import com.prueba.voting_api.repository.VoteRepository;
import com.prueba.voting_api.repository.VoterRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;

    public VoteService(VoteRepository voteRepository, VoterRepository voterRepository, CandidateRepository candidateRepository) {
        this.voteRepository = voteRepository;
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
    }

    public String castVote(Long voterId, Long candidateId) {
        Voter voter = voterRepository.findById(voterId)
                .orElseThrow(() -> new RuntimeException("Votante no encontrado."));
        

        if (voteRepository.findByVoter(voter).isPresent()) {
            return "Este votante ya emitió su voto.";
        }

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidato no encontrado."));

        Vote vote = new Vote(voter, candidate);
        voteRepository.save(vote);

        candidate.setVotes(candidate.getVotes() + 1);
        candidateRepository.save(candidate);

        return "¡Voto registrado con éxito! Para el candidato: " + candidate.getName();
    }

    public Map<String, Object> getResults() {
        List<Candidate> candidates = candidateRepository.findAll();
        long totalVotes = candidates.stream().mapToLong(Candidate::getVotes).sum();

        List<Map<String, Object>> results = candidates.stream()
                .map(c -> {
                    Map<String, Object> candidateResult = new HashMap<>();
                    candidateResult.put("Candidato", c.getName());
                    candidateResult.put("Votos", c.getVotes());
                    double percentage = totalVotes == 0 ? 0.0 : (c.getVotes() * 100.0) / totalVotes;
                    candidateResult.put("Porcentaje", Math.round(percentage * 100.0) / 100.0 + "%");
                    return candidateResult;
                })
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("Total votos", totalVotes);
        response.put("Resultados", results);

        return response;
    }

}
