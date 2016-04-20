/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Email {

    //Attribute
    private int id;
    private String toWho;
    private String fromWho;
    private Date whenSent;
    private String subject;
    private String msg;

    public Email(int id, String toWho, String fromWho, Date whenSent, String subject, String msg) {
        this.id = id;
        this.toWho = toWho;
        this.fromWho = fromWho;
        this.whenSent = whenSent;
        this.subject = subject;
        this.msg = msg;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public Date getWhenSent() {
        return whenSent;
    }

    public void setWhenSent(Date whenSent) {
        this.whenSent = whenSent;
    }

    @Override
    public String toString()
    {
        return toWho + ";" +  fromWho + ";" + whenSent + ";" + subject + ";" +  msg;
    }
}
