package com.simpleSchedule.service;

import com.simpleSchedule.model.User;

import java.util.List;

/**
 * Created by SteveGreen on 28/10/2015.
 */
public interface UserService {

    void persistUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    //todo: consider passing in options to return active users, enabled, password verified etc etc - AdminService?
    List<User> getListOfUsers();
    User getUserById(Integer userId);
}
