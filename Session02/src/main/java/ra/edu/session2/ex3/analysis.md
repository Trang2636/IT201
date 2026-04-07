## 1. Request Scope vs Session Scope

Thông báo lỗi đăng nhập nên được lưu trong **Request Scope** vì chỉ cần hiển thị một lần ngay sau khi người dùng submit form.
Nếu lưu vào **Session Scope**, thông báo lỗi sẽ bị giữ lại trong nhiều request tiếp theo, kể cả khi người dùng đã thao tác lại đúng. Điều này gây ra trải nghiệm không tốt và hiển thị thông tin sai lệch.
Do đó, Request Scope là phù hợp vì nó chỉ tồn tại trong một request và tự động mất sau khi trang được load lại.

---

## 2. Application Scope
Biến `totalViewCount` cần được lưu trong **Application Scope** vì đây là dữ liệu dùng chung cho toàn bộ hệ thống.
Nếu lưu trong **Session Scope**, mỗi người dùng sẽ có một bộ đếm riêng. Ví dụ:
* Nhân viên A xem 2 lần → thấy 2
* Nhân viên B xem 1 lần → thấy 1
Điều này không phản ánh đúng tổng số lượt xem của toàn hệ thống.
Application Scope giúp tất cả người dùng cùng nhìn thấy một giá trị chung, đảm bảo tính chính xác của dữ liệu.

---

## 3. Race Condition
**Race Condition** là tình trạng nhiều request (nhiều người dùng) cùng truy cập và thay đổi một biến chung tại cùng một thời điểm, dẫn đến dữ liệu bị sai lệch.
Khi nhiều người truy cập cùng lúc:
* Nhiều thread có thể đọc cùng một giá trị `count`
* Sau đó cùng tăng lên → mất dữ liệu (ví dụ từ 5 lên 6 thay vì 7)

### Cách khắc phục

Sử dụng cơ chế đồng bộ (synchronized):

```
synchronized (application) {
    Integer count = (Integer) application.getAttribute("totalViewCount");
    if (count == null) count = 0;
    count++;
    application.setAttribute("totalViewCount", count);
}
```

Cách này đảm bảo tại một thời điểm chỉ có một thread được phép cập nhật giá trị, giúp tránh sai lệch dữ liệu.

---
