/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PRIVLEGIO.JAVABEANS;

import SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "DCM_PRIVILEGIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmPrivilegioTO.findAll", query = "SELECT d FROM DcmPrivilegioTO d")
    , @NamedQuery(name = "DcmPrivilegioTO.findByPkIdePrivilegio", query = "SELECT d FROM DcmPrivilegioTO d WHERE d.pkIdePrivilegio = :pkIdePrivilegio")
    , @NamedQuery(name = "DcmPrivilegioTO.findByNomPrivilegio", query = "SELECT d FROM DcmPrivilegioTO d WHERE d.nomPrivilegio = :nomPrivilegio")
    , @NamedQuery(name = "DcmPrivilegioTO.findByUsuCreacion", query = "SELECT d FROM DcmPrivilegioTO d WHERE d.usuCreacion = :usuCreacion")
    , @NamedQuery(name = "DcmPrivilegioTO.findByFecCreacion", query = "SELECT d FROM DcmPrivilegioTO d WHERE d.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "DcmPrivilegioTO.findByUsuModifica", query = "SELECT d FROM DcmPrivilegioTO d WHERE d.usuModifica = :usuModifica")
    , @NamedQuery(name = "DcmPrivilegioTO.findByFecModifica", query = "SELECT d FROM DcmPrivilegioTO d WHERE d.fecModifica = :fecModifica")})
public class DcmPrivilegioTO implements Serializable {

    @OneToMany(mappedBy = "fkDcmPrivilegio")
    private Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_PRIVILEGIO")
    private Integer pkIdePrivilegio;
    @Size(max = 50)
    @Column(name = "NOM_PRIVILEGIO")
    private String nomPrivilegio;
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

    public DcmPrivilegioTO() {
    }

    public DcmPrivilegioTO(int pkIdePrivilegio) {
        this.pkIdePrivilegio = pkIdePrivilegio;
    }

    public int getPkIdePrivilegio() {
        return pkIdePrivilegio;
    }

    public void setPkIdePrivilegio(int pkIdePrivilegio) {
        this.pkIdePrivilegio = pkIdePrivilegio;
    }

    public String getNomPrivilegio() {
        return nomPrivilegio;
    }

    public void setNomPrivilegio(String nomPrivilegio) {
        this.nomPrivilegio = nomPrivilegio;
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
        hash += (pkIdePrivilegio != null ? pkIdePrivilegio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmPrivilegioTO)) {
            return false;
        }
        DcmPrivilegioTO other = (DcmPrivilegioTO) object;
        if ((this.pkIdePrivilegio == null && other.pkIdePrivilegio != null) || (this.pkIdePrivilegio != null && !this.pkIdePrivilegio.equals(other.pkIdePrivilegio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.PRIVLEGIO.JAVABEANS.DcmPrivilegioTO[ pkIdePrivilegio=" + pkIdePrivilegio + " ]";
    }

    @XmlTransient
    public Collection<DcmPermisoUsuarioTO> getDcmPermisoUsuarioTOCollection() {
        return dcmPermisoUsuarioTOCollection;
    }

    public void setDcmPermisoUsuarioTOCollection(Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection) {
        this.dcmPermisoUsuarioTOCollection = dcmPermisoUsuarioTOCollection;
    }
    
}
