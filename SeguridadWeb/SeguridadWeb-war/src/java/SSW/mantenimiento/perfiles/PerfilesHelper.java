
package SSW.mantenimiento.perfiles;

import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.PERFIL_USUARIO.SESSIONFACADE.DcmPerfilUsuarioTOFacadeLocal;
import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PerfilesHelper {

    DcmPerfilUsuarioTOFacadeLocal dcmPerfilUsuarioTOFacade = lookupDcmPerfilUsuarioTOFacadeLocal();

    private DcmPerfilUsuarioTOFacadeLocal lookupDcmPerfilUsuarioTOFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (DcmPerfilUsuarioTOFacadeLocal) c.lookup("java:global/SeguridadWeb/SeguridadWeb-ejb/DcmPerfilUsuarioTOFacade!SSW.PERFIL_USUARIO.SESSIONFACADE.DcmPerfilUsuarioTOFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public DcmPerfilUsuarioTO buscar(int PK_IDE_PERFIL) {
        return dcmPerfilUsuarioTOFacade.find(PK_IDE_PERFIL);
    }

    public List<DcmPerfilUsuarioTO> listar() {
        return dcmPerfilUsuarioTOFacade.manyResult("DcmPerfilUsuarioTO.findAll", null);
    }

//    public String PK_IDE_PERFIL() {
//
//        return dcmPerfilUsuarioTOFacade.Obtener_Sequencia_MOC("Sequence_DCM_PEFIL_USUARIO");
//
//    }
                                       
    public DcmPerfilUsuarioTO buscarPorSistema( String perfil, DcmSistemaTO sistema) {
        Map param = new HashMap();
        param.put("nomPerfil", perfil);
        param.put("fkDcmSistema", sistema);
        return dcmPerfilUsuarioTOFacade.oneResult("DcmPerfilUsuarioTO.findBySistema", param);
    }

    public void insertar(DcmPerfilUsuarioTO perfilTO) {
        dcmPerfilUsuarioTOFacade.create(perfilTO);
    }

    public void actualizar(DcmPerfilUsuarioTO perfilTO) {
        dcmPerfilUsuarioTOFacade.edit(perfilTO);
    }
    
    public void eliminar(DcmPerfilUsuarioTO perfilTO) {
        dcmPerfilUsuarioTOFacade.remove(perfilTO);
    }

    public int maximo() {
        return dcmPerfilUsuarioTOFacade.maxResult("DcmPerfilUsuarioTO.findMaxPerfil");
    }
              
    public List<DcmPerfilUsuarioTO> listarPorSistema(DcmSistemaTO sistema) {
        Map param = new HashMap();
        param.put("fkDcmSistema", sistema);
        return dcmPerfilUsuarioTOFacade.manyResult("DcmPerfilUsuarioTO.listBySistema", param);
    }
         

}
