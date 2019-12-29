/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.SpringMySQL.models;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rizky
 */
@Entity
@Table(name = "bpjs_kes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BpjsKes.findAll", query = "SELECT b FROM BpjsKes b")
    , @NamedQuery(name = "BpjsKes.findById", query = "SELECT b FROM BpjsKes b WHERE b.id = :id")
    , @NamedQuery(name = "BpjsKes.findByIdClinic", query = "SELECT b FROM BpjsKes b WHERE b.idClinic = :idClinic")
    , @NamedQuery(name = "BpjsKes.findByIdDoktergigi", query = "SELECT b FROM BpjsKes b WHERE b.idDoktergigi = :idDoktergigi")})
public class BpjsKes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_clinic")
    private int idClinic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_doktergigi")
    private int idDoktergigi;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employee;

    public BpjsKes() {
    }

    public BpjsKes(Integer id) {
        this.id = id;
    }

    public BpjsKes(Integer id, int idClinic, int idDoktergigi) {
        this.id = id;
        this.idClinic = idClinic;
        this.idDoktergigi = idDoktergigi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(int idClinic) {
        this.idClinic = idClinic;
    }

    public int getIdDoktergigi() {
        return idDoktergigi;
    }

    public void setIdDoktergigi(int idDoktergigi) {
        this.idDoktergigi = idDoktergigi;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof BpjsKes)) {
            return false;
        }
        BpjsKes other = (BpjsKes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.BpjsKes[ id=" + id + " ]";
    }
    
}
