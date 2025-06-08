package com.spring.proxylab.async.controller;

import com.spring.proxylab.async.service.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private  AsyncService asyncService;

    @GetMapping("/start")
    public String startAsync() {
        System.out.println(" Main thread: " + Thread.currentThread().getName());
        asyncService.longRunningTask();
        return "Async task started";
    }

    @GetMapping("/with-result")
    public CompletableFuture<String> callWithResult() {
        return asyncService.asyncWithResult();
    }
    @GetMapping("/with-error")
    public CompletableFuture<String> callWithError() {
        return asyncService.asyncWithError()
                .exceptionally(ex -> {
                    System.out.println("Caught async error: " + ex.getMessage());
                    return " Error handled!";
                });
    }
    @GetMapping("/self-invoke")
    public String callSelfInvoke() {
        asyncService.callFromInside();
        return "Called runAsync() from inside the same class";
    }
    @GetMapping("/direct-async")
    public String callDirectAsync() {
        asyncService.runAsync();
        return " Called async directly";
    }

    @GetMapping("/custom-executor")
    public String callCustomExecutor() {
        asyncService.runAsyncWithCustomExecutor();
        return "Called runAsync with custom executor";
    }
}
