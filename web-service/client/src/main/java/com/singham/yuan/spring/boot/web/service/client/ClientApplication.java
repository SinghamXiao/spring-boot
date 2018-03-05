package com.singham.yuan.spring.boot.web.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ClientApplication extends SpringBootServletInitializer {

    private static final Class<ClientApplication> applicationClass = ClientApplication.class;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(applicationClass);
    }

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

}
