package com.tickets.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import lombok.extern.slf4j.Slf4j;

/**
 * Main spring boot application.
 */
@Slf4j
@EnableCaching
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Application run with args: ", args.toString());
    }
}