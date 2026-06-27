package com.redcare.challenge.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Default scoring implementation based on repository popularity and activity.
 * Stars are weighted once, forks twice, and repositories updated within
 * the last 30 days receive a small bonus.
 */
@Service
@Primary
public class DefaultScoringService implements ScoringService {

    private static final int RECENT_DAYS_THRESHOLD = 30;

    @Override
    public int calculateScore(int stars, int forks, Instant updatedAt) {
        int score = stars + forks * 2;

        long daysOld = ChronoUnit.DAYS.between(updatedAt, Instant.now());

        if (daysOld <= RECENT_DAYS_THRESHOLD) {
            score += 10;
        }

        return score;
    }
}