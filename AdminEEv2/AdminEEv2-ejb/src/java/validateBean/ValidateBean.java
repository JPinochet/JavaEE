/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validateBean;

import javax.ejb.Stateless;
import java.sql.*;

/**
 *
 * @author Administrator
 */
@Stateless
public class ValidateBean implements ValidateBeanLocal {

    public boolean validateLogin(String username, String password)
    {
	boolean result=false;

	try
	{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myusers"
		    ,"root","password");

	    Statement s =conn.createStatement();
	    s.executeQuery("select count(*) from users where username='" + username +
		    "' and password='" + password + "';");

	    ResultSet rs=s.getResultSet();

	    rs.next();

	    int count=rs.getInt(1);

	    if (count>0)
		result=true;

	    rs.close();
	    conn.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return result;
    }

    public boolean isAdmin(String username, String password)
    {
        boolean result=false;

        try
	{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myusers","root","password");

	    Statement s =conn.createStatement();
	    s.executeQuery("select isAdmin from users where username='" + username + "' and password='" + password + "';");

	    ResultSet rs=s.getResultSet();

	    if (rs.first())
		result = rs.getBoolean(1);

	    rs.close();
	    conn.close();
	}
	catch (Exception e)
	{
	    //e.printStackTrace();
	}

        return result;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
