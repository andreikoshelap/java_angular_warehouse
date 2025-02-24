package com.koshelap.spring.docker.service;


import com.koshelap.spring.docker.dto.ClientDTO;
import com.koshelap.spring.docker.enumeration.UserRoles;
import com.koshelap.spring.docker.exeption.UserDoesNotExistException;
import com.koshelap.spring.docker.exeption.UsernameAlreadyExistException;
import com.koshelap.spring.docker.model.Client;
import com.koshelap.spring.docker.repository.ClientRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository userRepository;
    private final ClientMapper mappingService;
    private final PasswordEncoder passwordEncoder;

    public ClientService(ClientRepository userRepository, ClientMapper mappingService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mappingService = mappingService;
        this.passwordEncoder = passwordEncoder;
    }


    public List<ClientDTO> getAllOrders() {
        return userRepository.findAll().stream()
                .map(mappingService::clientToClientDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO save(ClientDTO userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new UsernameAlreadyExistException();
        }
        Client forSave = Client.builder().build();
        Optional<Client> userById = Optional.empty();
        if (userDto.getId() != null) {
            userById = userRepository.findById(userDto.getId());
            if (userById.isEmpty()) {
                throw new UserDoesNotExistException();
            }
        }
        forSave.setId(userById.map(Client::getId).orElse(null));
        forSave.setUsername(userDto.getUsername());
        forSave.setPassword(passwordEncoder.encode(userDto.getPassword()));
        forSave.setAccountNonExpired(true);
        forSave.setAccountNonLocked(true);
        forSave.setCredentialsNonExpired(true);
        forSave.setEnabled(true);
        forSave.setRole(UserRoles.USER.getRoleName());
        return mappingService.clientToClientDTO(userRepository.save(forSave));
    }

    public Optional<ClientDTO> getById(Long id) {
        return userRepository.findById(id).map(user -> mappingService.clientToClientDTO(user));
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserDoesNotExistException();
        }
        userRepository.deleteById(id);
    }

    public boolean login(ClientDTO userDto) {
        Client userByEmail = userRepository.findByUsername(userDto.getUsername());
        if (userByEmail != null) {
            return passwordEncoder.matches(userDto.getPassword(), userByEmail.getPassword());
        }
        return false;
    }

    public ClientDTO getUserByUsername(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        String username = new String(Base64.getDecoder().decode(authToken)).split(":")[0];
        Client userByUserName = userRepository.findByUsername(username);
        return mappingService.clientToClientDTO(userByUserName);
    }

}
