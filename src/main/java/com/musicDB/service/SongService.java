package com.musicDB.service;

import com.musicDB.entity.Song;

import java.util.List;

public interface SongService {
    public List<Song> getSongs();
    public Song getSong(long songId);
}
