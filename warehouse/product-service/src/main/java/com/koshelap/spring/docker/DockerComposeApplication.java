package com.koshelap.spring.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.koshelap.spring.docker.model.Inventory;
import com.koshelap.spring.docker.repository.InventoryRepository;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories
public class DockerComposeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DockerComposeApplication.class, args);
		InventoryRepository repository = context.getBean(InventoryRepository.class);
		repository.save(new Inventory("Thinkpad", 10, LocalDate.now()));
		System.out.println(repository.findAll());
	}

}
