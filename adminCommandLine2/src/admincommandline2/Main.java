package admincommandline2;

import java.util.Scanner;
import userAdminBean.UserAdminBean;
import validateBean.ValidateBean;

/**
 *
 * @author ${user}
 */
public class Main {

    private static ValidateBean vb = new ValidateBean();
    private static UserAdminBean uab = new UserAdminBean();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        if(args.length < 2)
        {
            System.out.println("Usage: java - jar adminCommandLine2.jar <username> <password>");
            System.exit(1);
        }
        else if(!vb.isAdmin(args[0], args[1]))
        {
            System.out.println("Must be an admin to user this program.");
            System.exit(1);
        }
        else
        {
            int menuSelection = 0;

            do
            {
                menuSelection = getMenu();

                switch(menuSelection)
                {
                    case 1:
                        //Add User
                        if(addUser())
                            System.out.println("User added successfully");
                        else
                            System.out.println("Error adding user!!");
                        break;
                    case 2:
                        //Delete user
                        if(deleteUser())
                            System.out.println("User deleted successfully");
                        else
                            System.out.println("Error deleting user!!");
                        break;
                    case 3:
                        //Reset password
                        if(resetPassword())
                            System.out.println("User password successfully reset");
                        else
                            System.out.println("Error resetting password!!");
                        break;
                }
            }while(menuSelection != 0);
        }
    }

    private static int getMenu()
    {
        int menu = 0;

        System.out.println("1) Add User");
        System.out.println("2) Delete User");
        System.out.println("3) Reset Password");
        System.out.println("0) Exit");

        menu = s.nextInt();

        return menu;
    }

    private static boolean addUser() {
        boolean result = false;
        String username = null, password = null;

        s.nextLine(); //Strips out the new line command thing after reading in an int

        System.out.println("Enter new user name: ");
        username = s.nextLine();

        System.out.println("Enter new password: ");
        password = s.nextLine();

        result = uab.addUser(username, password, password);

        return result;
    }

    private static boolean deleteUser() {
        boolean result = false;
        String username = null;

        s.nextLine(); //Strips out the new line command thing after reading in an int

        System.out.println("Enter username to delete: ");
        username = s.nextLine();

        result = uab.deleteUser(username);
        
        return result;
    }

    private static boolean resetPassword() {
        boolean result = false;
        String username = null, oldPassword = null, newPassword = null;

        s.nextLine(); //Strips out the new line command thing after reading in an int

        System.out.println("Enter username to delete: ");
        username = s.nextLine();

        System.out.println("Enter old password: ");
        oldPassword = s.nextLine();

        System.out.println("Enter new password: ");
        newPassword = s.nextLine();

        result = uab.resetPassswordUser(username, oldPassword, newPassword, newPassword);

        return result;
    }

}
