package com.redcare.challenge.dto.github;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record RepositoryItem(
        String name,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("html_url") String htmlUrl,
        String description,
        String language,
        @JsonProperty("stargazers_count") int stars,
        @JsonProperty("forks_count") int forks,
        @JsonProperty("created_at") Instant createdAt,
        @JsonProperty("updated_at") Instant updatedAt
) {
}