package com.clinic.forms;

import com.clinic.validators.PasswordMatches;
import org.hibernate.validator.constraints.Email;

@PasswordMatches
public class RegistrationForm {

    @Email
    private String email;

    private String password;

    private String password_again;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_again() {
        return password_again;
    }

    public void setPassword_again(String password_again) {
        this.password_again = password_again;
    }

    @Override
    public String toString() {
        return "REgistration form with email = " +
                this.getEmail() + " password = " +
                this.getPassword() + " password2 = " +
                this.getPassword_again();
    }
}
