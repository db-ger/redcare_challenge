package com.redcare.challenge.controller;

import com.redcare.challenge.dto.request.RepositorySearchRequest;
import com.redcare.challenge.dto.response.RepositoryScoreResponse;
import com.redcare.challenge.service.GitHubPopularityService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/repositories")
@Validated
public class PopularityController {

    private final GitHubPopularityService popularityService;

    public PopularityController(GitHubPopularityService popularityService) {
        this.popularityService = popularityService;
    }

    @GetMapping
    public List<RepositoryScoreResponse> searchRepositories(@Valid @ModelAttribute RepositorySearchRequest request) {
        return popularityService.getScoreFor(request);
    }
}