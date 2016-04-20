<%-- 
    Document   : calc
    Created on : Feb 25, 2010, 12:28:17 PM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>JSTL + EL Calculator</h1><br />
        <form action="calc.jsp" method="GET">
            x: <input type="text" name="x" value="0"/><br />
            y: <input type="text" name="y" value="0"/><br />
            <input type="submit" value="+" name="command" />
            <input type="submit" value="-" name="command" />
            <input type="submit" value="*" name="command" />
            <input type="submit" value="/" name="command" />
        </form>

        <c:choose>
            <c:when test="${!empty param.command && param.command == '+'}">
                Sum = ${param.x + param.y} <br />
            </c:when>
            <c:when test="${!empty param.command && param.command == '-'}">
                Subtraction = ${param.x - param.y} <br />
            </c:when>
            <c:when test="${!empty param.command && param.command == '*'}">
                Product = ${param.x * param.y} <br />
            </c:when>
            <c:when test="${!empty param.command && param.command == '/'}">
                Division = ${param.x / param.y} <br />
            </c:when>
            <c:otherwise>
                No values for x and y. <br />
            </c:otherwise>
        </c:choose>

    </body>
</html>
