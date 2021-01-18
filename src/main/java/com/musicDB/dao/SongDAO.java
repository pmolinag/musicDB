package com.musicDB.dao;

import com.musicDB.entity.Song;

import java.util.List;

public interface SongDAO {
    public List<Song> getSongs();
    public Song getSong(long songId);
}
