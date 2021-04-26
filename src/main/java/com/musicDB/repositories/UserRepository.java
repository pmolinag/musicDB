package com.musicDB.repositories;

import com.musicDB.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public User findByUsername(String username) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<User> getUserQuery =
                currentSession.createQuery("SELECT user FROM User user WHERE user.username = :username",
                        User.class);

        // execute query and get result list
        User user = getUserQuery.getSingleResult();

        // return the results
        return user;
    }

    public User saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        user.setId(0L);

        session.save(user);

        return user;
    }
}
