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
@Table(name = "equipe", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "EquipeEntity.findAll", query = "SELECT e FROM EquipeEntity e"),
    @NamedQuery(name = "EquipeEntity.findById", query = "SELECT e FROM EquipeEntity e WHERE e.id = :id"),
    @NamedQuery(name = "EquipeEntity.findByEquipe", query = "SELECT e FROM EquipeEntity e WHERE e.equipe = :equipe"),
    @NamedQuery(name = "EquipeEntity.findByColor", query = "SELECT e FROM EquipeEntity e WHERE e.color = :color")})
public class EquipeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "equipe", nullable = false, length = 10)
    private String equipe;
    @Basic(optional = false)
    @Column(name = "color", nullable = false, length = 10)
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipe")
    private Collection<IndicadoEntity> indicadoEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipe")
    private Collection<InvestimentoConfigEntity> investimentoConfigEntityCollection;

    public EquipeEntity() {
    }

    public EquipeEntity(Integer id) {
        this.id = id;
    }

    public EquipeEntity(Integer id, String equipe, String color) {
        this.id = id;
        this.equipe = equipe;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Collection<IndicadoEntity> getIndicadoEntityCollection() {
        return indicadoEntityCollection;
    }

    public void setIndicadoEntityCollection(Collection<IndicadoEntity> indicadoEntityCollection) {
        this.indicadoEntityCollection = indicadoEntityCollection;
    }

    public Collection<InvestimentoConfigEntity> getInvestimentoConfigEntityCollection() {
        return investimentoConfigEntityCollection;
    }

    public void setInvestimentoConfigEntityCollection(Collection<InvestimentoConfigEntity> investimentoConfigEntityCollection) {
        this.investimentoConfigEntityCollection = investimentoConfigEntityCollection;
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
        if (!(object instanceof EquipeEntity)) {
            return false;
        }
        EquipeEntity other = (EquipeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.EquipeEntity[ id=" + id + " ]";
    }
    
}
