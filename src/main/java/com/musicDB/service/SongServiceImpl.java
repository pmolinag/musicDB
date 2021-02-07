package com.musicDB.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.musicDB.dao.SongDAO;
import com.musicDB.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongDAO songDAO;

    @Override
    @Transactional
    public List<Song> getSongs() {
        return songDAO.getSongs();
    }

    @Override
    @Transactional
    public Song getSong(long songId) {
        return songDAO.getSong(songId);
    }

    @Override
    @Transactional
    public Song createSong(Song song) {
        return songDAO.createSong(song);
    }

    @Override
    @Transactional
    public Song putSong(long songId, Song song) {
        return songDAO.putSong(songId, song);
    }

    @Override
    @Transactional
    public Song patchSong(long songId, JsonNode songInfo) {
        return songDAO.patchSong(songId, songInfo);
    }

    @Override
    @Transactional
    public void deleteSong(long songId) {
        songDAO.deleteSong(songId);
    }
}
