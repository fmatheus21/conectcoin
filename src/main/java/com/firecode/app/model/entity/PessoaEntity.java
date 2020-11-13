/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pessoa", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"cpf_cnpj"})})
@NamedQueries({
    @NamedQuery(name = "PessoaEntity.findAll", query = "SELECT p FROM PessoaEntity p"),
    @NamedQuery(name = "PessoaEntity.findById", query = "SELECT p FROM PessoaEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaEntity.findByNomeRazaosocial", query = "SELECT p FROM PessoaEntity p WHERE p.nomeRazaosocial = :nomeRazaosocial"),
    @NamedQuery(name = "PessoaEntity.findByCpfCnpj", query = "SELECT p FROM PessoaEntity p WHERE p.cpfCnpj = :cpfCnpj")})
public class PessoaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome_razaosocial", nullable = false, length = 70)
    private String nomeRazaosocial;
    @Basic(optional = false)
    @Column(name = "cpf_cnpj", nullable = false, length = 20)
    private String cpfCnpj;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PessoaTipoEntity idTipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private EnderecoEntity enderecoEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private InvestidorEntity investidorEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private UsuarioEntity usuarioEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private ContatoEntity contatoEntity;

    public PessoaEntity() {
    }

    public PessoaEntity(Integer id) {
        this.id = id;
    }

    public PessoaEntity(Integer id, String nomeRazaosocial, String cpfCnpj) {
        this.id = id;
        this.nomeRazaosocial = nomeRazaosocial;
        this.cpfCnpj = cpfCnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeRazaosocial() {
        return nomeRazaosocial;
    }

    public void setNomeRazaosocial(String nomeRazaosocial) {
        this.nomeRazaosocial = nomeRazaosocial;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public PessoaTipoEntity getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(PessoaTipoEntity idTipo) {
        this.idTipo = idTipo;
    }

    public EnderecoEntity getEnderecoEntity() {
        return enderecoEntity;
    }

    public void setEnderecoEntity(EnderecoEntity enderecoEntity) {
        this.enderecoEntity = enderecoEntity;
    }

    public InvestidorEntity getInvestidorEntity() {
        return investidorEntity;
    }

    public void setInvestidorEntity(InvestidorEntity investidorEntity) {
        this.investidorEntity = investidorEntity;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public ContatoEntity getContatoEntity() {
        return contatoEntity;
    }

    public void setContatoEntity(ContatoEntity contatoEntity) {
        this.contatoEntity = contatoEntity;
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
        if (!(object instanceof PessoaEntity)) {
            return false;
        }
        PessoaEntity other = (PessoaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PessoaEntity[ id=" + id + " ]";
    }
    
}
