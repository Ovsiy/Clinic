package com.clinic.dao;

import com.clinic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    BCryptPasswordEncoder password_encoder;

    @PersistenceContext
    private EntityManager entityManager;

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
