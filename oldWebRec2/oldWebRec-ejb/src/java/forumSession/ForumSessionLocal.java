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

    public boolean validateCredentials(java.lang.String username, java.lang.String password);

    public boolean addUser(java.lang.String username, java.lang.String password, java.lang.String confirmPassword);

    public java.util.ArrayList<webSite.WebSite> getWebsites();

    public void setWebsites(java.util.ArrayList<webSite.WebSite> websites);

    public int getUserId(java.lang.String username);

    public boolean addSite(int website, java.lang.String url, int creator, java.lang.String description);

    public boolean isAdmin(java.lang.String username);
    
}
