/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webrecDB.*;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
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
        DBManager dbm = new DBManager();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newUser = request.getParameter("newUser");
        String newPassword = request.getParameter("newPassword");
        String conPassword = request.getParameter("conPassword");
        String logout = request.getParameter("logout");
        String delete = request.getParameter("delete");
        String edit = request.getParameter("edit");
        String webURL = request.getParameter("webURL");
        String webDesc = request.getParameter("webDesc");
        String update = request.getParameter("update");
        String newWebURL = request.getParameter("newWebURL");
        String newWebDesc = request.getParameter("newWebDesc");
        String reset = request.getParameter("reset");
        String deleteUser = request.getParameter("deleteUser");
        String lockAccount = request.getParameter("lockAccount");
        String makeAdmin = request.getParameter("makeAdmin");
        String rate = request.getParameter("rate");
        String webToRate = request.getParameter("webToRate");
        String sortByURL = request.getParameter("sortByURL");
        String sortByUsername = request.getParameter("sortByUsername");
        String sortByRating = request.getParameter("sortByRating");

        if (username != null && password != null) {
            Users user = dbm.getUser(username, password);
            if (user != null) {
                if (user.getLockedAccount() == 0) {
                    if (user.getIsAdmin() == 1) {
                        session.setAttribute("userList", dbm.getUserList());
                    }
                    session.setAttribute("user", user);
                    session.setAttribute("webList", dbm.getWebList());
                    response.sendRedirect("user.jsp");
                } else {
                    response.sendRedirect("index.jsp?message=Your account has been locked.");
                }
            } else {
                response.sendRedirect("index.jsp?message=Invalid username or password.");
            }
        } else if (sortByRating != null) {
            session.setAttribute("webList", dbm.getWebList());
            response.sendRedirect("user.jsp");
        } else if (sortByUsername != null) {
            session.setAttribute("webList", dbm.getWebListSortByUsername());
            response.sendRedirect("user.jsp");
        } else if (sortByURL != null) {
            session.setAttribute("webList", dbm.getWebListSortByURL());
            response.sendRedirect("user.jsp");
        } else if (newUser != null && newPassword != null && conPassword != null) {

            if (newPassword.equals(conPassword)) {

                if (dbm.addUser(newUser, newPassword)) {
                    response.sendRedirect("index.jsp?message=Registered.");
                } else {

                    response.sendRedirect("register.jsp?message=Unable to add new user. May already exist in the system.");
                }
            } else {
                response.sendRedirect("register.jsp?message=Passwords do not match.");
            }
        } else if (logout != null) {
            session.invalidate();
            response.sendRedirect("index.jsp?message=Logged out at: " + new Date());
        } else if (delete != null) {
            dbm.removeWebsite(Integer.parseInt(delete));
            session.setAttribute("webList", dbm.getWebList());
            response.sendRedirect("user.jsp");
        } else if (edit != null) {
            dbm.saveWebsite(Integer.parseInt(edit), webURL, webDesc);
            session.setAttribute("webList", dbm.getWebList());
            response.sendRedirect("user.jsp");
        } else if (update != null) {
            session.setAttribute("webList", dbm.getWebList());
            response.sendRedirect("index.jsp");
        } else if (newWebURL != null && newWebDesc != null) {
            dbm.addWebsite((Users) session.getAttribute("user"), newWebURL, newWebDesc);
            session.setAttribute("webList", dbm.getWebList());
            response.sendRedirect("user.jsp");
        } else if (reset != null) {
            dbm.resetUserPassword(Integer.parseInt(reset));
            session.setAttribute("userList", dbm.getUserList());
            response.sendRedirect("admin.jsp");
        } else if (deleteUser != null) {
            dbm.deleteUSer(Integer.parseInt(deleteUser));
            session.setAttribute("userList", dbm.getUserList());
            response.sendRedirect("admin.jsp");
        } else if (lockAccount != null) {
            dbm.lockAccount(Integer.parseInt(lockAccount));
            session.setAttribute("userList", dbm.getUserList());
            response.sendRedirect("admin.jsp");
        } else if (makeAdmin != null) {
            dbm.makeAdmin(Integer.parseInt(makeAdmin));
            session.setAttribute("userList", dbm.getUserList());
            response.sendRedirect("admin.jsp");
        } else if (rate != null && webToRate != null) {
            if (dbm.rateWebsite((Users) session.getAttribute("user"), Integer.parseInt(webToRate), Integer.parseInt(rate))) {
                session.setAttribute("webList", dbm.getWebList());
                response.sendRedirect("user.jsp");
            } else {
                response.sendRedirect("user.jsp?message=Cannot rate more than once.");
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
