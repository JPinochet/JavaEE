/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package forumSession;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface ForumSessionLocal {

    public boolean addThread(java.lang.String threadTitle, java.lang.String threadInitPost, java.lang.String username);

    public boolean addUser(java.lang.String username, java.lang.String password, java.lang.String confirmPassword);

    public boolean validateCredentialsSP(java.lang.String username, java.lang.String password);

    public boolean addPost(java.lang.String threadId, java.lang.String postText, java.lang.String poster);

    public java.util.ArrayList<thread.Thread> getThreads();

    public java.util.ArrayList<post.Post> getPosts(int tId);
}
