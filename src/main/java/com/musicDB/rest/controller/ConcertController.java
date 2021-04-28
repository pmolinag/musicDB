package com.musicDB.rest.controller;

import com.musicDB.entity.Disc;
import com.musicDB.entity.Song;
import com.musicDB.entity.Concert;
import com.musicDB.service.ConcertService;
import main.java.com.musicDB.errors.ConcertErrorResponse;
import main.java.com.musicDB.errors.ConcertNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler
    public ResponseEntity<ConcertErrorResponse> handleException(ConcertNotFoundException exc){
        // Prepare response for NOT FOUND concert situation.
        ConcertErrorResponse resp = new ConcertErrorResponse();
        resp.setStatus(HttpStatus.NOT_FOUND.value());
        resp.setMessage(exc.getMessage());
        resp.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
}
