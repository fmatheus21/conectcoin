/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "pagamento_mensal", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "PagamentoMensalEntity.findAll", query = "SELECT p FROM PagamentoMensalEntity p"),
    @NamedQuery(name = "PagamentoMensalEntity.findById", query = "SELECT p FROM PagamentoMensalEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PagamentoMensalEntity.findByDataPagamento", query = "SELECT p FROM PagamentoMensalEntity p WHERE p.dataPagamento = :dataPagamento"),
    @NamedQuery(name = "PagamentoMensalEntity.findByValor", query = "SELECT p FROM PagamentoMensalEntity p WHERE p.valor = :valor"),
    @NamedQuery(name = "PagamentoMensalEntity.findByPago", query = "SELECT p FROM PagamentoMensalEntity p WHERE p.pago = :pago")})
public class PagamentoMensalEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_pagamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;
    @Column(name = "pago")
    private Boolean pago;
    @JoinColumn(name = "id_investimento_pagamento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private InvestimentoPagamentoEntity idInvestimentoPagamento;

    public PagamentoMensalEntity() {
    }

    public PagamentoMensalEntity(Integer id) {
        this.id = id;
    }

    public PagamentoMensalEntity(Integer id, Date dataPagamento, BigDecimal valor) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public InvestimentoPagamentoEntity getIdInvestimentoPagamento() {
        return idInvestimentoPagamento;
    }

    public void setIdInvestimentoPagamento(InvestimentoPagamentoEntity idInvestimentoPagamento) {
        this.idInvestimentoPagamento = idInvestimentoPagamento;
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
        if (!(object instanceof PagamentoMensalEntity)) {
            return false;
        }
        PagamentoMensalEntity other = (PagamentoMensalEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PagamentoMensalEntity[ id=" + id + " ]";
    }
    
}
