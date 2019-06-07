/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERMISO_USUARIO_HIST.JAVABEANS;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joma2
 */
@Entity
@Table(name = "DCM_PERMISO_USUARIO_HIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmPermisoUsuarioHistTO.findAll", query = "SELECT d FROM DcmPermisoUsuarioHistTO d")
    , @NamedQuery(name = "DcmPermisoUsuarioHistTO.findByPkIdePerfilHist", query = "SELECT d FROM DcmPermisoUsuarioHistTO d WHERE d.pkIdePerfilHist = :pkIdePerfilHist")})
public class DcmPermisoUsuarioHistTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_PERFIL_HIST")
    private Short pkIdePerfilHist;

    public DcmPermisoUsuarioHistTO() {
    }

    public DcmPermisoUsuarioHistTO(Short pkIdePerfilHist) {
        this.pkIdePerfilHist = pkIdePerfilHist;
    }

    public Short getPkIdePerfilHist() {
        return pkIdePerfilHist;
    }

    public void setPkIdePerfilHist(Short pkIdePerfilHist) {
        this.pkIdePerfilHist = pkIdePerfilHist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdePerfilHist != null ? pkIdePerfilHist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmPermisoUsuarioHistTO)) {
            return false;
        }
        DcmPermisoUsuarioHistTO other = (DcmPermisoUsuarioHistTO) object;
        if ((this.pkIdePerfilHist == null && other.pkIdePerfilHist != null) || (this.pkIdePerfilHist != null && !this.pkIdePerfilHist.equals(other.pkIdePerfilHist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.PERMISO_USUARIO_HIST.JAVABEANS.DcmPermisoUsuarioHistTO[ pkIdePerfilHist=" + pkIdePerfilHist + " ]";
    }
    
}
