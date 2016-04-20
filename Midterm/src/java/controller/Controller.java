/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import student.Student;
import student.StudentListWrapper;

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
        ServletContext context = getServletContext();
	RequestDispatcher dispatcher=null;

        if(request.getParameter("JSTL") != null)
        {
            if((request.getParameter("name") != null) && (request.getParameter("age") != null))
            {
                
                ArrayList<Student> students = null;

                if(session.getAttribute("studentList") != null)
                {
                    students = (ArrayList<Student>) session.getAttribute("studentList");
                }
                else
                {
                    students = new ArrayList<Student>();
                }


                int i = 0;

                if(students != null)
                    i = students.size();

                i++;

                Student s = new Student(i, request.getParameter("name"), Integer.parseInt(request.getParameter("age")));

                students.add(s);

                session.setAttribute("studentList", students);
                session.setAttribute("studentWrapper", new StudentListWrapper(students));

                dispatcher = context.getRequestDispatcher("/JSTL.jsp");
		dispatcher.forward(request,response);
            }
            else if(request.getParameter("delete") != null)
            {
                int deleteStudent = Integer.parseInt(request.getParameter("delete"));

                ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("studentList");

                for (int i=0; i< students.size(); i++)
		{
		    Student s = students.get(i);
		    if (s.getId()==deleteStudent)
		    {
			students.remove(i);
		    }
		}

                session.setAttribute("studentList", students);
                session.setAttribute("studentWrapper", new StudentListWrapper(students));
                dispatcher = context.getRequestDispatcher("/JSTL.jsp");
		dispatcher.forward(request,response);
            }
            else
            {
                ArrayList<Student> students = null;
                session.setAttribute("studentList", students);
                session.setAttribute("studentWrapper", new StudentListWrapper(students));
                dispatcher = context.getRequestDispatcher("/JSTL.jsp");
		dispatcher.forward(request,response);
            }
        }

        if(request.getParameter("scriptlet") != null)
        {
            if((request.getParameter("name") != null) && (request.getParameter("age") != null))
            {
                ArrayList<Student> students = null;

                if(session.getAttribute("studentList") != null)
                {
                    students = (ArrayList<Student>) session.getAttribute("studentList");
                }
                else
                {
                    students = new ArrayList<Student>();
                }


                int i = 0;

                if(students != null)
                    i = students.size();

                i++;

                Student s = new Student(i, request.getParameter("name"), Integer.parseInt(request.getParameter("age")));

                students.add(s);

                session.setAttribute("studentList", students);

                dispatcher = context.getRequestDispatcher("/scriptlet.jsp");
		dispatcher.forward(request,response);
            }
            else if(request.getParameter("delete") != null)
            {
                int deleteStudent = Integer.parseInt(request.getParameter("delete"));

                ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("studentList");

                for (int i=0; i< students.size(); i++)
		{
		    Student s = students.get(i);
		    if (s.getId()==deleteStudent)
		    {
			students.remove(i);
		    }
		}

                session.setAttribute("studentList", students);
                dispatcher = context.getRequestDispatcher("/scriptlet.jsp");
		dispatcher.forward(request,response);
            }
            else
            {
                ArrayList<Student> students = null;
                session.setAttribute("studentList", students);

                dispatcher = context.getRequestDispatcher("/scriptlet.jsp");
		dispatcher.forward(request,response);
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
