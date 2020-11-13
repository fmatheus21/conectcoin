/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "pagamento_menor_equipe", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_patrocinador"}),
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "PagamentoMenorEquipeEntity.findAll", query = "SELECT p FROM PagamentoMenorEquipeEntity p"),
    @NamedQuery(name = "PagamentoMenorEquipeEntity.findById", query = "SELECT p FROM PagamentoMenorEquipeEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PagamentoMenorEquipeEntity.findByDataPagamento", query = "SELECT p FROM PagamentoMenorEquipeEntity p WHERE p.dataPagamento = :dataPagamento")})
public class PagamentoMenorEquipeEntity implements Serializable {

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
    @JoinColumn(name = "id_patrocinador", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private InvestidorEntity idPatrocinador;

    public PagamentoMenorEquipeEntity() {
    }

    public PagamentoMenorEquipeEntity(Integer id) {
        this.id = id;
    }

    public PagamentoMenorEquipeEntity(Integer id, Date dataPagamento) {
        this.id = id;
        this.dataPagamento = dataPagamento;
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

    public InvestidorEntity getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(InvestidorEntity idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
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
        if (!(object instanceof PagamentoMenorEquipeEntity)) {
            return false;
        }
        PagamentoMenorEquipeEntity other = (PagamentoMenorEquipeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PagamentoMenorEquipeEntity[ id=" + id + " ]";
    }
    
}
