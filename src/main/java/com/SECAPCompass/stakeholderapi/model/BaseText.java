package com.SECAPCompass.stakeholderapi.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.UUID;

public abstract class BaseText {
    @Id
    @GeneratedValue
    private UUID id;
    private String body;
    private Instant createInstant;
    private Boolean isEdited;
    private Instant editInstant;

    public BaseText(String body) {
        this.body = body;
        this.createInstant = Instant.now();
        this.isEdited = false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Instant getCreateInstant() {
        return createInstant;
    }

    public void setCreateInstant(Instant createInstant) {
        this.createInstant = createInstant;
    }

    public Boolean getEdited() {
        return isEdited;
    }

    public void setEdited(Boolean edited) {
        isEdited = edited;
    }

    public Instant getEditInstant() {
        return editInstant;
    }

    public void setEditInstant(Instant editInstant) {
        this.editInstant = editInstant;
    }
}
