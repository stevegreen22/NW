package com.nakedwines.dao;

import com.nakedwines.model.Appointment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class AppointmentDaoImpl implements AppointmentDao {

    @PersistenceContext private EntityManager em;

    @Override
    @Transactional
    public void persistAppointment(Appointment appointment) {
        em.persist(appointment);
        ////em.getTransaction().begin(); &
        // em.getTransaction().commit(); removed as spring is taking care of this...?
    }

    @Override
    @Transactional
    public void updateAppointment(Appointment appointment) {
        //sessionFactory.getCurrentSession().update(appointment);
    }

    @Override
    @Transactional
    public void deleteAppointment(Appointment appointment) {
        //sessionFactory.getCurrentSession().delete(appointment);
    }

    @Override
    public List<Appointment> getAppointmentlist() {
        TypedQuery<Appointment> query = em.createQuery(
                "SELECT app from Appointment as app order by app.appId",
                Appointment.class);
        return query.getResultList();

    }
}

