## 1. Cấu trúc đối tượng Dish
- id: int → mã món ăn
- name: String → tên món
- price: double → giá tiền
- isAvailable: boolean → trạng thái còn hàng

## 2. Luồng Input / Output

Client (Browser)
↓ request GET /bai2/dishes
Controller (DishController)
↓ gọi Service
Service (DishService)
↓ trả về List<Dish>
Controller
↓ add vào Model (attribute: dishes)
View (dish-list.html)
↓ render bằng Thymeleaf (th:each, th:if)
Client nhận HTML