/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.ESTADO.SESSIONFACADE;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmEstadoTOFacadeLocal {

    void create(DcmEstadoTO dcmEstadoTO);

    void edit(DcmEstadoTO dcmEstadoTO);

    void remove(DcmEstadoTO dcmEstadoTO);

    DcmEstadoTO find(Object id);

    List<DcmEstadoTO> findAll();

    List<DcmEstadoTO> findRange(int[] range);

    int count();
    
    DcmEstadoTO oneResult(String sql, Map<String, Object> parametros);

    List<DcmEstadoTO> manyResult(String sql, Map<String, Object> parametros);
    
}
