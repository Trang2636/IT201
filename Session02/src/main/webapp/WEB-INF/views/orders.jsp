<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 06/04/2026
  Time: 8:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Ex3</title>
</head>
<body>
<h2>
    Xin chào, ${sessionScope.loggedUser}!
    Vai trò: ${sessionScope.role}
</h2>

<a href="logout">Đăng xuất</a>

<table border="1">
    <tr>
        <th>Mã</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày</th>
    </tr>

    <c:forEach var="o" items="${orders}">
        <tr>
            <td>${o.id}</td>
            <td>${o.productName}</td>
            <td>
                <fmt:formatNumber value="${o.total}" type="currency"/>
            </td>
            <td>
                <fmt:formatDate value="${o.orderDate}" pattern="dd/MM/yyyy"/>
            </td>
        </tr>
    </c:forEach>
</table>

<p>
    Tổng lượt xem đơn hàng: ${applicationScope.totalViewCount}
</p>
</body>
</html>
