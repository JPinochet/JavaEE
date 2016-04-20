<%-- 
    Document   : main
    Created on : Apr 6, 2010, 8:54:44 AM
    Author     : Administrator
--%>
<%@page import="mySession.MySession" %>

<%
    MySession mySession = (MySession) session.getAttribute("mySession");

    if(mySession == null)
    {
        response.sendRedirect("index.jsp?message=Not Logged in!!");
        return;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
    </head>
    <body>
        <h1>Main Page</h1>
        Welcome, <%= mySession.getUsername() %><br />
        <a href="Controller?logout=true">Logout</a><br />

        <%
            if(mySession.isIsAdmin())
                out.println("<a href='admin.jsp'>Admin</a><br />");
        %>

        <h2>Reset Password</h2>
        <form action="Controller" method="post">
            Old Password: <input type="text" name="oldPassword"><br />
            New Password: <input type="text" name="newPassword1"><br />
            Confirm New Password: <input type="text" name="newPassword2"><br />
            <input type="submit" value="Change password"><br />
        </form>

        <%
            String message = request.getParameter("message");
            if(message != null)
                out.println(message);
        %>
    </body>
</html>
