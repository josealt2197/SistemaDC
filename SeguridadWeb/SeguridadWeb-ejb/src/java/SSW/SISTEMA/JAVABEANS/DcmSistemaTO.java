/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.SISTEMA.JAVABEANS;

import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "DCM_SISTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmSistemaTO.findAll", query = "SELECT d FROM DcmSistemaTO d")
    , @NamedQuery(name = "DcmSistemaTO.findByPkIdeSistema", query = "SELECT d FROM DcmSistemaTO d WHERE d.pkIdeSistema = :pkIdeSistema")
    , @NamedQuery(name = "DcmSistemaTO.findByNomSistema", query = "SELECT d FROM DcmSistemaTO d WHERE d.nomSistema = :nomSistema")
    , @NamedQuery(name = "DcmSistemaTO.findByUsuCreacion", query = "SELECT d FROM DcmSistemaTO d WHERE d.usuCreacion = :usuCreacion")
    , @NamedQuery(name = "DcmSistemaTO.findByFecCreacion", query = "SELECT d FROM DcmSistemaTO d WHERE d.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "DcmSistemaTO.findByUsuModifica", query = "SELECT d FROM DcmSistemaTO d WHERE d.usuModifica = :usuModifica")
    , @NamedQuery(name = "DcmSistemaTO.findByFecModifica", query = "SELECT d FROM DcmSistemaTO d WHERE d.fecModifica = :fecModifica")})
public class DcmSistemaTO implements Serializable {

    @OneToMany(mappedBy = "fkDcmSistema")
    private Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDcmSistema")
    private Collection<DcmPerfilUsuarioTO> dcmPerfilUsuarioTOCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_SISTEMA")
    private Integer pkIdeSistema;
    @Size(max = 50)
    @Column(name = "NOM_SISTEMA")
    private String nomSistema;
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

    public DcmSistemaTO() {
    }

    public DcmSistemaTO(int pkIdeSistema) {
        this.pkIdeSistema = pkIdeSistema;
    }

    public int getPkIdeSistema() {
        return pkIdeSistema;
    }

    public void setPkIdeSistema(int pkIdeSistema) {
        this.pkIdeSistema = pkIdeSistema;
    }

    public String getNomSistema() {
        return nomSistema;
    }

    public void setNomSistema(String nomSistema) {
        this.nomSistema = nomSistema;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdeSistema != null ? pkIdeSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmSistemaTO)) {
            return false;
        }
        DcmSistemaTO other = (DcmSistemaTO) object;
        if ((this.pkIdeSistema == null && other.pkIdeSistema != null) || (this.pkIdeSistema != null && !this.pkIdeSistema.equals(other.pkIdeSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.SISTEMA.JAVABEANS.DcmSistemaTO[ pkIdeSistema=" + pkIdeSistema + " ]";
    }

    @XmlTransient
    public Collection<DcmPerfilUsuarioTO> getDcmPerfilUsuarioTOCollection() {
        return dcmPerfilUsuarioTOCollection;
    }

    public void setDcmPerfilUsuarioTOCollection(Collection<DcmPerfilUsuarioTO> dcmPerfilUsuarioTOCollection) {
        this.dcmPerfilUsuarioTOCollection = dcmPerfilUsuarioTOCollection;
    }

    @XmlTransient
    public Collection<DcmPermisoUsuarioTO> getDcmPermisoUsuarioTOCollection() {
        return dcmPermisoUsuarioTOCollection;
    }

    public void setDcmPermisoUsuarioTOCollection(Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection) {
        this.dcmPermisoUsuarioTOCollection = dcmPermisoUsuarioTOCollection;
    }
    
}
