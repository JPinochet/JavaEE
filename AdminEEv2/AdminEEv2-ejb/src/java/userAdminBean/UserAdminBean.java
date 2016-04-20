/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userAdminBean;

import javax.ejb.Stateless;
import java.sql.*;

/**
 *
 * @author Administrator
 */
@Stateless
public class UserAdminBean implements UserAdminBeanLocal {

    public boolean addUser(String username, String password1, String password2)
    {
	boolean result=false;

	//Check passwords are the same
	if (! password1.equals(password2))
	    return false;

	try
	{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myusers"
		    ,"root","password");

	    CallableStatement s =conn.prepareCall("call addUser(?,?,?)");

	    s.registerOutParameter(3, java.sql.Types.BOOLEAN);

	    s.setString(1,username);
	    s.setString(2,password1);

	    s.executeQuery();

	    result=s.getBoolean(3);

	    s.close();
	    conn.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}

	return result;
    }

    public boolean deleteUser(String username)
    {
	boolean result=false;

	try
	{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myusers"
		    ,"root","password");

	    CallableStatement s =conn.prepareCall("call deleteUser(?,?)");

	    s.registerOutParameter(2, java.sql.Types.BOOLEAN);

	    s.setString(1,username);

	    s.executeQuery();

	    result=s.getBoolean(2);

	    s.close();
	    conn.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}

	return result;
    }

    public boolean resetPasswordAdmin(String username)
    {
	boolean result=false;

	try
	{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myusers"
		    ,"root","password");

	    CallableStatement s =conn.prepareCall("call resetPasswordAdmin(?,?)");

	    s.registerOutParameter(2, java.sql.Types.BOOLEAN);

	    s.setString(1,username);

	    s.executeQuery();

	    result=s.getBoolean(2);

	    s.close();
	    conn.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}

	return result;
    }

    public boolean resetPassswordUser(String username, String oldPassword, String newPassword1, String newPassword2)
    {
	boolean result=false;

	//Check passwords are the same
	if (! newPassword1.equals(newPassword2))
	    return false;

	try
	{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myusers"
		    ,"root","password");

	    CallableStatement s =conn.prepareCall("call resetPasswordUser(?,?,?,?)");

	    s.registerOutParameter(4, java.sql.Types.BOOLEAN);

	    s.setString(1,username);
	    s.setString(2,oldPassword);
	    s.setString(3,newPassword1);

	    s.executeQuery();

	    result=s.getBoolean(4);

	    s.close();
	    conn.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}

	return result;
    }
    

 
}
