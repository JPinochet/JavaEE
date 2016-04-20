/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Thread {

    int threadId = 0;
    Date dateCreated = null;
    String description = null;
    String creator = null;

    public Thread(){}

    public Thread(int id, Date date, String desc, String user)
    {
        this.threadId = id;
        this.dateCreated = date;
        this.description = desc;
        this.creator = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String fk_username) {
        this.creator = fk_username;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }
}
