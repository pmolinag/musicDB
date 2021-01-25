package com.musicDB.rest.controller;

import com.musicDB.entity.Artist;
import com.musicDB.entity.Disc;
import com.musicDB.entity.Song;
import com.musicDB.service.DiscService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/discs")
public class DiscController {

    List<Disc> discs = new ArrayList<>();
    List<Song> songs = new ArrayList<>();
    Artist artist = new Artist(0, "Pablo", "Molina", null);

    @Autowired
    public DiscService discService;

    @PostConstruct
    public void loadData() {
      songs.add(new Song(0, "primera", 5));
      songs.add(new Song(1, "segunda", 5));
      discs.add(new Disc(0, songs, artist));
      artist.setDiscs(discs);
    };

    @GetMapping()
    public String getDiscs() {
        return discs.toString();
    }

    @GetMapping("/{discId}")
    public String getDiscFromId(@PathVariable int discId) {
        return discs.get(discId).toString();
    }

    @GetMapping("/{discId}/songs")
    public List<Song> getSongsFromDisc(@PathVariable int discId) {
        return discs.get(discId).getSongs();
    }

}
