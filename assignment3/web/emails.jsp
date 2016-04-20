<%-- 
    Document   : emails
    Created on : Feb 28, 2010, 11:04:15 AM
    Author     : Administrator
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        Welcome, <c:out value='${sessionScope["username"]}'/><br />
        Logged in: <c:out value='${sessionScope["loggedIn"]}'/><br />
        <a href="Controller?logout=true">Logout</a><br />
        <br />

        <hr />
        <h3>Send Email</h3>
	<form action="Controller" method="post">
	    To: <input type="text" name="to"><br />
	    Subject: <input type="text" name="subject" size="40"><br />
	    Message: <input type="text" name="message" size="60"><br />
	    <input type="submit" value="Send"><br />
	</form>

        <c:if test="${! empty param.readID}">
            <c:forEach var="emails" items="${sessionScope.emailList}">
                <c:if test="${emails.id == param.readID}">
                    <hr />
                    <h3>Read Email</h3>
                    <b>From:</b> <c:out value="${emails.from}" /><br />
                    <b>Sent:</b> <c:out value="${emails.sent}" /><br />
                    <b>Subject:</b> <c:out value="${emails.subject}" /><br />
                    <b>Message:</b> <c:out value="${emails.message}" /><br /><br />
                </c:if>
            </c:forEach>
        </c:if>

        <hr />
        <h3>Email List</h3>
	<a href="Controller?checkNew=true">Check for new messages</a>
	<table border="1">
	    <tr><th>From</th><th>Date</th><th>Subject</th><th>Delete</th></tr>
        <c:forEach var="emails" items="${sessionScope.emailList}">
            <tr>
                <td><c:out value="${emails.from}" /></td>
                <td><c:out value="${emails.sent}" /></td>
                <td><a href="emails.jsp?readID=${emails.id}">${emails.subject}</a></td>
                <td><a href="Controller?delete=${emails.id}">Delete</a> </td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
