package com.gespro.platform.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Modulithic
@SpringBootApplication
public class GesproApplication {

    public static void main(String[] args) {
        SpringApplication.run(GesproApplication.class, args);
    }
}
