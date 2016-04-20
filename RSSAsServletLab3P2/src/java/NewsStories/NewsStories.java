/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NewsStories;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author Administrator
 */
@WebServlet(name="NewsStories", urlPatterns={"/"})
public class NewsStories extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ParserConfigurationException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse("http://feeds.reuters.com/reuters/topNews");
            String message = " ";
            NodeList nodes = doc.getElementsByTagName("item");
            for (int i = 0; i < nodes.getLength(); i++)
            {
                Element news = (Element) nodes.item(i);

                //customer name
                NodeList titles = news.getElementsByTagName("title");
                Element title = (Element) titles.item(0);
                message += "<br />News: " + getCharacterDataFromElement(title) + "<br />";

                NodeList dates = news.getElementsByTagName("pubDate");
                Element date = (Element) dates.item(0);
                message += "<br />Date: " + getCharacterDataFromElement(date) + "<br />";

               //System.out.println(message);
             }
            try {
                /* TODO output your page here*/
                out.println("<html>");
                out.println("<head>");
                out.println("<title>News Stories</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Todays Top Stories are: </h1>");
                out.println(message);
                out.println("</body>");
                out.println("</html>");
                /**/
            } finally {
                out.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Get character data from specified element, return as a String
 private static String getCharacterDataFromElement(Element e)
    {
            Node child = e.getFirstChild();
            String result="";

            if (child instanceof CharacterData)
            {
                    CharacterData cd = (CharacterData) child;
                    result=cd.getData();
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
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(NewsStories.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(NewsStories.class.getName()).log(Level.SEVERE, null, ex);
        }
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
