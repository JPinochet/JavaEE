/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import guessSession.GuessSession;
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
@WebServlet(name="GuessingGame", urlPatterns={"/GuessingGame"})
public class GuessingGame extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String guess = request.getParameter("guess");

        HttpSession session = request.getSession();

        if(guess != null)
        {
            GuessSession gs = new GuessSession();

            int answer = gs.makeGuess(Integer.parseInt(guess));

            if(answer == -1)
            {
                session.setAttribute("numberOfGuesses", gs.getNumGuesses());
                session.setAttribute("guessList", gs.getGuesses());

                response.sendRedirect("index.jsp?message=Too Low");
            }
            else if(answer == 1)
            {
                session.setAttribute("numberOfGuesses", gs.getNumGuesses());
                session.setAttribute("guessList", gs.getGuesses());

                response.sendRedirect("index.jsp?message=Too High");
            }
            else if(answer == 0)
            {
                session.setAttribute("numberOfGuesses", gs.getNumGuesses());
                session.setAttribute("guessList", gs.getGuesses());

                response.sendRedirect("index.jsp?message=That's it!!");
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
