package com.koshelap.spring.docker.rest;


import com.koshelap.spring.docker.dto.OrderDTO;
import com.koshelap.spring.docker.dto.OrderRequestDTO;
import com.koshelap.spring.docker.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

private final OrderService service;

	@GetMapping
	public List<OrderDTO> getAllOrders() {
		return this.service.getAllOrders();
	}

	@PostMapping
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
		OrderDTO savedOrder = service.createOrder(orderRequestDTO);
		return ResponseEntity.ok(savedOrder);
	}
}
