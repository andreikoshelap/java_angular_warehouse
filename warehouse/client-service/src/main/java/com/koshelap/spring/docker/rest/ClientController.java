package com.koshelap.spring.docker.rest;


import com.koshelap.spring.docker.dto.ClientDTO;
import com.koshelap.spring.docker.dto.ErrorDTO;
import com.koshelap.spring.docker.exeption.UserDoesNotExistException;
import com.koshelap.spring.docker.exeption.UsernameAlreadyExistException;
import com.koshelap.spring.docker.model.Client;
import com.koshelap.spring.docker.repository.ClientRepository;
import com.koshelap.spring.docker.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.koshelap.spring.docker.enumeration.ApplicationErrorsEnum.USER_EXIST;
import static com.koshelap.spring.docker.enumeration.ApplicationErrorsEnum.USER_NOT_FOUND;

@RestController
@RequiredArgsConstructor
public class ClientController {

private final ClientRepository clientRepository;
private final ClientService clientService;

	@GetMapping("/api/clients")
	public List<Client> getAllInventory() {
		return this.clientRepository.findAll();
	}

	@GetMapping("/api/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		return clientRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody ClientDTO userDto) {
		final boolean login = clientService.login(userDto);
		if (login) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping("/authenticate")
	public ResponseEntity<?> authenticate(HttpServletRequest request) {
		return new ResponseEntity<>(clientService.getUserByUsername(request), HttpStatus.OK);
	}

	@PostMapping("/api/clients")
	public ResponseEntity<?> save(@RequestBody ClientDTO userDto) {
		try {
			return new ResponseEntity<>(clientService.save(userDto), HttpStatus.OK);
		} catch (UsernameAlreadyExistException e) {
			return new ResponseEntity<>(new ErrorDTO(USER_EXIST.getCode(), USER_EXIST.getMessage()), HttpStatus.NOT_FOUND);
		} catch (UserDoesNotExistException e) {
			return new ResponseEntity<>(new ErrorDTO(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/api/clients/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			clientService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (UserDoesNotExistException e) {
			return new ResponseEntity<>(new ErrorDTO(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
}
