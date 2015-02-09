package com.clinic.dao;

import com.clinic.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserByEmail(String email) {

        User user = (User)this.entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email").setParameter("email", email).getSingleResult();
        return (user == null ? null : user);
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
