package com.musicDB.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Disc entity.
 */
@Entity
@Table(name = "disc")
public class Disc {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<Song> songs;

    @ManyToOne
    private Artist artist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "id=" + id +
                ", songs=" + songs +
                ", artist=" + artist.getFirstName() +
                '}';
    }

    public Disc () {
    }

    public Disc (int id, List<Song> songs, Artist artist) {
        this.id = id;
        this.songs = songs;
        this.artist = artist;
    }
}
