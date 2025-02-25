package com.koshelap.spring.docker.service;

import com.koshelap.spring.docker.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String CLIENT_SERVICE_URL = "http://client-app:8081/api/clients/";

    public ClientDTO getClientById(Long clientId) {
        String url = CLIENT_SERVICE_URL + clientId;
        ResponseEntity<ClientDTO> response = restTemplate.getForEntity(url, ClientDTO.class);
        return response.getBody();
    }
}
