package com.restaurant.bai5.controller;

import com.restaurant.bai5.service.OrderServiceEx5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai5/orders")
public class LegacyControllerEx5 {

    private final OrderServiceEx5 service;

    public LegacyControllerEx5(OrderServiceEx5 service) {
        this.service = service;
    }

    //get
    @GetMapping("/{id}")
    @ResponseBody
    public String getOrder(@PathVariable("id") Long id) {
        return service.getOrder(id);
    }

    //post
    @PostMapping
    @ResponseBody
    public String createOrder() {
        return service.createOrder();
    }

    //delete
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable("id") Long id) {
        return service.deleteOrder(id);
    }

    //error
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleError(Exception e) {
        return "ID don hang phai la mot so!";
    }
}