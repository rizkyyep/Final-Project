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
import javax.persistence.Lob;
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
@Table(name = "working_exp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkingExp.findAll", query = "SELECT w FROM WorkingExp w")
    , @NamedQuery(name = "WorkingExp.findById", query = "SELECT w FROM WorkingExp w WHERE w.id = :id")
    , @NamedQuery(name = "WorkingExp.findByCompany", query = "SELECT w FROM WorkingExp w WHERE w.company = :company")
    , @NamedQuery(name = "WorkingExp.findByPosition", query = "SELECT w FROM WorkingExp w WHERE w.position = :position")
    , @NamedQuery(name = "WorkingExp.findByStart", query = "SELECT w FROM WorkingExp w WHERE w.start = :start")
    , @NamedQuery(name = "WorkingExp.findByEnd", query = "SELECT w FROM WorkingExp w WHERE w.end = :end")
    , @NamedQuery(name = "WorkingExp.findBySalary", query = "SELECT w FROM WorkingExp w WHERE w.salary = :salary")})
public class WorkingExp implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end")
    @Temporal(TemporalType.DATE)
    private Date end;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "job_desc")
    private String jobDesc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "project_history")
    private String projectHistory;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "reason_to_leave")
    private String reasonToLeave;
    @Column(name = "salary")
    private Integer salary;
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Candidate candidate;

    public WorkingExp() {
    }

    public WorkingExp(Integer id) {
        this.id = id;
    }

    public WorkingExp(Integer id, String company, String position, Date start, Date end, String address, String jobDesc, String projectHistory, String reasonToLeave) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.start = start;
        this.end = end;
        this.address = address;
        this.jobDesc = jobDesc;
        this.projectHistory = projectHistory;
        this.reasonToLeave = reasonToLeave;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getProjectHistory() {
        return projectHistory;
    }

    public void setProjectHistory(String projectHistory) {
        this.projectHistory = projectHistory;
    }

    public String getReasonToLeave() {
        return reasonToLeave;
    }

    public void setReasonToLeave(String reasonToLeave) {
        this.reasonToLeave = reasonToLeave;
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
        if (!(object instanceof WorkingExp)) {
            return false;
        }
        WorkingExp other = (WorkingExp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.WorkingExp[ id=" + id + " ]";
    }
    
}
