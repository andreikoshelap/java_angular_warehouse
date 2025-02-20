package ru.otus.spring.docker.rest;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.docker.model.Inventory;
import ru.otus.spring.docker.repository.InventoryRepository;

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
