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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "configuracao", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class ConfiguracaoEntity implements Serializable {

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
    @Column(name = "dias_remmanejamento_equipe", nullable = false)
    private int diasRemmanejamentoEquipe;

    @Basic(optional = false)
    @Column(name = "saque_minimo", nullable = false, precision = 10, scale = 2)
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

    public ConfiguracaoEntity() {
    }

    public ConfiguracaoEntity(Integer id) {
        this.id = id;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ConfiguracaoEntity[ id=" + id + " ]";
    }

}
