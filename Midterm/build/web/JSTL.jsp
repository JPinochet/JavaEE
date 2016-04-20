<%-- 
    Document   : JSTL
    Created on : Mar 9, 2010, 8:23:12 AM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Page</title>
    </head>
    <body>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Page</title>
    </head>
    <body>
        <h1>Class Average Age (JSTL)</h1>
        <br />
        <h2>New Student</h2>
        <form action="Controller?JSTL=true" method="post">
	    Name: <input type="text" name="name"><br />
	    Age: <input type="text" name="age"><br />
	    <input type="submit" value="Add Student">
	</form>
        <br />
        <h2>List of Students</h2>
        <table border="1">
	    <tr><th>Name</th><th>Age</th><th>Delete</th></tr>
            <c:choose>
                <c:when test="${session.studentWrapper.size == 0}">
                    <tr>
                        <td colspan="3">No students to show</td>
                    </tr>
                </c:when> 
                <c:otherwise>
                    <c:forEach var="i" begin="0" end="${sessionScope.studentWrapper.size-1}">
                        <c:set var="sum" value="${sum + studentList[i].age}" />
                        <tr>
                            <td><c:out value="${students.name}" /></td>
                            <td><c:out value="${students.age}" /></td>
                            <td><a href="Controller?JSTL=true&delete=${students.id}">Delete</a> </td>
                        </tr>
                     </c:forEach>
                </c:otherwise>>
            </c:choose>
        </table>
        <c:if test="${session.studentWrapper.size > 0}">
            Average age of class: <c:out value="${sum / session.studentWrapper.size}" />
        </c:if>
    </body>
</html>
