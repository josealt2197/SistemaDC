/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERMISO_USUARIO_HIST.SESSIONFACADE;

import SSW.PERMISO_USUARIO_HIST.JAVABEANS.DcmPermisoUsuarioHistTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmPermisoUsuarioHistTOFacade extends AbstractFacade<DcmPermisoUsuarioHistTO> implements DcmPermisoUsuarioHistTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmPermisoUsuarioHistTOFacade() {
        super(DcmPermisoUsuarioHistTO.class);
    }
    
}
