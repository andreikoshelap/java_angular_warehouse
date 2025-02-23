package com.koshelap.spring.docker.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private String category;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
