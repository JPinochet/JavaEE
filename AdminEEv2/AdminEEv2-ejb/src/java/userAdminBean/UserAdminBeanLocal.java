/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userAdminBean;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface UserAdminBeanLocal {

    boolean addUser(String username, String password1, String password2);

    boolean deleteUser(String username);

    boolean resetPasswordAdmin(String username);

    boolean resetPassswordUser(String username, String oldPassword, String newPassword1, String newPassword2);
    
}
