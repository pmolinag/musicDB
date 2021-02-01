package com.musicDB.rest.controller;

import com.musicDB.entity.Song;
import com.musicDB.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}
