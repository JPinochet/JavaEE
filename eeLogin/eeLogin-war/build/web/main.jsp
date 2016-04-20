<%-- 
    Document   : main
    Created on : Mar 16, 2010, 8:47:26 AM
    Author     : Administrator
--%>
<%@page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="eeSession" class="mySession.MySession" scope="session" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <h1>Main Page</h1>
        Welcome, <%= eeSession.getUsername() %><br />
        Page Count: <%= eeSession.pageCount()%><br />
        Logged In: <%= eeSession.loggedIn() %><br />
        <a href="Validate?logout=true">Logout</a>
    </body>
</html>
