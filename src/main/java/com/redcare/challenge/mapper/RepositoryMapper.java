package com.redcare.challenge.mapper;

import com.redcare.challenge.dto.github.RepositoryItem;
import com.redcare.challenge.dto.github.SearchResponse;
import com.redcare.challenge.dto.response.RepositoryScoreResponse;
import com.redcare.challenge.service.ScoringService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositoryMapper {

    private final ScoringService scoringService;

    public RepositoryMapper(ScoringService scoringService) {
        this.scoringService = scoringService;
    }

    public List<RepositoryScoreResponse> toRepositoryScoreResponses(SearchResponse response) {
        return response.items()
                .stream()
                .map(this::toRepositoryScoreResponse)
                .toList();
    }

    public RepositoryScoreResponse toRepositoryScoreResponse(RepositoryItem item) {
        return new RepositoryScoreResponse(
                item.name(),
                item.fullName(),
                item.htmlUrl(),
                item.description(),
                item.language(),
                item.stars(),
                item.forks(),
                item.createdAt(),
                item.updatedAt(),
                scoringService.calculateScore(
                        item.stars(),
                        item.forks(),
                        item.updatedAt()
                )
        );
    }
}