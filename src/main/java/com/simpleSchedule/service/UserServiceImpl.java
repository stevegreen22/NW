package com.simpleSchedule.service;

import com.simpleSchedule.dao.UserDao;
import com.simpleSchedule.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by SteveGreen on 28/10/2015.
 */
@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public void persistUser(User user) {
        userDao.persistUser(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    //todo: remember to verify model attribute.
    @Override
    @ModelAttribute("allUsers")
    public List<User> getListOfUsers() {
        return userDao.getListOfUsers();
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserByUserId(userId);
    }
}
