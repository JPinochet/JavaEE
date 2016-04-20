<%-- 
    Document   : index
    Created on : Feb 9, 2010, 8:14:08 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="Controller?logStatus=login" method="POST">
            Username: <input type="text" name="username" /><br />
            Password: <input type="text" name="password" /><br />
            <input type="submit" value="Login"><br />
            <%
            if(request.getParameter("message") != null)
            { %>
               <%= request.getParameter("message") %>
            <%
                }
            %>
        </form>
    </body>
</html>
