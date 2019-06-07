/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERFIL_USUARIO.SESSIONFACADE;

import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.common.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joma2
 */
@Stateless
public class DcmPerfilUsuarioTOFacade extends AbstractFacade<DcmPerfilUsuarioTO> implements DcmPerfilUsuarioTOFacadeLocal {

    @PersistenceContext(unitName = "SeguridadWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DcmPerfilUsuarioTOFacade() {
        super(DcmPerfilUsuarioTO.class);
    }
    
}
