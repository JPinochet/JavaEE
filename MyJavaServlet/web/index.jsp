<%-- 
    Document   : index
    Created on : Jan 21, 2010, 12:03:10 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyJavaServlet Login Page</title>
    </head>
    <body>
        <form action="validateLogin" method="POST">
            Username: <input type="text" name="username"><br />
            Password: <input type="password" name="password"><br />
            <input type="submit" value="Login">
        </form>
    </body>
</html>
