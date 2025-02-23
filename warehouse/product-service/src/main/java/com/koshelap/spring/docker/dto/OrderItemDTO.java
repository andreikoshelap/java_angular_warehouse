package com.koshelap.spring.docker.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderItemDTO {
    private Long productId;
    private Integer quantity;
    private Float unitPrice;
}
