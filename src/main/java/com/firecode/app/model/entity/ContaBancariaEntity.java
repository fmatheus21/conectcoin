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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "conta_bancaria", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cliente"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContaBancariaEntity.findAll", query = "SELECT c FROM ContaBancariaEntity c"),
    @NamedQuery(name = "ContaBancariaEntity.findById", query = "SELECT c FROM ContaBancariaEntity c WHERE c.id = :id"),
    @NamedQuery(name = "ContaBancariaEntity.findByAgencia", query = "SELECT c FROM ContaBancariaEntity c WHERE c.agencia = :agencia"),
    @NamedQuery(name = "ContaBancariaEntity.findByNumero", query = "SELECT c FROM ContaBancariaEntity c WHERE c.numero = :numero")})
public class ContaBancariaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "agencia", nullable = false, length = 15)
    private String agencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero", nullable = false, length = 15)
    private String numero;
    @JoinColumn(name = "id_banco", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private BancoEntity idBanco;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private ClienteEntity idCliente;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ContaBancariaTipoEntity idTipo;

    public ContaBancariaEntity() {
    }

    public ContaBancariaEntity(Integer id) {
        this.id = id;
    }

    public ContaBancariaEntity(Integer id, String agencia, String numero) {
        this.id = id;
        this.agencia = agencia;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BancoEntity getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(BancoEntity idBanco) {
        this.idBanco = idBanco;
    }

    public ClienteEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteEntity idCliente) {
        this.idCliente = idCliente;
    }

    public ContaBancariaTipoEntity getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(ContaBancariaTipoEntity idTipo) {
        this.idTipo = idTipo;
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
