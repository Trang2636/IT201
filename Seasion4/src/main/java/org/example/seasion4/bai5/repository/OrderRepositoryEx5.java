package com.restaurant.bai5.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryEx5 {
    public String findById(Long id) {
        return "Thong tin don hang: " + id;
    }

    public String save() {
        return "Da tao don hang moi";
    }

    public String delete(Long id) {
        return "Da xoa don hang: " + id;
    }
}
