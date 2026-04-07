1. XSS là gì?

XSS (Cross-Site Scripting) là lỗ hổng cho phép kẻ tấn công chèn mã JavaScript vào trang web. Khi người dùng truy cập, đoạn script này sẽ được thực thi trên trình duyệt.

Ví dụ input:

Nếu không xử lý, trình duyệt sẽ hiển thị popup.

2. Vì sao <c> an toàn hơn ${}?
   ${keyword} → render trực tiếp HTML → script chạy
   <c value="${keyword}"/> → escape HTML

Ví dụ:

Input:

Output:

${keyword}:
<c>:
<script>alert(1)</script> → không chạy
3. <c> vs <c>
<c>: dùng cho điều kiện đơn giản
<c>: giống if-else-if-else

Trong bài này:

Giá vé → nhiều trường hợp → dùng <c>
Vé còn lại → nhiều điều kiện → dùng <c>
4. <c> vs hardcode

Hardcode:
href="/events/1/book"

Nếu deploy:
http://localhost:8080/ticketing

→ link sẽ sai

<c>:
tự thêm context path

→ luôn đúng dù deploy ở đâu
