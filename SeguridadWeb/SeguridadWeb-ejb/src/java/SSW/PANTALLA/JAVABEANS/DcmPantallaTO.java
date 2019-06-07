/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PANTALLA.JAVABEANS;

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
@Table(name = "DCM_PANTALLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmPantallaTO.findAll", query = "SELECT d FROM DcmPantallaTO d")
    , @NamedQuery(name = "DcmPantallaTO.findByPkIdePantalla", query = "SELECT d FROM DcmPantallaTO d WHERE d.pkIdePantalla = :pkIdePantalla")
    , @NamedQuery(name = "DcmPantallaTO.findByNumPantalla", query = "SELECT d FROM DcmPantallaTO d WHERE d.numPantalla = :numPantalla")
    , @NamedQuery(name = "DcmPantallaTO.findByUsuCreacion", query = "SELECT d FROM DcmPantallaTO d WHERE d.usuCreacion = :usuCreacion")
    , @NamedQuery(name = "DcmPantallaTO.findByFecCreacion", query = "SELECT d FROM DcmPantallaTO d WHERE d.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "DcmPantallaTO.findByUsuModifica", query = "SELECT d FROM DcmPantallaTO d WHERE d.usuModifica = :usuModifica")
    , @NamedQuery(name = "DcmPantallaTO.findByFecModifica", query = "SELECT d FROM DcmPantallaTO d WHERE d.fecModifica = :fecModifica")
    , @NamedQuery(name = "DcmPantallaTO.findByNomPantalla", query = "SELECT d FROM DcmPantallaTO d WHERE d.nomPantalla = :nomPantalla")})
public class DcmPantallaTO implements Serializable {

    @OneToMany(mappedBy = "fkDcmPantalla")
    private Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_PANTALLA")
    private Integer pkIdePantalla;
    @Column(name = "NUM_PANTALLA")
    private Short numPantalla;
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
    @Size(max = 50)
    @Column(name = "NOM_PANTALLA")
    private String nomPantalla;

    public DcmPantallaTO() {
    }

    public DcmPantallaTO(int pkIdePantalla) {
        this.pkIdePantalla = pkIdePantalla;
    }

    public int getPkIdePantalla() {
        return pkIdePantalla;
    }

    public void setPkIdePantalla(int pkIdePantalla) {
        this.pkIdePantalla = pkIdePantalla;
    }

    public Short getNumPantalla() {
        return numPantalla;
    }

    public void setNumPantalla(Short numPantalla) {
        this.numPantalla = numPantalla;
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

    public String getNomPantalla() {
        return nomPantalla;
    }

    public void setNomPantalla(String nomPantalla) {
        this.nomPantalla = nomPantalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdePantalla != null ? pkIdePantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmPantallaTO)) {
            return false;
        }
        DcmPantallaTO other = (DcmPantallaTO) object;
        if ((this.pkIdePantalla == null && other.pkIdePantalla != null) || (this.pkIdePantalla != null && !this.pkIdePantalla.equals(other.pkIdePantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.PANTALLA.JAVABEANS.DcmPantallaTO[ pkIdePantalla=" + pkIdePantalla + " ]";
    }

    @XmlTransient
    public Collection<DcmPermisoUsuarioTO> getDcmPermisoUsuarioTOCollection() {
        return dcmPermisoUsuarioTOCollection;
    }

    public void setDcmPermisoUsuarioTOCollection(Collection<DcmPermisoUsuarioTO> dcmPermisoUsuarioTOCollection) {
        this.dcmPermisoUsuarioTOCollection = dcmPermisoUsuarioTOCollection;
    }
    
}
