/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.USUARIO.SESSIONFACADE;

import SSW.USUARIO.JAVABEANS.DcmUsuarioTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmUsuarioTOFacade extends AbstractFacade<DcmUsuarioTO> implements DcmUsuarioTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmUsuarioTOFacade() {
        super(DcmUsuarioTO.class);
    }
    
}
