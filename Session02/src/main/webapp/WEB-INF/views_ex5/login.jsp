<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 06/04/2026
  Time: 10:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form method="post" action="<c:url value='/login'/>">
    Username: <input name="username"><br>
    Password: <input type="password" name="password"><br>
    <button>Login</button>
</form>

<c:if test="${not empty errorMessage}">
    <p style="color:red"><c:out value="${errorMessage}"/></p>
</c:if>