package com.SECAPCompass.stakeholderapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class Stakeholder{
    private final UUID id;
    private final String userName;
    private String name;
    private String surname;
    private String city;

    public Stakeholder(@JsonProperty("id") UUID id, @JsonProperty("name") String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Stakeholder(@JsonProperty("id") UUID id, @JsonProperty("userName") String userName,
                       @JsonProperty("name") String name, @JsonProperty("surname") String surname,
                       @JsonProperty("city") String city) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
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
