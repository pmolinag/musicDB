package com.musicDB;

public class Song {

    private String name;
    private int duration;

    public Song() {
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
