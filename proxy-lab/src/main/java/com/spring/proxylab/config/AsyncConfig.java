package com.spring.proxylab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {
    @Bean(name = "customExecutor")
    public Executor customExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3); // min number of threads
        executor.setMaxPoolSize(5);  // max number of threads
        executor.setQueueCapacity(100); // queue size (if all threads busy new tasks will wait here)
        executor.setThreadNamePrefix("MyAsyncThread-"); // prefix for thread names
        executor.initialize();
        return executor;
    }
}
