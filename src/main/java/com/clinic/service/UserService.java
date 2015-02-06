package com.clinic.service;

import com.clinic.model.User;

public interface UserService {
    public void addUser(User user);
    public User getUserById(int id);
    public void removeUser(int id);
}
