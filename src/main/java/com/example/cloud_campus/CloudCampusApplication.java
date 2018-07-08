package com.example.cloud_campus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CloudCampusApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCampusApplication.class, args);
    }
}
