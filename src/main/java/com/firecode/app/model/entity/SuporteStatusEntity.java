package com.firecode.app.model.entity;

import com.firecode.app.controller.util.AppUtil;
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
@Table(name = "suporte_status", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cor"}),
    @UniqueConstraint(columnNames = {"Id"}),
    @UniqueConstraint(columnNames = {"nome"})})

public class SuporteStatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Basic(optional = false)
    @Column(name = "cor", nullable = false, length = 10)
    private String cor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private Collection<SuporteEntity> suporteEntityCollection;

    public SuporteStatusEntity() {
    }

    public SuporteStatusEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        if (nome != null) {
            return AppUtil.convertFirstUppercaseCharacter(AppUtil.removeDuplicateSpace(nome));
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = AppUtil.convertFirstUppercaseCharacter(AppUtil.removeDuplicateSpace(nome));
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Collection<SuporteEntity> getSuporteEntityCollection() {
        return suporteEntityCollection;
    }

    public void setSuporteEntityCollection(Collection<SuporteEntity> suporteEntityCollection) {
        this.suporteEntityCollection = suporteEntityCollection;
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
        if (!(object instanceof SuporteStatusEntity)) {
            return false;
        }
        SuporteStatusEntity other = (SuporteStatusEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SuporteStatusEntity[ id=" + id + " ]";
    }

}
