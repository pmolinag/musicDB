package com.musicDB.dao;

import com.musicDB.annotations.PatchableField;
import com.musicDB.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class SongDAOImpl implements SongDAO {

    private List<Field> patchableSongFields = Arrays.stream(Song.class.getDeclaredFields())
            .filter((Field field) -> field.isAnnotationPresent(PatchableField.class))
            .peek((Field field) -> field.setAccessible(true))
            .collect(Collectors.toList());

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
        song.setId(0L);

        long songId = (long) currentSession.save(song);
        song.setId(songId);

        return song;
    }

    @Override
    public Song putSong(long songId, Song song) {
        Session currentSession = sessionFactory.getCurrentSession();

        song.setId(songId);

        currentSession.saveOrUpdate(song);

        return song;
    }

    @Override
    public Song patchSong(long songId, Song song) {
        Session currentSession = sessionFactory.getCurrentSession();

        // Sanitize and validate the data
        if (songId <= 0 || song == null || (song.getId() != null && !song.getId().equals(songId))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Song realSong = currentSession.get(Song.class, songId);

        // Does the object exist?
        if (realSong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        for (Field field : patchableSongFields) {
            Object newFieldValue = ReflectionUtils.getField(field, song);

            if (newFieldValue != null) {
                ReflectionUtils.setField(field, realSong, newFieldValue);
            }
        }

        currentSession.saveOrUpdate(realSong);

        return realSong;
    }

    @Override
    public void deleteSong(long songId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Song song = currentSession.get(Song.class, songId);

        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        currentSession.delete(song);
    }
}
