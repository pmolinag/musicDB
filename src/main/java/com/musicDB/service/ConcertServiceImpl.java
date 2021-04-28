package com.musicDB.service;

import com.musicDB.entity.Concert;
import com.musicDB.entity.Song;
import com.musicDB.dao.ConcertDAO;
import com.musicDB.repositories.DiscRepository;
import com.musicDB.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConcertServiceImpl implements ConcertService {

    @Autowired
    private ConcertDAO concertDAO;

    @Transactional
    public List<Concert> getConcerts() {
        return concertDAO.getConcerts();
    }

    @Transactional
    public Concert getConcertById(Long concertId) {
        return concertDAO.getConcertById(concertId);
    }

    @Transactional
    public List<Song> getConcertSongs(Long concertId) {
        return concertDAO.getConcertSongs(concertId);
    }

    @Override
    @Transactional
    public Concert createConcert(Concert concert) {
        return concertDAO.createConcert(concert);
    }

    @Override
    @Transactional
    public void setConcertSongs(Long concertId, List<Integer> songIds) {
        concertDAO.setConcertSongs(concertId, songIds);
    }
}
