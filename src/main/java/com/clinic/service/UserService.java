package com.clinic.service;

import com.clinic.forms.RegistrationForm;
import com.clinic.model.User;

public interface UserService {
    public void addUser(RegistrationForm userForm);
    public User getUserById(int id);
    public void removeUser(int id);
}
