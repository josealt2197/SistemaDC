/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERMISO_USUARIO_HIST.SESSIONFACADE;

import SSW.PERMISO_USUARIO_HIST.JAVABEANS.DcmPermisoUsuarioHistTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmPermisoUsuarioHistTOFacadeLocal {

    void create(DcmPermisoUsuarioHistTO dcmPermisoUsuarioHistTO);

    void edit(DcmPermisoUsuarioHistTO dcmPermisoUsuarioHistTO);

    void remove(DcmPermisoUsuarioHistTO dcmPermisoUsuarioHistTO);

    DcmPermisoUsuarioHistTO find(Object id);

    List<DcmPermisoUsuarioHistTO> findAll();

    List<DcmPermisoUsuarioHistTO> findRange(int[] range);

    int count();
    
}
