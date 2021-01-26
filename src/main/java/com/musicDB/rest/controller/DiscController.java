package com.musicDB.rest.controller;

import com.musicDB.entity.Disc;
import com.musicDB.service.DiscService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/discs")
public class DiscController {

    @Autowired
    private DiscService discService;

    @GetMapping()
    public List<Disc> getDiscs() {
        return discService.getDiscs();
    }

//    @GetMapping("/{discId}")
//    public String getDiscFromId(@PathVariable int discId) {
//        return discs.get(discId).toString();
//    }
//
//    @GetMapping("/{discId}/songs")
//    public List<Song> getSongsFromDisc(@PathVariable int discId) {
//
//    }

}
