/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mySession;

import javax.ejb.Stateful;
import validateBean.ValidateBean;

/**
 *
 * @author Administrator
 */
@Stateful
public class MySession implements MySessionLocal {
    String username = null;
    boolean isAdmin = false;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean validateLogin(String username, String password) {
        ValidateBean vb = new ValidateBean();

        return vb.validateLogin(username, password);
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
