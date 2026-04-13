package org.example.seasion7_bai3.controller;

import org.example.seasion7_bai3.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    // luu tạm
    private static List<Food> foodList = new ArrayList<Food>();

    @GetMapping("/add")
    public String showForm() {
        return "food-add";
    }


    @PostMapping("/add")
    public String addFood(@RequestParam("name") String name, @RequestParam("category") String category,
                          @RequestParam("price") double price, @RequestParam("image") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        // check rong
        if (file.isEmpty()) {
            System.out.println("Loi tai len: File rong");
            return "food-add";
        }

        // check dinh dang
        String filename = file.getOriginalFilename();
        if (filename == null || !(filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".jpeg"))) {
            System.out.println("Loi sai dinh dang file");
            return "food-add";
        }

        // check gia
        if (price < 0) {
            System.out.println("Gia phai >= 0");
            return "food-add";
        }


        // bai4
        // tao filde k trung ten
        String uniqueName= System.currentTimeMillis() + "_"+ filename;

        // luu file
        String uploadDir = "E:/upload_img_java/";
        File dest = new File(uploadDir + uniqueName);
        file.transferTo(dest);

        // luu vao list
        Food food = new Food(name, category, price, dest.getAbsolutePath());
        foodList.add(food);

        int id=foodList.size()-1;
        // redirect + truyen du lieu
        redirectAttributes.addFlashAttribute("mesage", "them thanh cong");
        redirectAttributes.addAttribute("id", id);
        System.out.println("Da them mon: " + name);
        System.out.println("Tong so mon: " + foodList.size());
        return "redirect:/food/detail";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id, Model model) {
        if(id>=0 && id<foodList.size()) {
            model.addAttribute("food", foodList.get(id));
        }
        return "food-detail";
    }
}