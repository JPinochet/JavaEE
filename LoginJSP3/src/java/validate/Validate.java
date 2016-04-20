/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validate;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int loginAttempts = 0;

        HttpSession session = request.getSession();
        if(session.getAttribute("loginAttempts") != null)
        {
            loginAttempts = (Integer)(session.getAttribute("loginAttempts"));
        }


        if (username.equals("user") && password.equals("password"))
        {
            session.setAttribute("username", username);

            ServletContext context = getServletContext();  //Now Sending off the information
            RequestDispatcher dispatcher = context.getRequestDispatcher("/Main.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            loginAttempts++;
        }

        if(loginAttempts >= 3)
        {
            String message = "More than 3 attempts tried";
            session.setAttribute("message", message);

            ServletContext context = getServletContext();  //Now Sending off the information
            RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
             String message = "Invalid login information";
             session.setAttribute("loginAttempts", loginAttempts);
             session.setAttribute("message", message);

             ServletContext context = getServletContext();  //Now Sending off the information
             RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
             dispatcher.forward(request, response);
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