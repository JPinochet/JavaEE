<%-- 
    Document   : user
    Created on : Apr 2, 2010, 5:08:13 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <body>
        <h1>Users Page</h1>
        <a href="Controller?logout=true">Logout</a>
        <h2>Add a new site</h2>
        <form action="Controller" method="POST">
            URL: <input type="text" name="url" /><br />
            Description: <input type="text" name="description" /><br />
            <input type="submit" value="Add Website" /><br />
        </form>
        <c:if test="${!empty param.message}">
            <c:out value="${param.message}" /><br />
        </c:if>
        <table border="1">
            <tr>
                <th>Website</th>
                <th>Rating</th>
                <th>Description</th>
                <th>Creator</th>
            </tr>
            <c:forEach var="webList" items="${sessionScope.webList}">
                <tr>
                    <td><c:out value="${webList.url}" /></td>
                    <td><c:out value="${webList.rating}" /></td>
                    <td><c:out value="${webList.description}" /></td>
                    <td><c:out value="${webList.creator}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
