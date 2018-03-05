package com.singham.yuan.spring.boot.web.service.client.log;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Aspect
@Component
public class ClientPerformanceLog {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientPerformanceLog.class);

    private static final Logger PERF_LOGGER = LoggerFactory.getLogger("PERF_LOGGER");

    @Autowired
    private ThreadPoolExecutor performanceLogThreadPool;

    @Around("execution(* com.singham.yuan.spring.boot.web.service.client.remote.ClientRemoteService.execute(..))")
    public void log(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
            performanceLogThreadPool.execute(() -> PERF_LOGGER.info("Client Execute"));
        } catch (Throwable e) {
            LOGGER.error(ExceptionUtils.getMessage(e));
        }
    }

}
