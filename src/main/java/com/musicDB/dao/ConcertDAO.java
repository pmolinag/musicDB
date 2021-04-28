package com.musicDB.dao;

import com.musicDB.entity.Concert;
import com.musicDB.entity.Song;

import java.util.List;

public interface ConcertDAO {
    List<Concert> getConcerts();
    Concert getConcertById(long concertId);
    List<Song> getConcertSongs(long concertId);
    Concert createConcert(Concert concert);
    Concert putConcert(long ConcertId, Concert concert);
    void deleteConcert(long concertId);
    void setConcertSongs(long concertId, List<Integer> songIds);
}
