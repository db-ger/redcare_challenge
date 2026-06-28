package com.redcare.challenge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultScoringServiceTest {

    private ScoringService scoringService;

    @BeforeEach
    void setUp() {
        scoringService = new DefaultScoringService();
    }

    @Test
    void shouldAddBonusForRecentlyUpdatedRepositories() {
        Instant tenDaysAgo = Instant.now().minus(30, ChronoUnit.DAYS);
        Instant fortyDaysAgo = Instant.now().minus(31, ChronoUnit.DAYS);

        double highScore = scoringService.calculateScore(100, 50, tenDaysAgo);
        double lowScore = scoringService.calculateScore(100, 50, fortyDaysAgo);

        assertAll("score calculation",
                () -> assertEquals(
                        210,
                        highScore,
                        () -> String.format(
                                "Repositories updated exactly 30 days ago should receive the recency bonus and have a score of 210 with 100 Stars and 50 forks, but was %.2f",
                                highScore)
                ),
                () -> assertEquals(
                        200,
                        lowScore,
                        () -> String.format(
                                "Repositories updated 31 days ago should not receive the recency bonus and have a score of 200 with 100 Stars and 50 forks, but was %.2f",
                                lowScore)
                )
        );
    }
}