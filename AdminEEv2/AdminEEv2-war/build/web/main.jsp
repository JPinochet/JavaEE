<%@page import="mySession.MySession" %>

<%
    MySession mySession = (MySession)session.getAttribute("mySession");

    if (mySession==null)
    {
	 response.sendRedirect("index.jsp?message=Not logged in!!");
	 return;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <h1>Main</h1>
	Welcome, <%= mySession.getUsername() %><br>
	<a href="Controller?logout=true">Logout</a><br>

	<%
		    if (mySession.getUsername().equals("admin"))
			{
			    out.println("<a href='admin.jsp'>Admin</a>");
			}
		%>

	<h2>Reset password</h2>
	<form action="Controller" method="post">
	    Old password: <input type="text" name="oldPassword"><br>
	    New password: <input type="text" name="newPassword1"><br>
	    Confirm password: <input type="text" name="newPassword2"><br>
	    <input type="submit" value="Change password"><br>
	</form>



	<%
		    String message=request.getParameter("message");
		    if (message!=null)
			out.println(message);
		%>
    </body>
</html>
