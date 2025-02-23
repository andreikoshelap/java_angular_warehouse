package com.koshelap.spring.docker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int clientId;

    private String status;
    private float totalPrice;
    @Column(name = "created_at")
    private LocalDate createdAt;
    private LocalDate updatedAt;


}
