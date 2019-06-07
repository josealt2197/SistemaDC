/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.SISTEMA.SESSIONFACADE;

import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmSistemaTOFacade extends AbstractFacade<DcmSistemaTO> implements DcmSistemaTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmSistemaTOFacade() {
        super(DcmSistemaTO.class);
    }
    
}
