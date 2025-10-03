package com.prueba.voting_api.repository;
import com.prueba.voting_api.model.Vote;
import com.prueba.voting_api.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByVoter(Voter voter); //verifica si un votante ya tiene un voto registrado
}
