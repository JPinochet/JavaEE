<%-- 
    Document   : admin
    Created on : Apr 6, 2010, 7:54:33 AM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Jorge Pinochet" />
        <meta name="description" content="Website that rates other websites! Voted on by you." />
        <meta name="keywords" content="site, rate, user managed" />
        <title>Admin JSP</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
        <link rel="shortcut icon" href="nyansapo.gif" />
        <script type="text/javascript" src="js/textsizer.js"></script>
        <script type="text/javascript" src="js/rel.js"></script>
    </head>
    <body>
        <div id="wrap">
            <div id="top">
                <h2>Admin Page</h2>
                <div align="right">
                    <br /><br />
                    Welcome, <c:out value="${sessionScope.user.username}" /><br />
                    <a href="Controller?logout=true" >Logout</a><br />
                    <a href="user.jsp">Website Page</a>
                </div>
            </div>
            <div id="context" align="center">
                <br />
                <h2>Websites</h2>
                <table border="1">
                    <tr>
                        <th>URL</th>
                        <th>Description</th>
                        <th>Rating</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${sessionScope.webList}" var="website">
                        <tr>
                            <td><a href="<c:out value="${website.url}" />"><c:out value="${website.url}" /></a></td>
                            <td><c:out value="${website.description}" /></td>
                            <td><c:out value="${website.rating}" /></td>
                            <td><a href="Controller?delete=${website.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <br />
                <h2>Users</h2>
                <table border="1">
                    <tr>
                        <th>User</th>
                        <th>Reset Password</th>
                        <th>Lock Account</th>
                        <th>Make Admin</th>
                        <th>Delete User</th>
                    </tr>
                    <c:forEach items="${sessionScope.userList}" var="users">
                        <tr>
                            <td><c:out value="${users.username}" /></td>
                            <td><a href="Controller?reset=${users.userId}">Reset Password</a></td>
                            <c:choose>
                                <c:when test="${users.lockedAccount == 0}">
                                    <td><a href="Controller?lockAccount=${users.userId}">Lock Account</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="Controller?lockAccount=${users.userId}">UnLock Account</a></td>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${users.isAdmin == 0}">
                                    <td><a href="Controller?makeAdmin=${users.userId}">Make Admin</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="Controller?makeAdmin=${users.userId}">Remove Admin</a></td>
                                </c:otherwise>
                            </c:choose>
                            <td><a href="Controller?deleteUser=${users.userId}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
