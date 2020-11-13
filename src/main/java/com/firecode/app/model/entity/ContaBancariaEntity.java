/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "conta_bancaria", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"id_investidor"})})
@NamedQueries({
    @NamedQuery(name = "ContaBancariaEntity.findAll", query = "SELECT c FROM ContaBancariaEntity c"),
    @NamedQuery(name = "ContaBancariaEntity.findById", query = "SELECT c FROM ContaBancariaEntity c WHERE c.id = :id"),
    @NamedQuery(name = "ContaBancariaEntity.findByBanco", query = "SELECT c FROM ContaBancariaEntity c WHERE c.banco = :banco"),
    @NamedQuery(name = "ContaBancariaEntity.findByAgencia", query = "SELECT c FROM ContaBancariaEntity c WHERE c.agencia = :agencia"),
    @NamedQuery(name = "ContaBancariaEntity.findByNumeroConta", query = "SELECT c FROM ContaBancariaEntity c WHERE c.numeroConta = :numeroConta"),
    @NamedQuery(name = "ContaBancariaEntity.findByTipoConta", query = "SELECT c FROM ContaBancariaEntity c WHERE c.tipoConta = :tipoConta")})
public class ContaBancariaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "banco", length = 50)
    private String banco;
    @Column(name = "agencia", length = 10)
    private String agencia;
    @Column(name = "numero_conta", length = 20)
    private String numeroConta;
    @Column(name = "tipo_conta", length = 45)
    private String tipoConta;
    @JoinColumn(name = "id_investidor", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private InvestidorEntity idInvestidor;

    public ContaBancariaEntity() {
    }

    public ContaBancariaEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public InvestidorEntity getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(InvestidorEntity idInvestidor) {
        this.idInvestidor = idInvestidor;
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
        if (!(object instanceof ContaBancariaEntity)) {
            return false;
        }
        ContaBancariaEntity other = (ContaBancariaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ContaBancariaEntity[ id=" + id + " ]";
    }
    
}
