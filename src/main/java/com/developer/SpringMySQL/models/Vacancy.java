/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author Rizky
 */
@Entity
@Table(name = "vacancy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacancy.findAll", query = "SELECT v FROM Vacancy v")
    , @NamedQuery(name = "Vacancy.findById", query = "SELECT v FROM Vacancy v WHERE v.id = :id")
    , @NamedQuery(name = "Vacancy.findByCompany", query = "SELECT v FROM Vacancy v WHERE v.company = :company")
    , @NamedQuery(name = "Vacancy.findByStatus", query = "SELECT v FROM Vacancy v WHERE v.status = :status")
    , @NamedQuery(name = "Vacancy.findByExpired", query = "SELECT v FROM Vacancy v WHERE v.expired = :expired")})
public class Vacancy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expired")
    @Temporal(TemporalType.DATE)
    private Date expired;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacancy")
    private List<ProcessStatus> processStatusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacancy")
    private List<Ptkp> ptkpList;
    @JoinColumn(name = "jobs", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Jobs jobs;

    public Vacancy() {
    }

    public Vacancy(Integer id) {
        this.id = id;
    }

    public Vacancy(Integer id, String company, String description, int status, Date expired) {
        this.id = id;
        this.company = company;
        this.description = description;
        this.status = status;
        this.expired = expired;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    @XmlTransient
    public List<ProcessStatus> getProcessStatusList() {
        return processStatusList;
    }

    public void setProcessStatusList(List<ProcessStatus> processStatusList) {
        this.processStatusList = processStatusList;
    }

    @XmlTransient
    public List<Ptkp> getPtkpList() {
        return ptkpList;
    }

    public void setPtkpList(List<Ptkp> ptkpList) {
        this.ptkpList = ptkpList;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
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
        if (!(object instanceof Vacancy)) {
            return false;
        }
        Vacancy other = (Vacancy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.Vacancy[ id=" + id + " ]";
    }
    
}
