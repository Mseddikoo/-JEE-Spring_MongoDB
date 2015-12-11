<%--
  Created by IntelliJ IDEA.
  User: Vans
  Date: 23.08.2014
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/add" modelAttribute="user">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="userName" alt="${user.userName}" /></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><form:input path="email" alt="${user.email}"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password" alt="${user.password}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
