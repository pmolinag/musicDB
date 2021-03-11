package com.musicDB.service;

import com.musicDB.dao.ArtistDAO;
import com.musicDB.entity.Artist;
import com.musicDB.entity.Disc;
import com.musicDB.repositories.DiscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private DiscRepository discRepository;

    @Autowired
    private ArtistDAO artistDAO;

    @Override
    @Transactional
    public List<Artist> getArtists() {
        return artistDAO.getArtists();
    }

    @Override
    @Transactional
    public Artist createArtist(Artist artist) {
        return artistDAO.createArtist(artist);
    }

    @Override
    @Transactional
    public Disc createArtistDisc(Long artistId, Disc disc) {
        return discRepository.createArtistDisc(artistId, disc);
    }

    @Override
    @Transactional
    public List<Disc> getArtistDiscs(Long artistId) {
        return discRepository.getArtistDiscs(artistId);
    }
}
