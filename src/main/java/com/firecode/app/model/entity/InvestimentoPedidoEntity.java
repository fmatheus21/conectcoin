/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "investimento_pedido", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvestimentoPedidoEntity.findAll", query = "SELECT i FROM InvestimentoPedidoEntity i"),
    @NamedQuery(name = "InvestimentoPedidoEntity.findById", query = "SELECT i FROM InvestimentoPedidoEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InvestimentoPedidoEntity.findByDataSolicitacao", query = "SELECT i FROM InvestimentoPedidoEntity i WHERE i.dataSolicitacao = :dataSolicitacao"),
    @NamedQuery(name = "InvestimentoPedidoEntity.findByValor", query = "SELECT i FROM InvestimentoPedidoEntity i WHERE i.valor = :valor"),
    @NamedQuery(name = "InvestimentoPedidoEntity.findByPontos", query = "SELECT i FROM InvestimentoPedidoEntity i WHERE i.pontos = :pontos"),
    @NamedQuery(name = "InvestimentoPedidoEntity.findByQuantidade", query = "SELECT i FROM InvestimentoPedidoEntity i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "InvestimentoPedidoEntity.findByDataExpiracao", query = "SELECT i FROM InvestimentoPedidoEntity i WHERE i.dataExpiracao = :dataExpiracao")})
public class InvestimentoPedidoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_solicitacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSolicitacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pontos", nullable = false)
    private int pontos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_expiracao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;
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

    public InvestimentoPedidoEntity(Integer id, Date dataSolicitacao, BigDecimal valor, int pontos, int quantidade, Date dataExpiracao) {
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
        this.valor = valor;
        this.pontos = pontos;
        this.quantidade = quantidade;
        this.dataExpiracao = dataExpiracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
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

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestimentoPedidoEntity[ id=" + id + " ]";
    }
    
}
