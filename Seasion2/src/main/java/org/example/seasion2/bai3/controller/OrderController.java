package org.example.seasion2.bai3.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("OD01", "Laptop", 15000000, new Date()));
        orders.add(new Order("OD02", "Chuột", 300000, new Date()));
        orders.add(new Order("OD03", "Bàn phím", 800000, new Date()));

        request.setAttribute("orderList", orders);

        ServletContext application = request.getServletContext();

        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            application.setAttribute("totalViewCount", count + 1);
        }

        return "orders";
    }
}
