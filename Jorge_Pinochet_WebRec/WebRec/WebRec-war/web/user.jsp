<%-- 
    Document   : user
    Created on : Apr 6, 2010, 7:54:21 AM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList, webrecDB.*, website.WebSite" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Jorge Pinochet" />
        <meta name="description" content="Website that rates other websites! Voted on by you." />
        <meta name="keywords" content="site, rate, user managed" />
        <title>User Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
        <link rel="shortcut icon" href="nyansapo.gif" />
        <script type="text/javascript" src="js/textsizer.js"></script>
        <script type="text/javascript" src="js/rel.js"></script>
    </head>
    <body>
        <div id="wrap">
            <div id="top">
                <h2>User Page</h2>
                <div align="right">
                    <br /><br />
                    Welcome, <c:out value="${sessionScope.user.username}" /><br />
                    <a href="Controller?logout=true" >Logout</a><br />
                    <c:if test="${sessionScope.user.isAdmin == 1}">
                        <a href="admin.jsp">Admin Page</a>
                    </c:if>
                </div>
            </div>
            <div id="context">
                <div align="center">
                    <div align="right">
                        <h2>Add Webiste</h2>
                        <form action="Controller" method="POST">
                            URL: <input type="text" name="newWebURL" /><br />
                            Description: <input type="text" name="newWebDesc" /><br />
                            <input type="submit" value="Save" /><br />
                        </form>
                        <c:if test="${!empty param.edit}">
                            <h2>WebSite Details</h2>
                            <form action="Controller?edit=${param.edit}" method="POST">
                                <c:forEach items="${sessionScope.webList}" var="website">
                                    <c:if test="${param.edit == website.id}">
                                        URL: <input type="text" name="webURL" value="${website.url}" /><br />
                                        Description: <input type="text" name="webDesc" value="${website.description}" /><br />
                                        <input type="submit" value="Save" /> <br />
                                    </c:if>
                                </c:forEach>
                            </form>
                        </c:if>
                    </div>
                    <h2>Search:</h2>
                    <form action="user.jsp" method="GET">
                        Search: <input type="text" name="search" />
                        <input type="submit" value="Search" />
                    </form>
                    <c:if test="${!empty param.search}">
                        <table border="1">
                            <tr>
                                <th>URL</th>
                                <th>Description</th>
                                <th>Creator</th>
                                <th>Rating</th>
                                <th>Rate</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <%
                                        String search = null;
                                        if (request.getParameter("search") != null) {
                                            search = request.getParameter("search");
                                        }
                                        Users user = null;
                                        if (session.getAttribute("user") != null) {
                                            user = (Users) session.getAttribute("user");
                                        }
                                        ArrayList<WebSite> websites = new ArrayList<WebSite>();
                                        if (session.getAttribute("webList") != null) {
                                            websites = (ArrayList<WebSite>) session.getAttribute("webList");
                                        }

                                        for (int i = 0; i < websites.size(); i++) {
                                            if (websites.get(i).getUrl().contains(search)) {
                            %>
                            <tr>
                                <td><a href=<%= websites.get(i).getUrl() %>><%= websites.get(i).getUrl() %></a></td>
                                <td><%= websites.get(i).getDescription()%></td>
                                <td><%= websites.get(i).getCreator()%></td>
                                <td><%= websites.get(i).getRating()%></td>
                                <td width="52px">
                                    <a href="Controller?rate=1&webToRate=<%= websites.get(i).getId()%>">1</a>
                                    <a href="Controller?rate=2&webToRate=<%= websites.get(i).getId()%>">2</a>
                                    <a href="Controller?rate=3&webToRate=<%= websites.get(i).getId()%>">3</a>
                                    <a href="Controller?rate=4&webToRate=<%= websites.get(i).getId()%>">4</a>
                                    <a href="Controller?rate=5&webToRate=<%= websites.get(i).getId()%>">5</a>
                                </td>
                                <%
                                                                                if (websites.get(i).getCreator().equals(user.getUsername())) {
                                %>
                                <td><a href="user.jsp?edit=<%= websites.get(i).getId()%>">Edit</a></td>
                                <td><a href="Controller?delete=<%= websites.get(i).getId()%>">Delete</a></td>
                                <%
                                                                                                            } else {
                                %>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <%                                                }
                                %>
                            </tr>
                            <%
                                                                        }
                                                                        if (websites.get(i).getDescription().contains(search)) {
                            %>
                            <tr>
                                <td><a href=<%= websites.get(i).getUrl() %>><%= websites.get(i).getUrl() %></a></td>
                                <td><%= websites.get(i).getDescription()%></td>
                                <td><%= websites.get(i).getCreator()%></td>
                                <td><%= websites.get(i).getRating()%></td>
                                <td width="52px">
                                    <a href="Controller?rate=1&webToRate=<%= websites.get(i).getId()%>">1</a>
                                    <a href="Controller?rate=2&webToRate=<%= websites.get(i).getId()%>">2</a>
                                    <a href="Controller?rate=3&webToRate=<%= websites.get(i).getId()%>">3</a>
                                    <a href="Controller?rate=4&webToRate=<%= websites.get(i).getId()%>">4</a>
                                    <a href="Controller?rate=5&webToRate=<%= websites.get(i).getId()%>">5</a>
                                </td>
                                <%
                                                                                                        if (websites.get(i).getCreator().equals(user.getUsername())) {
                                %>
                                <td><a href="user.jsp?edit=<%= websites.get(i).getId()%>">Edit</a></td>
                                <td><a href="Controller?delete=<%= websites.get(i).getId()%>">Delete</a></td>
                                <%
                                                                                                                } else {
                                %>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <%                                                }
                                %>
                            </tr>
                            <%
                                            }
                                        }
                            %>
                        </table>
                    </c:if>
                    <br />
                    <h2>Websites</h2>
                    <table border="1">
                        <tr>
                            <th><a href="Controller?sortByURL=true">URL</a></th>
                            <th>Description</th>
                            <th><a href="Controller?sortByUsername=true">Creator</a></th>
                            <th><a href="Controller?sortByRating=true">Rating</a></th>
                            <th>Rate</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach items="${sessionScope.webList}" var="website">
                            <tr>
                                <td><a href="<c:out value="${website.url}" />"><c:out value="${website.url}" /></a></td>
                                <td><c:out value="${website.description}" /></td>
                                <td><c:out value="${website.creator}" /></td>
                                <td><c:out value="${website.rating}" /></td>
                                <td width="52px">
                                    <a href="Controller?rate=1&webToRate=${website.id}">1</a>
                                    <a href="Controller?rate=2&webToRate=${website.id}">2</a>
                                    <a href="Controller?rate=3&webToRate=${website.id}">3</a>
                                    <a href="Controller?rate=4&webToRate=${website.id}">4</a>
                                    <a href="Controller?rate=5&webToRate=${website.id}">5</a>
                                </td>
                                <c:if test="${website.creator == sessionScope.user.username}">
                                    <td><a href="user.jsp?edit=${website.id}">Edit</a></td>
                                </c:if>
                                <c:if test="${website.creator == sessionScope.user.username}">
                                    <td><a href="Controller?delete=${website.id}">Delete</a></td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </table>
                    <c:if test="${!empty param.message}">
                        <c:out value="${param.message}" /><br />
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>