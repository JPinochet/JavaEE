/* * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webSite;

/**
 *
 * @author Administrator
 */
public class WebSite implements java.util.Comparator{
    int id;
    String url = "";
    int creator;
    String description = "";
    int rating;

    public WebSite() {
    }

    public WebSite(int id)
    {
        this.id = id;
    }

    public WebSite(int id, String url, int creator, String description, int rating) {
        this.id = id;
        this.url = url;
        this.creator = creator;
        this.description = description;
        this.rating = rating;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int compare(Object website1, Object website2)
    {
        WebSite webSite1 = (WebSite) website1;
        WebSite webSite2 = (WebSite) website2;

        return webSite2.getRating() - webSite1.getRating();//(webSite1.getRating() - webSite2.getRating());
    }
}
