/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "processo_sistema", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessoSistemaEntity.findAll", query = "SELECT p FROM ProcessoSistemaEntity p"),
    @NamedQuery(name = "ProcessoSistemaEntity.findById", query = "SELECT p FROM ProcessoSistemaEntity p WHERE p.id = :id"),
    @NamedQuery(name = "ProcessoSistemaEntity.findByDataProcesso", query = "SELECT p FROM ProcessoSistemaEntity p WHERE p.dataProcesso = :dataProcesso")})
public class ProcessoSistemaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_processo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataProcesso;

    public ProcessoSistemaEntity() {
    }

    public ProcessoSistemaEntity(Integer id) {
        this.id = id;
    }

    public ProcessoSistemaEntity(Integer id, Date dataProcesso) {
        this.id = id;
        this.dataProcesso = dataProcesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataProcesso() {
        return dataProcesso;
    }

    public void setDataProcesso(Date dataProcesso) {
        this.dataProcesso = dataProcesso;
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
        if (!(object instanceof ProcessoSistemaEntity)) {
            return false;
        }
        ProcessoSistemaEntity other = (ProcessoSistemaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ProcessoSistemaEntity[ id=" + id + " ]";
    }
    
}
