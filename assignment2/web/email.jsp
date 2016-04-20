<%--
    Document   : email
    Created on : Feb 9, 2010, 8:58:19 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="util.*" %>
<%@page import="java.util.*" %>

<%  ArrayList<Email> emails = new ArrayList<Email>();
    if(session.getAttribute("emails")!= null)
    {
        emails = (ArrayList<Email>) session.getAttribute("emails");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inbox</title>
    </head>
    <body>
        <h1>My Emails</h1>
        Welcome, <%= session.getAttribute("user") %><br/>
        Logged in, <%= session.getAttribute("date") %><br />
        <a href="Controller?logStatus=logout">Logout</a><br /><br />

        <hr />

        <h2>Send Email</h2>
        <form action="Controller?emailSent=true" method="POST">
            To: <input type="text" name="toWho"><br />
            Subject: <input type="text" name="subject"><br />
            Message: <input type="text" name="msg"><br />
            <input type="submit" name="send" value="Send" />
        </form>

        <hr />

        <% if(request.getParameter("viewEmail") != null)
           {
                int emailArrayPosition = Integer.parseInt(request.getParameter("viewEmail"));
        %>
                <h2>Read Email</h2><br />
                From: <%= emails.get(emailArrayPosition).getFromWho() %><br />
                Sent: <%= emails.get(emailArrayPosition).getWhenSent() %><br />
                Subject: <%= emails.get(emailArrayPosition).getSubject() %><br />
                Message: <%= emails.get(emailArrayPosition).getMsg() %><br />

                <hr />
        <%
           }
         %>

         <h2>Email List</h2>

         <a href="Controller?update=true">Check for new messages</a>
         <table border="1">
             <tr>
                 <th>From</th>
                 <th>Date</th>
                 <th>Subject</th>
                 <th>Delete</th>
             </tr>

                 <% for(int i = 0; i < emails.size(); i++)
                    { %>
                     <tr>
                         <td><%= emails.get(i).getFromWho() %></td>
                         <td><%= emails.get(i).getWhenSent() %></td>
                         <td><a href="email.jsp?viewEmail=<%= i %>"><%= emails.get(i).getSubject() %></a></td>
                         <td><a href="Controller?delete=<%= i %>">Delete</a></td>
                     </tr>
                 <% } %>

         </table>
    </body>
</html>
