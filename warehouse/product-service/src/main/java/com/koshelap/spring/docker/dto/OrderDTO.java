package com.koshelap.spring.docker.dto;

import com.koshelap.spring.docker.model.Order;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDTO {

    private Long id;
    private Long clientId;
    private String status;
    private float totalPrice;
    private LocalDate createdAt;

    public OrderDTO(Order savedOrder) {
    }
}
