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
@Table(name = "test_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestScore.findAll", query = "SELECT t FROM TestScore t")
    , @NamedQuery(name = "TestScore.findById", query = "SELECT t FROM TestScore t WHERE t.id = :id")
    , @NamedQuery(name = "TestScore.findByScore", query = "SELECT t FROM TestScore t WHERE t.score = :score")
    , @NamedQuery(name = "TestScore.findByType", query = "SELECT t FROM TestScore t WHERE t.type = :type")
    , @NamedQuery(name = "TestScore.findByStartDate", query = "SELECT t FROM TestScore t WHERE t.startDate = :startDate")
    , @NamedQuery(name = "TestScore.findByEndDate", query = "SELECT t FROM TestScore t WHERE t.endDate = :endDate")
    , @NamedQuery(name = "TestScore.findByStartTest", query = "SELECT t FROM TestScore t WHERE t.startTest = :startTest")
    , @NamedQuery(name = "TestScore.findByStatus", query = "SELECT t FROM TestScore t WHERE t.status = :status")})
public class TestScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "score")
    private String score;
    @Size(max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "start_test")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTest;
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

    public TestScore() {
    }

    public TestScore(Integer id) {
        this.id = id;
    }

    public TestScore(Integer id, Date startDate, Date endDate, int status) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTest() {
        return startTest;
    }

    public void setStartTest(Date startTest) {
        this.startTest = startTest;
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
        if (!(object instanceof TestScore)) {
            return false;
        }
        TestScore other = (TestScore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.TestScore[ id=" + id + " ]";
    }
    
}
