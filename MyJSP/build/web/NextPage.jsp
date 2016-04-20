<%-- 
    Document   : NextPage
    Created on : Feb 2, 2010, 9:30:55 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="user" class="user.UserData" scope="session"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Hello, <% user.getUsername(); %><br />
        Email: <% user.getEmail(); %><br />
        Age: <% user.getAge(); %><br />
    </body>
</html>
