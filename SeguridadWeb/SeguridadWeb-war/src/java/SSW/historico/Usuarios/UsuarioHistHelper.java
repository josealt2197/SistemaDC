
package SSW.historico.Usuarios;

import SSW.USUARIO_HIST.JAVABEANS.DcmUsuarioHistTO;
import SSW.USUARIO_HIST.SESSIONFACADE.DcmUsuarioHistTOFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class UsuarioHistHelper {

    DcmUsuarioHistTOFacadeLocal dcmUsuarioHistTOFacade = lookupDcmUsuarioHistTOFacadeLocal();

    private DcmUsuarioHistTOFacadeLocal lookupDcmUsuarioHistTOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (DcmUsuarioHistTOFacadeLocal) c.lookup("java:global/SeguridadWeb/SeguridadWeb-ejb/DcmUsuarioHistTOFacade!SSW.USUARIO_HIST.SESSIONFACADE.DcmUsuarioHistTOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void insertar(DcmUsuarioHistTO usuarioHistTO) {
        dcmUsuarioHistTOFacade.create(usuarioHistTO);
    }

//    public int maximo() {
//        return dcmUsuarioHistTOFacade.maxResult("DcmUsuarioHistTO.findMaxUsuario");
//    }
    
}
