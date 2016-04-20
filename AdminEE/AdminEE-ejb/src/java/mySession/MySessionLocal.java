/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mySession;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface MySessionLocal {

    public void setUsername(java.lang.String username);

    public java.lang.String getUsername();

    boolean validateLogin(String username, String password);

    public boolean isIsAdmin();

    public void setIsAdmin(boolean isAdmin);
    
}
