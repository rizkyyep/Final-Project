/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Rizky
 */
@Entity
@Table(name = "family")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Family.findAll", query = "SELECT f FROM Family f")
    , @NamedQuery(name = "Family.findById", query = "SELECT f FROM Family f WHERE f.id = :id")
    , @NamedQuery(name = "Family.findByName", query = "SELECT f FROM Family f WHERE f.name = :name")
    , @NamedQuery(name = "Family.findByGender", query = "SELECT f FROM Family f WHERE f.gender = :gender")
    , @NamedQuery(name = "Family.findByPlaceOfBirth", query = "SELECT f FROM Family f WHERE f.placeOfBirth = :placeOfBirth")
    , @NamedQuery(name = "Family.findByDateOfBirth", query = "SELECT f FROM Family f WHERE f.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Family.findByLastEducation", query = "SELECT f FROM Family f WHERE f.lastEducation = :lastEducation")
    , @NamedQuery(name = "Family.findByJob", query = "SELECT f FROM Family f WHERE f.job = :job")
    , @NamedQuery(name = "Family.findByStatus", query = "SELECT f FROM Family f WHERE f.status = :status")
    , @NamedQuery(name = "Family.findBySalary", query = "SELECT f FROM Family f WHERE f.salary = :salary")})
public class Family implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "last_education")
    private String lastEducation;
    @Size(max = 50)
    @Column(name = "job")
    private String job;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Column(name = "salary")
    private Integer salary;
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Candidate candidate;

    public Family() {
    }

    public Family(Integer id) {
        this.id = id;
    }

    public Family(Integer id, String name, String gender, String placeOfBirth, Date dateOfBirth, String lastEducation, int status) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.lastEducation = lastEducation;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastEducation() {
        return lastEducation;
    }

    public void setLastEducation(String lastEducation) {
        this.lastEducation = lastEducation;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Family)) {
            return false;
        }
        Family other = (Family) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.Family[ id=" + id + " ]";
    }
    
}
