package ra.edu.session2.ex5.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ra.edu.session2.ex5.model.Employee;
import ra.edu.session2.ex5.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public String list(HttpSession session, Model model) {

        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        model.addAttribute("employees", service.getAll());
        model.addAttribute("totalTechSalary", service.totalTechSalary());

        return "employees";
    }

    @GetMapping("/employees/{code}")
    public String detail(@PathVariable String code,
                         HttpSession session,
                         Model model) {

        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        model.addAttribute("emp", service.findByCode(code));
        return "employee-detail";
    }
}