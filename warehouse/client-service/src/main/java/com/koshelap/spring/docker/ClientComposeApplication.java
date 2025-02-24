package com.koshelap.spring.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "com.koshelap.spring.docker.model")
public class ClientComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientComposeApplication.class, args);
    }

}
