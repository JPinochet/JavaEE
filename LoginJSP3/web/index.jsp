<%-- 
    Document   : index
    Created on : Feb 4, 2010, 12:11:00 PM
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
        <form name="loginform" action="Validate" method="POST">
            <table border="1">
                <tr>
                    <td>Username: <input type="text" name="username"><br /></td>
                </tr>
                <tr>
                    <td>Password: <input type="text" name="password"><br /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"><br /></td>
                </tr>
                <tr>
                    <%= session.getAttribute("message") %>
                </tr>
            </table>
        </form>
    </body>
</html>
