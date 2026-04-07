<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 06/04/2026
  Time: 11:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="header.jsp" %>

<p>Tên: <c:out value="${emp.name}"/></p>

<p>Lương:
    <c:choose>
        <c:when test="${sessionScope.role=='hr_manager'}">
            <fmt:formatNumber value="${emp.salary}"/>
        </c:when>
        <c:otherwise>***</c:otherwise>
    </c:choose>
</p>

<a href="<c:url value='/employees'/>">Quay lại</a>

<%@ include file="footer.jsp" %>