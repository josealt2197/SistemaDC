package SSW.mantenimiento.usuarios;

import SSW.USUARIO.JAVABEANS.DcmUsuarioTO;
import SSW.USUARIO.SESSIONFACADE.DcmUsuarioTOFacadeLocal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class UsuariosHelper {

    DcmUsuarioTOFacadeLocal dcmUsuarioTOFacade = lookupDcmUsuarioTOFacadeLocal();

    private DcmUsuarioTOFacadeLocal lookupDcmUsuarioTOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (DcmUsuarioTOFacadeLocal) c.lookup("java:global/SeguridadWeb/SeguridadWeb-ejb/DcmUsuarioTOFacade!SSW.USUARIO.SESSIONFACADE.DcmUsuarioTOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public DcmUsuarioTO buscar(int ideUsuario) {
        return dcmUsuarioTOFacade.find(ideUsuario);
    }

    public DcmUsuarioTO buscarPorNombre(String usuario) {
        Map param = new HashMap();
        param.put("nomUsuario", usuario);
        return dcmUsuarioTOFacade.oneResult("DcmUsuarioTO.findByNomUsuario", param);
    }

    public List<DcmUsuarioTO> listar() {
        return dcmUsuarioTOFacade.manyResult("DcmUsuarioTO.findAll", null);
    }

    public void insertar(DcmUsuarioTO usuarioTO) {
        dcmUsuarioTOFacade.create(usuarioTO);
    }

    public void actualizar(DcmUsuarioTO usuarioTO) {
        dcmUsuarioTOFacade.edit(usuarioTO);
    }
    
    public void eliminar(DcmUsuarioTO usuarioTO) {
        dcmUsuarioTOFacade.remove(usuarioTO);
    }

    public int maximo() {
        return dcmUsuarioTOFacade.maxResult("DcmUsuarioTO.findMaxUsuario");
    }

}
