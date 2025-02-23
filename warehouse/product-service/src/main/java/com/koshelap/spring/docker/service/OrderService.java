package com.koshelap.spring.docker.service;

import com.koshelap.spring.docker.dto.OrderDTO;
import com.koshelap.spring.docker.dto.OrderRequestDTO;
import com.koshelap.spring.docker.model.Inventory;
import com.koshelap.spring.docker.model.Item;
import com.koshelap.spring.docker.model.Order;
import com.koshelap.spring.docker.repository.InventoryRepository;
import com.koshelap.spring.docker.repository.ItemRepository;
import com.koshelap.spring.docker.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;


    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, InventoryRepository inventoryRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.inventoryRepository = inventoryRepository;
        this.itemRepository = itemRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::orderToOrderDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setClientId(orderRequestDTO.getClientId());

        Order savedOrder = orderRepository.save(order);

        List<Item> items = orderRequestDTO.getItems().stream()
                .map(dto -> {
                    Inventory inventory = inventoryRepository.findById(dto.getProductId())
                            .orElseThrow(() -> new RuntimeException("Inventory not found: " + dto.getProductId()));

                    Item item = new Item();
                    item.setOrder(savedOrder);
                    item.setProduct(inventory);
                    item.setQuantity(dto.getQuantity());
                    item.setUnitPrice(dto.getUnitPrice());

                    return item;
                }).collect(Collectors.toList());

        itemRepository.saveAll(items);

        return orderMapper.orderToOrderDTO(savedOrder);
    }
}
