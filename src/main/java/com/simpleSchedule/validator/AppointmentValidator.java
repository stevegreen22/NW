package com.simpleSchedule.validator;

import com.simpleSchedule.model.Appointment;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.xml.bind.ValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SteveGreen on 17/10/15.
 */

public class AppointmentValidator implements Validator {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public boolean supports(Class<?> aClass) {
        return Appointment.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "form.title.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "form.description.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startTime", "form.startTime.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duration", "form.duration.empty");

        Appointment appointment = (Appointment) obj;

        try {
            validateTheDate(appointment.getTheDate(), errors);
            validateDuration(appointment.getDuration(), errors);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    private void validateDuration(int duration, Errors errors) {
        if (duration == 0) {
            errors.rejectValue("duration", "form.duration.errorEmptyOrNull");
        } else if (duration < 15) {
            errors.rejectValue("duration", "form.duration.errorTooShort");
        }
    }

    private Date validateAndParseTodaysDate() throws ValidationException {
        try {
            return DATE_FORMAT.parse(DATE_FORMAT.format(new Date()));
        } catch (ParseException e) {
            throw new ValidationException("Unable to parse and validate today's date", e);
        }
    }

    private boolean isTheDateMalformed(Date dateUnderTest){

        Date valid = null;
        try{
            valid = DATE_FORMAT.parse(DATE_FORMAT.format(dateUnderTest));
            if(!DATE_FORMAT.format(valid).equals(DATE_FORMAT.format(dateUnderTest))){
                valid = null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return valid != null;
    }


    //need to make sure the date is not malform before it gets here...
    private void validateTheDate(Date theDate, Errors errors) throws ValidationException {

        //check date is not before today
        Date today = validateAndParseTodaysDate();

        if (theDate == null || (!isTheDateMalformed(theDate)) ) {
            errors.rejectValue("theDate", "form.date.dateFormatMistmatch");

        //check date is not before today
        } else if (theDate.compareTo(today) < 0) {
            errors.rejectValue("theDate", "form.error.dateAfterToday");
        }

    }
}


