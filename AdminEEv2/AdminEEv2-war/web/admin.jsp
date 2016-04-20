<%@page import="mySession.MySession, java.sql.*" %>

<%
    MySession mySession = (MySession)session.getAttribute("mySession");

    if (mySession==null)
    {
	 response.sendRedirect("index.jsp?message=Not logged in!!");
	 return;
    }
    else if (! mySession.getUsername().equals("admin"))
   {
	    response.sendRedirect("main.jsp?message=Must be admin to view this page!");
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
	<a href="Controller?logout=true">Logout</a>

	<h2>Add User</h2>
	<form action="Controller" method="post">
	    New username: <input type="text" name="newusername"><br>
	    Password: <input type="text" name="newPassword1"><br>
	    Confirm: <input type="text" name="newPassword2"><br>
	    <input type="submit" value="Add User"><br>
	</form>

	<%
		    String message=request.getParameter("message");
		    if (message!=null)
			    out.println(message);
		%>

	<h2>List of Users</h2>
	<table border="1">
	    <tr><th>Username</th><th>Delete</th><th>Reset</th></tr>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myusers",
			"root","password");

		Statement s = conn.createStatement();

		ResultSet rs = s.executeQuery("select * from users");

		while (rs.next())
		    {
			out.println("<tr><td>" + rs.getString(1)
				+ "</td><td><a href=Controller?delete=" + rs.getString(1)
				+ ">Delete</a></td><td><a href=Controller?reset=" + rs.getString(1)
				+ ">Reset</a></td></tr>");
		    }

		    rs.close();
		    conn.close();
		   %>

	</table>

    </body>
</html>
