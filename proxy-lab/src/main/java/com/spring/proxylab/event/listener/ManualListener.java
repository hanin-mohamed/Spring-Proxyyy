package com.spring.proxylab.event.listener;

import com.spring.proxylab.event.model.CustomEvent;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


// not using @Component here
public class ManualListener {

    @EventListener
    @Async
    public void onEvent(CustomEvent event) {
        System.out.println("This should not run! Event: " + event.getMessage());
    }
}