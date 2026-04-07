package ra.edu.session2.ex3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String orders(HttpSession session, HttpServletRequest request, Model model) {

        // chưa login
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // lấy application scope
        ServletContext application = request.getServletContext(); // ✅ thêm dòng này

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("OD01", "Laptop", 15000000, new Date()));
        orders.add(new Order("OD02", "Chuột", 200000, new Date()));
        orders.add(new Order("OD03", "Bàn phím", 500000, new Date()));

        model.addAttribute("orders", orders);

        // cập nhật counter
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) {
                count = 0;
            }
            count++;
            application.setAttribute("totalViewCount", count);
        }

        return "orders";
    }
}