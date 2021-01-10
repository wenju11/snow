package com.cloud.snow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.cloud.snow")
public class SnowApplication {
    public static void main(String[] args) {
        SpringApplication.run(SnowApplication.class,args);
    }
}