package com.prueba.voting_api.controller;

import com.prueba.voting_api.model.Voter;
import com.prueba.voting_api.service.VoterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voters")
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @PostMapping
    public ResponseEntity<Voter> createVoter(@RequestBody Voter voter) {
        Voter savedVoter = voterService.saveVoter(voter);
        return ResponseEntity.ok(savedVoter);
    }

    @GetMapping
    public ResponseEntity<List<Voter>> getAllVoters() {
        return ResponseEntity.ok(voterService.getAllVoters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voter> getVoterById(@PathVariable Long id) {
        Optional<Voter> voter = voterService.getVoterById(id);
        return voter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoter(@PathVariable Long id) {
        voterService.deleteVoter(id);
        return ResponseEntity.noContent().build();
    }
}
