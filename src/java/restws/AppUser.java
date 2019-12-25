/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ning
 */
@Entity
@Table(name = "APP_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a")
    , @NamedQuery(name = "AppUser.findByUserId", query = "SELECT a FROM AppUser a WHERE a.userId = :userId")
    , @NamedQuery(name = "AppUser.findByFirstname", query = "SELECT a FROM AppUser a WHERE a.firstname = :firstname")
    , @NamedQuery(name = "AppUser.findBySurname", query = "SELECT a FROM AppUser a WHERE a.surname = :surname")
    , @NamedQuery(name = "AppUser.findByEmail", query = "SELECT a FROM AppUser a WHERE a.email = :email")
    , @NamedQuery(name = "AppUser.findByDateOfBirth", query = "SELECT a FROM AppUser a WHERE a.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "AppUser.findByHeight", query = "SELECT a FROM AppUser a WHERE a.height = :height")
    , @NamedQuery(name = "AppUser.findByWeight", query = "SELECT a FROM AppUser a WHERE a.weight = :weight")
    , @NamedQuery(name = "AppUser.findByGender", query = "SELECT a FROM AppUser a WHERE a.gender = :gender")
    , @NamedQuery(name = "AppUser.findByAddress", query = "SELECT a FROM AppUser a WHERE a.address = :address")
    , @NamedQuery(name = "AppUser.findByPostcode", query = "SELECT a FROM AppUser a WHERE a.postcode = :postcode")
    , @NamedQuery(name = "AppUser.findByLevelOfActivity", query = "SELECT a FROM AppUser a WHERE a.levelOfActivity = :levelOfActivity")
    , @NamedQuery(name = "AppUser.findByStepsPerMile", query = "SELECT a FROM AppUser a WHERE a.stepsPerMile = :stepsPerMile")})
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USER_ID")
    private String userId;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "SURNAME")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HEIGHT")
    private Double height;
    @Column(name = "WEIGHT")
    private Double weight;
    @Size(max = 50)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 500)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "POSTCODE")
    private String postcode;
    @Column(name = "LEVEL_OF_ACTIVITY")
    private Integer levelOfActivity;
    @Column(name = "STEPS_PER_MILE")
    private Integer stepsPerMile;
    @OneToMany(mappedBy = "userId")
    private Collection<Credential> credentialCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Report> reportCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<Consumption> consumptionCollection;

    public AppUser() {
    }

    public AppUser(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getLevelOfActivity() {
        return levelOfActivity;
    }

    public void setLevelOfActivity(Integer levelOfActivity) {
        this.levelOfActivity = levelOfActivity;
    }

    public Integer getStepsPerMile() {
        return stepsPerMile;
    }

    public void setStepsPerMile(Integer stepsPerMile) {
        this.stepsPerMile = stepsPerMile;
    }

    @XmlTransient
    public Collection<Credential> getCredentialCollection() {
        return credentialCollection;
    }

    public void setCredentialCollection(Collection<Credential> credentialCollection) {
        this.credentialCollection = credentialCollection;
    }

    @XmlTransient
    public Collection<Report> getReportCollection() {
        return reportCollection;
    }

    public void setReportCollection(Collection<Report> reportCollection) {
        this.reportCollection = reportCollection;
    }

    @XmlTransient
    public Collection<Consumption> getConsumptionCollection() {
        return consumptionCollection;
    }

    public void setConsumptionCollection(Collection<Consumption> consumptionCollection) {
        this.consumptionCollection = consumptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restws.AppUser[ userId=" + userId + " ]";
    }
    
}
