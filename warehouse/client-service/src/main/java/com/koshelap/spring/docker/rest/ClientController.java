package com.koshelap.spring.docker.rest;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.koshelap.spring.docker.model.Client;
import com.koshelap.spring.docker.repository.ClientRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {

private final ClientRepository repository;

	@GetMapping("/api/clients")
	public List<Client> getAllInventory() {
		return this.repository.findAll();
	}

}
