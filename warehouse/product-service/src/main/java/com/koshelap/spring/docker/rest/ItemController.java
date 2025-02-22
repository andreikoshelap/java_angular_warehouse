package com.koshelap.spring.docker.rest;


import com.koshelap.spring.docker.model.Item;
import com.koshelap.spring.docker.model.Order;
import com.koshelap.spring.docker.repository.ItemRepository;
import com.koshelap.spring.docker.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

private final ItemRepository repository;

	@GetMapping("/api/items")
	public List<Item> getAllItems() {
		return this.repository.findAll();
	}

}
