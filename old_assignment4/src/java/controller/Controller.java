/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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

        //Attributes that can be sent to Controller
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        String conPassword = request.getParameter("conPassword");
        String logout = request.getParameter("logout");
        String newThreadTitle = request.getParameter("newThreadTitle");
        String newThreadInitPost = request.getParameter("newThreadInitPost");
        String threadID = request.getParameter("threadID");
        String newPost = request.getParameter("newPost");

        //Get the users current system
        HttpSession session = request.getSession();

        if(username != null && password != null)
        {
            if(validateCredentialsSP(username, password))
            {
                response.sendRedirect("forum.jsp");
            }
            else
            {
                response.sendRedirect("index.jsp?message=Invalid username or password");
            }
        }

        if(newUsername != null && newPassword != null && conPassword != null)
        {

        }

        if(logout != null)
        {
            session.invalidate();
            response.sendRedirect("index.jsp?message=Logged Out");
        }

        if(newThreadTitle != null && newThreadInitPost != null)
        {

        }

        if(threadID != null && newPost != null)
        {
            
        }
    }

    private Boolean validateCredentialsSP(String username, String password)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/forumdb", "root", "password");

            String sql = "CALL validateLogin(?,?,?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(3, java.sql.Types.BOOLEAN);

            cs.setString(1, username);
            cs.setString(2, password);

            cs.execute();

            result = cs.getBoolean(3);

            cs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
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
