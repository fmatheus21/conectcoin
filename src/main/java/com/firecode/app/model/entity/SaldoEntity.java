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

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "saldo", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"id_investidor"})})
@NamedQueries({
    @NamedQuery(name = "SaldoEntity.findAll", query = "SELECT s FROM SaldoEntity s"),
    @NamedQuery(name = "SaldoEntity.findById", query = "SELECT s FROM SaldoEntity s WHERE s.id = :id"),
    @NamedQuery(name = "SaldoEntity.findBySaldoDisponivel", query = "SELECT s FROM SaldoEntity s WHERE s.saldoDisponivel = :saldoDisponivel"),
    @NamedQuery(name = "SaldoEntity.findBySaldoBloqueado", query = "SELECT s FROM SaldoEntity s WHERE s.saldoBloqueado = :saldoBloqueado"),
    @NamedQuery(name = "SaldoEntity.findByTotalGanho", query = "SELECT s FROM SaldoEntity s WHERE s.totalGanho = :totalGanho")})
public class SaldoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "saldo_disponivel", nullable = false, precision = 8, scale = 2)
    private BigDecimal saldoDisponivel;
    @Basic(optional = false)
    @Column(name = "saldo_bloqueado", nullable = false, precision = 8, scale = 2)
    private BigDecimal saldoBloqueado;
    @Basic(optional = false)
    @Column(name = "total_ganho", nullable = false, precision = 8, scale = 2)
    private BigDecimal totalGanho;
    @JoinColumn(name = "id_investidor", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private InvestidorEntity idInvestidor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSaldo")
    private Collection<SaqueEntity> saqueEntityCollection;

    public SaldoEntity() {
    }

    public SaldoEntity(Integer id) {
        this.id = id;
    }

    public SaldoEntity(Integer id, BigDecimal saldoDisponivel, BigDecimal saldoBloqueado, BigDecimal totalGanho) {
        this.id = id;
        this.saldoDisponivel = saldoDisponivel;
        this.saldoBloqueado = saldoBloqueado;
        this.totalGanho = totalGanho;
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

    public BigDecimal getTotalGanho() {
        return totalGanho;
    }

    public void setTotalGanho(BigDecimal totalGanho) {
        this.totalGanho = totalGanho;
    }

    public InvestidorEntity getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(InvestidorEntity idInvestidor) {
        this.idInvestidor = idInvestidor;
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
        if (!(object instanceof SaldoEntity)) {
            return false;
        }
        SaldoEntity other = (SaldoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SaldoEntity[ id=" + id + " ]";
    }
    
}
