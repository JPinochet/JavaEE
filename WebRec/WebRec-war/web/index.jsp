<%-- 
    Document   : index
    Created on : Apr 3, 2010, 7:32:53 PM
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
        <title>Website Rating</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
        <link rel="shortcut icon" href="nyansapo.gif" />
        <script type="text/javascript" src="js/textsizer.js"></script>
        <script type="text/javascript" src="js/rel.js"></script>
    </head>

    <body>
        <div id="wrap">
            <div id="top">
                <h2>Welcome to WebRec</h2>
            </div>
            <div id="context">
                <div id="right">
                    <div id="nav" align="right">
                        <c:choose>
                            <c:when test="${!empty sessionScope.user}">
                                <li><a href="Controller?logout=true" class="current">Logout</a></li>
                            </c:when>
                            <c:otherwise>
                                <form action="Controller" method="POST">
                                    Username: <input type="text" name="username" /><br />
                                    Password: <input type="text" name="password" /><br />
                                    <input align="right" type="submit" value="Login" /><br />
                                </form>
                                <a href="register.jsp">Register</a>
                                <c:if test="${!empty param.message}">
                                    <c:out value="${param.message}" /><br />
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div id="left">
                    <c:if test="${empty sessionScope.webList}">
                        <c:redirect url="/Controller?update=true"/>
                    </c:if>
                    <br /><br />
                    <h2>Top 5 Rated Websites</h2>
                    <table border="1">
                        <tr>
                            <th>URL</th>
                            <th>Description</th>
                            <th>Creator</th>
                            <th>Rating</th>
                        </tr>
                        <c:forEach begin="0" end="4" items="${sessionScope.webList}" var="website">
                            <tr>
                                <td><a href="<c:out value="${website.url}" />"><c:out value="${website.url}" /></a></td>
                                <td><c:out value="${website.description}" /></td>
                                <td><c:out value="${website.creator}" /></td>
                                <td><c:out value="${website.rating}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
