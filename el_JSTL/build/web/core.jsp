<%-- 
    Document   : core
    Created on : Feb 23, 2010, 8:44:45 AM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Core JSTL Page</title>
    </head>
    <body>
        <h1>CORE JSTL Page</h1>

        <c:set var="x" value="20" scope="page" />
        <c:remove var="x" scope="page" />

        <jsp:useBean id="s" class="student.Student">
            <jsp:setProperty name="s" property="name" value="adam"/>
            <jsp:setProperty name="s" property="id" value="11111"/>
            <jsp:setProperty name="s" property="gpa" value="3.8"/>
        </jsp:useBean>

        Name: <c:out value="${s.name}" /><br />
        ID: <c:out value="${s.id}" /><br />
        GPA: <c:out value="${s.gpa}" /><br />

        <c:if test="${! empty param.message}">
            Message: <c:out value="${param.message}"/><br />
        </c:if>

        <c:choose>
            <c:when test="${empty param.message}">
                No message <br />
            </c:when>
            <c:otherwise>
                There is a message <br/>
            </c:otherwise>
        </c:choose>

        <c:if test="${! empty param.number}">
            <c:choose>
                <c:when test="${param.number == '1'}">One</c:when>
                <c:when test="${param.number == '2'}">Two</c:when>
                <c:otherwise>Not one or two</c:otherwise>
            </c:choose>
        </c:if>

        <br />

        <c:forEach var="i" begin="1" end="10">
            <c:out value="${i}<br />" escapeXml="false"/>
        </c:forEach>

        <c:forTokens var="i" items="a, b, c, de, f, g" delims=",">
            <c:out value="${i}<br />" escapeXml="false" />
        </c:forTokens>

        <c:import var="other" url="http://www.sait.ca" />
        <c:out value="${other}" escapeXml="false"/>

    </body>
</html>
