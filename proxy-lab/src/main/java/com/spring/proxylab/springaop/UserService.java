package com.spring.proxylab.springaop;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @PostConstruct
    public void inspectProxy() {
        System.out.println(" Class at runtime: " + this.getClass());
    }

    public void sayHello() {
        System.out.println(" Hello from UserService!");
    }
}
