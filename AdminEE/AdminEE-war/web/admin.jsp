<%-- 
    Document   : admin
    Created on : Apr 6, 2010, 9:13:27 AM
    Author     : Administrator
--%>
<%@page import="mySession.MySession, java.sql.*" %>

<%
    MySession mySession = (MySession) session.getAttribute("mySession");

    if(mySession == null)
    {
        response.sendRedirect("index.jsp?message=Not Logged in!!");
        return;
    }
    else if(!mySession.getUsername().equals("admin"))
    {
        response.sendRedirect("main.jsp?message=Must be admin to view this page");
        return;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Admin Page</h1>
        <a href="Controller?logout=true">Logout</a><br />
        <a href="main.jsp">BACK</a><br />

        <h2>Add new user</h2>
        <form action="Controller" method="post">
            Username: <input type="text" name="newusername" /><br />
            Password: <input type="text" name="newPassword1" /><br />
            Confirm: <input type="text" name="newPassword2" /><br />
            <input type="submit" value="Add User" />
        </form>
        <%
            String message = request.getParameter("message");
            if(message != null)
                out.println(message);
        %>
        <h2>List of Users</h2>
        <table border="1">
            <tr><td>Username</td><td>Delete</td><td>Reset</td></tr>
            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");
                Statement s = conn.createStatement();

                s.executeQuery("SELECT * FROM users;");

                ResultSet rs = s.getResultSet();

                while(rs.next())
                {
                    out.println("<tr><td>"+ rs.getString(1) +
                            "</td><td><a href=Controller?delete=" + rs.getString(1) +
                            ">Delete</a></td><td><a href=Controller?reset=" + rs.getString(1)+">Reset</a></td></tr>");
                }
            %>
        </table>
    </body>
</html>
