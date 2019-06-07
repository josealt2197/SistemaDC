package SSW.general.Sistema;

import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import SSW.SISTEMA.SESSIONFACADE.DcmSistemaTOFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SistemaHelper {

    DcmSistemaTOFacadeLocal dcmSistemaTOFacade = lookupDcmSistemaTOFacadeLocal();

    private DcmSistemaTOFacadeLocal lookupDcmSistemaTOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (DcmSistemaTOFacadeLocal) c.lookup("java:global/SeguridadWeb/SeguridadWeb-ejb/DcmSistemaTOFacade!SSW.SISTEMA.SESSIONFACADE.DcmSistemaTOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public List<DcmSistemaTO> listar() {
        return dcmSistemaTOFacade.manyResult("DcmSistemaTO.findAll", null);
    }
    
    public DcmSistemaTO buscar(int PK_IDE_SISTEMA) {
        return dcmSistemaTOFacade.find(PK_IDE_SISTEMA);
    }

}
