/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.USUARIO_HIST.JAVABEANS;

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
@Table(name = "DCM_USUARIO_HIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DcmUsuarioHistTO.findAll", query = "SELECT d FROM DcmUsuarioHistTO d")
    , @NamedQuery(name = "DcmUsuarioHistTO.findByPkIdeUsuarioHist", query = "SELECT d FROM DcmUsuarioHistTO d WHERE d.pkIdeUsuarioHist = :pkIdeUsuarioHist")
    , @NamedQuery(name = "DcmUsuarioHistTO.findByNomFuncionario", query = "SELECT d FROM DcmUsuarioHistTO d WHERE d.nomFuncionario = :nomFuncionario")
    , @NamedQuery(name = "DcmUsuarioHistTO.findByNomUsuario", query = "SELECT d FROM DcmUsuarioHistTO d WHERE d.nomUsuario = :nomUsuario")})
public class DcmUsuarioHistTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_IDE_USUARIO_HIST")
    private Short pkIdeUsuarioHist;
    @Size(max = 50)
    @Column(name = "NOM_FUNCIONARIO")
    private String nomFuncionario;
    @Size(max = 50)
    @Column(name = "NOM_USUARIO")
    private String nomUsuario;

    public DcmUsuarioHistTO() {
    }

    public DcmUsuarioHistTO(Short pkIdeUsuarioHist) {
        this.pkIdeUsuarioHist = pkIdeUsuarioHist;
    }

    public Short getPkIdeUsuarioHist() {
        return pkIdeUsuarioHist;
    }

    public void setPkIdeUsuarioHist(Short pkIdeUsuarioHist) {
        this.pkIdeUsuarioHist = pkIdeUsuarioHist;
    }

    public String getNomFuncionario() {
        return nomFuncionario;
    }

    public void setNomFuncionario(String nomFuncionario) {
        this.nomFuncionario = nomFuncionario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdeUsuarioHist != null ? pkIdeUsuarioHist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DcmUsuarioHistTO)) {
            return false;
        }
        DcmUsuarioHistTO other = (DcmUsuarioHistTO) object;
        if ((this.pkIdeUsuarioHist == null && other.pkIdeUsuarioHist != null) || (this.pkIdeUsuarioHist != null && !this.pkIdeUsuarioHist.equals(other.pkIdeUsuarioHist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SSW.USUARIO_HIST.JAVABEANS.DcmUsuarioHistTO[ pkIdeUsuarioHist=" + pkIdeUsuarioHist + " ]";
    }
    
}
