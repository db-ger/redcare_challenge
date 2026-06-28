package com.redcare.challenge.client;

import com.redcare.challenge.config.GithubProperties;
import com.redcare.challenge.dto.github.SearchResponse;
import com.redcare.challenge.exception.GithubApiException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.List;

/**
 * Basic client for handling the requests for GitHub
 */
@Component
public class GithubClient {

    private final RestClient githubRestClient;
    private final GithubProperties properties;

    public GithubClient(RestClient githubRestClient, GithubProperties properties) {
        this.githubRestClient = githubRestClient;
        this.properties = properties;
    }

    public SearchResponse searchRepositories(String language, LocalDate createdAfter, int limit) {
        int safeLimit = Math.min(limit, properties.maxPageSize());
        String query = "language:%s created:>=%s".formatted(language.trim(), createdAfter);

        SearchResponse response = githubRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/repositories")
                        .queryParam("q", query)
                        .queryParam("sort", "stars")
                        .queryParam("order", "desc")
                        .queryParam("per_page", safeLimit)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, clientResponse) -> {
                    throw new GithubApiException("GitHub API returned status " + clientResponse.getStatusCode().value());
                })
                .body(SearchResponse.class);

        if (response == null || response.items() == null) {
            return new SearchResponse(0, List.of());
        }

        return response;
    }
}
