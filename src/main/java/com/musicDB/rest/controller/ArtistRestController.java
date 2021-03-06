package com.musicDB.rest.controller;

import com.musicDB.entity.Artist;
import com.musicDB.entity.Disc;
import com.musicDB.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistRestController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<Artist> getArtists() {
        return artistService.getArtists();
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }

    @PostMapping("/{artistId}/discs")
    public Disc createArtistDisc(@PathVariable Long artistId, @RequestBody Disc disc) {
        return artistService.createArtistDisc(artistId, disc);
    }

    @GetMapping("/{artistId}/discs")
    public List<Disc> getArtistDiscs(@PathVariable Long artistId) {
        return artistService.getArtistDiscs(artistId);
    }
}
