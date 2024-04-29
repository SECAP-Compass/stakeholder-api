package com.SECAPCompass.stakeholderapi.model;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Comment extends BaseText{
    private Integer order;
    private Instant removeInstant;
    private Boolean isRemoved;

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
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
