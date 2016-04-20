/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mySession.MySession;
import userAdminBean.UserAdminBean;
import validateBean.ValidateBean;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String logout = request.getParameter("logout");

        String oldPassword = request.getParameter("oldPassword");
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");

        String newUsername = request.getParameter("newusername");

        String delete = request.getParameter("delete");
        String reset = request.getParameter("reset");

        HttpSession session = request.getSession();

        if(logout != null)
        {
            session.invalidate();
            response.sendRedirect("index.jsp?message=Logged out");
        }
        else if(username != null && password != null)
        {
            //login validation
            ValidateBean vb = new ValidateBean();

            if(vb.validateLogin(username, password))
            {
                MySession mySession = new MySession();
                mySession.setUsername(username);

                if(vb.isAdmin(username))
                    mySession.setIsAdmin(true);

                session.setAttribute("mySession", mySession);
                response.sendRedirect("main.jsp");
            }
            else
            {
                response.sendRedirect("index.jsp?message=Invalid username or password");
            }
        }
        else if(oldPassword != null && newPassword1 != null && newPassword2 != null)
        {
            UserAdminBean uab = new UserAdminBean();
            String currentUser = ((MySession) session.getAttribute("mySession")).getUsername();

            if(uab.resetPasswordUser(currentUser, oldPassword, newPassword1, newPassword2))
            {
                response.sendRedirect("main.jsp?message=Password changed");
            }
            else
            {
                response.sendRedirect("main.jsp?message=Error changing password!");
            }
        }
        else if(newUsername != null)
        {
            UserAdminBean uab = new UserAdminBean();

            if(uab.addUser(newUsername, newPassword1, newPassword2))
            {
                response.sendRedirect("admin.jsp?message=User added");
            }
            else
            {
                response.sendRedirect("admin.jsp?message=Error adding user!!!!");
            }
        }
        else if(delete != null)
        {
            UserAdminBean uab = new UserAdminBean();

            if(uab.deleteUser(delete))
            {
                response.sendRedirect("admin.jsp?message=User deleted");
            }
            else
            {
                response.sendRedirect("admin.jsp?message=Error deleting user!!!!");
            }
        }
        else if(reset != null)
        {
            UserAdminBean uab = new UserAdminBean();

            if(uab.resetPasswordAdmin(reset))
            {
                response.sendRedirect("admin.jsp?message=User password reset");
            }
            else
            {
                response.sendRedirect("admin.jsp?message=Error resetting user password!!!!");
            }
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
