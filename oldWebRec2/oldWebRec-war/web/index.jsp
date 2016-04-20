<%-- 
    Document   : index
    Created on : Mar 26, 2010, 2:08:03 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webSite.WebSite" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top 5 sites</title>
    </head>
    <body>
        <h1>The Top 5 Rated Websites</h1>
        <table border="1">
            <tr>
                <th>URL</th>
                <th>Rating</th>
                <th>Description</th>
            </tr>
            <c:forEach begin="1" end="5" var="webList" items="${sessionScope.webList}">
                <tr>
                    <td><c:out value="${webList.url}" /></td>
                    <td><c:out value="${webList.rating}" /></td>
                    <td><c:out value="${webList.description}" /></td>
                </tr>
            </c:forEach>
        </table>


        <c:choose>
            <c:when test="${!empty sessionScope.user}">
                <a href="Controller?logout=true">Logout</a>
            </c:when>
            <c:otherwise>
                <form action="Controller" method="POST">
                    Username: <input type="text" name="username" />
                    Password: <input type="text" name="password" />
                    <input type="submit" value="Login" />
                </form>
                <a href="register.jsp">Register</a>
            </c:otherwise>
        </c:choose>
        
        <c:if test="${!empty param.message}">
            <c:out value="${param.message}" /><br />
        </c:if>
    </body>
</html>
