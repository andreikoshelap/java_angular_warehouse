package com.koshelap.spring.docker.service;


import com.koshelap.spring.docker.dto.ClientDTO;
import com.koshelap.spring.docker.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;


    public List<ClientDTO> getAllOrders() {
        return repository.findAll().stream()
                .map(mapper::clientToClientDTO)
                .collect(Collectors.toList());
    }
}
