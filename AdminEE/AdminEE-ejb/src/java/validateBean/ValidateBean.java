/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validateBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class ValidateBean implements ValidateBeanLocal {

    public boolean isAdmin(String username)
    {
        boolean result = false;
         try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

            Statement s = conn.createStatement();

            s.executeQuery("SELECT isAdmin FROM users WHERE username='" + username + "';");

            ResultSet rs = s.getResultSet();

            rs.next();

            int count = rs.getInt(1);

            if(count>0)
                result=true;

            rs.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public boolean validateLogin(String username, String password) {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

            Statement s = conn.createStatement();

            s.executeQuery("SELECT COUNT(*) FROM users WHERE username='" + username + "' AND password='" + password + "';");

            ResultSet rs = s.getResultSet();

            rs.next();

            int count = rs.getInt(1);

            if(count>0)
                result=true;

            rs.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }
    
}
