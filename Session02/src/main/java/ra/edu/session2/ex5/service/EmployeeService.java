package ra.edu.session2.ex5.service;

import ra.edu.session2.ex5.model.Employee;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> list = new ArrayList<>();

    public EmployeeService() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            list.add(new Employee("NV001","Nguyễn Thị Lan","Kế toán",15000000,sdf.parse("2020-03-01"),"Đang làm"));
            list.add(new Employee("NV002","Trần Văn Hùng","Kỹ thuật",25000000,sdf.parse("2019-07-15"),"Đang làm"));
            list.add(new Employee("NV003","Lê Minh Đức","Kinh doanh",18500000,sdf.parse("2021-11-20"),"Nghỉ phép"));
            list.add(new Employee("NV004","Phạm Thu Hương","Kỹ thuật",22000000,sdf.parse("2022-01-05"),"Đang làm"));
            list.add(new Employee("NV005","Hoàng Văn Nam","Kế toán",12000000,sdf.parse("2023-06-10"),"Thử việc"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAll() {
        return list;
    }

    public Employee findByCode(String code) {
        return list.stream()
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nhân viên [" + code + "] không tồn tại"));
    }

    public double totalTechSalary() {
        return list.stream()
                .filter(e -> e.getDepartment().equals("Kỹ thuật"))
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}