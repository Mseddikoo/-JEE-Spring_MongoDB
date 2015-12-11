<%--
  Created by IntelliJ IDEA.
  User: Vans
  Date: 21.08.2014
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Root Page</title>
</head>
<body>
<%@include file="static/_header.jsp" %>
<h1>This is going to be root page of blog for ${parameter}</h1>

<a href="${pageContext.request.contextPath}/users">Get info about users</a>
<a href="${pageContext.request.contextPath}/about">About me</a>
<a href="${pageContext.request.contextPath}/contacts">Contacts</a>
</body>
</html>
