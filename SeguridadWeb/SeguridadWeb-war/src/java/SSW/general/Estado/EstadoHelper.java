/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.general.Estado;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.ESTADO.SESSIONFACADE.DcmEstadoTOFacadeLocal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author julio
 */
public class EstadoHelper {

    DcmEstadoTOFacadeLocal dcmEstadoTOFacade = lookupDcmEstadoTOFacadeLocal();

    private DcmEstadoTOFacadeLocal lookupDcmEstadoTOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (DcmEstadoTOFacadeLocal) c.lookup("java:global/SeguridadWeb/SeguridadWeb-ejb/DcmEstadoTOFacade!SSW.ESTADO.SESSIONFACADE.DcmEstadoTOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
     public DcmEstadoTO buscar(int PK_IDE_PERFIL) {
        return dcmEstadoTOFacade.find(PK_IDE_PERFIL);
    }
    
    public List<DcmEstadoTO> listar() {
        return dcmEstadoTOFacade.manyResult("DcmEstadoTO.findAll", null);
    }
    
}
