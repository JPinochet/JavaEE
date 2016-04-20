/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package forumSession;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.ejb.Stateless;
import webSite.WebSite;

/**
 *
 * @author Administrator
 */
@Stateless
public class ForumSession implements ForumSessionLocal {

    //Attributes
    ArrayList<WebSite> websites = new ArrayList<WebSite>();

    public ForumSession(){}

    public ArrayList<WebSite> getWebsites() {
        websites.clear();

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webrecdb", "root", "password");

            String sql = "SELECT * "
                            + "FROM websites;";

            Statement s = con.createStatement();
            s.executeQuery("SELECT * FROM websites;");

            ResultSet rs = s.getResultSet();

            if(rs != null)
            {
                while(rs.next())
                {
                    WebSite ws = new WebSite(rs.getInt("website_id"), rs.getString("url"), rs.getInt("creator"), rs.getString("description"), this.getRating(rs.getInt("website_id")));
                    websites.add(ws);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        Collections.sort(websites, new WebSite());

        return websites;
    }

    private int getRating(int website_id)
    {
        int rating = 0;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webrecdb", "root", "password");

            String sql = "SELECT AVG(rating) "
                            + "FROM ratings "
                            + "WHERE website_id='" + website_id + "'; ";

            Statement s = con.createStatement();
            s.executeQuery(sql);

            ResultSet rs = s.getResultSet();

            rs.next();

            rating = (int) rs.getDouble(1);

            rs.close();
            s.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return rating;
    }

    public void setWebsites(ArrayList<WebSite> websites) {
        this.websites = websites;
    }

    public boolean validateCredentials(String username, String password)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webrecdb", "root", "password");

            String sql = "CALL validateLogin(?,?,?)";

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

    public boolean addUser(String username, String password, String confirmPassword)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webrecdb", "root", "password");

            String sql = "CALL addUser(?,?,?,?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(4, java.sql.Types.BOOLEAN);

            cs.setString(1, username);
            cs.setString(2, password);
            cs.setString(3, confirmPassword);

            cs.execute();

            result = cs.getBoolean(4);

            cs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public boolean isAdmin(String username)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webrecdb", "root", "password");

            String sql = "CALL isAdmin(?,?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(2, java.sql.Types.BOOLEAN);

            cs.setString(1, username);

            cs.execute();

            result = cs.getBoolean(2);

            cs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public int getUserId(String username)
    {
        int result = -1;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webrecdb", "root", "password");

            String sql = "CALL getUserId(?,?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(2, java.sql.Types.INTEGER);

            cs.setString(1, username);

            cs.execute();

            result = cs.getInt(2);

            cs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public boolean addSite(int website, String url, int creator, String description)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webrecdb", "root", "password");

            String sql = "CALL saveSite(?,?,?,?,?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(5, java.sql.Types.BOOLEAN);

            cs.setInt(1, website);
            cs.setString(2, url);
            cs.setInt(3, creator);
            cs.setString(4, description);

            cs.execute();

            result = cs.getBoolean(5);

            cs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
