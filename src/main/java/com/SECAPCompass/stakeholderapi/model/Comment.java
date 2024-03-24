package com.SECAPCompass.stakeholderapi.model;

import java.util.UUID;

public class Comment {
    private final UUID id;
    private final UUID commenterID;
    private String comment;
    private final UUID topicID;

    public Comment(UUID id, UUID commenterID, String comment, UUID topicID) {
        this.id = id;
        this.commenterID = commenterID;
        this.comment = comment;
        this.topicID = topicID;
    }

    public UUID getId() {
        return id;
    }

    public UUID getTopicID() {
        return topicID;
    }

    public UUID getCommenterID() {
        return commenterID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
