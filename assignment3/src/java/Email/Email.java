/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Email;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Email {
    int id;
    String to;
    String from;
    String sent;
    String subject;
    String message;

    public Email(int id, String to, String from, String sent, String subject, String message)
    {
	this.id=id;
	this.to=to;
	this.from=from;
	this.sent=sent;
	this.subject=subject;
	this.message=message;
    }

    public String getFrom() {
	return from;
    }

    public void setFrom(String from) {
	this.from = from;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getSent() {
	return sent;
    }

    public void setSent(String sent) {
	this.sent = sent;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getTo() {
	return to;
    }

    public void setTo(String to) {
	this.to = to;
    }


}
