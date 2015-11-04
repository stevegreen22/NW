package com.simpleSchedule.service;

import com.simpleSchedule.dao.UserDao;
import com.simpleSchedule.model.MyUserDetails;
import com.simpleSchedule.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by SteveGreen on 03/11/2015.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        MyUserDetails myUserDetails = new MyUserDetails.Builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .role(user.getRole)
                .socialSignInProvider(user.getSignInProvider)
                .username(user.getEmail())
                .build();

        return myUserDetails;
    }
}
