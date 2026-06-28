package com.redcare.challenge.mapper;

import com.redcare.challenge.dto.github.RepositoryItem;
import com.redcare.challenge.dto.response.RepositoryScoreResponse;
import com.redcare.challenge.service.ScoringService;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RepositoryMapperTest {

    private final ScoringService scoringService = mock(ScoringService.class);
    private final RepositoryMapper mapper = new RepositoryMapper(scoringService);

    @Test
    void shouldMapRepositoryItemToResponse() {
        Instant now = Instant.now();

        RepositoryItem item = new RepositoryItem(
                "challenge",
                "redcare/challenge",
                "https://github.com/redcare/challenge",
                "description",
                "Java",
                100,
                20,
                now,
                now
        );

        when(scoringService.calculateScore(100, 20, now)).thenReturn(42.0);

        RepositoryScoreResponse response = mapper.toRepositoryScoreResponse(item);

        assertEquals("challenge", response.name());
        assertEquals(42.0, response.popularityScore());
    }
}
