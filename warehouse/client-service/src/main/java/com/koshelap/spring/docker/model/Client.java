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
public class Client {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "created_at")
    private LocalDate createdAt;



    public Client(Integer id) {
        this.id = id;
    }


    public Client(String email, LocalDate createdAt) {
        this.email = email;
        this.createdAt = createdAt;
    }
}
