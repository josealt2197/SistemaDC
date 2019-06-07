/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PERFIL_USUARIO.SESSIONFACADE;

import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmPerfilUsuarioTOFacadeLocal {

    void create(DcmPerfilUsuarioTO dcmPerfilUsuarioTO);

    void edit(DcmPerfilUsuarioTO dcmPerfilUsuarioTO);

    void remove(DcmPerfilUsuarioTO dcmPerfilUsuarioTO);

    DcmPerfilUsuarioTO find(Object id);

    List<DcmPerfilUsuarioTO> findAll();

    List<DcmPerfilUsuarioTO> findRange(int[] range);

    int count();

    DcmPerfilUsuarioTO oneResult(String sql, Map<String, Object> parametros);

    List<DcmPerfilUsuarioTO> manyResult(String sql, Map<String, Object> parametros);

    //String Obtener_Sequencia_MOC(String seq_name);
    int maxResult(String sql);
}
