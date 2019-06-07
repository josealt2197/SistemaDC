/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERFIL_USUARIO_HIST.JAVABEANS;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joma2
 */
@Entity
@Table(name = "DCM_PERFIL_USUARIO_HIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmPerfilUsuarioHistTO.findAll", query = "SELECT d FROM DcmPerfilUsuarioHistTO d")
    , @NamedQuery(name = "DcmPerfilUsuarioHistTO.findByPkIdePerfilHist", query = "SELECT d FROM DcmPerfilUsuarioHistTO d WHERE d.pkIdePerfilHist = :pkIdePerfilHist")
    , @NamedQuery(name = "DcmPerfilUsuarioHistTO.findByNomPerfil", query = "SELECT d FROM DcmPerfilUsuarioHistTO d WHERE d.nomPerfil = :nomPerfil")})
public class DcmPerfilUsuarioHistTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_PERFIL_HIST")
    private Short pkIdePerfilHist;
    @Size(max = 50)
    @Column(name = "NOM_PERFIL")
    private String nomPerfil;

    public DcmPerfilUsuarioHistTO() {
    }

    public DcmPerfilUsuarioHistTO(Short pkIdePerfilHist) {
        this.pkIdePerfilHist = pkIdePerfilHist;
    }

    public Short getPkIdePerfilHist() {
        return pkIdePerfilHist;
    }

    public void setPkIdePerfilHist(Short pkIdePerfilHist) {
        this.pkIdePerfilHist = pkIdePerfilHist;
    }

    public String getNomPerfil() {
        return nomPerfil;
    }

    public void setNomPerfil(String nomPerfil) {
        this.nomPerfil = nomPerfil;
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
        if (!(object instanceof DcmPerfilUsuarioHistTO)) {
            return false;
        }
        DcmPerfilUsuarioHistTO other = (DcmPerfilUsuarioHistTO) object;
        if ((this.pkIdePerfilHist == null && other.pkIdePerfilHist != null) || (this.pkIdePerfilHist != null && !this.pkIdePerfilHist.equals(other.pkIdePerfilHist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.PERFIL_USUARIO_HIST.JAVABEANS.DcmPerfilUsuarioHistTO[ pkIdePerfilHist=" + pkIdePerfilHist + " ]";
    }
    
}
