package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

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
      out.write("        <title>Game</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Guessing Game</h1><br />\n");
      out.write("        <form action=\"GuessingGame\" method=\"POST\">\n");
      out.write("            Enter your guess (1-50)\n");
      out.write("            <input type=\"text\" name=\"guess\" />\n");
      out.write("            <input type=\"submit\" value=\"Guess\" />\n");
      out.write("        </form>\n");
      out.write("        ");

            String message = request.getParameter("message");
            if(message != null)
            {
                if(message.equals("That's it!!"))
                {
                    int numGuess = (Integer)session.getAttribute("numberOfGuesses");
                    ArrayList<Integer> guesses = (ArrayList<Integer>) session.getAttribute("guessList");
                    out.println(message);
                    out.print("You got it in " + numGuess + " guesses. Guesses: [");
                    for(int i = 0; i < guesses.size(); i++)
                    {
                        out.print(guesses.get(i));
                    }
                    out.print("]");
                }
                else
                {
                    out.println(message + "\n");
                }
            }
        
      out.write("\n");
      out.write("        ");

            int numGuess = (Integer)session.getAttribute("numberOfGuesses");
            if(numGuess != 0)
                out.println("Number of guesses: " + numGuess + "\n");
        
      out.write("\n");
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
