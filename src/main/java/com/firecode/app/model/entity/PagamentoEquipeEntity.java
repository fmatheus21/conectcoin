package com.firecode.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pagamento_equipe", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_patrocinador"}),
    @UniqueConstraint(columnNames = {"id"})})

public class PagamentoEquipeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @JoinColumn(name = "id_patrocinador", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private ClienteEntity idPatrocinador;

    public PagamentoEquipeEntity() {
    }

    public PagamentoEquipeEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public ClienteEntity getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(ClienteEntity idPatrocinador) {
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
        if (!(object instanceof PagamentoEquipeEntity)) {
            return false;
        }
        PagamentoEquipeEntity other = (PagamentoEquipeEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PagamentoEquipeEntity[ id=" + id + " ]";
    }

}
