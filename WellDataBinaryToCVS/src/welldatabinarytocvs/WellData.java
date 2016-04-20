/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package welldatabinarytocvs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "well_data", catalog = "pinochet_mysql", schema = "")
@NamedQueries({
    @NamedQuery(name = "WellData.findAll", query = "SELECT w FROM WellData w"),
    @NamedQuery(name = "WellData.findByWellId", query = "SELECT w FROM WellData w WHERE w.wellId = :wellId"),
    @NamedQuery(name = "WellData.findByLocation", query = "SELECT w FROM WellData w WHERE w.location = :location"),
    @NamedQuery(name = "WellData.findByDepth", query = "SELECT w FROM WellData w WHERE w.depth = :depth"),
    @NamedQuery(name = "WellData.findByPerforationDepth", query = "SELECT w FROM WellData w WHERE w.perforationDepth = :perforationDepth"),
    @NamedQuery(name = "WellData.findByPerforationZone", query = "SELECT w FROM WellData w WHERE w.perforationZone = :perforationZone"),
    @NamedQuery(name = "WellData.findByPumpStrokeLength", query = "SELECT w FROM WellData w WHERE w.pumpStrokeLength = :pumpStrokeLength"),
    @NamedQuery(name = "WellData.findByPumpStrokesPerMinute", query = "SELECT w FROM WellData w WHERE w.pumpStrokesPerMinute = :pumpStrokesPerMinute")})
public class WellData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "well_id")
    private Integer wellId;
    @Column(name = "location")
    private String location;
    @Column(name = "depth")
    private Double depth;
    @Column(name = "perforationDepth")
    private Double perforationDepth;
    @Column(name = "perforationZone")
    private Double perforationZone;
    @Column(name = "pumpStrokeLength")
    private Double pumpStrokeLength;
    @Column(name = "pumpStrokesPerMinute")
    private Integer pumpStrokesPerMinute;

    public WellData() {
    }

    public WellData(Integer wellId) {
        this.wellId = wellId;
    }

    public WellData(Integer wellId, String location, Double depth, Double perforationDepth, Double perforationZone, Double pumpStrokeLength, Integer pumpStrokesPerMinute) {
        this.wellId = wellId;
        this.location = location;
        this.depth = depth;
        this.perforationDepth = perforationDepth;
        this.perforationZone = perforationZone;
        this.pumpStrokeLength = pumpStrokeLength;
        this.pumpStrokesPerMinute = pumpStrokesPerMinute;
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

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getPerforationDepth() {
        return perforationDepth;
    }

    public void setPerforationDepth(Double perforationDepth) {
        this.perforationDepth = perforationDepth;
    }

    public Double getPerforationZone() {
        return perforationZone;
    }

    public void setPerforationZone(Double perforationZone) {
        this.perforationZone = perforationZone;
    }

    public Double getPumpStrokeLength() {
        return pumpStrokeLength;
    }

    public void setPumpStrokeLength(Double pumpStrokeLength) {
        this.pumpStrokeLength = pumpStrokeLength;
    }

    public Integer getPumpStrokesPerMinute() {
        return pumpStrokesPerMinute;
    }

    public void setPumpStrokesPerMinute(Integer pumpStrokesPerMinute) {
        this.pumpStrokesPerMinute = pumpStrokesPerMinute;
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
        if (!(object instanceof WellData)) {
            return false;
        }
        WellData other = (WellData) object;
        if ((this.wellId == null && other.wellId != null) || (this.wellId != null && !this.wellId.equals(other.wellId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "welldatabinarytocvs.WellData[wellId=" + wellId + "]";
    }

}
