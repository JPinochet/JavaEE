<%-- 
    Document   : wellProductionData
    Created on : Apr 1, 2010, 4:42:27 PM
    Author     : Kerri
--%>
<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Well Production Data Search</title>
    </head>
    <body>
        <h1>Search by Well Production Data</h1>
	<b>For well location:</b> <%= request.getParameter("wellDataLocation") %>
	<br><br>

	<table border="1">
	    <tr>
		<th>Date</th>
		<th>Oil Production (/cubic m)</th>
		<th>Water Production (/cubic m)</th>
		<th>Gas Production (/cubic m)</th>
	    </tr>

	    <%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/oloughlin_mysql","root","password");
		Statement s = conn.createStatement();
		String sql = "select * from well_production where location = '" + request.getParameter("wellDataLocation") + "';";
		System.out.println("DEBUG:" + sql);

		ResultSet rs = s.executeQuery(sql);

		while (rs.next())
		{
		    out.println("<tr><td>" + rs.getString(3) +"</td>");
		    out.println("<td>" + rs.getDouble(4) +"</td>");
		    out.println("<td>" + rs.getDouble(5) +"</td>");
		    out.println("<td>" + rs.getDouble(6) +"</td></tr>");
		}

		rs.close();
		conn.close();


	    %>

	</table>


	<a href="index.jsp">BACK</a>
    </body>
</html>
