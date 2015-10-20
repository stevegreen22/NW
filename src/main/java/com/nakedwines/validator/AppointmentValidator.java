package com.nakedwines.validator;

import com.nakedwines.formatter.DateFormatter;
import com.nakedwines.model.Appointment;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.xml.bind.ValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SteveGreen on 17/10/15.
 */

public class AppointmentValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Appointment.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "form.title.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "form.description.empty");

        Appointment appointment = (Appointment) obj;

        Date theDate = appointment.getTheDate();

        try {
            validateTheDate(theDate, errors);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }


    private void validateTheDate(Date theDate, Errors errors) throws ValidationException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date today;
        try {
            today = dateFormat.parse(dateFormat.format(new Date()));
            theDate = dateFormat.parse(dateFormat.format(theDate));
        } catch (ParseException e) {
            throw new ValidationException("Date Validation Failed", e);
        }

        if (theDate == null) {
            errors.rejectValue("theDate", "form.date.empty");
        }
//        if (theDate.compareTo(today) < 0) {
//            errors.rejectValue("theDate", "form.error.dateAfterToday");
//        }


    }
}


