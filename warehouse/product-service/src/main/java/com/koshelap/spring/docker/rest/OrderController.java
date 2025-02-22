package com.koshelap.spring.docker.rest;


import com.koshelap.spring.docker.model.Inventory;
import com.koshelap.spring.docker.model.Order;
import com.koshelap.spring.docker.repository.InventoryRepository;
import com.koshelap.spring.docker.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

private final OrderRepository repository;

	@GetMapping("/api/orders")
	public List<Order> getAllOrders() {
		return this.repository.findAll();
	}

}
