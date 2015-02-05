package com.clinic.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "Please enter a valid phone number. Only numbers allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
