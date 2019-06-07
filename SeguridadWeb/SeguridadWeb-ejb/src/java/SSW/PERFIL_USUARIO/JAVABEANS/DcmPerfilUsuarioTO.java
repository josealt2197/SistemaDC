/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERFIL_USUARIO.JAVABEANS;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO;
import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import SSW.USUARIO.JAVABEANS.DcmUsuarioTO;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joma2
 */
@Entity
@Table(name = "DCM_PERFIL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmPerfilUsuarioTO.findAll", query = "SELECT d FROM DcmPerfilUsuarioTO d")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.findByPkIdePerfil", query = "SELECT d FROM DcmPerfilUsuarioTO d WHERE d.pkIdePerfil = :pkIdePerfil")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.findByNomPerfil", query = "SELECT d FROM DcmPerfilUsuarioTO d WHERE d.nomPerfil = :nomPerfil")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.findByUsuCreacion", query = "SELECT d FROM DcmPerfilUsuarioTO d WHERE d.usuCreacion = :usuCreacion")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.findByFecCreacion", query = "SELECT d FROM DcmPerfilUsuarioTO d WHERE d.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.findByUsuModifica", query = "SELECT d FROM DcmPerfilUsuarioTO d WHERE d.usuModifica = :usuModifica")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.findByFecModifica", query = "SELECT d FROM DcmPerfilUsuarioTO d WHERE d.fecModifica = :fecModifica")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.findMaxPerfil", query = "SELECT max(d.pkIdePerfil) FROM DcmPerfilUsuarioTO d")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.findBySistema", query = "SELECT d FROM DcmPerfilUsuarioTO d WHERE  d.nomPerfil = :nomPerfil AND d.fkDcmSistema = :fkDcmSistema")
    , @NamedQuery(name = "DcmPerfilUsuarioTO.listBySistema", query = "SELECT d FROM DcmPerfilUsuarioTO d WHERE  d.fkDcmSistema = :fkDcmSistema")})

public class DcmPerfilUsuarioTO implements Serializable {

    @OneToMany(mappedBy = "fkDcmPerfil")
    private Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection;

    @OneToMany(mappedBy = "fkDcmPerfil")
    private Collection<DcmUsuarioTO> dcmUsuarioTOCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_PERFIL")
    private Integer pkIdePerfil;
    @Size(max = 50)
    @Column(name = "NOM_PERFIL")
    private String nomPerfil;
    @Size(max = 20)
    @Column(name = "USU_CREACION")
    private String usuCreacion;
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;
    @Size(max = 20)
    @Column(name = "USU_MODIFICA")
    private String usuModifica;
    @Column(name = "FEC_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModifica;
    @JoinColumn(name = "FK_DCM_ESTADO", referencedColumnName = "PK_IDE_ESTADO")
    @ManyToOne(optional = false)
    private DcmEstadoTO fkDcmEstado;
    @JoinColumn(name = "FK_DCM_SISTEMA", referencedColumnName = "PK_IDE_SISTEMA")
    @ManyToOne(optional = false)
    private DcmSistemaTO fkDcmSistema;

    public DcmPerfilUsuarioTO() {
    }

    public DcmPerfilUsuarioTO(int pkIdePerfil) {
        this.pkIdePerfil = pkIdePerfil;
    }

    public int getPkIdePerfil() {
        return pkIdePerfil;
    }

    public void setPkIdePerfil(int pkIdePerfil) {
        this.pkIdePerfil = pkIdePerfil;
    }

    public String getNomPerfil() {
        return nomPerfil;
    }

    public void setNomPerfil(String nomPerfil) {
        this.nomPerfil = nomPerfil;
    }

    public String getUsuCreacion() {
        return usuCreacion;
    }

    public void setUsuCreacion(String usuCreacion) {
        this.usuCreacion = usuCreacion;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public String getUsuModifica() {
        return usuModifica;
    }

    public void setUsuModifica(String usuModifica) {
        this.usuModifica = usuModifica;
    }

    public Date getFecModifica() {
        return fecModifica;
    }

    public void setFecModifica(Date fecModifica) {
        this.fecModifica = fecModifica;
    }

    public DcmEstadoTO getFkDcmEstado() {
        return fkDcmEstado;
    }

    public void setFkDcmEstado(DcmEstadoTO fkDcmEstado) {
        this.fkDcmEstado = fkDcmEstado;
    }

    public DcmSistemaTO getFkDcmSistema() {
        return fkDcmSistema;
    }

    public void setFkDcmSistema(DcmSistemaTO fkDcmSistema) {
        this.fkDcmSistema = fkDcmSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdePerfil != null ? pkIdePerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmPerfilUsuarioTO)) {
            return false;
        }
        DcmPerfilUsuarioTO other = (DcmPerfilUsuarioTO) object;
        if ((this.pkIdePerfil == null && other.pkIdePerfil != null) || (this.pkIdePerfil != null && !this.pkIdePerfil.equals(other.pkIdePerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO[ pkIdePerfil=" + pkIdePerfil + " ]";
    }

    @XmlTransient
    public Collection<DcmUsuarioTO> getDcmUsuarioTOCollection() {
        return dcmUsuarioTOCollection;
    }

    public void setDcmUsuarioTOCollection(Collection<DcmUsuarioTO> dcmUsuarioTOCollection) {
        this.dcmUsuarioTOCollection = dcmUsuarioTOCollection;
    }

    @XmlTransient
    public Collection<DcmPermisoUsuarioTO> getDcmPermisoUsuarioTOCollection() {
        return dcmPermisoUsuarioTOCollection;
    }

    public void setDcmPermisoUsuarioTOCollection(Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection) {
        this.dcmPermisoUsuarioTOCollection = dcmPermisoUsuarioTOCollection;
    }

}
