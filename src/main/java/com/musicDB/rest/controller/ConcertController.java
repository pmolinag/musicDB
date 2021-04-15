package com.musicDB.rest.controller;

import com.musicDB.entity.Disc;
import com.musicDB.entity.Song;
import com.musicDB.entity.Concert;
import com.musicDB.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/concerts")
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    @GetMapping()
    public List<Concert> getConcerts(@RequestParam(value = "searchPattern", required = false) String searchPattern) {
        return concertService.getConcerts();
    }

    @GetMapping("/{concertId}")
    public Concert getConcertById(@PathVariable Long concertId) {
        return concertService.getConcertById(concertId);
    }

    @GetMapping("/{concertId}/songs")
    public List<Song> getConcertSongs(@PathVariable Long concertId) {
        return concertService.getConcertSongs(concertId);
    }

    @PostMapping
    public Concert createConcert(@RequestBody Concert concert) {
        return concertService.createConcert(concert);
    }

    @PostMapping("/{concertId}/songs")
    public String setConcertSongs(@PathVariable Long concertId, @RequestBody List<Integer> songIds) {
        concertService.setConcertSongs(concertId, songIds);
        return "Update finished";
    }
}
