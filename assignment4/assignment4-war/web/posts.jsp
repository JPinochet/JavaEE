<%-- 
    Document   : posts
    Created on : Mar 19, 2010, 2:51:46 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post</title>
    </head>
    <body>
        <h1>Thread Posts</h1>
        Welcome, <c:out value="${sessionScope.user}"/><br />
        <a href="Controller?logout=true">Logout</a><br />
        <a href="forum.jsp">BACK</a><br />
        <h2>New Post</h2>
        <form action="Controller?threadId=${threadId}" method="post">
            Reply: <input type="text" name="newPost" /><input type="submit" value="Post" /><br />
        </form>
        <c:if test="${! empty param.message}">
            <c:out value="${param.message}"/><br />
        </c:if>
        <h2>List of Posts</h2>
        <table border="1">
            <tr>
                <th>Date</th><th>Post</th><th>From</th>
            </tr>
            <c:forEach var="postList" items="${sessionScope.postList}">
                <tr>
                    <td><c:out value="${postList.datePosted}" /></td>
                    <td><c:out value="${postList.postText}" /></td>
                    <td><c:out value="${postList.fk_username}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
