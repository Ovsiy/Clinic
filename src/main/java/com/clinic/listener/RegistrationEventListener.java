package com.clinic.listener;

import com.clinic.event.RegistrationFinishedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class RegistrationEventListener implements ApplicationListener<RegistrationFinishedEvent> {

    @Autowired
    private MailSender mailSender;

    @Override
    public void onApplicationEvent(RegistrationFinishedEvent applicationEvent)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("Clinic_Co");
        message.setTo("seal26ster@gmail.com");
        message.setSubject("Welcome to clinic Co!");
        message.setText("Registration success!");
        mailSender.send(message);
    }
}
