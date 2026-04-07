#	                Vị trí	                            Loại vấn đề	                            Mô tả hậu quả
1	    <%! private int requestCounter = 0; %>	        Race Condition	        Biến dùng chung giữa nhiều request → dễ bị sai dữ liệu khi nhiều user truy cập cùng lúc
2	            <% for(...) %>	                        Logic trong View	    Vi phạm nguyên tắc MVC (View chỉ hiển thị, không xử lý logic)
3	        <%= student.getName() %>	                    XSS	                Nếu dữ liệu từ user → có thể chèn script gây lỗi bảo mật
4	            <!-- comment -->	                    Sai loại comment	    HTML comment vẫn render ra client → lộ code nội bộ
5	            <%= something %>;	                Sai cú pháp Expression	    Dấu ; có thể gây lỗi hoặc code không chuẩn
6	        if/else trong <% %>	                        Logic trong View	    Làm JSP khó đọc, khó maintain
7	    Java code nhiều trong JSP	                    Code smell	            Khó bảo trì, không đúng chuẩn “View ngốc nghếch”
