/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.PANTALLA.SESSIONFACADE;

import SSW.PANTALLA.JAVABEANS.DcmPantallaTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author joma2
 */
@Local
public interface DcmPantallaTOFacadeLocal {

    void create(DcmPantallaTO dcmPantallaTO);

    void edit(DcmPantallaTO dcmPantallaTO);

    void remove(DcmPantallaTO dcmPantallaTO);

    DcmPantallaTO find(Object id);

    List<DcmPantallaTO> findAll();

    List<DcmPantallaTO> findRange(int[] range);

    int count();
    
}
