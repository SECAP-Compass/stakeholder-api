package com.SECAPCompass.stakeholderapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Stakeholder {
    private final UUID id;
    private final String userName;

    public Stakeholder(@JsonProperty("id") UUID id, @JsonProperty("name") String userName) {
        this.id = id;
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
