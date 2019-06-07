/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PANTALLA.SESSIONFACADE;

import SSW.PANTALLA.JAVABEANS.DcmPantallaTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmPantallaTOFacade extends AbstractFacade<DcmPantallaTO> implements DcmPantallaTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmPantallaTOFacade() {
        super(DcmPantallaTO.class);
    }
    
}
