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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "investimento_categoria", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"nome"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvestimentoCategoriaEntity.findAll", query = "SELECT i FROM InvestimentoCategoriaEntity i"),
    @NamedQuery(name = "InvestimentoCategoriaEntity.findById", query = "SELECT i FROM InvestimentoCategoriaEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InvestimentoCategoriaEntity.findByNome", query = "SELECT i FROM InvestimentoCategoriaEntity i WHERE i.nome = :nome"),
    @NamedQuery(name = "InvestimentoCategoriaEntity.findByCor", query = "SELECT i FROM InvestimentoCategoriaEntity i WHERE i.cor = :cor")})
public class InvestimentoCategoriaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cor", nullable = false, length = 10)
    private String cor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<InvestimentoPedidoEntity> investimentoPedidoEntityCollection;

    public InvestimentoCategoriaEntity() {
    }

    public InvestimentoCategoriaEntity(Integer id) {
        this.id = id;
    }

    public InvestimentoCategoriaEntity(Integer id, String nome, String cor) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @XmlTransient
    public Collection<InvestimentoPedidoEntity> getInvestimentoPedidoEntityCollection() {
        return investimentoPedidoEntityCollection;
    }

    public void setInvestimentoPedidoEntityCollection(Collection<InvestimentoPedidoEntity> investimentoPedidoEntityCollection) {
        this.investimentoPedidoEntityCollection = investimentoPedidoEntityCollection;
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
