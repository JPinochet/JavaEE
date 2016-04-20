/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import fileHandling.FileOutput;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import sun.applet.Main;
import util.Email;

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

        String log = "", user = "", password = "";
        HttpSession session = request.getSession();
        ArrayList<Email> emails = null;

        if(request.getParameter("delete") != null)
        {
            int id = Integer.parseInt(request.getParameter("delete"));
            
            if(session.getAttribute("emails") != null)
            {
                emails = (ArrayList<Email>) session.getAttribute("emails");
            }
            
            if(session.getAttribute("user") != null)
            {
                user = (String) session.getAttribute("user");
            }
            
            deleteEmail(id, emails, user);
            ServletContext context = getServletContext();  //Now Sending off the information
            RequestDispatcher dispatcher = context.getRequestDispatcher("/email.jsp");
            dispatcher.forward(request, response);
        }

        if(request.getParameter("emailSent") != null)
        {
            Boolean update = Boolean.parseBoolean(request.getParameter("emailSent"));

            if(update)
            {
                String toWho = "", subject = "", msg = "";

                if(request.getParameter("toWho") != null)
                {
                    toWho = request.getParameter("toWho");
                }

                if(request.getParameter("subject") != null)
                {
                    subject = request.getParameter("subject");
                }

                if(request.getParameter("msg") != null)
                {
                    msg = request.getParameter("msg");
                }

                if(session.getAttribute("user") != null)
                {
                    user = (String) session.getAttribute("user");
                }

                Email email = new Email(0, toWho, user, new Date(), subject, msg);

                sendEmail(email);
                
                response.sendRedirect("Controller?update=true");
            }
        }

        if(request.getParameter("update") != null)
        {

            if(session.getAttribute("user") != null)
            {
                user = (String) session.getAttribute("user");
            }

            emails = getEmails(user);
            session.setAttribute("emails", emails);
                
            ServletContext context = getServletContext();  //Now Sending off the information
            RequestDispatcher dispatcher = context.getRequestDispatcher("/email.jsp");
            dispatcher.forward(request, response);
            
        }

        if(request.getParameter("logStatus") != null)
        {
            log = request.getParameter("logStatus");

            if(log.equals("login"))
            {
                if(request.getParameter("username") != null)
                {
                    user = request.getParameter("username");
                }

                if(request.getParameter("password") != null)
                {
                    password = request.getParameter("password");
                }

                if(login(user, password))
                {
                    emails = getEmails(user);
                    Date date = new Date();

                    session.setAttribute("user", user);
                    session.setAttribute("emails", emails);
                    session.setAttribute("date", date);

                    ServletContext context = getServletContext();  //Now Sending off the information
                    RequestDispatcher dispatcher = context.getRequestDispatcher("/email.jsp");
                    dispatcher.forward(request, response);
                }
                else
                {
                    response.sendRedirect("index.jsp?message=Invalid username or password");
                }
            }
            else if(log.equals("logout"))
            {
                session.invalidate();
                Date date = new Date();
                response.sendRedirect("index.jsp?message=Logged out at " + date);
            }
        }
        
        
    }

    private static Boolean deleteEmail(int id, ArrayList<Email> emails, String user)
    {
        emails.remove(id);

        Boolean deleted = new File("D:/emails/" + user + ".txt").delete();

        if(deleted)
        {
            Boolean save = saveEmail(emails, user);

            if(save)
            {
                return true;
            }
        }

        return false;
    }

    private static Boolean sendEmail(Email email)
    {
        FileOutput out = new FileOutput("D:/emails/" + email.getToWho() + ".txt", true);

        out.print(email.getToWho() + ";");
        out.print(email.getFromWho() + ";");
        out.print(email.getWhenSent() + ";");
        out.print(email.getSubject() + ";");
        out.println(email.getMsg());
        
        out.close();

        return true;
    }

    private static Boolean saveEmail(ArrayList<Email> emails, String user)
    {
        FileOutput out = new FileOutput("D:/emails/" + user + ".txt");

        for(int i = 0; i < emails.size(); i++)
        {
            out.print(emails.get(i).getToWho()+ ";");
            out.print(emails.get(i).getFromWho() + ";");
            out.print(emails.get(i).getWhenSent() + ";");
            out.print(emails.get(i).getSubject() + ";");
            out.println(emails.get(i).getMsg());
        }

        out.close();

        return true;
    }

    private static ArrayList<Email> getEmails(String filename)
    {
        ArrayList<Email> emails = new ArrayList<Email>();

        if(new File("D:/emails/" + filename + ".txt").exists())
        {
            try {
                BufferedReader in = new BufferedReader(new FileReader("D:/emails/" + filename + ".txt"));
                String current;
                int id = 0;

                while((current = in.readLine()) != null)
                {
                    StringTokenizer st = new StringTokenizer(current, ";");

                    Email email = new Email(id++,
                                                st.nextToken(),
                                                st.nextToken(),
                                                new Date(st.nextToken()),
                                                st.nextToken(),
                                                st.nextToken());
                    emails.add(email);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return emails;
    }

    private static Boolean login(String user, String password)
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("D:/emails/users.txt"));
            String current;

            while((current = in.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(current);

                if(st.nextToken().equals(user))
                {
                    if(st.nextToken().equals(password))
                    {
                        return true;
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return false;
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
