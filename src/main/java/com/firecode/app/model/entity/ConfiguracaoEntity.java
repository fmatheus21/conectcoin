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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "configuracao", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracaoEntity.findAll", query = "SELECT c FROM ConfiguracaoEntity c"),
    @NamedQuery(name = "ConfiguracaoEntity.findById", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.id = :id"),
    @NamedQuery(name = "ConfiguracaoEntity.findByValorMinimo", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.valorMinimo = :valorMinimo"),
    @NamedQuery(name = "ConfiguracaoEntity.findByValorMaximo", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.valorMaximo = :valorMaximo"),
    @NamedQuery(name = "ConfiguracaoEntity.findByValorPonto", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.valorPonto = :valorPonto"),
    @NamedQuery(name = "ConfiguracaoEntity.findByDiasExpiracaoPagamento", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.diasExpiracaoPagamento = :diasExpiracaoPagamento"),
    @NamedQuery(name = "ConfiguracaoEntity.findByPercentualInvestimento", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.percentualInvestimento = :percentualInvestimento"),
    @NamedQuery(name = "ConfiguracaoEntity.findByPercentualIndicacao", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.percentualIndicacao = :percentualIndicacao"),
    @NamedQuery(name = "ConfiguracaoEntity.findByPercentualEquipe", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.percentualEquipe = :percentualEquipe"),
    @NamedQuery(name = "ConfiguracaoEntity.findByDiasRemmanejamentoEquipe", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.diasRemmanejamentoEquipe = :diasRemmanejamentoEquipe"),
    @NamedQuery(name = "ConfiguracaoEntity.findBySaqueMinimo", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.saqueMinimo = :saqueMinimo"),
    @NamedQuery(name = "ConfiguracaoEntity.findByTaxaSobreSaque", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.taxaSobreSaque = :taxaSobreSaque"),
    @NamedQuery(name = "ConfiguracaoEntity.findByDiasPagamento", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.diasPagamento = :diasPagamento"),
    @NamedQuery(name = "ConfiguracaoEntity.findByMesesPagamento", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.mesesPagamento = :mesesPagamento"),
    @NamedQuery(name = "ConfiguracaoEntity.findByDiasExclusaoInativos", query = "SELECT c FROM ConfiguracaoEntity c WHERE c.diasExclusaoInativos = :diasExclusaoInativos")})
public class ConfiguracaoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_minimo", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_maximo", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorMaximo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_ponto", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_expiracao_pagamento", nullable = false)
    private int diasExpiracaoPagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentual_investimento", nullable = false, precision = 2, scale = 2)
    private BigDecimal percentualInvestimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentual_indicacao", nullable = false, precision = 2, scale = 2)
    private BigDecimal percentualIndicacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentual_equipe", nullable = false, precision = 2, scale = 2)
    private BigDecimal percentualEquipe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_remmanejamento_equipe", nullable = false)
    private int diasRemmanejamentoEquipe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saque_minimo", nullable = false, precision = 10, scale = 2)
    private BigDecimal saqueMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxa_sobre_saque", nullable = false, precision = 2, scale = 2)
    private BigDecimal taxaSobreSaque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_pagamento", nullable = false)
    private int diasPagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meses_pagamento", nullable = false)
    private int mesesPagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_exclusao_inativos", nullable = false)
    private int diasExclusaoInativos;
    @JoinColumn(name = "id_equipe", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private EquipeEntity idEquipe;

    public ConfiguracaoEntity() {
    }

    public ConfiguracaoEntity(Integer id) {
        this.id = id;
    }

    public ConfiguracaoEntity(Integer id, BigDecimal valorMinimo, BigDecimal valorMaximo, BigDecimal valorPonto, int diasExpiracaoPagamento, BigDecimal percentualInvestimento, BigDecimal percentualIndicacao, BigDecimal percentualEquipe, int diasRemmanejamentoEquipe, BigDecimal saqueMinimo, BigDecimal taxaSobreSaque, int diasPagamento, int mesesPagamento, int diasExclusaoInativos) {
        this.id = id;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.valorPonto = valorPonto;
        this.diasExpiracaoPagamento = diasExpiracaoPagamento;
        this.percentualInvestimento = percentualInvestimento;
        this.percentualIndicacao = percentualIndicacao;
        this.percentualEquipe = percentualEquipe;
        this.diasRemmanejamentoEquipe = diasRemmanejamentoEquipe;
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

    public int getDiasRemmanejamentoEquipe() {
        return diasRemmanejamentoEquipe;
    }

    public void setDiasRemmanejamentoEquipe(int diasRemmanejamentoEquipe) {
        this.diasRemmanejamentoEquipe = diasRemmanejamentoEquipe;
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
        if (!(object instanceof ConfiguracaoEntity)) {
            return false;
        }
        ConfiguracaoEntity other = (ConfiguracaoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ConfiguracaoEntity[ id=" + id + " ]";
    }
    
}
