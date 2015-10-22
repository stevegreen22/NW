package com.nakedwines.service;

import com.nakedwines.model.Appointment;

import java.util.List;

/**
 * Created by SteveGreen on 15/10/15.
 */
public interface AppointmentService {

    void persistAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    List<Appointment> getAppointmentlist();
    Appointment getAppointmentById(Integer appId);
}
