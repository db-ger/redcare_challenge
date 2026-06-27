package com.redcare.challenge.service;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class BetterScoringService implements ScoringService {

    @Override
    public int calculateScore(int stars, int forks, Instant updatedAt) {

        // Example of how a more sophisticated scoring strategy
        // could be introduced in the future.

        throw new NotImplementedException();
    }
}