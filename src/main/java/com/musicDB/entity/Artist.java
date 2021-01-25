package com.musicDB.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

    @Id
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String lastName;

    @OneToMany
    private List<Disc> discs;

    public Artist(int id, String firstName, String lastName, List<Disc> discs) {
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

    public List<Disc> getDiscs() {
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

    public void setDiscs(List<Disc> discs) {
        this.discs = discs;
    }
}
