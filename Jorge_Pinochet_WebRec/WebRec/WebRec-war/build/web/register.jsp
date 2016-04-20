<%-- 
    Document   : register
    Created on : Apr 3, 2010, 7:46:45 PM
    Author     : Administrator
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Jorge Pinochet" />
        <meta name="description" content="Website that rates other websites! Voted on by you." />
        <meta name="keywords" content="site, rate, user managed" />
        <title>WebRec Registration</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
        <link rel="shortcut icon" href="nyansapo.gif" />
        <script type="text/javascript" src="js/textsizer.js"></script>
        <script type="text/javascript" src="js/rel.js"></script>
    </head>
    <body>
        <div id="wrap">
            <div id="top">
                <h2>Registration</h2>
            </div>
            <div id="context">
                <div id="left" align="right">
                    <br /><br />
                    <h2>Register</h2>
                    <form action="Controller" method="POST">
                        Username: <input type="text" name="newUser" /><br />
                        Password: <input type="text" name="newPassword" /><br />
                        Confirm Password: <input type="text" name="conPassword" /><br />
                        <input type="submit" value="Register"/><br />
                    </form>
                    <c:if test="${!empty param.message}">
                        <c:out value="${param.message}" /><br />
                    </c:if>
                </div>
                <div id="right" align="left">
                    <br /><br /><br /><br /><br /><br /><br /><br /><br />
                    <a href="index.jsp">BACK</a><br />
                </div>
            </div>
        </div>
    </body>
</html>
