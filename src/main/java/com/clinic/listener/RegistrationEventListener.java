package com.clinic.listener;

import com.clinic.event.RegistrationFinishedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RegistrationEventListener implements ApplicationListener<RegistrationFinishedEvent> {

    @Autowired
    private MailSender mailSender;

    @Override
    @Async
    public void onApplicationEvent(RegistrationFinishedEvent applicationEvent)
    {
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom("Clinic_Co");
//        message.setTo("seal26ster@gmail.com");
//        message.setSubject("Welcome to clinic Co!");
//        message.setText("Registration success!");
//        mailSender.send(message);
        System.out.println("Send email started::::");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Send email completed::::");
    }
}
