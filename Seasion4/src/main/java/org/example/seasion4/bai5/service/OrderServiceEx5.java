package com.restaurant.bai5.service;

import com.restaurant.bai5.repository.OrderRepositoryEx5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceEx5 {
    private final OrderRepositoryEx5 repository;

    public OrderServiceEx5(OrderRepositoryEx5 repository) {
        this.repository = repository;
    }

    public String getOrder(Long id) {
        return repository.findById(id);
    }

    public String createOrder() {
        return repository.save();
    }

    public String deleteOrder(Long id) {
        return repository.delete(id);
    }
}
