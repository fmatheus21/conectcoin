package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "usuario", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pessoa"}),
    @UniqueConstraint(columnNames = {"usuario"}),
    @UniqueConstraint(columnNames = {"id"})})

public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario", nullable = false, length = 45)
    private String usuario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "avatar", nullable = false, length = 30)
    private String avatar;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnalista")
    private Collection<SuporteAnaliseEntity> suporteAnaliseEntityCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private UsuarioPermissaoMapEntity usuarioPermissaoMapEntity;

    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PessoaEntity pessoaEntity;

    @JoinColumn(name = "id_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioStatusEntity usuarioStatusEntity;

    @JoinTable(name = "usuario_permissao_map", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_permissao"))
    @ManyToMany(fetch = FetchType.EAGER)
    private List<PermissaoEntity> permissoes;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer id) {
        this.id = id;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Collection<SuporteAnaliseEntity> getSuporteAnaliseEntityCollection() {
        return suporteAnaliseEntityCollection;
    }

    public void setSuporteAnaliseEntityCollection(Collection<SuporteAnaliseEntity> suporteAnaliseEntityCollection) {
        this.suporteAnaliseEntityCollection = suporteAnaliseEntityCollection;
    }

    public UsuarioPermissaoMapEntity getUsuarioPermissaoMapEntity() {
        return usuarioPermissaoMapEntity;
    }

    public void setUsuarioPermissaoMapEntity(UsuarioPermissaoMapEntity usuarioPermissaoMapEntity) {
        this.usuarioPermissaoMapEntity = usuarioPermissaoMapEntity;
    }

    public PessoaEntity getPessoaEntity() {
        return pessoaEntity;
    }

    public void setPessoaEntity(PessoaEntity pessoaEntity) {
        this.pessoaEntity = pessoaEntity;
    }

    public UsuarioStatusEntity getUsuarioStatusEntity() {
        return usuarioStatusEntity;
    }

    public void setUsuarioStatusEntity(UsuarioStatusEntity usuarioStatusEntity) {
        this.usuarioStatusEntity = usuarioStatusEntity;
    }

    public List<PermissaoEntity> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<PermissaoEntity> permissoes) {
        this.permissoes = permissoes;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.UsuarioEntity[ id=" + id + " ]";
    }

}
