<%-- 
    Document   : timeTables
    Created on : Feb 25, 2010, 1:11:42 PM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JSTL + EL Time Tables</h1><br />
        <form action="timeTables.jsp" method="GET">
            Time tables for:
            <input type="text" name="number" value="1" />
            <input type="submit" value="Go" />
        </form>

        <br />

        <c:if test="${!empty param.number}">
            <c:forEach var="i" begin="1" end="12">
               ${param.number} x ${i} = ${param.number* i} <br />
            </c:forEach>
        </c:if>
    </body>
</html>
