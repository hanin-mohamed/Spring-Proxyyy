package com.spring.proxylab.aop.controller;


import com.spring.proxylab.aop.service.AopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {
    private final AopService service;

    public AopController(AopService aopService) {
        this.service = aopService;
    }



    @GetMapping("/test")
    public String testAspect() {
        return service.doWork("Logging Aspect Test");
    }

    @GetMapping("/testException")
    public String testAspectException() {
        return service.doWorkWithException("exception");
    }
}
