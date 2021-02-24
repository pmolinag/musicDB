package com.musicDB.repositories;

import com.musicDB.entity.Song;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.musicDB.entity.Disc;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Repository
public class DiscsRepository {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Disc> getDiscs() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Disc> getDiscsQuery =
                currentSession.createQuery("select d from Disc d",
                        Disc.class);

        // execute query and get result list
        List<Disc> discs = getDiscsQuery.getResultList();

        // return the results
        return discs;
    }

    public Disc getDiscById(Long discId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Disc> getDiscQuery =
                currentSession.createQuery("select d from Disc d where d.id = :id",
                        Disc.class);
        getDiscQuery.setParameter("id", discId);

        // execute query and get result list
        Disc disc = getDiscQuery.getSingleResult();

        // return the results
        return disc;
    }

    public List<Song> getDiscSongs(Long discId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Disc disc = currentSession.get(Disc.class, discId);

        if (disc == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find disc");
        }

        Query<Song> getDiscSongsQuery =
                currentSession.createQuery("select s from Song s, Disc d where s.disc.id = d.id and d.id = :id", Song.class);

        getDiscSongsQuery.setParameter("id", discId);

        return getDiscSongsQuery.getResultList();
    }

    public Song createDiscSong(Long discId, Song song) {
        Session currentSession = sessionFactory.getCurrentSession();

        Disc disc = currentSession.get(Disc.class, discId);

        if (disc == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find disc");
        }

        song.setId(0L);
        song.setDisc(disc);

        currentSession.save(song);

        return song;
    }
}
