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
import javax.ejb.Stateful;
import post.Post;
import thread.Thread;

/**
 *
 * @author Administrator
 */
@Stateful
public class ForumSession implements ForumSessionLocal {

    //Attributes
    ArrayList<thread.Thread> threads = new ArrayList<thread.Thread>();
    ArrayList<post.Post> posts = new ArrayList<post.Post>();
    
    public ForumSession() {}

    public boolean validateCredentialsSP(String username, String password)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/forumdb", "root", "password");

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

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/forumdb", "root", "password");

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

    public boolean addThread(String threadTitle, String threadInitPost, String username)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/forumdb", "root", "password");

            String sql = "CALL addThread(?,?,?,?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(4, java.sql.Types.BOOLEAN);

            cs.setString(1, threadTitle);
            cs.setString(2, threadInitPost);
            cs.setString(3, username);

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

    public boolean addPost(String threadId, String postText, String poster)
    {
        boolean result = false;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/forumdb", "root", "password");

            String sql = "CALL addPost(?,?,?,?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.registerOutParameter(4, java.sql.Types.BOOLEAN);

            cs.setString(1, threadId);
            cs.setString(2, postText);
            cs.setString(3, poster);

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

    public ArrayList<Thread> getThreads() {

        threads.clear();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/forumdb", "root", "password");

            Statement s = conn.createStatement();
            s.executeQuery("SELECT * FROM threads;");

            ResultSet rs = s.getResultSet();

            while(rs.next())
            {
                Thread thread = new Thread(rs.getInt("threadId"), rs.getDate("dateCreated"), rs.getString("description"), rs.getString("fk_username"));
                threads.add(thread);
            }

            rs.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return threads;
    }

    public ArrayList<Post> getPosts(int tId) {

        posts.clear();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/forumdb", "root", "password");

            Statement s = conn.createStatement();
            s.executeQuery("SELECT * FROM posts WHERE fk_threadID='"+ tId +"';");

            ResultSet rs = s.getResultSet();

            while(rs.next())
            {
                Post post = new Post(rs.getInt("postID"), rs.getInt("fk_threadID"), rs.getDate("datePosted"), rs.getString("postText"), rs.getString("fk_username"));
                posts.add(post);
            }

            rs.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return posts;
    }
}
