package com.musicDB.dao;

import com.musicDB.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SongDAOImpl implements SongDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Song> getSongs() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Song> getSongsQuery =
                currentSession.createQuery("from Song order by name",
                        Song.class);

        // execute query and get result list
        List<Song> songs = getSongsQuery.getResultList();

        // return the results
        return songs;
    }

    @Override
    public Song getSong(long songId) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Song.class, songId);
    }

    @Override
    public Song createSong(Song song) {
        Session currentSession = sessionFactory.getCurrentSession();

        // Set song id to 0 so that DAO inserts a new customer instead of updating an existing one
        song.setId(0);

        long songId = (long) currentSession.save(song);
        song.setId(songId);

        return song;
    }
}
