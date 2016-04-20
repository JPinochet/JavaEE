<%-- 
    Document   : register
    Created on : Mar 19, 2010, 2:14:08 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
    </head>
    <body>
        <h1>Register</h1>
        <br />
        <a href="index.jsp">BACK</a><br />
        <br />
        <form action="Controller" method="post">
            <table>
                <tr>
                    <td>New user name:</td>
                    <td><input type="text" name="newUsername"></td>
                </tr>
                 <tr>
                    <td>Password:</td>
                    <td><input type="text" name="newPassword"></td>
                </tr>
                <tr>
                    <td>Confirm password:</td>
                    <td><input type="text" name="conPassword"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
        <c:if test="${! empty param.message}">
            <c:out value="${param.message}"/><br />
        </c:if>
    </body>
</html>
