<%--
    Document   : index
    Created on : Mar 2, 2010, 8:08:24 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin Page</h1>
        <form action="Admin" method="POST">
            Username: <input type="text" name="username" ><br />
            Password: <input type="text" name="password" ><br />
            <input type="submit" value="Add"><br />
        </form>
        <%
            String message = request.getParameter("message");
            if(message != null)
                out.println(message);
        %>
    </body>
</html>