package com.firecode.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "investimento_pedido", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class InvestimentoPedidoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "data_solicitacao", nullable = false)
    private LocalDateTime dataSolicitacao;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Basic(optional = false)
    @Column(name = "pontos", nullable = false)
    private int pontos;

    @Basic(optional = false)
    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Basic(optional = false)
    @Column(name = "data_expiracao", nullable = false)
    private LocalDate dataExpiracao;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClienteEntity idCliente;

    @JoinColumn(name = "id_patrocinador", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClienteEntity idPatrocinador;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private InvestimentoCategoriaEntity idCategoria;

    @JoinColumn(name = "id_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private InvestimentoStatusEntity idStatus;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idInvestimento")
    private InvestimentoPagamentoEntity investimentoPagamentoEntity;

    public InvestimentoPedidoEntity() {
    }

    public InvestimentoPedidoEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public ClienteEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteEntity idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteEntity getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(ClienteEntity idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public InvestimentoCategoriaEntity getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(InvestimentoCategoriaEntity idCategoria) {
        this.idCategoria = idCategoria;
    }

    public InvestimentoStatusEntity getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(InvestimentoStatusEntity idStatus) {
        this.idStatus = idStatus;
    }

    public InvestimentoPagamentoEntity getInvestimentoPagamentoEntity() {
        return investimentoPagamentoEntity;
    }

    public void setInvestimentoPagamentoEntity(InvestimentoPagamentoEntity investimentoPagamentoEntity) {
        this.investimentoPagamentoEntity = investimentoPagamentoEntity;
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
        if (!(object instanceof InvestimentoPedidoEntity)) {
            return false;
        }
        InvestimentoPedidoEntity other = (InvestimentoPedidoEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestimentoPedidoEntity[ id=" + id + " ]";
    }

}
