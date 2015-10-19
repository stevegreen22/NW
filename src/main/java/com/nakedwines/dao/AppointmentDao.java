package com.nakedwines.dao;

import com.nakedwines.model.Appointment;

import java.util.List;

/**
 * Created by SteveGreen on 15/10/15.
 */
public interface AppointmentDao {

    void persistAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    List<Appointment> getAppointmentlist();

}
