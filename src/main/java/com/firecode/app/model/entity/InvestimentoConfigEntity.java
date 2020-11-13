/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "investimento_config", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "InvestimentoConfigEntity.findAll", query = "SELECT i FROM InvestimentoConfigEntity i"),
    @NamedQuery(name = "InvestimentoConfigEntity.findById", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByValorMinimo", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.valorMinimo = :valorMinimo"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByValorMaximo", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.valorMaximo = :valorMaximo"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByValorPonto", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.valorPonto = :valorPonto"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByDiasExpiracaoPagamento", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.diasExpiracaoPagamento = :diasExpiracaoPagamento"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByPercentualInvestimento", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.percentualInvestimento = :percentualInvestimento"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByPercentualIndicacao", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.percentualIndicacao = :percentualIndicacao"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByPercentualEquipe", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.percentualEquipe = :percentualEquipe"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByDiasRemanejamentoEquipe", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.diasRemanejamentoEquipe = :diasRemanejamentoEquipe"),
    @NamedQuery(name = "InvestimentoConfigEntity.findBySaqueMinimo", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.saqueMinimo = :saqueMinimo"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByTaxaSobreSaque", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.taxaSobreSaque = :taxaSobreSaque"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByDiasPagamento", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.diasPagamento = :diasPagamento"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByMesesPagamento", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.mesesPagamento = :mesesPagamento"),
    @NamedQuery(name = "InvestimentoConfigEntity.findByDiasExclusaoInativos", query = "SELECT i FROM InvestimentoConfigEntity i WHERE i.diasExclusaoInativos = :diasExclusaoInativos")})
public class InvestimentoConfigEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_minimo", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorMinimo;
    @Basic(optional = false)
    @Column(name = "valor_maximo", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorMaximo;
    @Basic(optional = false)
    @Column(name = "valor_ponto", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPonto;
    @Basic(optional = false)
    @Column(name = "dias_expiracao_pagamento", nullable = false)
    private int diasExpiracaoPagamento;
    @Basic(optional = false)
    @Column(name = "percentual_investimento", nullable = false, precision = 2, scale = 2)
    private BigDecimal percentualInvestimento;
    @Basic(optional = false)
    @Column(name = "percentual_indicacao", nullable = false, precision = 2, scale = 2)
    private BigDecimal percentualIndicacao;
    @Basic(optional = false)
    @Column(name = "percentual_equipe", nullable = false, precision = 2, scale = 2)
    private BigDecimal percentualEquipe;
    @Basic(optional = false)
    @Column(name = "dias_remanejamento_equipe", nullable = false)
    private int diasRemanejamentoEquipe;
    @Basic(optional = false)
    @Column(name = "saque_minimo", nullable = false, precision = 8, scale = 2)
    private BigDecimal saqueMinimo;
    @Basic(optional = false)
    @Column(name = "taxa_sobre_saque", nullable = false, precision = 2, scale = 2)
    private BigDecimal taxaSobreSaque;
    @Basic(optional = false)
    @Column(name = "dias_pagamento", nullable = false)
    private int diasPagamento;
    @Basic(optional = false)
    @Column(name = "meses_pagamento", nullable = false)
    private int mesesPagamento;
    @Basic(optional = false)
    @Column(name = "dias_exclusao_inativos", nullable = false)
    private int diasExclusaoInativos;
    @JoinColumn(name = "id_equipe", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private EquipeEntity idEquipe;

    public InvestimentoConfigEntity() {
    }

    public InvestimentoConfigEntity(Integer id) {
        this.id = id;
    }

    public InvestimentoConfigEntity(Integer id, BigDecimal valorMinimo, BigDecimal valorMaximo, BigDecimal valorPonto, int diasExpiracaoPagamento, BigDecimal percentualInvestimento, BigDecimal percentualIndicacao, BigDecimal percentualEquipe, int diasRemanejamentoEquipe, BigDecimal saqueMinimo, BigDecimal taxaSobreSaque, int diasPagamento, int mesesPagamento, int diasExclusaoInativos) {
        this.id = id;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.valorPonto = valorPonto;
        this.diasExpiracaoPagamento = diasExpiracaoPagamento;
        this.percentualInvestimento = percentualInvestimento;
        this.percentualIndicacao = percentualIndicacao;
        this.percentualEquipe = percentualEquipe;
        this.diasRemanejamentoEquipe = diasRemanejamentoEquipe;
        this.saqueMinimo = saqueMinimo;
        this.taxaSobreSaque = taxaSobreSaque;
        this.diasPagamento = diasPagamento;
        this.mesesPagamento = mesesPagamento;
        this.diasExclusaoInativos = diasExclusaoInativos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public BigDecimal getValorPonto() {
        return valorPonto;
    }

    public void setValorPonto(BigDecimal valorPonto) {
        this.valorPonto = valorPonto;
    }

    public int getDiasExpiracaoPagamento() {
        return diasExpiracaoPagamento;
    }

    public void setDiasExpiracaoPagamento(int diasExpiracaoPagamento) {
        this.diasExpiracaoPagamento = diasExpiracaoPagamento;
    }

    public BigDecimal getPercentualInvestimento() {
        return percentualInvestimento;
    }

    public void setPercentualInvestimento(BigDecimal percentualInvestimento) {
        this.percentualInvestimento = percentualInvestimento;
    }

    public BigDecimal getPercentualIndicacao() {
        return percentualIndicacao;
    }

    public void setPercentualIndicacao(BigDecimal percentualIndicacao) {
        this.percentualIndicacao = percentualIndicacao;
    }

    public BigDecimal getPercentualEquipe() {
        return percentualEquipe;
    }

    public void setPercentualEquipe(BigDecimal percentualEquipe) {
        this.percentualEquipe = percentualEquipe;
    }

    public int getDiasRemanejamentoEquipe() {
        return diasRemanejamentoEquipe;
    }

    public void setDiasRemanejamentoEquipe(int diasRemanejamentoEquipe) {
        this.diasRemanejamentoEquipe = diasRemanejamentoEquipe;
    }

    public BigDecimal getSaqueMinimo() {
        return saqueMinimo;
    }

    public void setSaqueMinimo(BigDecimal saqueMinimo) {
        this.saqueMinimo = saqueMinimo;
    }

    public BigDecimal getTaxaSobreSaque() {
        return taxaSobreSaque;
    }

    public void setTaxaSobreSaque(BigDecimal taxaSobreSaque) {
        this.taxaSobreSaque = taxaSobreSaque;
    }

    public int getDiasPagamento() {
        return diasPagamento;
    }

    public void setDiasPagamento(int diasPagamento) {
        this.diasPagamento = diasPagamento;
    }

    public int getMesesPagamento() {
        return mesesPagamento;
    }

    public void setMesesPagamento(int mesesPagamento) {
        this.mesesPagamento = mesesPagamento;
    }

    public int getDiasExclusaoInativos() {
        return diasExclusaoInativos;
    }

    public void setDiasExclusaoInativos(int diasExclusaoInativos) {
        this.diasExclusaoInativos = diasExclusaoInativos;
    }

    public EquipeEntity getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(EquipeEntity idEquipe) {
        this.idEquipe = idEquipe;
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
        if (!(object instanceof InvestimentoConfigEntity)) {
            return false;
        }
        InvestimentoConfigEntity other = (InvestimentoConfigEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestimentoConfigEntity[ id=" + id + " ]";
    }
    
}
