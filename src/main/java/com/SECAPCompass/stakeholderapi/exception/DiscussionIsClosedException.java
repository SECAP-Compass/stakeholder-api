package com.SECAPCompass.stakeholderapi.exception;

import com.SECAPCompass.stakeholderapi.model.Discussion;

import java.util.UUID;

public class DiscussionIsClosedException extends RuntimeException{

    private final UUID id;

    public DiscussionIsClosedException(String message, UUID id) {
        super(message);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
