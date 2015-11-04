package com.simpleSchedule.dao;

import com.simpleSchedule.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by SteveGreen on 28/10/2015.
 */
@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext private EntityManager em;

    @Override
    public List<User> getListOfUsers() {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM user_accounts AS u ORDER BY u.userId",
                User.class);
        return query.getResultList();
    }

    @Override
    public User getUserByUserId(Integer userId) {
        return null;
    }

    @Override
    public void persistUser(User user) {
        em.persist(user);
    }
}
