package com.prueba.voting_api.controller;
import com.prueba.voting_api.service.VoteService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public String castVote(@RequestParam Long voterId, @RequestParam Long candidateId) {
        return voteService.castVote(voterId, candidateId);
    }

    @GetMapping("/results")
    public Map<String, Object> getResults() {
        return voteService.getResults();
    }
}

