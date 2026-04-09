package com.restaurant.bai5.service;

import com.restaurant.bai5.repository.OrderRepository;
import com.restaurant.common.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    public List<Dish> getMenu() {
        return repository.findAll();
    }

    // tinh tong
    public int calculateTotal(List<Dish> dishes) {
        return dishes.stream().mapToInt((d->(int) d.getPrice())).sum();
    }
}
