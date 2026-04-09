package com.restaurant.bai3.controller;

import com.restaurant.bai3.service.AdminDishService;
import com.restaurant.common.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminDishController {
    @Autowired
    private AdminDishService dishService;

    @GetMapping("/bai3/edit/{id}")
    public String editDish(@PathVariable("id") int id, Model model) {
        Dish dish = dishService.findById(id);

        if(dish==null){
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu");
            model.addAttribute("dishes", dishService.getAll());
            return "dish-list";
        }
       model.addAttribute("dish", dish);
        return "edit-dish";
    }
}
