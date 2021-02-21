package com.musicDB.entity;

import com.musicDB.annotations.PatchableField;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PatchableField
    @Column(name = "name")
    private String name;

    @PatchableField
    @Column(name = "duration")
    private int duration;

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Song(Long id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
