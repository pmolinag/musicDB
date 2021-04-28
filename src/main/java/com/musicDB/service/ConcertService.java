package com.musicDB.service;

import com.musicDB.entity.Concert;
import com.musicDB.entity.Song;

import java.util.List;

public interface ConcertService {

    public List<Concert> getConcerts();

    public Concert getConcertById(Long concertId);

    public Concert createConcert(Concert concert);

    public List<Song> getConcertSongs(Long concertId);

    public void setConcertSongs(Long concertId, List<Integer> songIds);

}
