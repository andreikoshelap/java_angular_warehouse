package com.koshelap.spring.docker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.koshelap.spring.docker.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
