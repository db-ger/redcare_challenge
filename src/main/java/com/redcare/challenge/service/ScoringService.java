package com.redcare.challenge.service;

import java.time.Instant;

/**
 * Defines a strategy for calculating a repository popularity score.
 */
public interface ScoringService {
    /**
     * Calculates a popularity score based on repository metrics.
     *
     * @param stars repository star count
     * @param forks repository fork count
     * @param updatedAt timestamp of the last update
     * @return calculated popularity score
     */
    double calculateScore(int stars, int forks, Instant updatedAt);
}