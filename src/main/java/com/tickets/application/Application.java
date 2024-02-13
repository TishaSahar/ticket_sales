package com.tickets.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("test");
        SpringApplication.run(Application.class, args);
        log.info("Application run with args: ", args.toString());
    }
}