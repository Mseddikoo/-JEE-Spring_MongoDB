<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>
<%--
  Created by IntelliJ IDEA.
  User: Vans
  Date: 07.09.2014
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is header's title!</title>
</head>
<body>
   <a href="<c:url value="/index"/>">
       <img src="<c:url value="/resources/images/blog.png"/>" alt="Home">
   </a>
<sec:authorize access="isAnonymous()">
    <a href="<c:url value="/login"/>">Login</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <h6>Hi, ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()">Logout</a> </h6>

    <c:url value="/j_spring_security_logout" var="logoutUrl"/>
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>

</sec:authorize>
</body>
</html>
