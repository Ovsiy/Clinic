package com.clinic.service;

import com.clinic.dao.UserDAO;
import com.clinic.forms.RegistrationForm;
import com.clinic.model.User;
import com.clinic.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<UserRole> userRoles = new HashSet<UserRole>();
        userRoles.add(new UserRole(user, UserRole.ROLE_ADMIN));
        userRoles.add(new UserRole(user, UserRole.ROLE_USER));

        user.setUserRole(userRoles);

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
    public UserDetails loadUserByUsername(String s) {

        try {
            User user = userDAO.findUserByEmail(s);

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    user.isEnabled(),
                    true,
                    true,
                    true,
                    buildUserAuthority(user.getUserRole())
            );
        } catch (Exception e) {
            throw new UsernameNotFoundException("Can't find the user");
        }
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }
}
