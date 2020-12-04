package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "investimento_status", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"nome"})})

public class InvestimentoStatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    @Basic(optional = false)
    @Column(name = "cor", nullable = false, length = 10)
    private String cor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private Collection<InvestimentoPedidoEntity> investimentoPedidoEntityCollection;

    public InvestimentoStatusEntity() {
    }

    public InvestimentoStatusEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Collection<InvestimentoPedidoEntity> getInvestimentoPedidoEntityCollection() {
        return investimentoPedidoEntityCollection;
    }

    public void setInvestimentoPedidoEntityCollection(Collection<InvestimentoPedidoEntity> investimentoPedidoEntityCollection) {
        this.investimentoPedidoEntityCollection = investimentoPedidoEntityCollection;
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
        if (!(object instanceof InvestimentoStatusEntity)) {
            return false;
        }
        InvestimentoStatusEntity other = (InvestimentoStatusEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestimentoStatusEntity[ id=" + id + " ]";
    }

}
