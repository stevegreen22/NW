package com.simpleSchedule.validator;

import com.simpleSchedule.model.User;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by SteveGreen on 10/10/15.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        User user = (User) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
