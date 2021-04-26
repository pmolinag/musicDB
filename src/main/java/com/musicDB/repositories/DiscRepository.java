package com.musicDB.repositories;

import com.musicDB.entity.Artist;
import com.musicDB.entity.Song;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.musicDB.entity.Disc;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class DiscRepository {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Disc> getDiscs() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Disc> getDiscsQuery =
                currentSession.createQuery("SELECT d FROM Disc d",
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
                currentSession.createQuery("SELECT d FROM Disc d WHERE d.id = :id",
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
            throw new EntityNotFoundException("Unable to find disc");
        }

        Query<Song> getDiscSongsQuery =
                currentSession.createQuery("SELECT s FROM Song s, Disc d WHERE s.disc.id = d.id AND d.id = :id", Song.class);

        getDiscSongsQuery.setParameter("id", discId);

        return getDiscSongsQuery.getResultList();
    }

    public Song createDiscSong(Long discId, Song song) {
        Session currentSession = sessionFactory.getCurrentSession();

        Disc disc = currentSession.get(Disc.class, discId);

        if (disc == null) {
            throw new EntityNotFoundException("Unable to find disc");
        }

        song.setId(0L);
        song.setDisc(disc);

        currentSession.save(song);

        return song;
    }

    public List<Disc> searchDiscs(String pattern) {
        Session session = sessionFactory.getCurrentSession();

        Query<Disc> getDiscsQuery = session.createQuery("SELECT d FROM Disc d WHERE d.title LIKE CONCAT('%', :pattern, '%')", Disc.class);

        getDiscsQuery.setParameter("pattern", pattern);

        return getDiscsQuery.getResultList();
    }

    public Disc createArtistDisc(long artistId, Disc disc) {
        Session session = sessionFactory.getCurrentSession();

        Artist artist = session.get(Artist.class, artistId);

        if (artist == null) {
            throw new EntityNotFoundException("Unable to find artist");
        }

        disc.setArtist(artist);

        session.save(disc);

        return disc;
    }

    public List<Disc> getArtistDiscs(long artistId) {
        Session session = sessionFactory.getCurrentSession();

        Query<Disc> getDiscsQuery = session.createQuery("SELECT d FROM Disc d WHERE d.artist.id=:artistId", Disc.class);

        getDiscsQuery.setParameter("artistId", artistId);

        return getDiscsQuery.getResultList();
    }
}
