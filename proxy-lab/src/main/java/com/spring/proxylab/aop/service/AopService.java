package com.spring.proxylab.aop.service;


import org.springframework.stereotype.Service;

@Service
public class AopService {
    public String doWork(String taskName) {
        System.out.println(" Inside service: Doing task -> " + taskName);
        return "Done! " + taskName;
    }

    public String doWorkWithException(String taskName) {
        System.out.println(" Inside service: Doing task with exception -> " + taskName);
        if ("exception".equals(taskName)) {
            throw new RuntimeException("Simulated Exception");
        }
        return "Done! " + taskName;
    }
}
