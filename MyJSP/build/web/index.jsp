<%-- 
    Document   : index
    Created on : Feb 2, 2010, 8:06:45 AM
    Author     : Administrator
--%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <%!
        Date myDate = new Date();

        Date getDate()
        {
            return new Date();
        }
    %>
    <%--<%
        java.util.Date myDate = new java.util.Date();
        System.out.println("DEBUG: " + myDate);
        //out.println("HELLO WORLD <br />");
        out.println(request.getRemoteAddr());
    %>--%>
    <body>
        <h1>Hello</h1>
        <%--<%= new java.util.Date() %><br />--%>
        <%--<%= myDate %><br />--%>
        <%= getDate() %><br />
        <%= System.getProperty("java.version") %><br />
        <%= System.getProperty("os.name") %><br />
        <%= System.getProperty("user.name") %><br />
        <table border="1">
        <%
            //out.println("<table border=\"1\">");
            for(int i = 1; i <= 5; i++)
            {
                //out.println("<tr><td>" + i + "</td></tr>");
            //out.println("</table>");
        %>
            <tr><td><%= i %></td></tr>
        <%
            }
        %>
        </table>

        <%@include file="Hello.jspf" %>
        <br />
        <jsp:include page="Hello.jspf"/>
    </body>
</html>
