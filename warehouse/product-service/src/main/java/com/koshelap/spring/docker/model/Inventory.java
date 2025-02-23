package com.koshelap.spring.docker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




    public Inventory(Long id) {
        this.id = id;
    }

    public Inventory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Inventory(String name, String description, float price, int stock, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public Inventory(String name, int stock, LocalDate createdAt) {
        this.name = name;
        this.stock = stock;
    }
}
