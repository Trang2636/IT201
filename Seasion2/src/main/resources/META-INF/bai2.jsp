<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>${reportTitle}</title>
</head>
<body>

<h1>${reportTitle}</h1>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>

    <c:forEach var="sv" items="${studentList}" varStatus="loop">
        <tr>
            <!-- STT -->
            <td>${loop.index + 1}</td>
            <td>
                <c:out value="${sv.fullName}" />
            </td>
            <td>${sv.score}</td>
            <td>
                <c:choose>
                    <c:when test="${sv.score >= 90}">Xuất sắc</c:when>
                    <c:when test="${sv.score >= 80}">Giỏi</c:when>
                    <c:when test="${sv.score >= 70}">Khá</c:when>
                    <c:when test="${sv.score >= 60}">Trung bình khá</c:when>
                    <c:when test="${sv.score >= 50}">Trung bình</c:when>
                    <c:otherwise>Yếu</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>

<%---
phân tích
Biến dùng chung cho nhiều request → nhiều user truy cập đồng thời → sai dữ liệu, không thread-safe
View không nên chứa logic Java → khó bảo trì, sai kiến trúc MVC
JSP phụ thuộc Java code → khó đọc, khó test
In ra giao diện bị sai: ví dụ 92;
Logic nên nằm Controller/Service
---%>