package com.SECAPCompass.stakeholderapi.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException{
    private final String clas;

    public EntityNotFoundException(String message, String clas) {
        super(message);
        this.clas = clas;
    }

    public String getClas() {
        return clas;
    }
}
