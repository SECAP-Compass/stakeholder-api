package com.SECAPCompass.stakeholderapi.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private final UUID id;
    private String body;
    private Integer order;

    private Instant createInstant;

    private Boolean isEdited;
    private Instant editInstant;
    private Instant removeInstant;
    private Boolean isRemoved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stakeholder_id")
    private Stakeholder stakeholder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    public Comment(UUID id, String comment, Stakeholder stakeholder, Discussion discussion) {
        this.id = id;
        this.body = comment;
        this.isRemoved = false;
        this.isEdited = false;
        this.stakeholder = stakeholder;
        this.discussion = discussion;
    }

    public UUID getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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

    public Instant getCreateInstant() {
        return createInstant;
    }

    public void setCreateInstant(Instant createInstant) {
        this.createInstant = createInstant;
    }

    public Instant getEditInstant() {
        return editInstant;
    }

    public void setEditInstant(Instant editInstant) {
        this.editInstant = editInstant;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    public Boolean getEdited() {
        return isEdited;
    }

    public void setEdited(Boolean edited) {
        isEdited = edited;
    }

    public Instant getRemoveInstant() {
        return removeInstant;
    }

    public void setRemoveInstant(Instant removeInstant) {
        this.removeInstant = removeInstant;
    }
}
