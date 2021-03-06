package com.musicDB.entity;

import com.musicDB.annotations.PatchableField;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PatchableField
    @Column(name = "name")
    private String name;

    @PatchableField
    @Range(min = 0, max = 10 * 60) // 10 minutes
    @Column(name = "duration")
    private int duration;

    @ManyToOne(targetEntity = Disc.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "disc_id", referencedColumnName = "id")
    private Disc disc;

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

    public Disc getDisc() {
        return this.disc;
    }

    public void setDisc(Disc disc) {
        this.disc = disc;
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
