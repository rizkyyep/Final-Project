/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.models;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rizky
 */
@Entity
@Table(name = "process_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessStatus.findAll", query = "SELECT p FROM ProcessStatus p")
    , @NamedQuery(name = "ProcessStatus.findById", query = "SELECT p FROM ProcessStatus p WHERE p.id = :id")
    , @NamedQuery(name = "ProcessStatus.findByStatus", query = "SELECT p FROM ProcessStatus p WHERE p.status = :status")})
public class ProcessStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processStatus")
    private List<TestScore> testScoreList;
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Candidate candidate;
    @JoinColumn(name = "vacancy", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vacancy vacancy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processStatus")
    private List<InterviewSchedule> interviewScheduleList;

    public ProcessStatus() {
    }

    public ProcessStatus(Integer id) {
        this.id = id;
    }

    public ProcessStatus(Integer id, int status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<TestScore> getTestScoreList() {
        return testScoreList;
    }

    public void setTestScoreList(List<TestScore> testScoreList) {
        this.testScoreList = testScoreList;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    @XmlTransient
    public List<InterviewSchedule> getInterviewScheduleList() {
        return interviewScheduleList;
    }

    public void setInterviewScheduleList(List<InterviewSchedule> interviewScheduleList) {
        this.interviewScheduleList = interviewScheduleList;
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
        if (!(object instanceof ProcessStatus)) {
            return false;
        }
        ProcessStatus other = (ProcessStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.ProcessStatus[ id=" + id + " ]";
    }
    
}
