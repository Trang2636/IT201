## LUỒNG DỮ LIỆU (DATA FLOW)

Bước 1: Người dùng bấm "Chỉnh sửa" tại trang dish-list.html (Bài 2)

View A (dish-list.html)
↓ gửi request GET /bai3/edit/{id}

Controller (AdminDishController)
↓ nhận id từ URL (@PathVariable)
↓ gọi Service tìm món ăn theo id

Service (AdminDishService)
↓ trả về đối tượng Dish

Controller
↓ add vào Model (attribute: dish)
↓ trả về view edit-dish.html

View B (edit-dish.html)
↓ sử dụng th:object + th:field để hiển thị dữ liệu lên form

---

## THYMELEAF SỬ DỤNG
- th:object → bind object Dish
- th:field → bind từng field (name, price, available)
- @{...} → tạo URL động