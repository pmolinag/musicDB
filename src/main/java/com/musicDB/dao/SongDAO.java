package com.musicDB.dao;

import com.musicDB.entity.Song;

import java.util.List;

public interface SongDAO {
    List<Song> getSongs();
    Song getSong(long songId);
    Song createSong(Song song);
    Song putSong(long songId, Song song);
    Song patchSong(long songId, Song song);
    void deleteSong(long songId);
}
