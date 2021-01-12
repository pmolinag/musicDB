package com.musicDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicDB.entity.Artist;
import com.musicDB.entity.Disc;

import java.io.File;

public class Application {

    public static void main(String[] args) {

        try {
          ObjectMapper mapper = new ObjectMapper();

            Artist theArtist = mapper.readValue(new File("data/artist.json"), Artist.class);

            System.out.println("First name " + theArtist.getFirstName());
            System.out.println("Last name " + theArtist.getLastName());

            for (Disc disc : theArtist.getDiscs()) {
                System.out.println("Discs " + disc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
