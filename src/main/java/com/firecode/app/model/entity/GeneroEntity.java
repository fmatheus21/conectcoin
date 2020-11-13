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
@Table(name = "genero", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"nome"})})
@NamedQueries({
    @NamedQuery(name = "GeneroEntity.findAll", query = "SELECT g FROM GeneroEntity g"),
    @NamedQuery(name = "GeneroEntity.findById", query = "SELECT g FROM GeneroEntity g WHERE g.id = :id"),
    @NamedQuery(name = "GeneroEntity.findByNome", query = "SELECT g FROM GeneroEntity g WHERE g.nome = :nome")})
public class GeneroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 15)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGenero")
    private Collection<InvestidorEntity> investidorEntityCollection;

    public GeneroEntity() {
    }

    public GeneroEntity(Integer id) {
        this.id = id;
    }

    public GeneroEntity(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<InvestidorEntity> getInvestidorEntityCollection() {
        return investidorEntityCollection;
    }

    public void setInvestidorEntityCollection(Collection<InvestidorEntity> investidorEntityCollection) {
        this.investidorEntityCollection = investidorEntityCollection;
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
        if (!(object instanceof GeneroEntity)) {
            return false;
        }
        GeneroEntity other = (GeneroEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.GeneroEntity[ id=" + id + " ]";
    }
    
}
