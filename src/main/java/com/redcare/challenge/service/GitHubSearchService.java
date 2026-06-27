package com.redcare.challenge.service;

import com.redcare.challenge.client.GithubClient;
import com.redcare.challenge.dto.github.SearchResponse;
import com.redcare.challenge.dto.request.RepositorySearchRequest;
import org.springframework.stereotype.Service;

@Service
public class GitHubSearchService {

    private final GithubClient githubClient;

    public GitHubSearchService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public SearchResponse searchRepositories(RepositorySearchRequest request) {
        return githubClient.searchRepositories(
                request.language(),
                request.createdAfter(),
                request.limit()
        );
    }
}