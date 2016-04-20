<%-- 
    Document   : index
    Created on : Jan 19, 2010, 8:31:28 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebCalc</title>
    </head>
    <body>
        <h1>WebCalc</h1>
        <form action="addServlet" method="GET">
            First number: <input type="text" name="first"><br />
            Second number: <input type="text" name="second"><br />
            <input type="submit" value="Add">
        </form>
    </body>
</html>
