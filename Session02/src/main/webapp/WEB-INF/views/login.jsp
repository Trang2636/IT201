<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 06/04/2026
  Time: 8:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ex3</title>
</head>
<body>
    <h2>Đăng nhập</h2>

    <form method="post" action="login">
        Username: <input type="text" name="username"/><br>
        Password: <input type="password" name="password"/><br>
        <button type="submit">Login</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
</body>
</html>
