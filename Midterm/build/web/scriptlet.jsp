<%-- 
    Document   : scriptlet.jsp
    Created on : Mar 9, 2010, 8:07:29 AM
    Author     : Administrator
--%>

<%@page import="student.Student,java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scriptlet Page</title>
    </head>
    <body>
        <h1>Class Average Age (Scriptlet)</h1>
        <br />
        <h2>New Student</h2>
        <form action="Controller?scriptlet=true" method="post">
	    Name: <input type="text" name="name"><br />
	    Age: <input type="text" name="age"><br />
	    <input type="submit" value="Add Student">
	</form>
        <br />
        <h2>List of Students</h2>
        <table border="1">
	    <tr><th>Name</th><th>Age</th><th>Delete</th></tr>

	    <%
                if(session.getAttribute("studentList") != null)
                {
                    ArrayList<Student> students = (ArrayList<Student>)session.getAttribute("studentList");

                    if (students.size()==0)
                        out.println("<tr><td colspan=\"3\">No students</td></tr>");
                    else
                    {
                        for (int i=0; i<students.size(); i++)
                        {
	    %>

                    <tr>
                        <td><%= students.get(i).getName() %></td>
                        <td><%= students.get(i).getAge() %></td>
                        <td><a href="Controller?scriptlet=true&delete=<%= students.get(i).getId()%>">Delete</a></td>
                    </tr>

	    <%

                        }
                    }
                }
	    %>
        </table>
    </body>
</html>
