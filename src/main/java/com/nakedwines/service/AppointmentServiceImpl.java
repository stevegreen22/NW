package com.nakedwines.service;

import com.nakedwines.dao.AppointmentDao;
import com.nakedwines.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Calendar;
import java.util.List;

/**
 * Created by SteveGreen on 15/10/15.
 */
@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentDao appointmentDao;

    @Override
    @Transactional
    public void persistAppointment(Appointment appointment) {
        //set the end time of the object.

        if (appointment.getDuration() != 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(appointment.getStartTime());
            cal.add(Calendar.MINUTE, appointment.getDuration());
            appointment.setEndTime(cal.getTime());
        }

        appointmentDao.persistAppointment(appointment);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentDao.updateAppointment(appointment);
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentDao.deleteAppointment(appointment);
    }

    @Override
    @ModelAttribute("allAppointments")
    public List<Appointment> getAppointmentlist() {
        return appointmentDao.getAppointmentlist();
    }

    @Override
    public Appointment getAppointmentById(Integer appId) {
        return null;
    }
}
