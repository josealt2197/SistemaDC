/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERMISO_USUARIO.SESSIONFACADE;

import SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmPermisoUsuarioTOFacadeLocal {

    void create(DcmPermisoUsuarioTO dcmPermisoUsuarioTO);

    void edit(DcmPermisoUsuarioTO dcmPermisoUsuarioTO);

    void remove(DcmPermisoUsuarioTO dcmPermisoUsuarioTO);

    DcmPermisoUsuarioTO find(Object id);

    List<DcmPermisoUsuarioTO> findAll();

    List<DcmPermisoUsuarioTO> findRange(int[] range);

    int count();
    
    int maxResult(String sql);
    
    List<DcmPermisoUsuarioTO> manyResult(String sql, Map<String, Object> parametros);


    
}
