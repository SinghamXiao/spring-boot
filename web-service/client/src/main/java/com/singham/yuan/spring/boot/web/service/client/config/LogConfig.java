package com.singham.yuan.spring.boot.web.service.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class LogConfig {

    @Bean(name = "performanceLogThreadPool")
    public ThreadPoolExecutor getPerformanceLogThreadPool() {
        return new ThreadPoolExecutor(20,
                20,
                5,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(10000));
    }

    @Bean(name = "streamLogRecorderExecutor")
    public ThreadPoolExecutor getStreamLogRecorderExecutor() {
        return new ThreadPoolExecutor(20,
                20,
                5,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(10000));
    }

}
