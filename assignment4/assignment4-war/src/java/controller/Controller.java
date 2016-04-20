/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import forumSession.ForumSession;
import java.io.IOException;
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
        String threadId = request.getParameter("threadId");
        String newPost = request.getParameter("newPost");
        String threadUpdate = request.getParameter("threadUpdate");

        //Get the users current system
        HttpSession session = request.getSession();
        //Create ForumSession object to user methods
        ForumSession fs = new ForumSession();

        if(username != null && password != null)
        {
            if(fs.validateCredentialsSP(username, password))
            {
                session.setAttribute("user", username);
                session.setAttribute("threadsList", fs.getThreads());

                response.sendRedirect("forum.jsp");
            }
            else
            {
                response.sendRedirect("index.jsp?message=Invalid username or password");
            }
        }

        if(newUsername != null && newPassword != null && conPassword != null)
        {
            if(fs.addUser(newUsername, newPassword, conPassword))
            {
                response.sendRedirect("index.jsp?message=You are now registered");
            }
            else
            {
                response.sendRedirect("register.jsp?message=Registration unsuccessful. User name already exists, or passwords do not match");
            }
        }

        if(logout != null)
        {
            session.invalidate();
            response.sendRedirect("index.jsp?message=Logged Out");
        }

        if(newThreadTitle != null && newThreadInitPost != null)
        {
            String user = (String) session.getAttribute("user");

            if(fs.addThread(newThreadTitle, newThreadInitPost, user))
            {
                response.sendRedirect("Controller?threadUpdate=true");
            }
            else
            {
                response.sendRedirect("forum.jsp?message=Thread could not be added");
            }
        }

        if(threadId != null && newPost == null)
        {
            session.setAttribute("threadId", threadId);
            session.setAttribute("postList", fs.getPosts(Integer.parseInt(threadId)));

            response.sendRedirect("posts.jsp");
        }
        
        if(newPost != null && threadId != null)
        {
            threadId = (String)session.getAttribute("threadId");

            if(fs.addPost(threadId, newPost, (String)session.getAttribute("user")))
            {
                response.sendRedirect("Controller?threadId=" + threadId);
            }
            else
            {
                response.sendRedirect("posts.jsp?message=Post could not be added");
            }
        }

        if(threadUpdate != null)
        {
            session.setAttribute("threadsList", fs.getThreads());
            response.sendRedirect("forum.jsp");
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
