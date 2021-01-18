package com.musicDB.service;

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
}
