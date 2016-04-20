/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validate;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name="Validate", urlPatterns={"/Validate"})
public class Validate extends HttpServlet {
   
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

        try {
            if((username != null) && (password != null))
            {
                if(validateCredentialsSP(username, password))
                {
                    response.sendRedirect("index.jsp?message=Valid");
                }
                else
                {
                    response.sendRedirect("index.jsp?message=INVALID");
                }
            }
            
        } finally { 
        }
    }

    private Boolean validateCredentials(String username, String password)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");
            Statement s = con.createStatement();

            String sql = "SELECT COUNT(*) FROM users WHERE username='" + username + "' AND password='" + password + "';";

            s.executeQuery(sql);

            ResultSet rs = s.getResultSet();
            rs.next(); //cursor pointer now looking at result

            int count = rs.getInt(1);

            if(count == 1)
                result = true;

            s.close();
            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    private Boolean validateCredentialsPS(String username, String password)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM users WHERE username=? AND password=?;");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            rs.next(); //cursor pointer now looking at result

            int count = rs.getInt(1);

            if(count == 1)
                result = true;

            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    private Boolean validateCredentialsSP(String username, String password)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

            String sql = "CALL validateCredentials(?,?,?)";

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
