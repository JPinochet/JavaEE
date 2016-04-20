/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.UserData;

/**
 *
 * @author Administrator
 */
@WebServlet(name="Main", urlPatterns={"/Main"})
public class Main extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        UserData user = (UserData) request.getAttribute("userInformation");
        String username = "", loggedIn = "", pageCount = "";

        if((request.getAttribute("userInformation")) != null)
        {
            username = user.getUsername();
            loggedIn = user.getD().toString();
            pageCount = Integer.toString(user.getPageCount());
        }
        else if((request.getAttribute("username")) != null)
        {
            username = (String) request.getAttribute("username");
            loggedIn = request.getAttribute("loggedIn").toString();
            pageCount = request.getAttribute("pageCount").toString();
        }
        else if(request.getParameter("username") != null)
        {
            username = request.getParameter("username");
            loggedIn = request.getParameter("loggedIn");
            pageCount = request.getParameter("pageCount");
        }
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Main</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Username: "+ username + "<br />");
            out.println("Logged In: "+ loggedIn + "<br />");
            out.println("Page Count: "+ pageCount + "<br />");
            out.println("<a href=\"Main?username=" + username + "&loggedIn=" + loggedIn + "&pageCount=" + (Integer.parseInt(pageCount) + 1) +"\">Refresh</a>");

            out.println("<hr>");
            out.println("<form name=\"hiddenForm\" action=\"Main\" method=\"POST\">");
            out.println("<input type=\"hidden\" name=\"username\" value=\""+ username + "\">");
            out.println("<input type=\"hidden\" name=\"loggedIn\" value=\""+ loggedIn + "\">");
            out.println("<input type=\"hidden\" name=\"pageCount\" value=\""+ (Integer.parseInt(pageCount) + 1) + "\">");
            out.println("<input type=\"submit\" value=\"Refresh\">");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
