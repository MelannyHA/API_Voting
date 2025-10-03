package com.prueba.voting_api.repository;
import com.prueba.voting_api.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
