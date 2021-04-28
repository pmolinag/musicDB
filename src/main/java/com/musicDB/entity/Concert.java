package com.musicDB.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.sql.Date;
import com.musicDB.entity.Song;
import java.util.List;

/*
This Concert class represents a music concert where multiple songs can take place
(many to many) at a given date.
- Only one concert can take place per day.
 */

@Entity
@Table(name = "concert")
public class Concert {

    // Concert id following DB generation strategy.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Load the songs from the "concert_song" table
    // Note this a resulting table from the N:M relationship Concert-Song.
    @ManyToMany(
            targetEntity = Song.class,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name = "concert_song",
            joinColumns = @JoinColumn(name="concert_id"),
            inverseJoinColumns = @JoinColumn(name="song_id")
    )
    private List<Song> songs;

    // Date when the concert is held *UNIQUE*
    // JsonFormat tag needed to convert string to sql Date correctly.
    @Basic
    @JsonFormat(pattern="yyyyMMdd")
    @Column(name = "date")
    private java.sql.Date date;

    public Concert() {

    }

    public Concert(Long id, List<Song> songs, java.sql.Date date){
        this.id = id;
        this.songs = songs;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "id=" + id +
                ", songs='" + songs + '\'' +
                ", date='" + date +
                '}';
    }
}
