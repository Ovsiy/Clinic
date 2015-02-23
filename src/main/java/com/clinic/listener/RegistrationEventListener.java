package com.clinic.listener;

import com.clinic.event.RegistrationFinishedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RegistrationEventListener implements ApplicationListener<RegistrationFinishedEvent> {
    @Override
    public void onApplicationEvent(RegistrationFinishedEvent applicationEvent) {
        System.out.println("Listened that shit");
    }
}
