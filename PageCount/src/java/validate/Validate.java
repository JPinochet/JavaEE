/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import userData.UserData;

/**
 *
 * @author Administrator
 */
@WebServlet(name="Validate", urlPatterns={"/Validate"})
public class Validate extends HttpServlet {
   
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Date loggedIn = new Date();
        int pageCount = 0;
        
        try {
            if(request.getAttribute("pageCount") == null)
            {
                out.println("somestuff");
                if (username.equals("user") && password.equals("password"))
               {
                    out.println("classicstuff");
                    Date d = new Date();
                    UserData user = new UserData(d, username, 0);
                    request.setAttribute("userInformation", user);

                    out.println("newerstuff");
                    ServletContext context = getServletContext();  //Now Sending off the information
                    RequestDispatcher dispatcher = context.getRequestDispatcher("/Main");
                    dispatcher.forward(request, response);
               }
               else
               {
                   response.sendRedirect("LoginForm?message=Invalid username or password");
               }
            }
            if(request.getParameter("pageCount") != null)
            {
                username = request.getParameter("username");
                loggedIn = new Date(request.getParameter("loggedIn"));
                pageCount = Integer.parseInt(request.getParameter("pageCount"));
                out.println("stuff");

                UserData user = new UserData(loggedIn, username, pageCount);
                request.setAttribute("userInformation", user);
                out.println("morestuff");

                ServletContext context = getServletContext();  //Now Sending off the information
                RequestDispatcher dispatcher = context.getRequestDispatcher("/Main");
                out.println("muchmorestuff");
                dispatcher.forward(request, response);
            }
           
           
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
