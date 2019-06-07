/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PRIVLEGIO.SESSIONFACADE;

import SSW.PRIVLEGIO.JAVABEANS.DcmPrivilegioTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmPrivilegioTOFacade extends AbstractFacade<DcmPrivilegioTO> implements DcmPrivilegioTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmPrivilegioTOFacade() {
        super(DcmPrivilegioTO.class);
    }
    
}
