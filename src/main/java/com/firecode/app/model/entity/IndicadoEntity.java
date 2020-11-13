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

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "indicado", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"id_investidor"})})
@NamedQueries({
    @NamedQuery(name = "IndicadoEntity.findAll", query = "SELECT i FROM IndicadoEntity i"),
    @NamedQuery(name = "IndicadoEntity.findById", query = "SELECT i FROM IndicadoEntity i WHERE i.id = :id")})
public class IndicadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_equipe", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private EquipeEntity idEquipe;
    @JoinColumn(name = "id_investidor", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private InvestidorEntity idInvestidor;
    @JoinColumn(name = "id_patrocinador", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private InvestidorEntity idPatrocinador;

    public IndicadoEntity() {
    }

    public IndicadoEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EquipeEntity getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(EquipeEntity idEquipe) {
        this.idEquipe = idEquipe;
    }

    public InvestidorEntity getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(InvestidorEntity idInvestidor) {
        this.idInvestidor = idInvestidor;
    }

    public InvestidorEntity getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(InvestidorEntity idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
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
        if (!(object instanceof IndicadoEntity)) {
            return false;
        }
        IndicadoEntity other = (IndicadoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.IndicadoEntity[ id=" + id + " ]";
    }
    
}
