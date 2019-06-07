
package SSW.historico.Perfles;

import SSW.PERMISO_USUARIO_HIST.SESSIONFACADE.DcmPermisoUsuarioHistTOFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PerfilHistHelper {

    DcmPermisoUsuarioHistTOFacadeLocal dcmPermisoUsuarioHistTOFacade = lookupDcmPermisoUsuarioHistTOFacadeLocal();

    private DcmPermisoUsuarioHistTOFacadeLocal lookupDcmPermisoUsuarioHistTOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (DcmPermisoUsuarioHistTOFacadeLocal) c.lookup("java:global/SeguridadWeb/SeguridadWeb-ejb/DcmPermisoUsuarioHistTOFacade!SSW.PERMISO_USUARIO_HIST.SESSIONFACADE.DcmPermisoUsuarioHistTOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
