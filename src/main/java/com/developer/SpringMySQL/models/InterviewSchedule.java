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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rizky
 */
@Entity
@Table(name = "interview_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterviewSchedule.findAll", query = "SELECT i FROM InterviewSchedule i")
    , @NamedQuery(name = "InterviewSchedule.findById", query = "SELECT i FROM InterviewSchedule i WHERE i.id = :id")
    , @NamedQuery(name = "InterviewSchedule.findByDate", query = "SELECT i FROM InterviewSchedule i WHERE i.date = :date")
    , @NamedQuery(name = "InterviewSchedule.findByStatus", query = "SELECT i FROM InterviewSchedule i WHERE i.status = :status")})
public class InterviewSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Candidate candidate;
    @JoinColumn(name = "process_status", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProcessStatus processStatus;

    public InterviewSchedule() {
    }

    public InterviewSchedule(Integer id) {
        this.id = id;
    }

    public InterviewSchedule(Integer id, Date date, int status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
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
        if (!(object instanceof InterviewSchedule)) {
            return false;
        }
        InterviewSchedule other = (InterviewSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.InterviewSchedule[ id=" + id + " ]";
    }
    
}
