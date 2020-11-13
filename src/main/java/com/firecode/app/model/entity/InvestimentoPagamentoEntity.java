/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "investimento_pagamento", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_investimento"}),
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "InvestimentoPagamentoEntity.findAll", query = "SELECT i FROM InvestimentoPagamentoEntity i"),
    @NamedQuery(name = "InvestimentoPagamentoEntity.findById", query = "SELECT i FROM InvestimentoPagamentoEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InvestimentoPagamentoEntity.findByDataPagamento", query = "SELECT i FROM InvestimentoPagamentoEntity i WHERE i.dataPagamento = :dataPagamento"),
    @NamedQuery(name = "InvestimentoPagamentoEntity.findByPago", query = "SELECT i FROM InvestimentoPagamentoEntity i WHERE i.pago = :pago")})
public class InvestimentoPagamentoEntity implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "pago", nullable = false)
    private boolean pago;
    @JoinColumn(name = "id_patrocinador", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private InvestidorEntity idPatrocinador;
    @JoinColumn(name = "id_investimento", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private InvestimentoEntity idInvestimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInvestimentoPagamento")
    private Collection<PagamentoMensalEntity> pagamentoMensalEntityCollection;

    public InvestimentoPagamentoEntity() {
    }

    public InvestimentoPagamentoEntity(Integer id) {
        this.id = id;
    }

    public InvestimentoPagamentoEntity(Integer id, Date dataPagamento, boolean pago) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        this.pago = pago;
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

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public InvestidorEntity getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(InvestidorEntity idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public InvestimentoEntity getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(InvestimentoEntity idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public Collection<PagamentoMensalEntity> getPagamentoMensalEntityCollection() {
        return pagamentoMensalEntityCollection;
    }

    public void setPagamentoMensalEntityCollection(Collection<PagamentoMensalEntity> pagamentoMensalEntityCollection) {
        this.pagamentoMensalEntityCollection = pagamentoMensalEntityCollection;
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
        if (!(object instanceof InvestimentoPagamentoEntity)) {
            return false;
        }
        InvestimentoPagamentoEntity other = (InvestimentoPagamentoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestimentoPagamentoEntity[ id=" + id + " ]";
    }
    
}
