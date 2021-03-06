package com.musicDB.service;

import com.musicDB.entity.Disc;
import com.musicDB.entity.Song;

import java.util.List;

public interface DiscService {

    public List<Disc> getDiscs();

    public List<Disc> searchDiscs(String pattern);

    public Disc getDiscById(Long discId);

    public List<Song> getDiscSongs(Long discId);

    public Song createDiscSong(Long discId, Song song);
}
