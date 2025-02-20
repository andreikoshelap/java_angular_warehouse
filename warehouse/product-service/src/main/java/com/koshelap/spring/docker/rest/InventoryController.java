package com.koshelap.spring.docker.rest;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.koshelap.spring.docker.model.Inventory;
import com.koshelap.spring.docker.repository.InventoryRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryController {

private final InventoryRepository repository;

	@GetMapping("/api/inventory")
	public List<Inventory> getAllInventory() {
		return this.repository.findAll();
	}

}
