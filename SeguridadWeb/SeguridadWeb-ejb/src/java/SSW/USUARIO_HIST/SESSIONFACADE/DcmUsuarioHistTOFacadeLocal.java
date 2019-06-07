/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.USUARIO_HIST.SESSIONFACADE;

import SSW.USUARIO_HIST.JAVABEANS.DcmUsuarioHistTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmUsuarioHistTOFacadeLocal {

    void create(DcmUsuarioHistTO dcmUsuarioHistTO);

    void edit(DcmUsuarioHistTO dcmUsuarioHistTO);

    void remove(DcmUsuarioHistTO dcmUsuarioHistTO);

    DcmUsuarioHistTO find(Object id);

    List<DcmUsuarioHistTO> findAll();

    List<DcmUsuarioHistTO> findRange(int[] range);

    int count();
    
//    int maxResult(String sql);
    
}
