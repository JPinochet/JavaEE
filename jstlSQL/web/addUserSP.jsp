<%--
    Document   : addUser
    Created on : Mar 11, 2010, 1:18:50 PM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<c:if test="${!empty param.username}">
    <s:setDataSource var="source" url="jdbc:mysql://localhost/myusers"
                 user="root" password="password"
                 driver="com.mysql.jdbc.Driver" />
    <s:update var="result" dataSource="${source}"
              sql="CALL addUser(?,?,@result)">
        <s:param value="${param.username}"/>
        <s:param value="${param.password}"/>
    </s:update>
</c:if>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
    </head>
    <body>
        <h1>Add User</h1>
        <form action="addUserSP.jsp" method="post">
            Username: <input type="text" name="username"><br />
            Password: <input type="text" name="password"><br />
            <input type="submit" value="Add User">
            <c:if test="${!empty result}">
                <br /><c:out value="RESULT: ${result}" /><br />
            </c:if>
        </form>
    </body>
</html>
