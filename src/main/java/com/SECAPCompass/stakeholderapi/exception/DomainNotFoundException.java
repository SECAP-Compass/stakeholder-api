package com.SECAPCompass.stakeholderapi.exception;

import java.util.UUID;

public class DomainNotFoundException extends RuntimeException{

    private final UUID domainId;
    public DomainNotFoundException(String message,UUID domainId) {
        super(message);
        this.domainId = domainId;
    }

    public UUID getDomainId() {
        return domainId;
    }
}
