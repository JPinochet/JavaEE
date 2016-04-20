/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package emailArrayListWrapper;

import email.Email;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class EmailArrayListWrapper {
    ArrayList<Email> ref;
    int size;

    public EmailArrayListWrapper()
    {}

    public EmailArrayListWrapper(ArrayList<Email> ref)
    {
	this.ref=ref;
    }

    public ArrayList<Email> getRef() {
	return ref;
    }

    public void setRef(ArrayList<Email> ref) {
	this.ref = ref;
    }

    public int getSize() {
	return ref.size();
    }

}
