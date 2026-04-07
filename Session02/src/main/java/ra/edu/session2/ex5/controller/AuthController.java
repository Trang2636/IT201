package ra.edu.session2.ex5.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        if ((username.equals("hr_manager") && password.equals("hr123")) ||
                (username.equals("hr_staff") && password.equals("staff456"))) {

            session.setAttribute("loggedUser", username);
            session.setAttribute("role", username.equals("hr_manager") ? "hr_manager" : "hr_staff");

            return "redirect:/employees";
        }

        model.addAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}