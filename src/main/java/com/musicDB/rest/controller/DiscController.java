package com.musicDB.rest.controller;

import com.musicDB.entity.Disc;
import com.musicDB.entity.Song;
import com.musicDB.service.DiscService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/discs")
public class DiscController {

    @Autowired
    private DiscService discService;

    @GetMapping()
    public List<Disc> getDiscs() {
        return discService.getDiscs();
    }

    @GetMapping("/{discId}")
    public Disc getDiscById(@PathVariable Long discId) {
        return discService.getDiscById(discId);
    }

    @PostMapping("/{discId}/songs")
    public Song createDiscSong(@PathVariable Long discId, @RequestBody Song song) {
        return discService.createDiscSong(discId, song);
    }

    @GetMapping("/{discId}/songs")
    public List<Song> getDiscSongs(@PathVariable Long discId) {
        return discService.getDiscSongs(discId);
    }
}
