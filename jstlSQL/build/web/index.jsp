<%-- 
    Document   : index
    Created on : Mar 11, 2010, 12:54:21 PM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<s:setDataSource var="source" url="jdbc:mysql://localhost/myusers"
                 user="root" password="password"
                 driver="com.mysql.jdbc.Driver" />

<s:query var="users" dataSource="${source}" sql="SELECT * FROM users" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Users</title>
    </head>
    <body>
        <h1>List of Users</h1>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Password</th>
            </tr>
            <c:forEach var="user" items="${users.rows}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
