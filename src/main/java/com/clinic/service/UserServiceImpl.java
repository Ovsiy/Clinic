package com.clinic.service;

import com.clinic.dao.UserDAO;
import com.clinic.forms.RegistrationForm;
import com.clinic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    BCryptPasswordEncoder password_encoder;

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(RegistrationForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(password_encoder.encode(userForm.getPassword()));
        user.setEnabled(true);

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

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.findUserByEmail(s);
    }
}
