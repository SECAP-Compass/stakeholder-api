package com.SECAPCompass.stakeholderapi.model;

import java.time.Instant;

import jakarta.persistence.*;

@Entity
public class Comment extends BaseText{
    private Integer commentOrder;
    private Instant removeInstant;
    private Boolean isRemoved;
    private Boolean isUpdated;
    private Instant updateInstant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stakeholder_id")
    private Stakeholder stakeholder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    public Comment(String body, Stakeholder stakeholder, Discussion discussion) {
        super(body);
        this.isRemoved = false;
        this.stakeholder = stakeholder;
        this.discussion = discussion;
        this.isUpdated = false;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public void setUpdated(Boolean updated) {
        isUpdated = updated;
    }

    public Instant getUpdateInstant() {
        return updateInstant;
    }

    public void setUpdateInstant(Instant updateInstant) {
        this.updateInstant = updateInstant;
    }

    public Integer getCommentOrder() {
        return commentOrder;
    }

    public void setCommentOrder(Integer commentOrder) {
        this.commentOrder = commentOrder;
    }

    public Instant getRemoveInstant() {
        return removeInstant;
    }

    public void setRemoveInstant(Instant removeInstant) {
        this.removeInstant = removeInstant;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
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
