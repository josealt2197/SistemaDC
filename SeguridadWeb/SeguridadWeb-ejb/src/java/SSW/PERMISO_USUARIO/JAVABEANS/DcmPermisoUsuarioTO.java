/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERMISO_USUARIO.JAVABEANS;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.PANTALLA.JAVABEANS.DcmPantallaTO;
import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.PRIVLEGIO.JAVABEANS.DcmPrivilegioTO;
import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joma2
 */
@Entity
@Table(name = "DCM_PERMISO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmPermisoUsuarioTO.findAll", query = "SELECT d FROM DcmPermisoUsuarioTO d")
    , @NamedQuery(name = "DcmPermisoUsuarioTO.findByPkIdePermiso", query = "SELECT d FROM DcmPermisoUsuarioTO d WHERE d.pkIdePermiso = :pkIdePermiso")
    , @NamedQuery(name = "DcmPermisoUsuarioTO.findByUsuCreacion", query = "SELECT d FROM DcmPermisoUsuarioTO d WHERE d.usuCreacion = :usuCreacion")
    , @NamedQuery(name = "DcmPermisoUsuarioTO.findByFecCreacion", query = "SELECT d FROM DcmPermisoUsuarioTO d WHERE d.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "DcmPermisoUsuarioTO.findByUsuModifica", query = "SELECT d FROM DcmPermisoUsuarioTO d WHERE d.usuModifica = :usuModifica")
    , @NamedQuery(name = "DcmPermisoUsuarioTO.findByFecModifica", query = "SELECT d FROM DcmPermisoUsuarioTO d WHERE d.fecModifica = :fecModifica")
    , @NamedQuery(name = "DcmUsuarioTO.findMaxPermiso", query = "SELECT max(d.pkIdePermiso) FROM DcmPermisoUsuarioTO d")})

public class DcmPermisoUsuarioTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_PERMISO")
    private Integer pkIdePermiso;
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
    @ManyToOne
    private DcmEstadoTO fkDcmEstado;
    @JoinColumn(name = "FK_DCM_PANTALLA", referencedColumnName = "PK_IDE_PANTALLA")
    @ManyToOne
    private DcmPantallaTO fkDcmPantalla;
    @JoinColumn(name = "FK_DCM_PERFIL", referencedColumnName = "PK_IDE_PERFIL")
    @ManyToOne
    private DcmPerfilUsuarioTO fkDcmPerfil;
    @JoinColumn(name = "FK_DCM_PRIVILEGIO", referencedColumnName = "PK_IDE_PRIVILEGIO")
    @ManyToOne
    private DcmPrivilegioTO fkDcmPrivilegio;
    @JoinColumn(name = "FK_DCM_SISTEMA", referencedColumnName = "PK_IDE_SISTEMA")
    @ManyToOne
    private DcmSistemaTO fkDcmSistema;

    public DcmPermisoUsuarioTO() {
    }

    public DcmPermisoUsuarioTO(int pkIdePermiso) {
        this.pkIdePermiso = pkIdePermiso;
    }

    public int getPkIdePermiso() {
        return pkIdePermiso;
    }

    public void setPkIdePermiso(int pkIdePermiso) {
        this.pkIdePermiso = pkIdePermiso;
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

    public DcmPantallaTO getFkDcmPantalla() {
        return fkDcmPantalla;
    }

    public void setFkDcmPantalla(DcmPantallaTO fkDcmPantalla) {
        this.fkDcmPantalla = fkDcmPantalla;
    }

    public DcmPerfilUsuarioTO getFkDcmPerfil() {
        return fkDcmPerfil;
    }

    public void setFkDcmPerfil(DcmPerfilUsuarioTO fkDcmPerfil) {
        this.fkDcmPerfil = fkDcmPerfil;
    }

    public DcmPrivilegioTO getFkDcmPrivilegio() {
        return fkDcmPrivilegio;
    }

    public void setFkDcmPrivilegio(DcmPrivilegioTO fkDcmPrivilegio) {
        this.fkDcmPrivilegio = fkDcmPrivilegio;
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
        hash += (pkIdePermiso != null ? pkIdePermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmPermisoUsuarioTO)) {
            return false;
        }
        DcmPermisoUsuarioTO other = (DcmPermisoUsuarioTO) object;
        if ((this.pkIdePermiso == null && other.pkIdePermiso != null) || (this.pkIdePermiso != null && !this.pkIdePermiso.equals(other.pkIdePermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO[ pkIdePermiso=" + pkIdePermiso + " ]";
    }

}
