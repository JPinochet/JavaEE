<%-- 
    Document   : index
    Created on : Apr 1, 2010, 4:15:18 PM
    Author     : Kerri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Well Data System</title>
    </head>
    <body>
        <h1>Well Data System</h1>

	<h3>By Well Data</h3>
	<form action="wellData.jsp" method="post">
	    Enter well location: <input type="text" name="wellDataLocation"> <input type="submit" value="Search">
	</form>
	<br>
	<h3>By Well Production Data</h3>
	<form action="wellProductionData.jsp" method="post">
	    Enter well location: <input type="text" name="wellDataLocation"> <input type="submit" value="Search">
	</form>
    </body>
</html>
