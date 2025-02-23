package com.koshelap.spring.docker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Inventory product;

    private Integer quantity;
    private float unitPrice;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


}
