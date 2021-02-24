package com.musicDB.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import javax.persistence.*;

/**
 * Disc entity.
 */
@Entity
@Table(name = "disc")
public class Disc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "disc", targetEntity = Song.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;

    @ManyToOne(targetEntity = Artist.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    public Disc() {
    }

    public Disc(Long id, List<Song> songs, Artist artist) {
        this.id = id;
        this.songs = songs;
        this.artist = artist;
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
                ", artist=" + artist +
                '}';
    }
}
