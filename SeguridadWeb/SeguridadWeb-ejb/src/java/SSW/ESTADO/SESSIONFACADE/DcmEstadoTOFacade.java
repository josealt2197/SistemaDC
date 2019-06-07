/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.ESTADO.SESSIONFACADE;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmEstadoTOFacade extends AbstractFacade<DcmEstadoTO> implements DcmEstadoTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmEstadoTOFacade() {
        super(DcmEstadoTO.class);
    }
    
}
