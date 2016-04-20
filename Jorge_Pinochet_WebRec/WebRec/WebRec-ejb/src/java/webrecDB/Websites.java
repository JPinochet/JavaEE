/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webrecDB;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "websites", catalog = "webrecdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Websites.findAll", query = "SELECT w FROM Websites w"),
    @NamedQuery(name = "Websites.findByWebsiteId", query = "SELECT w FROM Websites w WHERE w.websiteId = :websiteId"),
    @NamedQuery(name = "Websites.findByUrl", query = "SELECT w FROM Websites w WHERE w.url = :url"),
    @NamedQuery(name = "Websites.findByDescription", query = "SELECT w FROM Websites w WHERE w.description = :description")})
public class Websites implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "website_id")
    private Integer websiteId;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "creator", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Users creator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "websites")
    private List<Ratings> ratingsList;

    public Websites() {
    }

    public Websites(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public Websites(Integer websiteId, String url) {
        this.websiteId = websiteId;
        this.url = url;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getCreator() {
        return creator;
    }

    public void setCreator(Users creator) {
        this.creator = creator;
    }

    public List<Ratings> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Ratings> ratingsList) {
        this.ratingsList = ratingsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (websiteId != null ? websiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Websites)) {
            return false;
        }
        Websites other = (Websites) object;
        if ((this.websiteId == null && other.websiteId != null) || (this.websiteId != null && !this.websiteId.equals(other.websiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webrecDB.Websites[websiteId=" + websiteId + "]";
    }

}
