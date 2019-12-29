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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rizky
 */
@Entity
@Table(name = "upload_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UploadFile.findAll", query = "SELECT u FROM UploadFile u")
    , @NamedQuery(name = "UploadFile.findById", query = "SELECT u FROM UploadFile u WHERE u.id = :id")
    , @NamedQuery(name = "UploadFile.findByKtp", query = "SELECT u FROM UploadFile u WHERE u.ktp = :ktp")
    , @NamedQuery(name = "UploadFile.findByNpwp", query = "SELECT u FROM UploadFile u WHERE u.npwp = :npwp")
    , @NamedQuery(name = "UploadFile.findByBankAccount", query = "SELECT u FROM UploadFile u WHERE u.bankAccount = :bankAccount")
    , @NamedQuery(name = "UploadFile.findByTaxAgreement", query = "SELECT u FROM UploadFile u WHERE u.taxAgreement = :taxAgreement")
    , @NamedQuery(name = "UploadFile.findByJamsostek", query = "SELECT u FROM UploadFile u WHERE u.jamsostek = :jamsostek")
    , @NamedQuery(name = "UploadFile.findByIjazah", query = "SELECT u FROM UploadFile u WHERE u.ijazah = :ijazah")
    , @NamedQuery(name = "UploadFile.findByTranskrip", query = "SELECT u FROM UploadFile u WHERE u.transkrip = :transkrip")
    , @NamedQuery(name = "UploadFile.findByCertificate", query = "SELECT u FROM UploadFile u WHERE u.certificate = :certificate")
    , @NamedQuery(name = "UploadFile.findBySkck", query = "SELECT u FROM UploadFile u WHERE u.skck = :skck")
    , @NamedQuery(name = "UploadFile.findByDomisili", query = "SELECT u FROM UploadFile u WHERE u.domisili = :domisili")
    , @NamedQuery(name = "UploadFile.findBySuratSehat", query = "SELECT u FROM UploadFile u WHERE u.suratSehat = :suratSehat")
    , @NamedQuery(name = "UploadFile.findByKk", query = "SELECT u FROM UploadFile u WHERE u.kk = :kk")
    , @NamedQuery(name = "UploadFile.findByTicket", query = "SELECT u FROM UploadFile u WHERE u.ticket = :ticket")})
public class UploadFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "ktp")
    private String ktp;
    @Size(max = 100)
    @Column(name = "npwp")
    private String npwp;
    @Size(max = 100)
    @Column(name = "bank_account")
    private String bankAccount;
    @Size(max = 100)
    @Column(name = "tax_agreement")
    private String taxAgreement;
    @Size(max = 100)
    @Column(name = "jamsostek")
    private String jamsostek;
    @Size(max = 100)
    @Column(name = "ijazah")
    private String ijazah;
    @Size(max = 100)
    @Column(name = "transkrip")
    private String transkrip;
    @Size(max = 100)
    @Column(name = "certificate")
    private String certificate;
    @Size(max = 100)
    @Column(name = "skck")
    private String skck;
    @Size(max = 100)
    @Column(name = "domisili")
    private String domisili;
    @Size(max = 100)
    @Column(name = "surat_sehat")
    private String suratSehat;
    @Size(max = 100)
    @Column(name = "kk")
    private String kk;
    @Size(max = 100)
    @Column(name = "ticket")
    private String ticket;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employee;

    public UploadFile() {
    }

    public UploadFile(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getTaxAgreement() {
        return taxAgreement;
    }

    public void setTaxAgreement(String taxAgreement) {
        this.taxAgreement = taxAgreement;
    }

    public String getJamsostek() {
        return jamsostek;
    }

    public void setJamsostek(String jamsostek) {
        this.jamsostek = jamsostek;
    }

    public String getIjazah() {
        return ijazah;
    }

    public void setIjazah(String ijazah) {
        this.ijazah = ijazah;
    }

    public String getTranskrip() {
        return transkrip;
    }

    public void setTranskrip(String transkrip) {
        this.transkrip = transkrip;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getSkck() {
        return skck;
    }

    public void setSkck(String skck) {
        this.skck = skck;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

    public String getSuratSehat() {
        return suratSehat;
    }

    public void setSuratSehat(String suratSehat) {
        this.suratSehat = suratSehat;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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
        if (!(object instanceof UploadFile)) {
            return false;
        }
        UploadFile other = (UploadFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.developer.SpringMySQL.models.UploadFile[ id=" + id + " ]";
    }
    
}
