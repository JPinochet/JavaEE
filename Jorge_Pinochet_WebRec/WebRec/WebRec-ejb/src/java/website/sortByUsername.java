package website;

import java.util.Comparator;

/**
 *
 * @author ${user}
 */
public class sortByUsername implements Comparator{

    public sortByUsername(){}

    public int compare(Object t, Object t1) {
        WebSite website1 = (WebSite)t, website2 = (WebSite)t1;
        return website1.getCreator().compareTo(website2.getCreator());
    }

}
