package com.musicDB.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.musicDB.enums.Gender;
import com.musicDB.validators.OverAge;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "artist")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "second_name")
    private String lastName;

    @Size(max = 200)
    @Column(name = "alias")
    private String alias;

    @NotBlank
    @Email
    @Column(name = "contact_email")
    private String email;

    @NotNull
    @OverAge
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", targetEntity = Disc.class, cascade = CascadeType.ALL)
    private List<Disc> discs;

    public Artist(Long id, String firstName, String lastName, String alias, String email, Date birthDate, Gender gender, List<Disc> discs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.discs = discs;
        this.alias = alias;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public void setDiscs(List<Disc> discs) {
        this.discs = discs;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", discs=" + discs +
                '}';
    }
}
