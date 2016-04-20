<%-- 
    Document   : SaveName
    Created on : Feb 2, 2010, 9:28:39 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="user" class="user.UserData" scope="session"/>
<jsp:setProperty name="user" property="*" />


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%--<%
        String username = request.getParameter("username");
        session.setAttribute("username", username);
    %>--%>
    <body>
        <a href="NextPage.jsp">Next</a>
    </body>
</html>
