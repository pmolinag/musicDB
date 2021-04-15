package com.musicDB.dao;

import com.musicDB.annotations.PatchableField;
import com.musicDB.entity.Concert;
import com.musicDB.entity.Song;
import com.musicDB.dao.ConcertDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ConcertDAOImpl implements ConcertDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Concert> getConcerts() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // Query all the concerts and sort by date.
        Query<Concert> getConcertsQuery =
                currentSession.createQuery("select s from Concert s order by s.date",
                        Concert.class);

        // execute query and get result list
        List<Concert> concerts = getConcertsQuery.getResultList();

        System.out.println("Returned concerts: " + concerts);

        // return the results
        return concerts;
    }

    @Override
    public Concert getConcertById(long concertId) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Concert.class, concertId);
    }

    @Override
    @Transactional
    public List<Song> getConcertSongs(long concertId) {
        // Manually open the session since we fetch LAZY data.
        Session currentSession = sessionFactory.openSession();
        Concert concert = currentSession.get(Concert.class, concertId);
        return concert.getSongs();
    }

    @Override
    public Concert createConcert(Concert concert) {
        Session currentSession = sessionFactory.getCurrentSession();

        // Set Concert id to 0 so that DAO inserts a new concert instead of updating an existing one
        concert.setId(0L);

        long concertId = (long) currentSession.save(concert);
        concert.setId(concertId);

        return concert;
    }

    @Override
    public Concert putConcert(long concertId, Concert concert) {
        Session currentSession = sessionFactory.getCurrentSession();

        concert.setId(concertId);

        currentSession.saveOrUpdate(concert);

        return concert;
    }

    @Override
    public void deleteConcert(long concertId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Concert concert = currentSession.get(Concert.class, concertId);

        if (concert == null) {
            throw new EntityNotFoundException("Unable to find Concert");
        }

        currentSession.delete(concert);
    }

    @Override
    public void setConcertSongs(long concertId, List<Integer> songIds) {
        // Inserting all concert songs via SQL into the N:M resulting table.
        Session currentSession = sessionFactory.getCurrentSession();
        for (Integer songId : songIds){
            String sql = String.format("INSERT INTO concert_song (concert_id, song_id) VALUES(%s, %s)", concertId, songId);
            currentSession.createNativeQuery(sql).executeUpdate();
        }
    }
}
