package com.musicDB.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.musicDB.entity.Song;
import com.musicDB.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongRestController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/{songId}")
    public Song getSongById(@PathVariable long songId) {
        Song song = songService.getSong(songId);

        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find song");
        }

        return song;
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @PatchMapping(path = "/{songId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Song patchSong(@PathVariable long songId, @RequestBody JsonNode body) {
        // only replace the fields in the body. Currently broken :(
        return songService.patchSong(songId, body);
    }

    @PutMapping("/{songId}")
    public Song putSong(@PathVariable long songId, @RequestBody Song song) {
        // replace all fields in song for the ones in the body. Create if it doesn't exist. Idempotent
        return songService.putSong(songId, song);
    }

    @DeleteMapping("/{songId}")
    public void deleteSong(@PathVariable long songId) {
        songService.deleteSong(songId);
    }
}
