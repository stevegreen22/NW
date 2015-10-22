package com.nakedwines.controller;

import com.nakedwines.model.Appointment;
import com.nakedwines.service.AppointmentService;
import com.nakedwines.validator.AppointmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import java.util.List;

/**
* Created by SteveGreen on 16/10/15.
*/
@Controller
@RequestMapping("/appointments.html")
@SessionAttributes("appointment")
public class AppointmentController {

    @Autowired AppointmentService appointmentService;
    @Autowired AppointmentValidator appointmentValidator;


    //Form backing object
    @RequestMapping(method = RequestMethod.GET)
    public Appointment setUpForm(@RequestParam(value="appId", required = false) Integer appId) {
        List<Appointment> appList = getAllCurrentAppointments();
        if (appId == null) {
            return new Appointment();
        } else {
            return appointmentService.getAppointmentById(appId);
        }
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createAppointment(Appointment appointment,
                                    BindingResult result, SessionStatus status) {

        return update(appointment, result, status);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Appointment appointment, BindingResult result, SessionStatus status) {

        appointmentValidator.validate(appointment, result);
        if (result.hasErrors()) {
            return "appointments";
        } else {
            appointmentService.persistAppointment(appointment);
            status.setComplete();
            return "redirect:appointments.html";
        }

    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deleteAppointment(Appointment appointment, BindingResult result, SessionStatus status) {

        appointmentService.deleteAppointment(appointment);
        status.setComplete();
        return "redirect:appointments.html";
    }

    @ModelAttribute("appList")
    private List<Appointment> getAllCurrentAppointments() {
        return appointmentService.getAppointmentlist();
    }

}
