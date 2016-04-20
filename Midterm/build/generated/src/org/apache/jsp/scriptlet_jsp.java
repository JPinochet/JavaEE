package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import student.Student;
import java.util.ArrayList;

public final class scriptlet_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Scriptlet Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Class Average Age (Scriptlet)</h1>\n");
      out.write("        <br />\n");
      out.write("        <h2>New Student</h2>\n");
      out.write("        <form action=\"Controller?scriptlet=true\" method=\"post\">\n");
      out.write("\t    Name: <input type=\"text\" name=\"name\"><br>\n");
      out.write("\t    Age: <input type=\"text\" name=\"age\"><br>\n");
      out.write("\t    <input type=\"submit\" value=\"Add Student\">\n");
      out.write("\t</form>\n");
      out.write("        <br />\n");
      out.write("        <h2>List of Students</h2>\n");
      out.write("        <table border=\"1\">\n");
      out.write("\t    <tr><th>Name</th><th>Age</th><th>Delete</th></tr>\n");
      out.write("\n");
      out.write("\t    ");

                if(session.getAttribute("studentList") != null)
                {
                    ArrayList<Student> students = (ArrayList<Student>)session.getAttribute("studentList");

                    if (students.size()==0)
                        out.println("<tr><td colspan=\"3\">No students</td></tr>");
                    else
                    {
                        for (int i=0; i<students.size(); i++)
                        {
	    
      out.write("\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( students.get(i).getName() );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( students.get(i).getAge() );
      out.write("</td>\n");
      out.write("                        <td><a href=\"Controller?Scriptlet=true&delete=");
      out.print( students.get(i).getId());
      out.write("\">Delete</a></td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("\t    ");

                        }
                    }
                }
	    
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
