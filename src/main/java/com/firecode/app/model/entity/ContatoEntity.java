package com.firecode.app.model.entity;

import com.firecode.app.controller.util.AppUtil;
import java.io.Serializable;
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
@Table(name = "contato", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pessoa"}),
    @UniqueConstraint(columnNames = {"id"})})

public class ContatoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 70)
    private String email;

    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PessoaEntity idPessoa;

    public ContatoEntity() {
    }

    public ContatoEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        if (telefone != null) {
            int count = AppUtil.countCharacter(telefone);
            if (count == 10) {
                return AppUtil.formatMask(telefone, "## ####-####");
            }
            if (count == 11) {
                return AppUtil.formatMask(telefone, "## #####-####");
            }
        }
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = AppUtil.removeSpecialCharacters(telefone);
    }

    public String getEmail() {
        if (email != null) {
            return AppUtil.convertAllLowercaseCharacters(email);
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = AppUtil.convertAllUppercaseCharacters(email);
    }

    public PessoaEntity getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(PessoaEntity idPessoa) {
        this.idPessoa = idPessoa;
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
        if (!(object instanceof ContatoEntity)) {
            return false;
        }
        ContatoEntity other = (ContatoEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ContatoEntity[ id=" + id + " ]";
    }

}
