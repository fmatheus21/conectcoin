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
@Table(name = "contato", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pessoa"}),
    @UniqueConstraint(columnNames = {"email"}),
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "ContatoEntity.findAll", query = "SELECT c FROM ContatoEntity c"),
    @NamedQuery(name = "ContatoEntity.findById", query = "SELECT c FROM ContatoEntity c WHERE c.id = :id"),
    @NamedQuery(name = "ContatoEntity.findByTelefone", query = "SELECT c FROM ContatoEntity c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "ContatoEntity.findByEmail", query = "SELECT c FROM ContatoEntity c WHERE c.email = :email")})
public class ContatoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PessoaEntity idPessoa;

    public ContatoEntity() {
    }

    public ContatoEntity(Integer id) {
        this.id = id;
    }

    public ContatoEntity(Integer id, String telefone, String email) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ContatoEntity[ id=" + id + " ]";
    }
    
}
