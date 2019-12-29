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
@Table(name = "training")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t")
    , @NamedQuery(name = "Training.findById", query = "SELECT t FROM Training t WHERE t.id = :id")
    , @NamedQuery(name = "Training.findByInstitute", query = "SELECT t FROM Training t WHERE t.institute = :institute")
    , @NamedQuery(name = "Training.findByDate", query = "SELECT t FROM Training t WHERE t.date = :date")
    , @NamedQuery(name = "Training.findByCertificate", query = "SELECT t FROM Training t WHERE t.certificate = :certificate")
    , @NamedQuery(name = "Training.findByScore", query = "SELECT t FROM Training t WHERE t.score = :score")})
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "institute")
    private String institute;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "name_of_training")
    private String nameOfTraining;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "certificate")
    private String certificate;
    @Size(max = 10)
    @Column(name = "score")
    private String score;
    @JoinColumn(name = "candidate", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Candidate candidate;

    public Training() {
    }

    public Training(Integer id) {
        this.id = id;
    }

    public Training(Integer id, String institute, String nameOfTraining, Date date, String certificate) {
        this.id = id;
        this.institute = institute;
        this.nameOfTraining = nameOfTraining;
        this.date = date;
        this.certificate = certificate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getNameOfTraining() {
        return nameOfTraining;
    }

    public void setNameOfTraining(String nameOfTraining) {
        this.nameOfTraining = nameOfTraining;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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
        if (!(object instanceof Training)) {
            return false;
        }
        Training other = (Training) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.Training[ id=" + id + " ]";
    }
    
}
