package com.musicDB.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Disc entity.
 */
@Entity
@Table(name = "disc", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "artist_id"}))
public class Disc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "disc", targetEntity = Song.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;

    @ManyToOne(targetEntity = Artist.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    public Disc() {
    }

    public Disc(Long id, String title, List<Song> songs, Artist artist) {
        this.id = id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "id=" + id +
                ", title=" + title +
                ", songs=" + songs +
                ", artist=" + artist +
                '}';
    }
}
