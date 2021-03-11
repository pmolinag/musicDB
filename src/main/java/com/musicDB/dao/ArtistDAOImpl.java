package com.musicDB.dao;

import com.musicDB.entity.Artist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ArtistDAOImpl implements ArtistDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Artist> getArtists() {
        Session session = sessionFactory.getCurrentSession();

        Query<Artist> q = session.createQuery("SELECT a FROM Artist a ORDER BY a.discs.size DESC", Artist.class);

        return q.getResultList();
    }

    @Override
    public Artist createArtist(Artist artist) {
        Session session = sessionFactory.getCurrentSession();

        artist.setId(0L);

        session.save(artist);

        return artist;
    }
}
