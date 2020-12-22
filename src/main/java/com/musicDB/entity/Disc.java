package com.musicDB.entity;

import java.util.Arrays;
import java.util.Date;

public class Disc {

    private Song[] songs;
    private Date releaseDate;

    public Disc() {
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Song[] getSongs() {
        return songs;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "songs=" + Arrays.toString(songs) +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
