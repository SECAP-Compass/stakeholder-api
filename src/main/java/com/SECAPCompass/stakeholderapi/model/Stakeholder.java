package com.SECAPCompass.stakeholderapi.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Entity
public class Stakeholder{
    @Id
    @GeneratedValue
    private UUID id;
    private final String userName;
    private final String eMail;
    private String name;
    private String surname;
    private String city;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussion_id")
    private List<Discussion> discussions;
    @Autowired
    public Stakeholder(String userName, String eMail, String name, String surname, String city) {
        this.userName = userName;
        this.eMail = eMail;
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
