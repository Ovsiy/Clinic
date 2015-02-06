package com.clinic.exceptions;

public class DublicateEmailException extends Exception {

    public DublicateEmailException() {
        super();
    }

    @Override
    public String getMessage() {
        return "This email is already exists";
    }
}
