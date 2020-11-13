/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
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
@Table(name = "investidor", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pessoa"}),
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "InvestidorEntity.findAll", query = "SELECT i FROM InvestidorEntity i"),
    @NamedQuery(name = "InvestidorEntity.findById", query = "SELECT i FROM InvestidorEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InvestidorEntity.findByDataNascimento", query = "SELECT i FROM InvestidorEntity i WHERE i.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "InvestidorEntity.findByDataCadastro", query = "SELECT i FROM InvestidorEntity i WHERE i.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "InvestidorEntity.findByDataAlteracao", query = "SELECT i FROM InvestidorEntity i WHERE i.dataAlteracao = :dataAlteracao")})
public class InvestidorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "data_cadastro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Basic(optional = false)
    @Column(name = "data_alteracao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idInvestidor")
    private ContaBancariaEntity contaBancariaEntity;
    @JoinColumn(name = "id_genero", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private GeneroEntity idGenero;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PessoaEntity idPessoa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private PagamentoMenorEquipeEntity pagamentoMenorEquipeEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idInvestidor")
    private SaldoEntity saldoEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private Collection<InvestimentoEntity> investimentoEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInvestidor")
    private Collection<InvestimentoEntity> investimentoEntityCollection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idInvestidor")
    private IndicadoEntity indicadoEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private Collection<IndicadoEntity> indicadoEntityCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idInvestidor")
    private PontuacaoEntity pontuacaoEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPatrocinador")
    private Collection<InvestimentoPagamentoEntity> investimentoPagamentoEntityCollection;

    public InvestidorEntity() {
    }

    public InvestidorEntity(Integer id) {
        this.id = id;
    }

    public InvestidorEntity(Integer id, Date dataNascimento, Date dataCadastro, Date dataAlteracao) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public ContaBancariaEntity getContaBancariaEntity() {
        return contaBancariaEntity;
    }

    public void setContaBancariaEntity(ContaBancariaEntity contaBancariaEntity) {
        this.contaBancariaEntity = contaBancariaEntity;
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

    public PagamentoMenorEquipeEntity getPagamentoMenorEquipeEntity() {
        return pagamentoMenorEquipeEntity;
    }

    public void setPagamentoMenorEquipeEntity(PagamentoMenorEquipeEntity pagamentoMenorEquipeEntity) {
        this.pagamentoMenorEquipeEntity = pagamentoMenorEquipeEntity;
    }

    public SaldoEntity getSaldoEntity() {
        return saldoEntity;
    }

    public void setSaldoEntity(SaldoEntity saldoEntity) {
        this.saldoEntity = saldoEntity;
    }

    public Collection<InvestimentoEntity> getInvestimentoEntityCollection() {
        return investimentoEntityCollection;
    }

    public void setInvestimentoEntityCollection(Collection<InvestimentoEntity> investimentoEntityCollection) {
        this.investimentoEntityCollection = investimentoEntityCollection;
    }

    public Collection<InvestimentoEntity> getInvestimentoEntityCollection1() {
        return investimentoEntityCollection1;
    }

    public void setInvestimentoEntityCollection1(Collection<InvestimentoEntity> investimentoEntityCollection1) {
        this.investimentoEntityCollection1 = investimentoEntityCollection1;
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

    public Collection<InvestimentoPagamentoEntity> getInvestimentoPagamentoEntityCollection() {
        return investimentoPagamentoEntityCollection;
    }

    public void setInvestimentoPagamentoEntityCollection(Collection<InvestimentoPagamentoEntity> investimentoPagamentoEntityCollection) {
        this.investimentoPagamentoEntityCollection = investimentoPagamentoEntityCollection;
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
        if (!(object instanceof InvestidorEntity)) {
            return false;
        }
        InvestidorEntity other = (InvestidorEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.InvestidorEntity[ id=" + id + " ]";
    }
    
}
