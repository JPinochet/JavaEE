<%-- 
    Document   : index
    Created on : Mar 30, 2010, 8:08:45 AM
    Author     : Administrator
--%>
<%@page import="javax.persistence.*, users.Users, java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
    </head>
    <body>
        <h1>Manage User</h1>

        <a href="index.jsp?listAll=true">List all Admins</a><br />

        <%
            String listAll = request.getParameter("listAll");

            if(listAll != null)
            {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("usersPersist");
                EntityManager em = emf.createEntityManager();

                Query q = em.createNamedQuery("Users.findByIsAdmin");
                q.setParameter("isAdmin", true);

                List uList = q.getResultList();
                Iterator i = uList.iterator();

                while(i.hasNext())
                {
                    Users temp = (Users)i.next();
                    out.println(temp.getUsername() + " " + temp.getPassword() + " " + temp.getIsAdmin() + "<br />");
                }

                em.close();
                emf.close();
            }
        %>

        <h2>Add User</h2>
        <form action="Controller" method="POST">
            Username: <input type="text" name="username" /><br />
            Password: <input type="text" name="password" /><br />
            <input type="submit" value="Add" /><br />
        </form>
        <%
            String message = request.getParameter("message");
            if(message != null)
                out.println(message);
        %>

        <h2>List of Users</h2>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Delete</th>
                <th>Reset</th>
            </tr>
            <%
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("usersPersist");
                EntityManager em = emf.createEntityManager();

                Query q = em.createNamedQuery("Users.findAll");

                List uList = q.getResultList();
                Iterator i = uList.iterator();

                while(i.hasNext())
                {
                    Users temp = (Users)i.next();
                    out.println("<tr><td>" + temp.getUsername() + "</td><td>"
                                    + "<a href=Controller?delete=" + temp.getUsername() + ">Delete</a></td><td>"
                                    + "<a href=Controller?reset=" + temp.getUsername() + ">Reset</a></td></tr>");
                }

                em.close();
                emf.close();
            %>
        </table>
    </body>
</html>
