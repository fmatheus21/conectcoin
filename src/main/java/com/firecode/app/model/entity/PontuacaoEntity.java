package com.firecode.app.model.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pontuacao", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cliente"}),
    @UniqueConstraint(columnNames = {"id"})})

public class PontuacaoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "pontuacao", nullable = false)
    private int pontuacao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ponto_esquerda", nullable = false)
    private int pontoEsquerda;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ponto_direita", nullable = false)
    private int pontoDireita;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status_binario", nullable = false, length = 10)
    private String statusBinario;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClienteEntity clienteEntity;

    public PontuacaoEntity() {
    }

    public PontuacaoEntity(Integer id) {
        this.id = id;
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

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PontuacaoEntity[ id=" + id + " ]";
    }

}
