<%-- 
    Document   : index
    Created on : Feb 23, 2010, 8:11:24 AM
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
        <h1>Hello World!</h1>
        <c:out value="Hello World<br />And again....<br />" escapeXml="false"/>

        <c:out value="${1+1}" /><br />
        <c:out value="Results: ${1+1} ${2+2} ${3+3}" /><br />

        <c:set var="age" value="21" scope="page" />
        <c:out value="Your age is ${pageScope.age}" /><br />

        <c:set var="age" value="${pageScope.age + 1}" scope="page" />
        <c:out value="Your age is now ${pageScope.age}" /><br />

        <c:out value="Message: ${param.message}" /><br />
        <c:out value="Message is empty: ${empty param.messge}" /><br />

        <c:out value="User agent: ${header['User-Agent']}" /><br />

    </body>
</html>
