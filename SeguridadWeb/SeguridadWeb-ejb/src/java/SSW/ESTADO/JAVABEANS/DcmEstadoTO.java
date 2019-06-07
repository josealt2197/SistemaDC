/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.ESTADO.JAVABEANS;

import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO;
import SSW.USUARIO.JAVABEANS.DcmUsuarioTO;
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
@Table(name = "DCM_ESTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmEstadoTO.findAll", query = "SELECT d FROM DcmEstadoTO d")
    , @NamedQuery(name = "DcmEstadoTO.findByPkIdeEstado", query = "SELECT d FROM DcmEstadoTO d WHERE d.pkIdeEstado = :pkIdeEstado")
    , @NamedQuery(name = "DcmEstadoTO.findByNomEstado", query = "SELECT d FROM DcmEstadoTO d WHERE d.nomEstado = :nomEstado")
    , @NamedQuery(name = "DcmEstadoTO.findByUsuCreacion", query = "SELECT d FROM DcmEstadoTO d WHERE d.usuCreacion = :usuCreacion")
    , @NamedQuery(name = "DcmEstadoTO.findByFecCreacion", query = "SELECT d FROM DcmEstadoTO d WHERE d.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "DcmEstadoTO.findByUsuModifica", query = "SELECT d FROM DcmEstadoTO d WHERE d.usuModifica = :usuModifica")
    , @NamedQuery(name = "DcmEstadoTO.findByFecModifica", query = "SELECT d FROM DcmEstadoTO d WHERE d.fecModifica = :fecModifica")})
public class DcmEstadoTO implements Serializable {

    @OneToMany(mappedBy = "fkDcmEstado")
    private Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection;

    @OneToMany(mappedBy = "fkDcmEstado")
    private Collection<DcmUsuarioTO> dcmUsuarioTOCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDcmEstado")
    private Collection<DcmPerfilUsuarioTO> dcmPerfilUsuarioTOCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_ESTADO")
    private Integer pkIdeEstado;
    @Size(max = 50)
    @Column(name = "NOM_ESTADO")
    private String nomEstado;
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

    public DcmEstadoTO() {
    }

    public DcmEstadoTO(int pkIdeEstado) {
        this.pkIdeEstado = pkIdeEstado;
    }

    public int getPkIdeEstado() {
        return pkIdeEstado;
    }

    public void setPkIdeEstado(int pkIdeEstado) {
        this.pkIdeEstado = pkIdeEstado;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
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
        hash += (pkIdeEstado != null ? pkIdeEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmEstadoTO)) {
            return false;
        }
        DcmEstadoTO other = (DcmEstadoTO) object;
        if ((this.pkIdeEstado == null && other.pkIdeEstado != null) || (this.pkIdeEstado != null && !this.pkIdeEstado.equals(other.pkIdeEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.ESTADO.JAVABEANS.DcmEstadoTO[ pkIdeEstado=" + pkIdeEstado + " ]";
    }

    @XmlTransient
    public Collection<DcmPerfilUsuarioTO> getDcmPerfilUsuarioTOCollection() {
        return dcmPerfilUsuarioTOCollection;
    }

    public void setDcmPerfilUsuarioTOCollection(Collection<DcmPerfilUsuarioTO> dcmPerfilUsuarioTOCollection) {
        this.dcmPerfilUsuarioTOCollection = dcmPerfilUsuarioTOCollection;
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
