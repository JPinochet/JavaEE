/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webrecDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrator
 */
@Embeddable
public class RatingsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "website_id")
    private int websiteId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;

    public RatingsPK() {
    }

    public RatingsPK(int websiteId, int userId) {
        this.websiteId = websiteId;
        this.userId = userId;
    }

    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) websiteId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingsPK)) {
            return false;
        }
        RatingsPK other = (RatingsPK) object;
        if (this.websiteId != other.websiteId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webrecDB.RatingsPK[websiteId=" + websiteId + ", userId=" + userId + "]";
    }

}
