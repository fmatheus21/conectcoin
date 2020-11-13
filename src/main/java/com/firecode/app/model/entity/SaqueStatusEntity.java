/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "saque_status", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"color"}),
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"status"})})
@NamedQueries({
    @NamedQuery(name = "SaqueStatusEntity.findAll", query = "SELECT s FROM SaqueStatusEntity s"),
    @NamedQuery(name = "SaqueStatusEntity.findById", query = "SELECT s FROM SaqueStatusEntity s WHERE s.id = :id"),
    @NamedQuery(name = "SaqueStatusEntity.findByStatus", query = "SELECT s FROM SaqueStatusEntity s WHERE s.status = :status"),
    @NamedQuery(name = "SaqueStatusEntity.findByColor", query = "SELECT s FROM SaqueStatusEntity s WHERE s.color = :color")})
public class SaqueStatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status", nullable = false, length = 45)
    private String status;
    @Basic(optional = false)
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private Collection<SaqueEntity> saqueEntityCollection;

    public SaqueStatusEntity() {
    }

    public SaqueStatusEntity(Integer id) {
        this.id = id;
    }

    public SaqueStatusEntity(Integer id, String status, String color) {
        this.id = id;
        this.status = status;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Collection<SaqueEntity> getSaqueEntityCollection() {
        return saqueEntityCollection;
    }

    public void setSaqueEntityCollection(Collection<SaqueEntity> saqueEntityCollection) {
        this.saqueEntityCollection = saqueEntityCollection;
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
        if (!(object instanceof SaqueStatusEntity)) {
            return false;
        }
        SaqueStatusEntity other = (SaqueStatusEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SaqueStatusEntity[ id=" + id + " ]";
    }
    
}
