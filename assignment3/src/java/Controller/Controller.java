/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Email.Email;
import emailArrayListWrapper.EmailArrayListWrapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
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
@WebServlet(name="Controller", urlPatterns={"/Controller"})
public class Controller extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

	HttpSession session = request.getSession();

	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String logout=request.getParameter("logout");
	String delete=request.getParameter("delete");
	String to=request.getParameter("to");
	String checkNew = request.getParameter("checkNew");

	ServletContext context = getServletContext();
	RequestDispatcher dispatcher=null;

        try {

	    //Logout
	    if (logout!=null)
	    {
		session.invalidate();
		response.sendRedirect("index.jsp?message=Logged out at " + (new Date()));
	    }

	    //Validate user details
	    if (username!=null && password!=null)
	    {
		if (checkUserDetails(username,password))
		{
		    session.setAttribute("username",username);
		    session.setAttribute("loggedIn",new Date());
		    
		    ArrayList<Email> ref=getEmails(username);
		    session.setAttribute("emailList", ref);

		    //Add wrapper for array list of emails to session also.
		    //Has a size property so we can determine the array list's size
		    //in a JSP using JSTL and EL.
		    session.setAttribute("emailListWrapper", new EmailArrayListWrapper(ref));

		    dispatcher = context.getRequestDispatcher("/emails.jsp");
		    dispatcher.forward(request,response);
		}
		else
		{
		    response.sendRedirect("index.jsp?message=Invalid username or password!");
		}
	    }

	    //Check for new messages (update ArrayList<Email> from file)
	    if (checkNew!=null)
	    {
		String user = (String)session.getAttribute("username");
		session.setAttribute("emailList",getEmails(user));

		dispatcher = context.getRequestDispatcher("/emails.jsp");
		dispatcher.forward(request,response);
	    }

	    //Send an email
	    if (to!=null)
	    {
		ArrayList<Email> emails = (ArrayList<Email>)session.getAttribute("emailList");
		String from = (String)session.getAttribute("username");
		String sent = new Date().toString();

		String subject = request.getParameter("subject");
		String message = request.getParameter("message");

		Email e = new Email(0,to,from,sent,subject,message);

		sendEmail(e);

		//If email sent to self, refresh ArrayList<Email>
		if (to.equals((String)session.getAttribute("username")))
		{
		    ArrayList<Email> ref=getEmails((String)session.getAttribute("username"));
		    session.setAttribute("emailList",ref);
		    session.setAttribute("emailListWrapper", new EmailArrayListWrapper(ref));
		}

		dispatcher=context.getRequestDispatcher("/emails.jsp");
		dispatcher.forward(request,response);

	    }

	    //Delete an email
	    if (delete!=null)
	    {
		int idToDelete = Integer.parseInt(delete);

		ArrayList<Email> emails = (ArrayList<Email>)session.getAttribute("emailList");

		for (int i=0; i< emails.size(); i++)
		{
		    Email e = emails.get(i);
		    if (e.getId()==idToDelete)
		    {
			emails.remove(i);
		    }
		}

		//Update email list wrapper to take deleted email into account
		session.setAttribute("emailListWrapper", new EmailArrayListWrapper(emails));

		//Save changes to file
		saveEmails((String)session.getAttribute("username"),emails);

		//Send user back to emails page
		dispatcher=context.getRequestDispatcher("/emails.jsp");
		dispatcher.forward(request,response);
		
	    }

        } finally { 
            
        }
    }

    boolean checkUserDetails(String username, String password)
    {
	boolean result=false;

	try
	{
	    File infile = new File("d:/emails/users.txt");
	    Scanner s = new Scanner(infile);

	    while (s.hasNext())
	    {
		String user=s.next();
		String pass=s.next();

		if (user.equals(username) && pass.equals(password))
		    result=true;
	    }
	    s.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}

	return result;
    } //end of checkUserDetails

    ArrayList<Email> getEmails(String username)
    {
	ArrayList<Email> emails=new ArrayList<Email>();

	try
	{
	    File infile = new File("d:/emails/" + username + ".txt");
	    int idCounter=0;

	    if (infile.exists())
	    {
		Scanner s = new Scanner(infile);

		while (s.hasNextLine())
		{
		    String emailLine=s.nextLine();

		    StringTokenizer t = new StringTokenizer(emailLine,";");

		    String to = t.nextToken();
		    String from = t.nextToken();
		    String sent = t.nextToken();
		    String subject = t.nextToken();
		    String message = t.nextToken();

		    Email email = new Email(idCounter++,to,from,sent,subject,message);

		    emails.add(email);
		}

	    }
	    else
	    {
		//Create empty file for users future emails
		PrintWriter p = new PrintWriter("d:/emails/" + username + ".txt");
		p.print("");
		p.close();

	    }
	    
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}

	return emails;
    } //end of getEmails

    void sendEmail(Email email)
    {
	try
	{
	    String to = email.getTo();

	    FileWriter f=new FileWriter("d:/emails/" + to + ".txt",true);
	    BufferedWriter bw=new BufferedWriter(f);

	    bw.write(email.getTo() + ";" + email.getFrom() + ";" + email.getSent() + ";" + email.getSubject() + ";" + email.getMessage() + "\r\n");

	    bw.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

    void saveEmails(String username, ArrayList<Email> emails)
    {

	try
	{
	    PrintWriter p = new PrintWriter("d:/emails/" + username + ".txt");

	    for (int i=0; i<emails.size(); i++)
	    {
		Email e = emails.get(i);
		p.println(e.getTo() + ";" + e.getFrom() + ";" + e.getSent() + ";" + e.getSubject() + ";" + e.getMessage());
	    }
	    
	    p.close();
	}
	catch(Exception e)
	{
	    e.printStackTrace();
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
