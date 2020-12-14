package com.musicDB;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

    private int id;
    private String firstName;
    private String lastName;
    private Disc[] discs;

    public Artist(int id, String firstName, String lastName, Disc[] discs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.discs = discs;
    }

    public Artist() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Disc[] getDiscs() {
        return discs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDiscs(Disc[] discs) {
        this.discs = discs;
    }
}
