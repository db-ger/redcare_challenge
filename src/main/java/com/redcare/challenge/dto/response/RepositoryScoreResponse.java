package com.redcare.challenge.dto.response;

import java.time.Instant;

public record RepositoryScoreResponse(
        String name,
        String fullName,
        String htmlUrl,
        String description,
        String language,
        int stars,
        int forks,
        Instant createdAt,
        Instant updatedAt,
        double popularityScore
) {
}
