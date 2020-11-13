/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "pontuacao", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"id_investidor"})})
@NamedQueries({
    @NamedQuery(name = "PontuacaoEntity.findAll", query = "SELECT p FROM PontuacaoEntity p"),
    @NamedQuery(name = "PontuacaoEntity.findById", query = "SELECT p FROM PontuacaoEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PontuacaoEntity.findByPontuacao", query = "SELECT p FROM PontuacaoEntity p WHERE p.pontuacao = :pontuacao"),
    @NamedQuery(name = "PontuacaoEntity.findByPontoEsquerda", query = "SELECT p FROM PontuacaoEntity p WHERE p.pontoEsquerda = :pontoEsquerda"),
    @NamedQuery(name = "PontuacaoEntity.findByPontoDireita", query = "SELECT p FROM PontuacaoEntity p WHERE p.pontoDireita = :pontoDireita"),
    @NamedQuery(name = "PontuacaoEntity.findByStatusBinario", query = "SELECT p FROM PontuacaoEntity p WHERE p.statusBinario = :statusBinario")})
public class PontuacaoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pontuacao", nullable = false)
    private int pontuacao;
    @Basic(optional = false)
    @Column(name = "ponto_esquerda", nullable = false)
    private int pontoEsquerda;
    @Basic(optional = false)
    @Column(name = "ponto_direita", nullable = false)
    private int pontoDireita;
    @Basic(optional = false)
    @Column(name = "status_binario", nullable = false, length = 10)
    private String statusBinario;
    @JoinColumn(name = "id_investidor", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private InvestidorEntity idInvestidor;

    public PontuacaoEntity() {
    }

    public PontuacaoEntity(Integer id) {
        this.id = id;
    }

    public PontuacaoEntity(Integer id, int pontuacao, int pontoEsquerda, int pontoDireita, String statusBinario) {
        this.id = id;
        this.pontuacao = pontuacao;
        this.pontoEsquerda = pontoEsquerda;
        this.pontoDireita = pontoDireita;
        this.statusBinario = statusBinario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPontoEsquerda() {
        return pontoEsquerda;
    }

    public void setPontoEsquerda(int pontoEsquerda) {
        this.pontoEsquerda = pontoEsquerda;
    }

    public int getPontoDireita() {
        return pontoDireita;
    }

    public void setPontoDireita(int pontoDireita) {
        this.pontoDireita = pontoDireita;
    }

    public String getStatusBinario() {
        return statusBinario;
    }

    public void setStatusBinario(String statusBinario) {
        this.statusBinario = statusBinario;
    }

    public InvestidorEntity getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(InvestidorEntity idInvestidor) {
        this.idInvestidor = idInvestidor;
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
        if (!(object instanceof PontuacaoEntity)) {
            return false;
        }
        PontuacaoEntity other = (PontuacaoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PontuacaoEntity[ id=" + id + " ]";
    }
    
}
