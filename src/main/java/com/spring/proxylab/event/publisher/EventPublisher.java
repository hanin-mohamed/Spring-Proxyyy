package com.spring.proxylab.event.publisher;

import com.spring.proxylab.event.model.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class EventPublisher {
    private final ApplicationEventPublisher publisher; // publisher for events to be sent to listeners

    public EventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(String message) {
        System.out.println(" Publishing event from thread: " + Thread.currentThread().getName());
        publisher.publishEvent(new CustomEvent(message));
    }
}
