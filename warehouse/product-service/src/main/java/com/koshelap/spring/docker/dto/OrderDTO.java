package com.koshelap.spring.docker.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDTO {

    private int id;
    private int clientId;
    private String status;
    private float totalPrice;
    private LocalDate createdAt;
}
