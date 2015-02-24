package com.clinic.event;

import org.springframework.context.ApplicationEvent;

public class RegistrationFinishedEvent extends ApplicationEvent {

    public RegistrationFinishedEvent(Object source) {
        super(source);
    }
}
