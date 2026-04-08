package org.example.seasion4.bai3.controller;
import org.example.seasion4.bai1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("legacyControllerBai3")

public class LegacyController {

    private OrderService orderService;



    @Autowired
    public LegacyController(OrderService orderService) {

        this.orderService = orderService;

    }



    @GetMapping(value = "/bai1/orders")

    @ResponseBody

    public String getAllOrders() {

        return orderService.getAllOrders();

    }



    @GetMapping(value = "/bai1/orders/{id}")

    @ResponseBody

    public String getOrderById(@PathVariable Long id) {

        return orderService.getOrderById(id);

    }

}


