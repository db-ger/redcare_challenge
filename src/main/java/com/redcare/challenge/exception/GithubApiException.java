package com.redcare.challenge.exception;

public class GithubApiException extends RuntimeException {
    public GithubApiException(String message) {
        super(message);
    }
}
