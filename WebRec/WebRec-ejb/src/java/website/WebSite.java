/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package website;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class WebSite implements Comparable, Serializable{

    private static final long serialVersionUID = 3894893283290489320L;

    int id;
    String url;
    String creator;
    String description;
    int rating;

    public WebSite() {
    }

    public WebSite(int id) {
        this.id = id;
    }

    public WebSite(int id, String url, String creator, String description, int rating) {
        this.id = id;
        this.url = url;
        this.creator = creator;
        this.description = description;
        this.rating = rating;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int compareTo(Object t) {
        WebSite website = (WebSite)t;
        return website.getRating() - this.getRating() ;
    }

}
