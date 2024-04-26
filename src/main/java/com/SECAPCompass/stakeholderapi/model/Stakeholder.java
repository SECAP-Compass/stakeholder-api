package com.SECAPCompass.stakeholderapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;

@Entity
public class Stakeholder{
    @Id
    private UUID id;
    private final String userName;
    private final String eMail;
    private String name;
    private String surname;
    private String city;

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
