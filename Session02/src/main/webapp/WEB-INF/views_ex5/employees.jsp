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

<table border="1">
    <tr>
        <th>#</th><th>Tên</th><th>Lương</th><th>Ngày</th><th>Trạng thái</th><th></th>
    </tr>

    <c:forEach var="emp" items="${employees}" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td><c:out value="${emp.name}"/></td>

            <td><fmt:formatNumber value="${emp.salary}"/></td>
            <td><fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy"/></td>

            <td>
                <c:choose>
                    <c:when test="${emp.status=='Đang làm'}"><span style="color:green">Đang làm</span></c:when>
                    <c:when test="${emp.status=='Nghỉ phép'}"><span style="color:orange">Nghỉ phép</span></c:when>
                    <c:otherwise><span style="color:blue">Thử việc</span></c:otherwise>
                </c:choose>
            </td>

            <td><a href="<c:url value='/employees/${emp.code}'/>">Chi tiết</a></td>
        </tr>
    </c:forEach>
</table>

<p>Tổng lương IT: <fmt:formatNumber value="${totalTechSalary}"/></p>

<%@ include file="footer.jsp" %>