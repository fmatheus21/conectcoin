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
@Table(name = "endereco", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pessoa"}),
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "EnderecoEntity.findAll", query = "SELECT e FROM EnderecoEntity e"),
    @NamedQuery(name = "EnderecoEntity.findById", query = "SELECT e FROM EnderecoEntity e WHERE e.id = :id"),
    @NamedQuery(name = "EnderecoEntity.findByLogradouro", query = "SELECT e FROM EnderecoEntity e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "EnderecoEntity.findByNumero", query = "SELECT e FROM EnderecoEntity e WHERE e.numero = :numero"),
    @NamedQuery(name = "EnderecoEntity.findByComplemento", query = "SELECT e FROM EnderecoEntity e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "EnderecoEntity.findByBairro", query = "SELECT e FROM EnderecoEntity e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "EnderecoEntity.findByCidade", query = "SELECT e FROM EnderecoEntity e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "EnderecoEntity.findByUf", query = "SELECT e FROM EnderecoEntity e WHERE e.uf = :uf"),
    @NamedQuery(name = "EnderecoEntity.findByCep", query = "SELECT e FROM EnderecoEntity e WHERE e.cep = :cep")})
public class EnderecoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "logradouro", nullable = false, length = 70)
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "numero", nullable = false, length = 10)
    private String numero;
    @Column(name = "complemento", length = 50)
    private String complemento;
    @Basic(optional = false)
    @Column(name = "bairro", nullable = false, length = 50)
    private String bairro;
    @Basic(optional = false)
    @Column(name = "cidade", nullable = false, length = 50)
    private String cidade;
    @Basic(optional = false)
    @Column(name = "uf", nullable = false, length = 2)
    private String uf;
    @Basic(optional = false)
    @Column(name = "cep", nullable = false, length = 15)
    private String cep;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PessoaEntity idPessoa;

    public EnderecoEntity() {
    }

    public EnderecoEntity(Integer id) {
        this.id = id;
    }

    public EnderecoEntity(Integer id, String logradouro, String numero, String bairro, String cidade, String uf, String cep) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
        if (!(object instanceof EnderecoEntity)) {
            return false;
        }
        EnderecoEntity other = (EnderecoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.EnderecoEntity[ id=" + id + " ]";
    }
    
}
