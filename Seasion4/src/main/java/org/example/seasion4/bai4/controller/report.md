BẢN THIẾT KẾ LUỒNG I/O

Dữ liệu đầu vào được truyền từ URL gồm 2 tham số: category và limit.
Controller nhận dữ liệu bằng @RequestParam, sau đó đưa vào ModelMap với các key tương ứng là category, limit và message.
View được sử dụng là file productList.jsp, nơi hiển thị dữ liệu bằng biểu thức ${}