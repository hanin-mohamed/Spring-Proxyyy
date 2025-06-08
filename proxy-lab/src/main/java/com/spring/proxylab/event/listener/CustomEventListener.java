package com.spring.proxylab.event.listener;

import com.spring.proxylab.event.model.CustomEvent;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    @Async
    @EventListener
    public void handle(CustomEvent event) {
        System.out.println(" Received event in thread: " + Thread.currentThread().getName());
        System.out.println(" Message: " + event.getMessage());
    }
}