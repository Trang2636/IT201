package org.example.seasion4.bai2.service;

import org.example.seasion4.bai1.service.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private org.example.seasion4.bai1.service.OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public String getAllOrders() {

        return orderRepository.getAllOrders();

    }
    public String getOrderById(Long id) {

        return orderRepository.getOrderById(id);
    }
}

