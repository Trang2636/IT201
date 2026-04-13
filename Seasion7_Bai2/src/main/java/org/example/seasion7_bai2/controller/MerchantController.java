package org.example.seasion7_bai1.controller;

import org.example.seasion7_bai1.model.RestaurantProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MerchantController {
    @PostMapping("/merchant/update-profile")
    public String updateProfile( RestaurantProfile profile) {
        System.out.println("Tên quán: "+ profile.getName());
            return "success";
    }
}
