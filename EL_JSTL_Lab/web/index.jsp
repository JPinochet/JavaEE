<%-- 
    Document   : index
    Created on : Feb 25, 2010, 12:12:25 PM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL</title>
    </head>
    <body>
        <h1>Expressions Only</h1><br />
        <c:out value="x + y = ${param.x + param.y}" /><br />
        <c:out value="x - y = ${param.x - param.y}" /><br />
        <c:out value="x * y = ${param.x * param.y}" /><br />
        <c:out value="x / y = ${param.x / param.y}" /><br />
        <c:out value="x % y = ${param.x % param.y}" /><br /><br />

        <c:out value="(x == y) = ${param.x == param.y}" /><br />
        <c:out value="(x != y) = ${param.x != param.y}" /><br />
        <c:out value="(x > y) = ${param.x > param.y}" /><br />
        <c:out value="(x < y) = ${param.x < param.y}" /><br />
        <c:out value="(x >= y) = ${param.x >= param.y}" /><br />
        <c:out value="(x <= y) = ${param.x <= param.y}" /><br /><br />

        <c:out value="x is empty = ${empty param.x}" /><br />
        <c:out value="x && y = ${empty param.x && empty param.y}" /><br />
        <c:out value="x || y = ${empty param.x || empty param.y}" /><br />
        <c:out value="!x = ${!param.x}" /><br />
    </body>
</html>
