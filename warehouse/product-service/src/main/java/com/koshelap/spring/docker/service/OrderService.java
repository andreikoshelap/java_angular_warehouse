package com.koshelap.spring.docker.service;

import com.koshelap.spring.docker.dto.OrderDTO;
import com.koshelap.spring.docker.model.Order;
import com.koshelap.spring.docker.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper orderMapper;


    public OrderService(OrderRepository repository, OrderMapper orderMapper) {
        this.repository = repository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> getAllOrders() {
        return repository.findAll().stream()
                .map(orderMapper::orderToOrderDTO)
                .collect(Collectors.toList());
    }
}
