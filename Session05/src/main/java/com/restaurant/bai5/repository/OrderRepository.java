package com.restaurant.bai5.repository;

import com.restaurant.bai2.service.DishService;
import com.restaurant.common.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final DishService dishService;

    public OrderRepository(DishService dishService) {
        this.dishService = dishService;
    }

    public List<Dish> findAll() {
        return dishService.getAllDishes();
    }
}
