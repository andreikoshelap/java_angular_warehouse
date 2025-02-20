package com.koshelap.spring.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.koshelap.spring.docker.model.Client;
import com.koshelap.spring.docker.repository.ClientRepository;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories
public class ClientComposeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ClientComposeApplication.class, args);
		ClientRepository repository = context.getBean(ClientRepository.class);
		repository.save(new Client("Andrei", LocalDate.now()));
		System.out.println(repository.findAll());
	}

}
