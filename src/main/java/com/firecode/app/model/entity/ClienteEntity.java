package com.firecode.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

@Entity
@Table(name = "cliente", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pessoa"}),
    @UniqueConstraint(columnNames = {"id"})})

public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Basic(optional = false)
    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime dataAlteracao;

    @Basic(optional = false)
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private ContaBancariaEntity contaBancariaEntity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private ContaEntity contaEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<SuporteEntity> suporteEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<InvestimentoPedidoEntity> investimentoPedidoEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private Collection<InvestimentoPedidoEntity> investimentoPedidoEntityCollection1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private Collection<InvestimentoPagamentoEntity> investimentoPagamentoEntityCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private IndicadoEntity indicadoEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private Collection<IndicadoEntity> indicadoEntityCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private PontuacaoEntity pontuacaoEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private Collection<ClienteEntity> clienteEntityCollection;

    @JoinColumn(name = "id_patrocinador", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClienteEntity idPatrocinador;

    @JoinColumn(name = "id_genero", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private GeneroEntity idGenero;

    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PessoaEntity idPessoa;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private PagamentoEquipeEntity pagamentoEquipeEntity;

    public ClienteEntity() {
    }

    public ClienteEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ContaBancariaEntity getContaBancariaEntity() {
        return contaBancariaEntity;
    }

    public void setContaBancariaEntity(ContaBancariaEntity contaBancariaEntity) {
        this.contaBancariaEntity = contaBancariaEntity;
    }

    public ContaEntity getContaEntity() {
        return contaEntity;
    }

    public void setContaEntity(ContaEntity contaEntity) {
        this.contaEntity = contaEntity;
    }

    public Collection<SuporteEntity> getSuporteEntityCollection() {
        return suporteEntityCollection;
    }

    public void setSuporteEntityCollection(Collection<SuporteEntity> suporteEntityCollection) {
        this.suporteEntityCollection = suporteEntityCollection;
    }

    public Collection<InvestimentoPedidoEntity> getInvestimentoPedidoEntityCollection() {
        return investimentoPedidoEntityCollection;
    }

    public void setInvestimentoPedidoEntityCollection(Collection<InvestimentoPedidoEntity> investimentoPedidoEntityCollection) {
        this.investimentoPedidoEntityCollection = investimentoPedidoEntityCollection;
    }

    public Collection<InvestimentoPedidoEntity> getInvestimentoPedidoEntityCollection1() {
        return investimentoPedidoEntityCollection1;
    }

    public void setInvestimentoPedidoEntityCollection1(Collection<InvestimentoPedidoEntity> investimentoPedidoEntityCollection1) {
        this.investimentoPedidoEntityCollection1 = investimentoPedidoEntityCollection1;
    }

    public Collection<InvestimentoPagamentoEntity> getInvestimentoPagamentoEntityCollection() {
        return investimentoPagamentoEntityCollection;
    }

    public void setInvestimentoPagamentoEntityCollection(Collection<InvestimentoPagamentoEntity> investimentoPagamentoEntityCollection) {
        this.investimentoPagamentoEntityCollection = investimentoPagamentoEntityCollection;
    }

    public IndicadoEntity getIndicadoEntity() {
        return indicadoEntity;
    }

    public void setIndicadoEntity(IndicadoEntity indicadoEntity) {
        this.indicadoEntity = indicadoEntity;
    }

    public Collection<IndicadoEntity> getIndicadoEntityCollection() {
        return indicadoEntityCollection;
    }

    public void setIndicadoEntityCollection(Collection<IndicadoEntity> indicadoEntityCollection) {
        this.indicadoEntityCollection = indicadoEntityCollection;
    }

    public PontuacaoEntity getPontuacaoEntity() {
        return pontuacaoEntity;
    }

    public void setPontuacaoEntity(PontuacaoEntity pontuacaoEntity) {
        this.pontuacaoEntity = pontuacaoEntity;
    }

    public Collection<ClienteEntity> getClienteEntityCollection() {
        return clienteEntityCollection;
    }

    public void setClienteEntityCollection(Collection<ClienteEntity> clienteEntityCollection) {
        this.clienteEntityCollection = clienteEntityCollection;
    }

    public ClienteEntity getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(ClienteEntity idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public GeneroEntity getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(GeneroEntity idGenero) {
        this.idGenero = idGenero;
    }

    public PessoaEntity getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(PessoaEntity idPessoa) {
        this.idPessoa = idPessoa;
    }

    public PagamentoEquipeEntity getPagamentoEquipeEntity() {
        return pagamentoEquipeEntity;
    }

    public void setPagamentoEquipeEntity(PagamentoEquipeEntity pagamentoEquipeEntity) {
        this.pagamentoEquipeEntity = pagamentoEquipeEntity;
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
        if (!(object instanceof ClienteEntity)) {
            return false;
        }
        ClienteEntity other = (ClienteEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ClienteEntity[ id=" + id + " ]";
    }

}
