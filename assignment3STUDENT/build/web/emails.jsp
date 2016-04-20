<%--
    Document   : emails
    Created on : Feb 5, 2010, 8:32:25 PM
    Author     : Administrator
--%>

<%@page import="email.Email,java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email Page</title>
    </head>
    <body>
        <h1>My Emails</h1>
	Welcome, <%= (String)session.getAttribute("username") %><br>
	Logged in: <%= session.getAttribute("loggedIn").toString() %><br>
	<a href="Controller?logout=true">Logout</a><br>
	<br>

	<hr>
	<h3>Send Email</h3>
	<form action="Controller" method="post">
	    To: <input type="text" name="to"><br>
	    Subject: <input type="text" name="subject" size="40"><br>
	    Message: <input type="text" name="message" size="60"><br>
	    <input type="submit" value="Send"><br
	</form>

	<%
	    String readID = request.getParameter("readID");

	    if (readID!=null)
	    {
		ArrayList<Email> emails = (ArrayList<Email>)session.getAttribute("emailList");
		Email e = null;

		for (int i=0; i<emails.size(); i++)
		{
		    if (emails.get(i).getId()==Integer.parseInt(readID))
			e = emails.get(i);
		}

	%>
	<hr>
	<h3>Read Email</h3>
	<b>From:</b> <%= e.getFrom() %><br>
	<b>Sent:</b> <%= e.getSent() %><br>
	<b>Subject:</b> <%= e.getSubject() %><br>
	<b>Message:</b> <%= e.getMessage() %><br>
	<%
	    }
	%>

	<hr>
	<h3>Email List</h3>
	<a href="Controller?checkNew=true">Check for new messages</a>
	<table border="1">
	    <tr><th>From</th><th>Date</th><th>Subject</th><th>Delete</th></tr>

	    <%
		ArrayList<Email> emails = (ArrayList<Email>)session.getAttribute("emailList");

		if (emails.size()==0)
		    out.println("<tr><td colspan=\"4\">No messages to show</td></tr>");
		else
		{
		    for (int i=0; i<emails.size(); i++)
		    {
	    %>

	    <tr>
		<td><%= emails.get(i).getFrom() %></td>
		<td><%= emails.get(i).getSent() %></td>
		<td><a href="emails.jsp?readID=<%= emails.get(i).getId() %>"><%= emails.get(i).getSubject() %></a></td>
		<td><a href="Controller?delete=<%= emails.get(i).getId()%>">Delete</a></td>
	    </tr>

	    <%
		    }
		}
	    %>

	</table>

    </body>
</html>
