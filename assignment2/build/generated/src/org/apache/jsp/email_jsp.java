package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.*;
import java.util.*;

public final class email_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
  ArrayList<Email> emails = new ArrayList<Email>();
    if(session.getAttribute("emails")!= null)
    {
        emails = (ArrayList<Email>) session.getAttribute("emails");
    }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Inbox</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>My Emails</h1>\n");
      out.write("        Welcome, ");
      out.print( session.getAttribute("username") );
      out.write("<br/>\n");
      out.write("        Logged in, ");
      out.print( session.getAttribute("date") );
      out.write("<br />\n");
      out.write("        <a href=\"/Controller?logStatus=logout\">Logout</a><br /><br />\n");
      out.write("\n");
      out.write("        <hr />\n");
      out.write("\n");
      out.write("        <h2>Send Email</h2>\n");
      out.write("        <form action=\"Controller?emailSent=true\" method=\"POST\">\n");
      out.write("            To: <input type=\"text\" name=\"toWho\"><br />\n");
      out.write("            Subject: <input type=\"text\" name=\"subject\"><br />\n");
      out.write("            Message: <input type=\"text\" name=\"msg\"><br />\n");
      out.write("            <input type=\"submit\" name=\"send\" value=\"Send\" />\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <hr />\n");
      out.write("\n");
      out.write("        ");
 if(request.getParameter("viewEmail") != null)
           {
                int emailArrayPosition = Integer.parseInt(request.getParameter("viewEmail"));
        
      out.write("\n");
      out.write("                <h2>Read Email</h2><br />\n");
      out.write("                From: ");
      out.print( emails.get(emailArrayPosition).getFromWho() );
      out.write("<br />\n");
      out.write("                Sent: ");
      out.print( emails.get(emailArrayPosition).getWhenSent() );
      out.write("<br />\n");
      out.write("                Subject: ");
      out.print( emails.get(emailArrayPosition).getSubject() );
      out.write("<br />\n");
      out.write("                Message: ");
      out.print( emails.get(emailArrayPosition).getMsg() );
      out.write("<br />\n");
      out.write("\n");
      out.write("                <hr />\n");
      out.write("        ");

           }
         
      out.write("\n");
      out.write("\n");
      out.write("         <h2>Email List</h2>\n");
      out.write("\n");
      out.write("         <a href=\"Controller?update=true\">Check for new messages</a>\n");
      out.write("         <table border=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                 <th>From</th>\n");
      out.write("                 <th>Date</th>\n");
      out.write("                 <th>Subject</th>\n");
      out.write("                 <th>Delete</th>\n");
      out.write("             </tr>\n");
      out.write("\n");
      out.write("                 ");
 for(int i = 0; i < emails.size(); i++)
                    { 
      out.write("\n");
      out.write("                     <tr>\n");
      out.write("                         <td>");
      out.print( emails.get(i).getFromWho() );
      out.write("</td>\n");
      out.write("                         <td>");
      out.print( emails.get(i).getWhenSent() );
      out.write("</td>\n");
      out.write("                         <td><a href=\"email.jsp?viewEmail=");
      out.print( i );
      out.write('"');
      out.write('>');
      out.print( emails.get(i).getSubject() );
      out.write("</a></td>\n");
      out.write("                         <td><a href=\"Controller?delete=");
      out.print( i );
      out.write("\">Delete</a></td>\n");
      out.write("                     </tr>\n");
      out.write("                 ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("         </table>\n");
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
