package website;

import java.util.Comparator;

/**
 *
 * @author ${user}
 */
public class sortByURL implements Comparator{

    public sortByURL(){}

    public int compare(Object t, Object t1) {
        WebSite website1 = (WebSite)t, website2 = (WebSite)t1;
        return website1.getUrl().compareTo(website2.getUrl());
    }

}
