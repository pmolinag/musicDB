package com.musicDB.dao;

import com.musicDB.entity.Artist;

import java.util.List;

public interface ArtistDAO {
    List<Artist> getArtists();
    Artist createArtist(Artist artist);
}
