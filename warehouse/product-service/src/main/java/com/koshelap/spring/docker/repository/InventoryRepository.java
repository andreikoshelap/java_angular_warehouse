package com.koshelap.spring.docker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.koshelap.spring.docker.model.Inventory;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
