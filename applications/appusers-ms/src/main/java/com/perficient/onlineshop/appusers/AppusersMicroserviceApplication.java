package com.perficient.onlineshop.appusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppusersMicroserviceApplication {
    public static void main(String... args) {
        SpringApplication.run(AppusersMicroserviceApplication.class, args);
    }
}