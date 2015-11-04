package com.dao;

import com.simpleSchedule.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/ApplicationContext.xml"})

public class UserDaoImplTest {

    private EntityManager entityManager;

    @Before
    public void setup() {
        entityManager = Persistence.createEntityManagerFactory("entityManager")
                .createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void tearDown() {
        entityManager.close();
    }

    @Test
    public void testPersistUser() throws Exception {

        User user = new User();


        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }


}