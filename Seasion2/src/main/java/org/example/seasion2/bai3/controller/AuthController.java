package org.example.seasion2.bai3.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

        @PostMapping("/login")
        public String login(@RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request) {

            if (("admin".equals(username) && "admin123".equals(password)) ||
                    ("staff".equals(username) && "staff123".equals(password))) {

                HttpSession session = request.getSession();
                session.setAttribute("loggedUser", username);
                session.setAttribute("role", username.equals("admin") ? "Admin" : "Staff");

                return "redirect:/orders";
            }

            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            return "login";
        }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.invalidate();
            return "redirect:/login";
        }
    }
}
