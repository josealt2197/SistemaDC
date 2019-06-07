/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.USUARIO.SESSIONFACADE;

import SSW.USUARIO.JAVABEANS.DcmUsuarioTO;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmUsuarioTOFacadeLocal {

    void create(DcmUsuarioTO dcmUsuarioTO);

    void edit(DcmUsuarioTO dcmUsuarioTO);

    void remove(DcmUsuarioTO dcmUsuarioTO);

    DcmUsuarioTO find(Object id);

    List<DcmUsuarioTO> findAll();

    List<DcmUsuarioTO> findRange(int[] range);

    int count();
    
    DcmUsuarioTO oneResult(String sql, Map<String, Object> parametros);

    List<DcmUsuarioTO> manyResult(String sql, Map<String, Object> parametros);

    int maxResult(String sql);
    
}
