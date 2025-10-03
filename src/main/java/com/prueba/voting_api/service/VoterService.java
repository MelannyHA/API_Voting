package com.prueba.voting_api.service;

import com.prueba.voting_api.model.Voter;
import com.prueba.voting_api.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public Voter saveVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Optional<Voter> getVoterById(Long id) {
        return voterRepository.findById(id);
    }

    public void deleteVoter(Long id) {
        voterRepository.deleteById(id);
    }
}
