package com.dao;

import com.simpleSchedule.model.Appointment;
import com.simpleSchedule.model.AppointmentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.Time;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/config.xml"})

public class AppointmentDaoImplTest {

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
    public void persistAppointment_savesBasicDetails() {
        Appointment appointment = new Appointment();

        appointment.setTitle("A Title");
        appointment.setDescription("A Description");
        appointment.setAppointmentType(AppointmentType.HOME);

        Calendar cal = Calendar.getInstance();//today
        appointment.setTheDate(cal.getTime());

        appointment.setStartTime(new Time(cal.getTime().getTime()));

        cal.add(Calendar.HOUR, 4);
        appointment.setEndTime(new Time(cal.getTime().getTime()));

        entityManager.persist(appointment);
        entityManager.getTransaction().commit();
    }

    @Test
    public void testPersistAppointment() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2015, Calendar.MAY, 22);

        Appointment appointment = new Appointment();
        appointment.setDescription("fy");
        appointment.setDescription("some description");
        appointment.setAppointmentType(AppointmentType.HOME);


        appointment.setTheDate(cal.getTime());
        cal.add(Calendar.MONTH, 1);
        entityManager.persist(appointment);
        entityManager.getTransaction().commit();
    }


    public void testUpdateAppointment() throws Exception {

    }

    public void testDeleteAppointment() throws Exception {

    }

    public void testGetAppointmentlist() throws Exception {

    }
}