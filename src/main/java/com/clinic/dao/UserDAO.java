package com.clinic.dao;

import com.clinic.model.User;

public interface UserDAO {
    public void addUser(User user);
    public void updateUser(User user);
    public User getUserById(int id);
    public void removeUser(int id);
    public User findUserByEmail(String email);
}
