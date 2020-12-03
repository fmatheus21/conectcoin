package com.firecode.app.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "suporte", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class SuporteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "departamento", nullable = false, length = 45)
    private String departamento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "assunto", nullable = false, length = 50)
    private String assunto;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao", nullable = false, length = 2147483647)
    private String descricao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClienteEntity clienteEntity;

    @JoinColumn(name = "id_status", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private SuporteStatusEntity suporteStatusEntity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idSuporte")
    private SuporteAnaliseEntity suporteAnaliseEntity;

    public SuporteEntity() {
    }

    public SuporteEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public SuporteStatusEntity getSuporteStatusEntity() {
        return suporteStatusEntity;
    }

    public void setSuporteStatusEntity(SuporteStatusEntity suporteStatusEntity) {
        this.suporteStatusEntity = suporteStatusEntity;
    }

    public SuporteAnaliseEntity getSuporteAnaliseEntity() {
        return suporteAnaliseEntity;
    }

    public void setSuporteAnaliseEntity(SuporteAnaliseEntity suporteAnaliseEntity) {
        this.suporteAnaliseEntity = suporteAnaliseEntity;
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
        if (!(object instanceof SuporteEntity)) {
            return false;
        }
        SuporteEntity other = (SuporteEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SuporteEntity[ id=" + id + " ]";
    }

}
