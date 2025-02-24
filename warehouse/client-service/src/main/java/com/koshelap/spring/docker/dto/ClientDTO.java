package com.koshelap.spring.docker.dto;

import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
}
