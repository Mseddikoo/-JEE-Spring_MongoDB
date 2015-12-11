<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vans
  Date: 07.09.2014
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <link href="<c:url value="/resources/css/general.css"/>" rel="stylesheet">
</head>
<body onload="document.loginForm.username.focus();">
    <h1>Welcome! Please, introduce yourself?</h1>

    <div id="login-box">
        <h3>Use login and password to access protected content</h3>
        
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <form name="loginForm" action="<c:url value="/j_spring_security_check"/> " method="post">
            <table>
                <tr>
                    <td>User:</td>
                    <td>
                        <input type='text' name='username' value=''>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <input type='password' name='password'/>
                    </td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit"
                                           value="submit" /></td>
                </tr>
            </table>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </div>
</body>
</html>
