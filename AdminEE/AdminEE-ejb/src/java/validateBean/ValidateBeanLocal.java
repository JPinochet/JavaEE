/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validateBean;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface ValidateBeanLocal {

    boolean validateLogin(String username, String password);

    public boolean isAdmin(java.lang.String username);
    
}
