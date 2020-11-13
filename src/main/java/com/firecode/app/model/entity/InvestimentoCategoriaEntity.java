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
@Table(name = "investimento_categoria", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"nome"})})
@NamedQueries({
    @NamedQuery(name = "InvestimentoCategoriaEntity.findAll", query = "SELECT i FROM InvestimentoCategoriaEntity i"),
    @NamedQuery(name = "InvestimentoCategoriaEntity.findById", query = "SELECT i FROM InvestimentoCategoriaEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InvestimentoCategoriaEntity.findByNome", query = "SELECT i FROM InvestimentoCategoriaEntity i WHERE i.nome = :nome"),
    @NamedQuery(name = "InvestimentoCategoriaEntity.findByColor", query = "SELECT i FROM InvestimentoCategoriaEntity i WHERE i.color = :color")})
public class InvestimentoCategoriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
    @Basic(optional = false)
    @Column(name = "color", nullable = false, length = 10)
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<InvestimentoEntity> investimentoEntityCollection;

    public InvestimentoCategoriaEntity() {
    }

    public InvestimentoCategoriaEntity(Integer id) {
        this.id = id;
    }

    public InvestimentoCategoriaEntity(Integer id, String nome, String color) {
        this.id = id;
        this.nome = nome;
        this.color = color;
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
        if (!(object instanceof InvestimentoCategoriaEntity)) {
            return false;
        }
        InvestimentoCategoriaEntity other = (InvestimentoCategoriaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestimentoCategoriaEntity[ id=" + id + " ]";
    }
    
}
