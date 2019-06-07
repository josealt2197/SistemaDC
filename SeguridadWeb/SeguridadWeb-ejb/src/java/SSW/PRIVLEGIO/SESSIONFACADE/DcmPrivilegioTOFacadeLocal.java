/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PRIVLEGIO.SESSIONFACADE;

import SSW.PRIVLEGIO.JAVABEANS.DcmPrivilegioTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmPrivilegioTOFacadeLocal {

    void create(DcmPrivilegioTO dcmPrivilegioTO);

    void edit(DcmPrivilegioTO dcmPrivilegioTO);

    void remove(DcmPrivilegioTO dcmPrivilegioTO);

    DcmPrivilegioTO find(Object id);

    List<DcmPrivilegioTO> findAll();

    List<DcmPrivilegioTO> findRange(int[] range);

    int count();
    
}
