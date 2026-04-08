package org.example.seasion4.bai2.service;

import org.springframework.web.bind.annotation.RequestParam;

public class OrderRepository {

    public String getAllOrders() {

        return "Danh sach toan bo don hang";

    }



    public String getOrderById(Long id) {

        return "Thong tin don hang voi ID: " + id;

    }




}
