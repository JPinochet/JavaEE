/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mySession;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface MySessionLocal {

    public java.lang.String getUsername();

    public void setUsername(java.lang.String username);

    int pageCount();

    boolean validateLogin(String username, String password);

    Date loggedIn();

    public void setLoggedIn(java.util.Date loggedIn);
    
}
