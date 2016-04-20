/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webrecDB;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface DBManagerLocal {

    public boolean addUser(java.lang.String username, java.lang.String password);

    public webrecDB.Users getUser(java.lang.String username, java.lang.String password);

    public webrecDB.Websites getWebsite(int website_id);

    public boolean saveWebsite(int website_id, java.lang.String url, java.lang.String description);

    public boolean addWebsite(webrecDB.Users user, java.lang.String url, java.lang.String description);

    public java.util.ArrayList<website.WebSite> getWebList();

    public java.util.ArrayList<webrecDB.Users> getUserList();

    public boolean resetUserPassword(int user_id);

    public boolean deleteUSer(int user_id);

    public boolean removeWebsite(int website_id);

    public boolean lockAccount(int user_id);

    public boolean makeAdmin(int user_id);

    public boolean rateWebsite(Users user, int website_id, int rate);

    public java.util.ArrayList<website.WebSite> getWebListSortByURL();

    public java.util.ArrayList<website.WebSite> getWebListSortByUsername();
}
