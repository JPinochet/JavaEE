package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.persistence.*;
import users.Users;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Management</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Manage User</h1>\n");
      out.write("\n");
      out.write("        <a href=\"index.jsp?listAll=true\">List all Admins</a><br />\n");
      out.write("\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("\n");
      out.write("        <h2>Add User</h2>\n");
      out.write("        <form action=\"Controller\" method=\"POST\">\n");
      out.write("            Username: <input type=\"text\" name=\"username\" /><br />\n");
      out.write("            Password: <input type=\"text\" name=\"password\" /><br />\n");
      out.write("            <input type=\"submit\" value=\"Add\" /><br />\n");
      out.write("        </form>\n");
      out.write("        ");

            String message = request.getParameter("message");
            if(message != null)
                out.println(message);
        
      out.write("\n");
      out.write("\n");
      out.write("        <h2>List of Users</h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Username</th>\n");
      out.write("                <th>Delete</th>\n");
      out.write("                <th>Reset</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
