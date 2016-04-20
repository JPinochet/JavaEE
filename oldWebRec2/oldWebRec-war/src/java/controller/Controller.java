/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import forumSession.ForumSession;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name="Controller", urlPatterns={"/Controller"})
public class Controller extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        ForumSession fs = new ForumSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        String conPassword = request.getParameter("conPassword");
        String logout = request.getParameter("logout");
        String url = request.getParameter("url");
        String description = request.getParameter("description");
        String webList = request.getParameter("webList");

        if(username != null && password != null)
        {
            if(fs.validateCredentials(username, password))
            {
                session.setAttribute("webList", fs.getWebsites());
                if(fs.isAdmin(username))
                {
                    session.setAttribute("user", fs.getUserId(username));

                    response.sendRedirect("admin.jsp");
                }
                else
                {
                    session.setAttribute("user", fs.getUserId(username));

                    response.sendRedirect("user.jsp");
                }
            }
            else
            {
                response.sendRedirect("index.jsp?message=Username or password are incorrect.");
            }
        }
        else if(newUsername != null && newPassword != null && conPassword != null)
        {
            if(newPassword.equals(conPassword))
            {
                if(fs.addUser(newUsername, newPassword, conPassword))
                {
                    response.sendRedirect("index.jsp?message=Registration Complete.");
                }
                else
                {
                    response.sendRedirect("register.jsp?message=Failed Registration. User may already exist.");
                }
            }
            else
            {
                response.sendRedirect("register.jsp?message=The passwords do not match.");
            }
        }
        else if(logout != null)
        {
            session.invalidate();
            response.sendRedirect("index.jsp?message=Logged out at " + new Date());
        }
        else if(url != null && description != null)
        {
            if(fs.addSite(-1, url, (Integer)session.getAttribute("user"), description))
            {
                response.sendRedirect("user.jsp?message=Site added to list.");
            }
            else
            {
                response.sendRedirect("user.jsp?message=Error adding new site");
            }
        }
        else if(webList != null)
        {
            session.setAttribute("webList", fs.getWebsites());
            response.sendRedirect("index.jsp");
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
