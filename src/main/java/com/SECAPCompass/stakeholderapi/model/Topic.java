package com.SECAPCompass.stakeholderapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Topic {
    @Id
    @GeneratedValue
    private final UUID id;
    private String topicTitle;
    private UUID ownerID;
    private String ownerName;

    public Topic(UUID id, String topicTitle, UUID ownerID, String ownerName) {
        this.id = id;
        this.topicTitle = topicTitle;
        this.ownerID = ownerID;
        this.ownerName = ownerName;
    }

    public UUID getId() {
        return id;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public UUID getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(UUID ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
