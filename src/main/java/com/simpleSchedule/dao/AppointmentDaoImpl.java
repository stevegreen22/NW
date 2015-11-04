package com.simpleSchedule.dao;

import com.simpleSchedule.model.Appointment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class AppointmentDaoImpl implements AppointmentDao {

    @PersistenceContext private EntityManager em;

    @Override
    @Transactional
    public void persistAppointment(Appointment appointment) {
        em.persist(appointment);
        //todo: have a look into this and find out wtf is going on.
        ////em.getTransaction().begin(); &
        // em.getTransaction().commit(); removed as spring is taking care of this...?
    }

    @Override
    @Transactional
    public void updateAppointment(Appointment appointment) {

    }

    @Override
    @Transactional
    public void deleteAppointment(Appointment appointment) {
        em.remove(appointment);
    }

    @Transactional
    public void deleteAppointmentUsingHql(int appIdValue) {

        Query query = em.createQuery("DELETE FROM Appointment where appId = :appId");
        query.setParameter("appId", appIdValue);

        int result = query.executeUpdate();
        if (result > 0) {
            //Todo:  Add a Logger, output details of deletion.
        }
    }

    @Override
    public List<Appointment> getAppointmentlist() {
        TypedQuery<Appointment> query = em.createQuery(
                "SELECT app from Appointment as app order by app.appId",
                Appointment.class);
        return query.getResultList();

    }
}

