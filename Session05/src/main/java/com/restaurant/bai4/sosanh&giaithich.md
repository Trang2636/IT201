## So sánh 2 cách xây dựng giao diện

| Tiêu chí      | (A) Copy-Paste       | (B) Layout Dialect |
|---------------|----------------------|--------------------|
| Tái sử dụng   | Không                | Có                 |
| Bảo trì       | Khó (sửa nhiều file) | Dễ (sửa 1 nơi)     |
| Độ sạch code  | Lặp lại              | DRY                |
| Mở rộng       | Khó                  | Dễ                 |
| Hiệu năng dev | Chậm                 | Nhanh              |
| Độ phức tạp   | Đơn giản             | Cần học thêm       |

## Kết luận
- Copy-paste phù hợp project nhỏ
- Layout Dialect phù hợp project thực tế


## Tại sao cần đăng ký LayoutDialect?
- Thymeleaf mặc định KHÔNG hỗ trợ layout:decorate
- LayoutDialect là thư viện mở rộng (extension)
- Khi đăng ký vào SpringTemplateEngine:
  → Thymeleaf mới hiểu được:
  - layout:decorate
  - layout:fragment

Nếu không đăng ký:
→ HTML vẫn chạy nhưng layout KHÔNG hoạt động