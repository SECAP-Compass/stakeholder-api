package com.SECAPCompass.stakeholderapi.exception;

public class UsernameNotFound extends RuntimeException{
    private final String userName;

    public UsernameNotFound(String message, String userName) {
        super(message);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
