package com.spring.proxylab.event.listener;

import com.spring.proxylab.event.model.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;



// not using @Component here
public class ManualListener {

    @EventListener
    @Async
    public void onEvent(CustomEvent event) {
        System.out.println("This should not run! Event: " + event.getMessage());
    }
}