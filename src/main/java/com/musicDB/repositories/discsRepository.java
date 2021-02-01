package com.musicDB.repositories;

import com.musicDB.entity.Artist;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.musicDB.entity.Disc;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import java.util.List;


@Repository
public class discsRepository {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Disc> getDiscs() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Disc> getDiscsQuery =
                currentSession.createQuery("from Disc",
                        Disc.class);

        // execute query and get result list
        List<Disc> discs = getDiscsQuery.getResultList();

        // return the results
        return discs;
    }

    public List<Disc> getDiscById(Long discId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<Disc> getDiscQuery =
                currentSession.createQuery("select d from Disc d where d.id = :id",
                        Disc.class);
        getDiscQuery.setParameter("id", discId);

        // execute query and get result list
        List<Disc> discs = getDiscQuery.getResultList();

        // return the results
        return discs;
    }
}
