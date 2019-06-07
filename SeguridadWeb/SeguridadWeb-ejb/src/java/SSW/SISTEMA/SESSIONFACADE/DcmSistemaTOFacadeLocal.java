/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.SISTEMA.SESSIONFACADE;

import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmSistemaTOFacadeLocal {

    void create(DcmSistemaTO dcmSistemaTO);

    void edit(DcmSistemaTO dcmSistemaTO);

    void remove(DcmSistemaTO dcmSistemaTO);

    DcmSistemaTO find(Object id);

    List<DcmSistemaTO> findAll();

    List<DcmSistemaTO> findRange(int[] range);

    int count();
    
    List<DcmSistemaTO> manyResult(String sql, Map<String, Object> parametros);
    
}
