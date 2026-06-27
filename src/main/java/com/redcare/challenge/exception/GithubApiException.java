package com.redcare.challenge.exception;

import java.io.Serial;

public class GithubApiException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 4819273506147852031L;
    public GithubApiException(String message) {
        super(message);
    }
}
