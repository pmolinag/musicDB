package com.musicDB.rest;

import com.musicDB.dao.SongDAO;
import com.musicDB.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/song")
@Transactional
public class SongRestController {

    @Autowired
    private SongDAO songDAO;

    @GetMapping()
    public List<Song> getSongs() {
        return songDAO.getSongs();
    }
}
