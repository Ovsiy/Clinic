package com.clinic.service;

import com.clinic.dao.UserDAO;
import com.clinic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(User user) {
        this.userDAO.addUser(user);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void removeUser(int id) {

    }
}
