package com.SECAPCompass.stakeholderapi.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private final UUID id;
    private String comment;

    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stakeholder_id")
    private Stakeholder stakeholder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    public Comment(UUID id, String comment, Stakeholder stakeholder, Discussion discussion) {
        this.id = id;
        this.comment = comment;
        this.stakeholder = stakeholder;
        this.discussion = discussion;
    }

    public UUID getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Stakeholder getStakeholder() {
        return stakeholder;
    }

    public void setStakeholder(Stakeholder stakeholder) {
        this.stakeholder = stakeholder;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }
}
