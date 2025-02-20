package ru.otus.spring.docker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private String category;
    @Column(name = "created_at")
    private LocalDate createdAt;



    public Inventory(Integer id) {
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
        this.createdAt = createdAt;
    }
}
