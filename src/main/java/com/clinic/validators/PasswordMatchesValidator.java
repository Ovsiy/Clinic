package com.clinic.validators;

import com.clinic.forms.RegistrationForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>
{
    @Override
    public void initialize(PasswordMatches annotation) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        RegistrationForm user = (RegistrationForm) o;

        return user.getPassword().equals(user.getPassword_again());
    }
}
