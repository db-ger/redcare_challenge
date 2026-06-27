package com.redcare.challenge.dto.github;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record SearchResponse(
        @JsonProperty("total_count") int totalCount,
        List<RepositoryItem> items
) {}