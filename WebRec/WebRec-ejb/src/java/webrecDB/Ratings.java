/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webrecDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "ratings", catalog = "webrecdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ratings.findAll", query = "SELECT r FROM Ratings r"),
    @NamedQuery(name = "Ratings.findByWebsiteId", query = "SELECT r FROM Ratings r WHERE r.ratingsPK.websiteId = :websiteId"),
    @NamedQuery(name = "Ratings.findByUserId", query = "SELECT r FROM Ratings r WHERE r.ratingsPK.userId = :userId"),
    @NamedQuery(name = "Ratings.findByRating", query = "SELECT r FROM Ratings r WHERE r.rating = :rating")})
public class Ratings implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RatingsPK ratingsPK;
    @Basic(optional = false)
    @Column(name = "rating")
    private int rating;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "website_id", referencedColumnName = "website_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Websites websites;

    public Ratings() {
    }

    public Ratings(RatingsPK ratingsPK) {
        this.ratingsPK = ratingsPK;
    }

    public Ratings(RatingsPK ratingsPK, int rating) {
        this.ratingsPK = ratingsPK;
        this.rating = rating;
    }

    public Ratings(int websiteId, int userId) {
        this.ratingsPK = new RatingsPK(websiteId, userId);
    }

    public RatingsPK getRatingsPK() {
        return ratingsPK;
    }

    public void setRatingsPK(RatingsPK ratingsPK) {
        this.ratingsPK = ratingsPK;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Websites getWebsites() {
        return websites;
    }

    public void setWebsites(Websites websites) {
        this.websites = websites;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingsPK != null ? ratingsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        if ((this.ratingsPK == null && other.ratingsPK != null) || (this.ratingsPK != null && !this.ratingsPK.equals(other.ratingsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webrecDB.Ratings[ratingsPK=" + ratingsPK + "]";
    }

}
