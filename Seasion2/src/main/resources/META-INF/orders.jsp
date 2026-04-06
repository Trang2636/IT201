<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
</head>
<body>

<h2>
    Xin chào, ${sessionScope.loggedUser}!
    Vai trò: ${sessionScope.role}
</h2>

<a href="logout">Đăng xuất</a>

<table border="1">
    <tr>
        <th>Mã đơn</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>

    <c:forEach var="o" items="${orderList}">
        <tr>
            <td>${o.id}</td>
            <td>${o.productName}</td>
            <td>
                <fmt:formatNumber value="${o.total}" type="currency" currencySymbol="₫"/>
            </td>
            <td>
                <fmt:formatDate value="${o.date}" pattern="dd/MM/yyyy"/>
            </td>
        </tr>
    </c:forEach>

</table>

<p>
    Tổng lượt xem đơn hàng toàn hệ thống:
    ${applicationScope.totalViewCount}
</p>

</body>
</html>