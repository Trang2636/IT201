package com.restaurant.bai5.controller;

import com.restaurant.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/bai5/order")
    public String orderPage(Model model) {
        try {
            var dishes = service.getMenu();

            if (dishes == null || dishes.isEmpty()) {
                throw new RuntimeException("Không có món ăn!");
            }

            model.addAttribute("dishes", dishes);
            model.addAttribute("total", service.calculateTotal(dishes));

            return "order-page";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error-page";
        }
    }
}