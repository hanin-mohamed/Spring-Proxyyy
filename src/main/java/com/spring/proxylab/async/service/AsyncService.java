package com.spring.proxylab.async.service;


import com.spring.proxylab.transactional.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Autowired
    private  UserRepository userRepository;
    @Async
    public void longRunningTask() {
        System.out.println(" Async thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Async task completed.");
    }

    @Async
    public CompletableFuture<String> asyncWithResult() {
        System.out.println(" Working in thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(" Result is ready!");
    }

    @Async
    public CompletableFuture<String> asyncWithError() {

        try {
            if (true) throw new RuntimeException("Error!");
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
        return CompletableFuture.completedFuture("Success");
    }

    @Async
    public void runAsync() {
        System.out.println(" runAsync(): " + Thread.currentThread().getName());
    }

    public void callFromInside() {
        System.out.println(" callFromInside(): " + Thread.currentThread().getName());
        this.runAsync(); //  This will NOT run in a separate thread (self-invocation)
    }

    @Async
    public void runAsyncWithCustomExecutor() {
        System.out.println(" runAsyncWithCustomExecutor(): " + Thread.currentThread().getName());
    }




}
