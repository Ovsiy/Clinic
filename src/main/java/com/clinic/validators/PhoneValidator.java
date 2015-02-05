package com.clinic.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String>{
    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String phone_number, ConstraintValidatorContext constraintValidatorContext) {
        if(phone_number == null)  return false;
        else if (phone_number.matches("[0-9]+")) return true;
        else return false;
    }
}
