BÁO CÁO "Bẫy dữ liệu ép kiểu":
Khi người dùng nhập ID không phải số (ví dụ abc), Spring sẽ không thể ép kiểu sang Long và ném ra ngoại lệ.
Hệ thống sử dụng @ExceptionHandler để bắt lỗi này và trả về thông báo thân thiện thay vì crash ứng dụng.


BÁO CÁO "Idempotent":
Phương thức DELETE là idempotent vì khi gọi nhiều lần vẫn cho cùng một kết quả (xóa một đơn hàng, 
    các lần sau không làm thay đổi dữ liệu thêm).
Ngược lại, POST không idempotent vì mỗi lần gọi sẽ tạo ra một đơn hàng mới, nếu nhân viên bấm nhiều lần
    sẽ sinh ra nhiều dữ liệu trùng lặp không mong muốn.