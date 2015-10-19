package com.nakedwines.controller;

import com.nakedwines.model.Appointment;
import com.nakedwines.service.AppointmentService;
import com.nakedwines.validator.AppointmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
* Created by SteveGreen on 16/10/15.
*/
@Controller
public class AppointmentController {

    @Autowired AppointmentService appointmentService;
    @Autowired AppointmentValidator appointmentValidator;

    /**
     * Method is triggered by /appointments mapping.  Make a call to the com.service to
     * request a list of all appointments, if there are any.
     * @param model
     * @return
     */
    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public String getAppointments(Model model){

        model.addAttribute("appList", getAllCurrentAppointments());

        Appointment createApp = new Appointment();
        model.addAttribute("createApp", createApp);

        return "appointments";
    }

    @RequestMapping(value = "/appointments/create", method = RequestMethod.POST)
    public String createAppointment(@ModelAttribute(value = "createApp") @Valid Appointment createApp,
                                    BindingResult result, Model model){

        appointmentValidator.validate(createApp, result);
        if (result.hasErrors()) {

            //better or easier to call the other controller?
            model.addAttribute("appList", getAllCurrentAppointments());
            return "appointments";
        } else {
            appointmentService.persistAppointment(createApp);
            //better or easier to call the other controller?
            model.addAttribute("appList", getAllCurrentAppointments());
            return "appointments";
        }

    }

    private List<Appointment> getAllCurrentAppointments() {
        return appointmentService.getAppointmentlist();
    }

}
