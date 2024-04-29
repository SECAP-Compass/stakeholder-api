package com.SECAPCompass.stakeholderapi.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Stakeholder extends User{
    private String city;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussion_id")
    private List<Discussion> discussions;

    public Stakeholder(String userName, String eMail, String name, String surname, String city) {
        super(userName, eMail, name, surname);
        this.city = city;
        discussions = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Discussion> getDiscussions() {
        return discussions;
    }

    public void setDiscussions(List<Discussion> discussions) {
        this.discussions = discussions;
    }
}
