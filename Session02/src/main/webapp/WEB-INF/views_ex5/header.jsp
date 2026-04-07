<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 06/04/2026
  Time: 9:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>HR Portal</h2>
<p>
    ${sessionScope.loggedUser}
    | <a href="<c:url value='/logout'/>">Logout</a>
</p>
<hr>
