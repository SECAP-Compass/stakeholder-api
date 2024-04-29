package com.SECAPCompass.stakeholderapi.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException{
    private final String clas;
    private final Object o;
    public EntityNotFoundException(String message,String clas,Object o) {
        super(message);
        this.clas = clas;
        this.o = o;
    }

    public String getClas() {
        return clas;
    }

    public Object getO() {
        return o;
    }
}
