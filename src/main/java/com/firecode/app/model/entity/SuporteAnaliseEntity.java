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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "suporte_analise", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_suporte"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuporteAnaliseEntity.findAll", query = "SELECT s FROM SuporteAnaliseEntity s"),
    @NamedQuery(name = "SuporteAnaliseEntity.findById", query = "SELECT s FROM SuporteAnaliseEntity s WHERE s.id = :id"),
    @NamedQuery(name = "SuporteAnaliseEntity.findByDataAnalise", query = "SELECT s FROM SuporteAnaliseEntity s WHERE s.dataAnalise = :dataAnalise")})
public class SuporteAnaliseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "resposta", nullable = false, length = 2147483647)
    private String resposta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_analise", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAnalise;
    @JoinColumn(name = "id_suporte", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private SuporteEntity idSuporte;
    @JoinColumn(name = "id_analista", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioEntity idAnalista;

    public SuporteAnaliseEntity() {
    }

    public SuporteAnaliseEntity(Integer id) {
        this.id = id;
    }

    public SuporteAnaliseEntity(Integer id, String resposta, Date dataAnalise) {
        this.id = id;
        this.resposta = resposta;
        this.dataAnalise = dataAnalise;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public SuporteEntity getIdSuporte() {
        return idSuporte;
    }

    public void setIdSuporte(SuporteEntity idSuporte) {
        this.idSuporte = idSuporte;
    }

    public UsuarioEntity getIdAnalista() {
        return idAnalista;
    }

    public void setIdAnalista(UsuarioEntity idAnalista) {
        this.idAnalista = idAnalista;
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
        if (!(object instanceof SuporteAnaliseEntity)) {
            return false;
        }
        SuporteAnaliseEntity other = (SuporteAnaliseEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SuporteAnaliseEntity[ id=" + id + " ]";
    }
    
}
