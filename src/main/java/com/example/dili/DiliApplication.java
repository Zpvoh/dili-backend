package com.example.dili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.dili")
@EnableJpaRepositories("com.example.dili.repository")
@EntityScan("com.example.dili.model")
public class DiliApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiliApplication.class, args);
    }

}
