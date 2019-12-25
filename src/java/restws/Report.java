/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ning
 */
@Entity
@Table(name = "REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r")
    , @NamedQuery(name = "Report.findByReportId", query = "SELECT r FROM Report r WHERE r.reportId = :reportId")
    , @NamedQuery(name = "Report.findByReportDate", query = "SELECT r FROM Report r WHERE r.reportDate = :reportDate")
    , @NamedQuery(name = "Report.findByCaloriesConsumed", query = "SELECT r FROM Report r WHERE r.caloriesConsumed = :caloriesConsumed")
    , @NamedQuery(name = "Report.findByCaloriesBurned", query = "SELECT r FROM Report r WHERE r.caloriesBurned = :caloriesBurned")
    , @NamedQuery(name = "Report.findByStepsTaken", query = "SELECT r FROM Report r WHERE r.stepsTaken = :stepsTaken")
    , @NamedQuery(name = "Report.findByCalorieGoal", query = "SELECT r FROM Report r WHERE r.calorieGoal = :calorieGoal")
    , @NamedQuery(name = "Report.findByUserId", query = "SELECT r FROM Report r WHERE r.userId.userId = :userId")
    , @NamedQuery(name = "Report.findByEmailAndDate", query = "SELECT r FROM Report r WHERE r.userId.email = :email and r.reportDate = :reportDate")
    ,@NamedQuery(name = "Report.findByUserIdAndDate", query = "SELECT r FROM Report r WHERE r.userId.userId = :userId and r.reportDate = :reportDate")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "REPORT_ID")
    private String reportId;
    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.DATE)
    private Date reportDate;
    @Column(name = "CALORIES_CONSUMED")
    private Double caloriesConsumed;
    @Column(name = "CALORIES_BURNED")
    private Double caloriesBurned;
    @Column(name = "STEPS_TAKEN")
    private Integer stepsTaken;
    @Column(name = "CALORIE_GOAL")
    private Double calorieGoal;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private AppUser userId;

    public Report() {
    }

    public Report(String reportId) {
        this.reportId = reportId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Double getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(Double caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public Double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Integer getStepsTaken() {
        return stepsTaken;
    }

    public void setStepsTaken(Integer stepsTaken) {
        this.stepsTaken = stepsTaken;
    }

    public Double getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(Double calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public AppUser getUserId() {
        return userId;
    }

    public void setUserId(AppUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restws.Report[ reportId=" + reportId + " ]";
    }

}
