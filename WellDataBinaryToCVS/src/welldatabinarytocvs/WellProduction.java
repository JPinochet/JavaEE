/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package welldatabinarytocvs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "well_production", catalog = "pinochet_mysql", schema = "")
@NamedQueries({
    @NamedQuery(name = "WellProduction.findAll", query = "SELECT w FROM WellProduction w"),
    @NamedQuery(name = "WellProduction.findByWellId", query = "SELECT w FROM WellProduction w WHERE w.wellId = :wellId"),
    @NamedQuery(name = "WellProduction.findByLocation", query = "SELECT w FROM WellProduction w WHERE w.location = :location"),
    @NamedQuery(name = "WellProduction.findByDate", query = "SELECT w FROM WellProduction w WHERE w.date = :date"),
    @NamedQuery(name = "WellProduction.findByOilProduction", query = "SELECT w FROM WellProduction w WHERE w.oilProduction = :oilProduction"),
    @NamedQuery(name = "WellProduction.findByWaterProduction", query = "SELECT w FROM WellProduction w WHERE w.waterProduction = :waterProduction"),
    @NamedQuery(name = "WellProduction.findByGasProduction", query = "SELECT w FROM WellProduction w WHERE w.gasProduction = :gasProduction")})
public class WellProduction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "well_id")
    private Integer wellId;
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "oilProduction")
    private Double oilProduction;
    @Column(name = "waterProduction")
    private Double waterProduction;
    @Column(name = "gasProduction")
    private Double gasProduction;

    public WellProduction() {
    }

    public WellProduction(Integer wellId) {
        this.wellId = wellId;
    }

    public WellProduction(Integer wellId, String location, Date date, Double oilProduction, Double waterProduction, Double gasProduction) {
        this.wellId = wellId;
        this.location = location;
        this.date = date;
        this.oilProduction = oilProduction;
        this.waterProduction = waterProduction;
        this.gasProduction = gasProduction;
    }

    public Integer getWellId() {
        return wellId;
    }

    public void setWellId(Integer wellId) {
        this.wellId = wellId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getOilProduction() {
        return oilProduction;
    }

    public void setOilProduction(Double oilProduction) {
        this.oilProduction = oilProduction;
    }

    public Double getWaterProduction() {
        return waterProduction;
    }

    public void setWaterProduction(Double waterProduction) {
        this.waterProduction = waterProduction;
    }

    public Double getGasProduction() {
        return gasProduction;
    }

    public void setGasProduction(Double gasProduction) {
        this.gasProduction = gasProduction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wellId != null ? wellId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WellProduction)) {
            return false;
        }
        WellProduction other = (WellProduction) object;
        if ((this.wellId == null && other.wellId != null) || (this.wellId != null && !this.wellId.equals(other.wellId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "welldatabinarytocvs.WellProduction[wellId=" + wellId + "]";
    }

}
