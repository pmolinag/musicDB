package com.musicDB.service;

import com.musicDB.entity.Disc;
import com.musicDB.entity.Song;
import com.musicDB.repositories.DiscRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscServiceImpl implements DiscService {

    @Autowired
    private DiscRepository discRepository;

    @Transactional
    public List<Disc> getDiscs() {
        return discRepository.getDiscs();
    }

    @Transactional
    public List<Disc> searchDiscs(String pattern) {
        return discRepository.searchDiscs(pattern);
    }

    @Transactional
    public Disc getDiscById(Long discId) {
        return discRepository.getDiscById(discId);
    }

    @Transactional
    public List<Song> getDiscSongs(Long discId) {
        return discRepository.getDiscSongs(discId);
    }

    @Transactional
    public Song createDiscSong(Long discId, Song song) {
        return discRepository.createDiscSong(discId, song);
    }
}
