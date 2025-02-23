package com.koshelap.spring.docker.service;

import com.koshelap.spring.docker.dto.ClientDTO;
import com.koshelap.spring.docker.dto.OrderDTO;
import com.koshelap.spring.docker.dto.OrderRequestDTO;
import com.koshelap.spring.docker.model.Inventory;
import com.koshelap.spring.docker.model.Item;
import com.koshelap.spring.docker.model.Order;
import com.koshelap.spring.docker.repository.InventoryRepository;
import com.koshelap.spring.docker.repository.ItemRepository;
import com.koshelap.spring.docker.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;
    private final ClientService clientService;


    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::orderToOrderDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public OrderDTO createOrder(OrderRequestDTO orderRequestDTO) {
        ClientDTO client = clientService.getClientById(orderRequestDTO.getClientId());
        if (client == null) {
            throw new RuntimeException("Client not found: " + orderRequestDTO.getClientId());
        }
        Order order = new Order();
        order.setClientId(client.getId());
        order.setStatus(orderRequestDTO.getStatus());
        order.setTotalPrice(orderRequestDTO.getTotalPrice());
        order.setCreatedAt(orderRequestDTO.getCreatedAt());
        order.setUpdatedAt(orderRequestDTO.getCreatedAt());

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
