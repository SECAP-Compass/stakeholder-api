package com.SECAPCompass.stakeholderapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Topic extends BaseText{
    private String topicTitle;
    private UUID ownerID;
    private String ownerName;

    public Topic(String body, String topicTitle, UUID ownerID, String ownerName) {
        super(body);
        this.topicTitle = topicTitle;
        this.ownerID = ownerID;
        this.ownerName = ownerName;
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
