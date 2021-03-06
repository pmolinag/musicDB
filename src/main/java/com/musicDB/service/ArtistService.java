package com.musicDB.service;

import com.musicDB.entity.Artist;
import com.musicDB.entity.Disc;

import java.util.List;

public interface ArtistService {
    List<Artist> getArtists();
    Artist createArtist(Artist artist);
    Disc createArtistDisc(Long artistId, Disc disc);
    List<Disc> getArtistDiscs(Long artistId);
}
