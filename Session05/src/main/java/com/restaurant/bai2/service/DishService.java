package com.restaurant.bai2.service;

import com.restaurant.common.model.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    private List<Dish> dishes = new ArrayList<>();
    public DishService() {
        dishes.add(new Dish(1, "Phở bò", 40000, true));
        dishes.add(new Dish(2, "Bún chả", 35000, false));
        dishes.add(new Dish(3, "Cơm tấm", 45000, true));
        System.out.println("SIZE: " + dishes.size());
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }

}
