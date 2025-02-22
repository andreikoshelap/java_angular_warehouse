package com.koshelap.spring.docker;

import com.koshelap.spring.docker.model.Item;
import com.koshelap.spring.docker.model.Order;
import com.koshelap.spring.docker.repository.ItemRepository;
import com.koshelap.spring.docker.repository.OrderRepository;
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
		Inventory product = new Inventory(1, "Thinkpad", "Notebook", 1200f,10,  "electronics", LocalDate.now());
		InventoryRepository repository = context.getBean(InventoryRepository.class);
		repository.save(product);

		Order order = new Order(1, 1, "pending");
		OrderRepository orderRepository = context.getBean(OrderRepository.class);
		orderRepository.save(order);

		ItemRepository itemRepository = context.getBean(ItemRepository.class);
		Item item = new Item(1, product,  1, 1200, order);
		itemRepository.save(item);

		System.out.println(repository.findAll());
		System.out.println(orderRepository.findAll());
		System.out.println(itemRepository.findAll());
	}

}
