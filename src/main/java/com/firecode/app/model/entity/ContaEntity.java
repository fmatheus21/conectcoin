/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "conta", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cliente"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContaEntity.findAll", query = "SELECT c FROM ContaEntity c"),
    @NamedQuery(name = "ContaEntity.findById", query = "SELECT c FROM ContaEntity c WHERE c.id = :id"),
    @NamedQuery(name = "ContaEntity.findBySaldoDisponivel", query = "SELECT c FROM ContaEntity c WHERE c.saldoDisponivel = :saldoDisponivel"),
    @NamedQuery(name = "ContaEntity.findBySaldoBloqueado", query = "SELECT c FROM ContaEntity c WHERE c.saldoBloqueado = :saldoBloqueado")})
public class ContaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_disponivel", nullable = false, precision = 8, scale = 2)
    private BigDecimal saldoDisponivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_bloqueado", nullable = false, precision = 8, scale = 2)
    private BigDecimal saldoBloqueado;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private ClienteEntity idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaEntity")
    private Collection<SaqueEntity> saqueEntityCollection;

    public ContaEntity() {
    }

    public ContaEntity(Integer id) {
        this.id = id;
    }

    public ContaEntity(Integer id, BigDecimal saldoDisponivel, BigDecimal saldoBloqueado) {
        this.id = id;
        this.saldoDisponivel = saldoDisponivel;
        this.saldoBloqueado = saldoBloqueado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(BigDecimal saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public BigDecimal getSaldoBloqueado() {
        return saldoBloqueado;
    }

    public void setSaldoBloqueado(BigDecimal saldoBloqueado) {
        this.saldoBloqueado = saldoBloqueado;
    }

    public ClienteEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteEntity idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
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
        if (!(object instanceof ContaEntity)) {
            return false;
        }
        ContaEntity other = (ContaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ContaEntity[ id=" + id + " ]";
    }
    
}
