package com.SECAPCompass.stakeholderapi.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue
    private UUID id;
    private final String userName;
    private final String eMail;
    private String name;
    private String surname;

    public User(String userName, String eMail, String name, String surname) {
        this.userName = userName;
        this.eMail = eMail;
        this.name = name;
        this.surname = surname;
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
}
