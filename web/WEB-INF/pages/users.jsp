<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vans
  Date: 23.08.2014
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:if test="${! empty(users)}">
    <table width="600px">
        <tr>
            <td><b>ID</b></td>
            <td><b>Name</b></td>
            <td><b>E-mail</b></td>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                    <a href="/edit?id=${user.id}" > ${user.id} </a>
                </td>
                <td>${user.userName}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${ empty(users)}">
    <h1>Empty list of users yet!</h1>
</c:if>
<a href="${pageContext.request.contextPath}/add">Create new user</a>
</body>
</html>
