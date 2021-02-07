package com.musicDB.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.musicDB.entity.Song;

import java.util.List;

public interface SongDAO {
    public List<Song> getSongs();
    public Song getSong(long songId);
    public Song createSong(Song song);
    public Song putSong(long songId, Song song);
    public Song patchSong(long songId, JsonNode songInfo);
    public void deleteSong(long songId);
}
