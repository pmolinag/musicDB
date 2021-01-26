package com.musicDB.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Disc entity.
 */
@Entity
@Table(name = "discs")
public class Disc {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "songs")
    @OneToMany(cascade= CascadeType.ALL)
    private List<Song> songs;

    // TODO cambiar por tipo Artist
    @Column(name = "artist")
    private String artist;

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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "id=" + id +
                ", songs=" + songs +
                ", artist=" + artist +
                '}';
    }

    public Disc () {
    }

    public Disc (int id, List<Song> songs, String artist) {
        this.id = id;
        this.songs = songs;
        this.artist = artist;
    }
}
