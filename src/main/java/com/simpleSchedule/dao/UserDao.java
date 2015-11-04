package com.simpleSchedule.dao;

import com.simpleSchedule.model.User;

import java.util.List;

/**
 * Created by SteveGreen on 28/10/2015.
 */
public interface UserDao {

    List<User> getListOfUsers();
    User getUserByUserId(Integer userId);
    void persistUser(User user);
    User findByEmail(String email);
}
