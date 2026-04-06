<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<html>
<head>
    <title>Kết quả tìm kiếm</title>
</head>
<body>

<!-- HEADER -->
<h2>
    Kết quả tìm kiếm cho:
    <c:out value="${keyword}" />
</h2>

<p>Tìm thấy ${totalFound} sự kiện</p>

<c:if test="${empty events}">
    <p>Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<!-- TABLE -->
<c:if test="${not empty events}">
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>

        <c:forEach var="event" items="${events}" varStatus="loop">
            <tr>

                <!-- STT -->
                <td>${loop.count}</td>

                <!-- TÊN (CHỐNG XSS) -->
                <td>
                    <c:out value="${event.name}" />
                </td>

                <!-- NGÀY -->
                <td>${event.eventDate}</td>

                <!-- GIÁ -->
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            MIỄN PHÍ
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number"/>
                        </c:otherwise>
                    </c:choose>
                </td>

                <!-- VÉ -->
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color:red;">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                        <span style="color:orange;">
                            Sắp hết (còn ${event.remainingTickets} vé)
                        </span>
                        </c:when>
                        <c:otherwise>
                        <span style="color:green;">
                                ${event.remainingTickets}
                        </span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <!-- LINK -->
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <button disabled>Đặt vé</button>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/events/${event.id}/book'/>">
                                Đặt vé
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>

<!-- FOOTER -->
<c:if test="${not empty events}">
    <p>
        Sự kiện đầu tiên:
            ${fn:toUpperCase(events[0].name)}
    </p>
</c:if>

<p>
    Độ dài từ khóa: ${fn:length(keyword)} ký tự
</p>

</body>
</html>

<%---
1. XSS là gì và vì sao <c:out> an toàn hơn ${}?

XSS (Cross-Site Scripting) là lỗ hổng bảo mật cho phép kẻ tấn công chèn mã JavaScript độc hại vào trang web. Khi người dùng khác truy cập, đoạn script này sẽ được thực thi trên trình duyệt của họ.

Trong JSP, nếu hiển thị dữ liệu người dùng bằng ${keyword}, dữ liệu sẽ được render trực tiếp ra HTML mà không qua xử lý. Ví dụ, nếu người dùng nhập:

<script>alert(1)</script>

thì trình duyệt sẽ thực thi đoạn script này và hiển thị popup, gây nguy hiểm.

Ngược lại, khi sử dụng <c:out value="${keyword}" />, JSP sẽ tự động escape các ký tự đặc biệt như <, >, chuyển thành &lt;, &gt;. Khi đó, trình duyệt chỉ hiển thị nội dung dưới dạng text, không thực thi script.

 Kết luận:
<c:out> an toàn hơn vì có cơ chế escape XML/HTML mặc định, giúp ngăn chặn XSS.

2. So sánh <c:if> và <c:choose>

Thẻ <c:if> được sử dụng khi chỉ có một điều kiện đơn giản, không có nhánh else. Nó tương đương với câu lệnh if trong Java.

Trong khi đó, <c:choose> kết hợp với <c:when> và <c:otherwise> tương đương với cấu trúc if - else if - else, dùng khi có nhiều điều kiện cần kiểm tra.

Trong bài này, phần hiển thị “Giá vé” và “Vé còn lại” có nhiều trường hợp khác nhau (ví dụ: miễn phí, còn vé, sắp hết, hết vé), nên sử dụng <c:choose> sẽ giúp code rõ ràng, dễ đọc và đúng logic hơn so với việc dùng nhiều <c:if> riêng lẻ.

Kết luận:
Dùng <c:if> cho điều kiện đơn giản, dùng <c:choose> khi có nhiều nhánh logic.

3. Vai trò của <c:url> so với hardcode link

Khi hardcode đường dẫn như:

href="/events/1/book"

đường dẫn này chỉ đúng khi ứng dụng chạy ở root context (/). Nếu ứng dụng được deploy với context path khác, ví dụ /ticketing, thì link sẽ bị sai và dẫn đến lỗi 404.

Ngược lại, khi sử dụng <c:url value="/events/${event.id}/book"/>, JSP sẽ tự động thêm context path hiện tại vào URL. Ví dụ:

/ticketing/events/1/book

Điều này giúp ứng dụng hoạt động đúng trong mọi môi trường deploy mà không cần sửa code.

Kết luận:
<c:url> giúp tạo URL động, đúng context path, tránh lỗi khi deploy.
---%>