package com.koshelap.spring.docker.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequestDTO {
    private Long clientId;
    private List<OrderItemDTO> items;
    private String status;
    private float totalPrice;
    private LocalDate createdAt;
}
