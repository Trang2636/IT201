Phân tích logic:

Việc lặp lại đoạn code
model.addAttribute("categories", ...)
ở nhiều hàm vi phạm nguyên tắc DRY (Don't Repeat Yourself) – tránh lặp code.

- Nếu sau này hệ thống có nhiều trang (ví dụ 20 trang) cùng sử dụng danh sách này:
    + Khi cần thay đổi dữ liệu phải sửa ở nhiều nơi
    + Dễ quên cập nhật → gây lỗi không đồng bộ
    + Code khó bảo trì, khó mở rộng