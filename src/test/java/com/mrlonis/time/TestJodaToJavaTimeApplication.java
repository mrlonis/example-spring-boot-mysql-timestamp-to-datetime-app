package com.mrlonis.time;

import org.springframework.boot.SpringApplication;

public class TestJodaToJavaTimeApplication {

    public static void main(String[] args) {
        SpringApplication.from(JodaToJavaTimeApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }
}
