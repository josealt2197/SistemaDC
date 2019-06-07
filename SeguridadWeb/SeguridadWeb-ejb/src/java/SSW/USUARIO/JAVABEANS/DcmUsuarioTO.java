/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.USUARIO.JAVABEANS;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
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
@Table(name = "DCM_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmUsuarioTO.findAll", query = "SELECT d FROM DcmUsuarioTO d")
    , @NamedQuery(name = "DcmUsuarioTO.findByPkIdeFuncionario", query = "SELECT d FROM DcmUsuarioTO d WHERE d.pkIdeFuncionario = :pkIdeFuncionario")
    , @NamedQuery(name = "DcmUsuarioTO.findByNomFuncionarios", query = "SELECT d FROM DcmUsuarioTO d WHERE d.nomFuncionarios = :nomFuncionarios")
    , @NamedQuery(name = "DcmUsuarioTO.findByNomUsuario", query = "SELECT d FROM DcmUsuarioTO d WHERE d.nomUsuario = :nomUsuario")
    , @NamedQuery(name = "DcmUsuarioTO.findByUsuCreacion", query = "SELECT d FROM DcmUsuarioTO d WHERE d.usuCreacion = :usuCreacion")
    , @NamedQuery(name = "DcmUsuarioTO.findByFecCreacion", query = "SELECT d FROM DcmUsuarioTO d WHERE d.fecCreacion = :fecCreacion")
    , @NamedQuery(name = "DcmUsuarioTO.findByUsuModifica", query = "SELECT d FROM DcmUsuarioTO d WHERE d.usuModifica = :usuModifica")
    , @NamedQuery(name = "DcmUsuarioTO.findByFecModifica", query = "SELECT d FROM DcmUsuarioTO d WHERE d.fecModifica = :fecModifica")
    , @NamedQuery(name = "DcmUsuarioTO.findMaxUsuario", query = "SELECT max(d.pkIdeFuncionario) FROM DcmUsuarioTO d")})

public class DcmUsuarioTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_FUNCIONARIO")
    private Integer pkIdeFuncionario;
    @Size(max = 50)
    @Column(name = "NOM_FUNCIONARIOS")
    private String nomFuncionarios;
    @Size(max = 50)
    @Column(name = "NOM_USUARIO")
    private String nomUsuario;
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
    @JoinColumn(name = "FK_DCM_PERFIL", referencedColumnName = "PK_IDE_PERFIL")
    @ManyToOne
    private DcmPerfilUsuarioTO fkDcmPerfil;

    public DcmUsuarioTO() {
    }

    public DcmUsuarioTO(int pkIdeFuncionario) {
        this.pkIdeFuncionario = pkIdeFuncionario;
    }

    public int getPkIdeFuncionario() {
        return pkIdeFuncionario;
    }

    public void setPkIdeFuncionario(int pkIdeFuncionario) {
        this.pkIdeFuncionario = pkIdeFuncionario;
    }

    public String getNomFuncionarios() {
        return nomFuncionarios;
    }

    public void setNomFuncionarios(String nomFuncionarios) {
        this.nomFuncionarios = nomFuncionarios;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
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

    public DcmPerfilUsuarioTO getFkDcmPerfil() {
        return fkDcmPerfil;
    }

    public void setFkDcmPerfil(DcmPerfilUsuarioTO fkDcmPerfil) {
        this.fkDcmPerfil = fkDcmPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdeFuncionario != null ? pkIdeFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmUsuarioTO)) {
            return false;
        }
        DcmUsuarioTO other = (DcmUsuarioTO) object;
        if ((this.pkIdeFuncionario == null && other.pkIdeFuncionario != null) || (this.pkIdeFuncionario != null && !this.pkIdeFuncionario.equals(other.pkIdeFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.USUARIO.JAVABEANS.DcmUsuarioTO[ pkIdeFuncionario=" + pkIdeFuncionario + " ]";
    }

}
