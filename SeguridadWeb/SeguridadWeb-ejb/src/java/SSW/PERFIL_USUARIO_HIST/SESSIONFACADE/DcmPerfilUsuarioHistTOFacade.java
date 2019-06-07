/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERFIL_USUARIO_HIST.SESSIONFACADE;

import SSW.PERFIL_USUARIO_HIST.JAVABEANS.DcmPerfilUsuarioHistTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmPerfilUsuarioHistTOFacade extends AbstractFacade<DcmPerfilUsuarioHistTO> implements DcmPerfilUsuarioHistTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmPerfilUsuarioHistTOFacade() {
        super(DcmPerfilUsuarioHistTO.class);
    }
    
}
