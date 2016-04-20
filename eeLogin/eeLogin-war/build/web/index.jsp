<%-- 
    Document   : index
    Created on : Mar 16, 2010, 8:12:48 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="Validate" method="post">
            Username: <input type="text" name="username"><br />
            Password: <input type="text" name="password"><br />
            <input type="submit" value="Login"><br />
        </form>
        <%
            String message = request.getParameter("message");
            if(message != null)
                out.println(message);
        %>
    </body>
</html>
