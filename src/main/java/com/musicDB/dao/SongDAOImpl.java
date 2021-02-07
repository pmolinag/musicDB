package com.musicDB.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.musicDB.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


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
    public Song patchSong(long songId, JsonNode songInfo) {
        Session currentSession = sessionFactory.getCurrentSession();

        // Sanitize and validate the data
        if (songId <= 0 || songInfo == null || songInfo.isEmpty() || (songInfo.get("id") != null && !songInfo.get("id").equals(songId))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Song song = currentSession.get(Song.class, songId);

        // Does the object exist?
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        for (Iterator<Map.Entry<String, JsonNode>> it = songInfo.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> entry = it.next();

            // use reflection to get field k on object and set it to value v
            Field field = ReflectionUtils.findField(Song.class, entry.getKey()); // find field in the object class

            if (field == null || !field.isAnnotationPresent(Column.class)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                ReflectionUtils.setField(field, song, fieldType.cast(entry.getValue().asToken())); // set given field for defined object to value V
            }
        }

        currentSession.saveOrUpdate(song);

        return song;
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
