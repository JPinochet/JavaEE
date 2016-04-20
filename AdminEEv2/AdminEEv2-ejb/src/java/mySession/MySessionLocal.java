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

    public java.lang.String getUsername();

    public void setUsername(java.lang.String username);

    boolean validateLogin(String username, String password);
    
}
