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
@Table(name = "investimento_status", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"status"})})
@NamedQueries({
    @NamedQuery(name = "InvestimentoStatusEntity.findAll", query = "SELECT i FROM InvestimentoStatusEntity i"),
    @NamedQuery(name = "InvestimentoStatusEntity.findById", query = "SELECT i FROM InvestimentoStatusEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InvestimentoStatusEntity.findByStatus", query = "SELECT i FROM InvestimentoStatusEntity i WHERE i.status = :status"),
    @NamedQuery(name = "InvestimentoStatusEntity.findByColor", query = "SELECT i FROM InvestimentoStatusEntity i WHERE i.color = :color")})
public class InvestimentoStatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status", nullable = false, length = 20)
    private String status;
    @Basic(optional = false)
    @Column(name = "color", nullable = false, length = 10)
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private Collection<InvestimentoEntity> investimentoEntityCollection;

    public InvestimentoStatusEntity() {
    }

    public InvestimentoStatusEntity(Integer id) {
        this.id = id;
    }

    public InvestimentoStatusEntity(Integer id, String status, String color) {
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

    public Collection<InvestimentoEntity> getInvestimentoEntityCollection() {
        return investimentoEntityCollection;
    }

    public void setInvestimentoEntityCollection(Collection<InvestimentoEntity> investimentoEntityCollection) {
        this.investimentoEntityCollection = investimentoEntityCollection;
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
        if (!(object instanceof InvestimentoStatusEntity)) {
            return false;
        }
        InvestimentoStatusEntity other = (InvestimentoStatusEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestimentoStatusEntity[ id=" + id + " ]";
    }
    
}
