package com.musicDB.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "artist")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", targetEntity = Disc.class, cascade = CascadeType.ALL)
    private List<Disc> discs;

    public Artist(Long id, String firstName, String lastName, List<Disc> discs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.discs = discs;
    }

    public Artist() {
    }

    public Long getId() {
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

    public void setId(Long id) {
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
