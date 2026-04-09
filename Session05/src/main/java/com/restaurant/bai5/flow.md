## Kiến trúc 3 tầng
Client (Browser)
↓ request /bai5/order
Controller (OrderController)
↓ gọi Service
Service (OrderService)
↓ xử lý logic (tính tổng tiền)
↓ gọi Repository
Repository (OrderRepository)
↓ trả dữ liệu (in-memory)
Controller
↓ add Model
View (HTML - Thymeleaf)
↓ hiển thị

## Nguyên tắc
- View: chỉ hiển thị (Dumb View)
- Service: xử lý logic
- Repository: lưu trữ dữ liệu


## Natural Templating
- HTML vẫn hiển thị được khi mở trực tiếp bằng trình duyệt
- Mock data được viết sẵn trong HTML
- Khi chạy Spring:
  → Thymeleaf thay thế bằng dữ liệu thật (th:each)
→ Đảm bảo Designer và Developer làm việc độc lập