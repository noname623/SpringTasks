package com.example.demoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IllegalAccessException {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

        Cafe cafe = applicationContext.getBean("cafe", Cafe.class);
        cafe.process();
    }
}