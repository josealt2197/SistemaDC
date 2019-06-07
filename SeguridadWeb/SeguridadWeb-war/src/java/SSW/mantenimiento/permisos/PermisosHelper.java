
package SSW.mantenimiento.permisos;

import SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO;
import SSW.PERMISO_USUARIO.SESSIONFACADE.DcmPermisoUsuarioTOFacadeLocal;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class PermisosHelper {

    DcmPermisoUsuarioTOFacadeLocal dcmPermisoUsuarioTOFacade = lookupDcmPermisoUsuarioTOFacadeLocal();

    private DcmPermisoUsuarioTOFacadeLocal lookupDcmPermisoUsuarioTOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (DcmPermisoUsuarioTOFacadeLocal) c.lookup("java:global/SeguridadWeb/SeguridadWeb-ejb/DcmPermisoUsuarioTOFacade!SSW.PERMISO_USUARIO.SESSIONFACADE.DcmPermisoUsuarioTOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    public DcmPermisoUsuarioTO buscar(int ideUsuario) {
        return dcmPermisoUsuarioTOFacade.find(ideUsuario);
    }


    public List<DcmPermisoUsuarioTO> listar() {
        return dcmPermisoUsuarioTOFacade.manyResult("DcmPermisoUsuarioTO.findAll", null);
    }

    public void insertar(DcmPermisoUsuarioTO permisoTO) {
        dcmPermisoUsuarioTOFacade.create(permisoTO);
    }

    public void actualizar(DcmPermisoUsuarioTO permisoTO) {
        dcmPermisoUsuarioTOFacade.edit(permisoTO);
    }
    
    public void eliminar(DcmPermisoUsuarioTO permisoTO) {
        dcmPermisoUsuarioTOFacade.remove(permisoTO);
    }

    public int maximo() {
        return dcmPermisoUsuarioTOFacade.maxResult("DcmPermisoUsuarioTO.findMaxPermiso");
    }
    
    
}
