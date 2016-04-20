/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mySession;

import java.util.Date;
import java.sql.*;
import javax.ejb.Stateful;

/**
 *
 * @author Administrator
 */
@Stateful
public class MySession implements MySessionLocal {
    
    String username = null;
    int pageCount = 0;
    Date loggedIn = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int pageCount() {
        return ++pageCount;
    }
    
    public boolean validateLogin(String username, String password) {
        boolean result = false;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myusers", "root", "password");

            Statement s = conn.createStatement();
            s.executeQuery("SELECT COUNT(*) FROM users WHERE username='" + username + "' AND password='" + password + "';");

            ResultSet rs = s.getResultSet();

            rs.next();

            int count = rs.getInt(1);
            if(count > 0)
                result = true;
            rs.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        setLoggedIn(new Date());
        return result;
    }

    public Date loggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Date loggedIn) {
        this.loggedIn = loggedIn;
    }
}
    
