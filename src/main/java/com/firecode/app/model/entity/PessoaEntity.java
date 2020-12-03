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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "pessoa", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"cpf_cnpj"})})

public class PessoaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nome_rasaosocial", nullable = false, length = 70)
    private String nomeRasaosocial;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cpf_cnpj", nullable = false, length = 20)
    private String cpfCnpj;

    @JoinColumn(name = "id_tipo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PessoaTipoEntity idTipo;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private ContatoEntity contatoEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaEntity")
    private Collection<EnderecoEntity> enderecoEntityCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private ClienteEntity clienteEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaEntity")
    private Collection<UsuarioEntity> usuarioEntityCollection;

    public PessoaEntity() {
    }

    public PessoaEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeRasaosocial() {
        if (nomeRasaosocial != null) {
            return AppUtil.convertFirstUppercaseCharacter(AppUtil.removeDuplicateSpace(nomeRasaosocial));
        }
        return nomeRasaosocial;
    }

    public void setNomeRasaosocial(String nomeRasaosocial) {
        this.nomeRasaosocial = AppUtil.convertAllUppercaseCharacters(AppUtil.removeDuplicateSpace(nomeRasaosocial));
    }

    public String getCpfCnpj() {
        if (cpfCnpj != null) {
            if (idTipo.getId() == 1) {
                return AppUtil.formatCPF(cpfCnpj);
            } else if (idTipo.getId() == 2) {
                return AppUtil.formatCNPJ(cpfCnpj);
            }
        }
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = AppUtil.removeSpecialCharacters(cpfCnpj);
    }

    public PessoaTipoEntity getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(PessoaTipoEntity idTipo) {
        this.idTipo = idTipo;
    }

    public ContatoEntity getContatoEntity() {
        return contatoEntity;
    }

    public void setContatoEntity(ContatoEntity contatoEntity) {
        this.contatoEntity = contatoEntity;
    }

    @XmlTransient
    public Collection<EnderecoEntity> getEnderecoEntityCollection() {
        return enderecoEntityCollection;
    }

    public void setEnderecoEntityCollection(Collection<EnderecoEntity> enderecoEntityCollection) {
        this.enderecoEntityCollection = enderecoEntityCollection;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    @XmlTransient
    public Collection<UsuarioEntity> getUsuarioEntityCollection() {
        return usuarioEntityCollection;
    }

    public void setUsuarioEntityCollection(Collection<UsuarioEntity> usuarioEntityCollection) {
        this.usuarioEntityCollection = usuarioEntityCollection;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PessoaEntity[ id=" + id + " ]";
    }

}
