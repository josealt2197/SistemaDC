/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERFIL_USUARIO_HIST.SESSIONFACADE;

import SSW.PERFIL_USUARIO_HIST.JAVABEANS.DcmPerfilUsuarioHistTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmPerfilUsuarioHistTOFacadeLocal {

    void create(DcmPerfilUsuarioHistTO dcmPerfilUsuarioHistTO);

    void edit(DcmPerfilUsuarioHistTO dcmPerfilUsuarioHistTO);

    void remove(DcmPerfilUsuarioHistTO dcmPerfilUsuarioHistTO);

    DcmPerfilUsuarioHistTO find(Object id);

    List<DcmPerfilUsuarioHistTO> findAll();

    List<DcmPerfilUsuarioHistTO> findRange(int[] range);

    int count();
    
}
