## Phân tích lỗi cấu hình Thymeleaf

1. Sai prefix:
- Code sử dụng "/WEB-INF/views" là thư mục dành cho JSP
- Thymeleaf phải dùng "/WEB-INF/templates/"

2. Sai suffix:
- Code sử dụng ".jsp"
- Thymeleaf yêu cầu ".html"

3. Thiếu cấu hình:
- Chưa cấu hình TemplateMode
- Thiếu SpringTemplateEngine
- Thiếu ThymeleafViewResolver

## Cách sửa:
- Đổi prefix thành /WEB-INF/templates/
- Đổi suffix thành .html
- Thêm đầy đủ TemplateResolver, TemplateEngine, ViewResolver