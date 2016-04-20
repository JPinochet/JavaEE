/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class UserData {

    Date d = new Date();
    String username = new String();
    int pageCount;

    public UserData(Date date, String user, int pageCount2)
    {
        this.d = date;
        this.username = user;
        this.pageCount = pageCount2;
    }

    public Date getD() {
        return d;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getUsername() {
        return username;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString()
    {
        return d + username + pageCount;
    }
}
