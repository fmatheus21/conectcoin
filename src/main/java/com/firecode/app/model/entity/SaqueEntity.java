package com.firecode.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "saque", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class SaqueEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_solicitado", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorSolicitado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_solicitacao", nullable = false)
    private LocalDateTime dataSolicitacao;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_recebimento", nullable = false, length = 45)
    private String tipoRecebimento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_desconto", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorDesconto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_saque", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorSaque;

    @JoinColumn(name = "id_conta", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ContaEntity contaEntity;

    @JoinColumn(name = "id_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SaqueStatusEntity idStatus;

    public SaqueEntity() {
    }

    public SaqueEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigDecimal valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getTipoRecebimento() {
        return tipoRecebimento;
    }

    public void setTipoRecebimento(String tipoRecebimento) {
        this.tipoRecebimento = tipoRecebimento;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorSaque() {
        return valorSaque;
    }

    public void setValorSaque(BigDecimal valorSaque) {
        this.valorSaque = valorSaque;
    }

    public ContaEntity getContaEntity() {
        return contaEntity;
    }

    public void setContaEntity(ContaEntity contaEntity) {
        this.contaEntity = contaEntity;
    }

    public SaqueStatusEntity getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(SaqueStatusEntity idStatus) {
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
        if (!(object instanceof SaqueEntity)) {
            return false;
        }
        SaqueEntity other = (SaqueEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SaqueEntity[ id=" + id + " ]";
    }

}
