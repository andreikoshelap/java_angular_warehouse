package com.koshelap.spring.docker.rest;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.koshelap.spring.docker.model.Inventory;
import com.koshelap.spring.docker.repository.InventoryRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

private final InventoryRepository repository;

	@GetMapping
	public List<Inventory> getAllInventory() {
		return this.repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		Inventory savedInventory = repository.save(inventory);
		return ResponseEntity.ok(savedInventory);
	}
}
