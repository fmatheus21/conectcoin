/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "usuario", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pessoa"}),
    @UniqueConstraint(columnNames = {"usuario"}),
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "UsuarioEntity.findAll", query = "SELECT u FROM UsuarioEntity u"),
    @NamedQuery(name = "UsuarioEntity.findById", query = "SELECT u FROM UsuarioEntity u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioEntity.findByUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "UsuarioEntity.findBySenha", query = "SELECT u FROM UsuarioEntity u WHERE u.senha = :senha"),
    @NamedQuery(name = "UsuarioEntity.findByDataCadastro", query = "SELECT u FROM UsuarioEntity u WHERE u.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "UsuarioEntity.findByDataAlteracao", query = "SELECT u FROM UsuarioEntity u WHERE u.dataAlteracao = :dataAlteracao")})
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "usuario", nullable = false, length = 15)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    @Basic(optional = false)
    @Column(name = "data_cadastro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Basic(optional = false)
    @Column(name = "data_alteracao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private UsuarioPermissaoMapEntity usuarioPermissaoMapEntity;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PessoaEntity idPessoa;
    @JoinColumn(name = "id_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioStatusEntity idStatus;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer id) {
        this.id = id;
    }

    public UsuarioEntity(Integer id, String usuario, String senha, Date dataCadastro, Date dataAlteracao) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public UsuarioPermissaoMapEntity getUsuarioPermissaoMapEntity() {
        return usuarioPermissaoMapEntity;
    }

    public void setUsuarioPermissaoMapEntity(UsuarioPermissaoMapEntity usuarioPermissaoMapEntity) {
        this.usuarioPermissaoMapEntity = usuarioPermissaoMapEntity;
    }

    public PessoaEntity getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(PessoaEntity idPessoa) {
        this.idPessoa = idPessoa;
    }

    public UsuarioStatusEntity getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(UsuarioStatusEntity idStatus) {
        this.idStatus = idStatus;
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
        if (!(object instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity other = (UsuarioEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.UsuarioEntity[ id=" + id + " ]";
    }
    
}
