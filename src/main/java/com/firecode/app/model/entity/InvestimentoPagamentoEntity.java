package com.firecode.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "investimento_pagamento", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_investimento"}),
    @UniqueConstraint(columnNames = {"id"})})

public class InvestimentoPagamentoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @Basic(optional = false)
    @Column(name = "pago", nullable = false)
    private boolean pago;

    @JoinColumn(name = "id_patrocinador", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClienteEntity idPatrocinador;

    @JoinColumn(name = "id_investimento", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private InvestimentoPedidoEntity idInvestimento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPagamento")
    private Collection<PagamentoMensalEntity> pagamentoMensalEntityCollection;

    public InvestimentoPagamentoEntity() {
    }

    public InvestimentoPagamentoEntity(Integer id) {
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

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public ClienteEntity getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(ClienteEntity idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public InvestimentoPedidoEntity getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(InvestimentoPedidoEntity idInvestimento) {
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestimentoPagamentoEntity[ id=" + id + " ]";
    }

}
