/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userAdminBean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class UserAdminBean implements UserAdminBeanLocal {

    public boolean addUser(String username, String password1, String password2) {
        boolean result = false;

        if(password1.equals(password2))
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

                CallableStatement s = conn.prepareCall("CALL addUser(?,?,?)");

                s.registerOutParameter(3, java.sql.Types.BOOLEAN);

                s.setString(1, username);
                s.setString(2, password1);

                result = s.getBoolean(3);

                s.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        return result;
    }

    public boolean deleteUser(String username) {
         boolean result = false;

            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

                CallableStatement s = conn.prepareCall("CALL deleteUser(?,?)");

                s.registerOutParameter(2, java.sql.Types.BOOLEAN);

                s.setString(1, username);

                result = s.getBoolean(2);

                s.close();
                conn.close();
            }
            catch(ClassNotFoundException e)
            {
            } catch (SQLException e) {
        }

        return result;
    }

    public boolean resetPasswordAdmin(String username) {
         boolean result = false;

            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

                CallableStatement s = conn.prepareCall("CALL resetPasswordAdmin(?,?)");

                s.registerOutParameter(2, java.sql.Types.BOOLEAN);

                s.setString(1, username);

                result = s.getBoolean(2);

                s.close();
                conn.close();
            }
            catch(ClassNotFoundException e)
            {
            } catch (SQLException e) {
        }

        return result;
    }

    public boolean resetPasswordUser(String username, String oldPassword, String newPassword1, String newPassword2) {
        boolean result = false;

        if(newPassword1.equals(newPassword2))
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

                CallableStatement s = conn.prepareCall("CALL resetPasswordUser(?,?,?,?)");

                s.registerOutParameter(4, java.sql.Types.BOOLEAN);

                s.setString(1, username);
                s.setString(2, oldPassword);
                s.setString(3, newPassword1);

                result = s.getBoolean(4);

                s.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        return result;
    }


}
