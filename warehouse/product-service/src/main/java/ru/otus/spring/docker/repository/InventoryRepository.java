package ru.otus.spring.docker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.docker.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
