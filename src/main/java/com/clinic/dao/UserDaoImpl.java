package com.clinic.dao;

import com.clinic.helpers.JPAHelper;
import com.clinic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    private JPAHelper helper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserByEmail(String email) {
        Query query = this.entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email").setParameter("email", email);
        User user = (User)this.helper.getSingleResultOrNull(query);

        System.out.println("from DAO " + user);
        if(user == null) throw new RuntimeException("User does not exist!");

        return user;
    }

    @Override
    public void addUser(User user) {
        this.entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUserById(int id) {
        return this.entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(int id) {

    }
}
