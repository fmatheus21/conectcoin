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
@Table(name = "banco", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numero"}),
    @UniqueConstraint(columnNames = {"id"})})

public class BancoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "numero", nullable = false, length = 45)
    private String numero;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 70)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanco")
    private Collection<ContaBancariaEntity> contaBancariaEntityCollection;

    public BancoEntity() {
    }

    public BancoEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<ContaBancariaEntity> getContaBancariaEntityCollection() {
        return contaBancariaEntityCollection;
    }

    public void setContaBancariaEntityCollection(Collection<ContaBancariaEntity> contaBancariaEntityCollection) {
        this.contaBancariaEntityCollection = contaBancariaEntityCollection;
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
        if (!(object instanceof BancoEntity)) {
            return false;
        }
        BancoEntity other = (BancoEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.BancoEntity[ id=" + id + " ]";
    }

}
