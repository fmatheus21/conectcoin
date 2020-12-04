package com.firecode.app.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "suporte_analise", catalog = "conectcoin", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_suporte"}),
    @UniqueConstraint(columnNames = {"id"})})

public class SuporteAnaliseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Lob
    @Column(name = "resposta", nullable = false, length = 2147483647)
    private String resposta;

    @Basic(optional = false)
    @Column(name = "data_analise", nullable = false)
    private LocalDateTime dataAnalise;

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

    public LocalDateTime getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDateTime dataAnalise) {
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SuporteAnaliseEntity[ id=" + id + " ]";
    }

}
