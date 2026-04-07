package ra.edu.session2.ex3;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        if ((username.equals("admin") && password.equals("admin123")) ||
                (username.equals("staff") && password.equals("staff123"))) {

            session.setAttribute("loggedUser", username);
            session.setAttribute("role", username.equals("admin") ? "ADMIN" : "STAFF");

            return "redirect:/orders";
        }

        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
