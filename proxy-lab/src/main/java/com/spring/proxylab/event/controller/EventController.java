package com.spring.proxylab.event.controller;

import com.spring.proxylab.event.model.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    private final ApplicationEventPublisher eventPublisher;

    public EventController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("/fire")
    public String fireEvent() {
        eventPublisher.publishEvent(new CustomEvent("Hello from EventController!"));
        return "Event fired";
    }
}
