package com.redcare.challenge.service;

import com.redcare.challenge.dto.github.SearchResponse;
import com.redcare.challenge.dto.request.RepositorySearchRequest;
import com.redcare.challenge.dto.response.RepositoryScoreResponse;
import com.redcare.challenge.mapper.RepositoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubPopularityService {

    private final GitHubSearchService searchService;
    private final RepositoryMapper repositoryMapper;

    public GitHubPopularityService(
            GitHubSearchService searchService,
            RepositoryMapper repositoryMapper
    ) {
        this.searchService = searchService;
        this.repositoryMapper = repositoryMapper;
    }

    public List<RepositoryScoreResponse> getScoreFor(RepositorySearchRequest request) {
        SearchResponse searchResponse = searchService.searchRepositories(request);

        return repositoryMapper.toRepositoryScoreResponses(searchResponse);
    }
}