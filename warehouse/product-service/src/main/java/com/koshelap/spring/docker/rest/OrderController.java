package com.koshelap.spring.docker.rest;


import com.koshelap.spring.docker.dto.OrderDTO;
import com.koshelap.spring.docker.model.Inventory;
import com.koshelap.spring.docker.model.Order;
import com.koshelap.spring.docker.repository.InventoryRepository;
import com.koshelap.spring.docker.repository.OrderRepository;
import com.koshelap.spring.docker.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

private OrderService service;

	public OrderController(OrderService service) {
		this.service = service;
	}

	@GetMapping("/api/orders")
	public List<OrderDTO> getAllOrders() {
		System.out.println( " here ");
		return this.service.getAllOrders();
	}

}
