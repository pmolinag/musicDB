package com.musicDB.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "The artist endpoint says hello!";
    }
}
