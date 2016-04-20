/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrator
 */
@WebServlet(name="Main", urlPatterns={"/Main"})
public class Main extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        File file = new File("res/allFeeds.xml");
        String command = "", title = "", link = "";
        short feed = 0;

        if(request.getAttribute("command") != null)
        {
            command = (String) request.getAttribute("command");
        }
        else if(request.getParameter("command") != null)
        {
            command = request.getParameter("command");
        }

        if(request.getAttribute("title") != null)
        {
            title = (String) request.getAttribute("title");
        }
        else if(request.getParameter("title") != null)
        {
            title = request.getParameter("title");
        }

        if(request.getAttribute("link") != null)
        {
            link = (String) request.getAttribute("link");
        }
        else if(request.getParameter("link") != null)
        {
            link = request.getParameter("link");
        }

        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(file);

            if(command.equals("delete"))
            {
                removeAll(doc, feed, title);
                removeAll(doc, feed, link);
            }
            else if(command.equals("add"))
            {
                NodeList nodes = doc.getElementsByTagName("feed");
                for (int i = 0; i <= nodes.getLength(); i++)
                {
                    if(i == nodes.getLength())
                    {
                        Element element = doc.createElement(title);
                        doc.appendChild(element);

                        Element element2 = doc.createElement(link);
                        doc.appendChild(element2);
                    }

                }
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Top News</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>The Feeds</h1></center><br /><br /><br />");

            NodeList nodes = doc.getElementsByTagName("feed");
            for (int i = 0; i < nodes.getLength(); i++)
            {
                Element stuff = (Element) nodes.item(i);

                NodeList titles = stuff.getElementsByTagName("title");
                Element newsTitle = (Element) titles.item(0);
                out.println("<br />Title: " + getCharacterDataFromElement(newsTitle));

                NodeList links = stuff.getElementsByTagName("link");
                Element newsLink = (Element) links.item(0);
                out.println("<a href=\"" + getCharacterDataFromElement(newsLink) + "\">Link</a><br />");
                out.println("<a href=\"\\Main?command=delete&title=" + getCharacterDataFromElement(newsTitle) + "&link=" +getCharacterDataFromElement(newsLink)+ "\">Delete</a><br />");
            }

            out.println("<a href=\"/AddFeed\">Add Feed</a><br /><br /><br />");

            out.println("</body>");
            out.println("</html>");

            out.close();
            writeXmlFile(doc, "res/allFeeds.xml");
        }
        catch (ParserConfigurationException e)
        {
        } catch (SAXException e) {
        } catch (IOException e) {
        } catch (DOMException e) {
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

    public static void removeAll(Node node, short nodeType, String name)
    {
        if (node.getNodeType() == nodeType &&  (name == null || node.getNodeName().equals(name)))
        {
            node.getParentNode().removeChild(node);
        }
        else
        {
            // Visit the children
            NodeList list = node.getChildNodes();

            for (int i=0; i<list.getLength(); i++)
            {
                removeAll(list.item(i), nodeType, name);
            }
        }
    }

    // This method writes a DOM document to a file
    public static void writeXmlFile(Document doc, String filename)
    {
        try
        {
            // Prepare the DOM document for writing
            Source source = new DOMSource(doc);

            // Prepare the output file
            File file = new File(filename);
            StreamResult result = new StreamResult(file);

            // Write the DOM document to the file
            javax.xml.transform.Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        }
        catch (TransformerConfigurationException e)
        {
        }
        catch (TransformerException e)
        {
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