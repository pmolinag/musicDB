package com.musicDB.rest;

import com.musicDB.entity.Song;
import com.musicDB.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongRestController {

    @Autowired
    private SongService songService;

    @GetMapping()
    public List<Song> getSongs() {
        return songService.getSongs();
    }
}
