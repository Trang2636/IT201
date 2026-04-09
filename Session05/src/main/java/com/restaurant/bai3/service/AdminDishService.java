package com.restaurant.bai3.service;

import com.restaurant.bai2.service.DishService;
import com.restaurant.common.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {
    @Autowired
    private DishService dishService;

    public Dish findById(int id) {
        return dishService.getAllDishes().stream()
                .filter(d -> d.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Dish> getAll() {
        return dishService.getAllDishes();
    }
}
