/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERMISO_USUARIO.SESSIONFACADE;

import SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmPermisoUsuarioTOFacade extends AbstractFacade<DcmPermisoUsuarioTO> implements DcmPermisoUsuarioTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmPermisoUsuarioTOFacade() {
        super(DcmPermisoUsuarioTO.class);
    }
    
}
