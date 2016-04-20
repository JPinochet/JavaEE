/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package post;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Post {

    int postId = 0;
    int threadId = 0;
    Date datePosted = null;
    String postText = null;
    String fk_username = null;

    public Post(){}

    public Post(int pId, int tId, Date date, String post, String user)
    {
        this.postId = pId;
        this.threadId = tId;
        this.datePosted = date;
        this.postText = post;
        this.fk_username = user;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getFk_username() {
        return fk_username;
    }

    public void setFk_username(String fk_username) {
        this.fk_username = fk_username;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }
}
