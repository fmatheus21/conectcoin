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
@Table(name = "conta_bancaria_tipo", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"nome"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContaBancariaTipoEntity.findAll", query = "SELECT c FROM ContaBancariaTipoEntity c"),
    @NamedQuery(name = "ContaBancariaTipoEntity.findById", query = "SELECT c FROM ContaBancariaTipoEntity c WHERE c.id = :id"),
    @NamedQuery(name = "ContaBancariaTipoEntity.findByNome", query = "SELECT c FROM ContaBancariaTipoEntity c WHERE c.nome = :nome")})
public class ContaBancariaTipoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<ContaBancariaEntity> contaBancariaEntityCollection;

    public ContaBancariaTipoEntity() {
    }

    public ContaBancariaTipoEntity(Integer id) {
        this.id = id;
    }

    public ContaBancariaTipoEntity(Integer id, String nome) {
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

    @XmlTransient
    public Collection<ContaBancariaEntity> getContaBancariaEntityCollection() {
        return contaBancariaEntityCollection;
    }

    public void setContaBancariaEntityCollection(Collection<ContaBancariaEntity> contaBancariaEntityCollection) {
        this.contaBancariaEntityCollection = contaBancariaEntityCollection;
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
        if (!(object instanceof ContaBancariaTipoEntity)) {
            return false;
        }
        ContaBancariaTipoEntity other = (ContaBancariaTipoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ContaBancariaTipoEntity[ id=" + id + " ]";
    }
    
}
