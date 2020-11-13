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
@Table(name = "saque", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "SaqueEntity.findAll", query = "SELECT s FROM SaqueEntity s"),
    @NamedQuery(name = "SaqueEntity.findById", query = "SELECT s FROM SaqueEntity s WHERE s.id = :id"),
    @NamedQuery(name = "SaqueEntity.findByValorSolicitado", query = "SELECT s FROM SaqueEntity s WHERE s.valorSolicitado = :valorSolicitado"),
    @NamedQuery(name = "SaqueEntity.findByDataSolicitacao", query = "SELECT s FROM SaqueEntity s WHERE s.dataSolicitacao = :dataSolicitacao"),
    @NamedQuery(name = "SaqueEntity.findByTipoRecebimento", query = "SELECT s FROM SaqueEntity s WHERE s.tipoRecebimento = :tipoRecebimento"),
    @NamedQuery(name = "SaqueEntity.findByValorDesconto", query = "SELECT s FROM SaqueEntity s WHERE s.valorDesconto = :valorDesconto"),
    @NamedQuery(name = "SaqueEntity.findByValorSaque", query = "SELECT s FROM SaqueEntity s WHERE s.valorSaque = :valorSaque")})
public class SaqueEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_solicitado", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorSolicitado;
    @Basic(optional = false)
    @Column(name = "data_solicitacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSolicitacao;
    @Basic(optional = false)
    @Column(name = "tipo_recebimento", nullable = false, length = 45)
    private String tipoRecebimento;
    @Basic(optional = false)
    @Column(name = "valor_desconto", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorDesconto;
    @Basic(optional = false)
    @Column(name = "valor_saque", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorSaque;
    @JoinColumn(name = "id_saldo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SaldoEntity idSaldo;
    @JoinColumn(name = "id_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SaqueStatusEntity idStatus;

    public SaqueEntity() {
    }

    public SaqueEntity(Integer id) {
        this.id = id;
    }

    public SaqueEntity(Integer id, BigDecimal valorSolicitado, Date dataSolicitacao, String tipoRecebimento, BigDecimal valorDesconto, BigDecimal valorSaque) {
        this.id = id;
        this.valorSolicitado = valorSolicitado;
        this.dataSolicitacao = dataSolicitacao;
        this.tipoRecebimento = tipoRecebimento;
        this.valorDesconto = valorDesconto;
        this.valorSaque = valorSaque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getTipoRecebimento() {
        return tipoRecebimento;
    }

    public void setTipoRecebimento(String tipoRecebimento) {
        this.tipoRecebimento = tipoRecebimento;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorSaque() {
        return valorSaque;
    }

    public void setValorSaque(BigDecimal valorSaque) {
        this.valorSaque = valorSaque;
    }

    public SaldoEntity getIdSaldo() {
        return idSaldo;
    }

    public void setIdSaldo(SaldoEntity idSaldo) {
        this.idSaldo = idSaldo;
    }

    public SaqueStatusEntity getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(SaqueStatusEntity idStatus) {
        this.idStatus = idStatus;
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
        if (!(object instanceof SaqueEntity)) {
            return false;
        }
        SaqueEntity other = (SaqueEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SaqueEntity[ id=" + id + " ]";
    }
    
}
