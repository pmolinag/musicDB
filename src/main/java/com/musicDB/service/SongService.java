package com.musicDB.service;

import com.musicDB.entity.Song;

import java.util.List;

public interface SongService {
    public List<Song> getSongs();
    public Song getSong(long songId);
    public Song createSong(Song song);
    public Song putSong(long songId, Song song);
    public Song patchSong(long songId, Song song);
    public void deleteSong(long songId);
}
