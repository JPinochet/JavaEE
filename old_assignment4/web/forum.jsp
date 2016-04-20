<%-- 
    Document   : forum
    Created on : Mar 19, 2010, 2:25:25 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forum</title>
    </head>
    <body>
        <h1>Forum Main Page</h1><br />
        Welcome, <c:out value="${sessionScope.user}"/><br />
        <a href="Controller?logout=true">Logout</a><br />
        <h2>Create New Thread</h2>
        <form action="Controller" method="post">
            Thread title: <input type="text" name="newThreadTitle" /><br />
            Initial post: <input type="text" name="newThreadInitPost" /><br />
            <input type="submit" value="Post" />
        </form>
        <h2>List of Threads</h2>
        <table border="1">
            <tr>
                <th>Date</th><th>Thread Name</th><th>Creator</th>
            </tr>
            <c:forEach var="threadsList" items="${sessionScope.threadsList}">
                <tr>
                    <td><c:out value="${threadsList.date}" /></td>
                    <td><a href="Controller?threadID=${threadsList.id}">${threadsList.name}</a></td>
                    <td><c:out value="${threadsList.creator}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
