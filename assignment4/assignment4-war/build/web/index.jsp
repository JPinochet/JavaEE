<%-- 
    Document   : index
    Created on : Mar 19, 2010, 2:05:03 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment 4 Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <br />
        <form action="Controller" method="post">
            Username: <input type="text" name="username" /><br />
            Password: <input type="text" name="password" /><br />
            <input type="submit" value="Login" /><br />
            <a href="register.jsp">Register</a><br />
        </form>
        <c:if test="${! empty param.message}">
            <c:out value="${param.message}"/><br />
        </c:if>
    </body>
</html>
