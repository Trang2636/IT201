package org.example.seasion7_bai5.controller;
import org.example.seasion7_bai5.model.Combo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/combo")
public class ComboController {
    private static List<Combo> comboList=new ArrayList<>();

    @GetMapping("/add")
    public String showFrom(){
        return "combo-add";
    }

    @PostMapping("/add")
    public String addCombo(@RequestParam("items") List<String> itemList, @RequestParam("banner")MultipartFile file) throws IOException {
        //check solg mon
        if(itemList== null || itemList.size()<2){
            System.out.println("Combo phai co it nhaat 2 mon");
            return "combo-add";
        }

        // luu
        String uploadDir = "E:/upload_img_java/";
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File dest = new File(uploadDir + fileName);
        file.transferTo(dest);

        Combo combo=new Combo(itemList, dest.getAbsolutePath());
        comboList.add(combo);

        System.out.println("Combo moi: ");
        System.out.println("Items: " + combo.getItemList());
        System.out.println("Banner: " + combo.getBannerPath());
        return "combo-add";
    }
}