
package SSW.mantenimiento.permisos;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.PERMISO_USUARIO.JAVABEANS.DcmPermisoUsuarioTO;
import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import SSW.general.Estado.EstadoHelper;
import SSW.general.Sistema.SistemaHelper;
import SSW.mantenimiento.perfiles.PerfilesHelper;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;


public class PermisosAction extends ActionSupport implements SessionAware{
    
    private static final String CARGAR_PAGINA = "cargarPagina";
    private static final String DATA_TABLE = "data_Table";
    private static final String ERROR = "error";

    //Variables p/conteo de registros
    private Integer records = 0;
    private Integer recordEstado = 0;
    private Integer recordSistema = 0;
    private Integer recordPerfil = 0;

    //Variables p/almacenar registros
    private List<DcmPermisoUsuarioTO> listaPermisos;
    private List<DcmPerfilUsuarioTO> listaPerfiles;
    private List<DcmEstadoTO> listaEstados;
    private List<DcmSistemaTO> listaSistemas;

    private Map<String, Object> session;

    public PermisosAction() {

    }

    public String listarPermisos() {

        try {
            PermisosHelper permisosHelper = new PermisosHelper();
            List<DcmPermisoUsuarioTO> lista_permisos = permisosHelper.listar();
            records = lista_permisos.size();
            listaPermisos = lista_permisos;
            if (records == 0) {
                addActionError("No hay datos para mostrar");
            }
            
            System.out.println(listaPermisos);
           
//            SistemaHelper sistemasHelper = new SistemaHelper();
//            List<DcmSistemaTO> lista_sistemas = sistemasHelper.listar();
//            recordSistema = lista_sistemas.size();
//            listaSistemas = lista_sistemas;
//
//            EstadoHelper estadosHelper = new EstadoHelper();
//            List<DcmEstadoTO> lista_estados = estadosHelper.listar();
//            recordEstado = lista_estados.size();
//            listaEstados = lista_estados;
//
//            PerfilesHelper perfilesHelper = new PerfilesHelper();
//            List<DcmPerfilUsuarioTO> lista_perfiles = perfilesHelper.listar();
//            recordPerfil = lista_perfiles.size();
//            listaPerfiles = lista_perfiles;

        } catch (Exception e) {
            System.out.println("Error UsuariosAction: " + e.getMessage());
            addActionError("No se ha encontrado ningun usuario registrado.");
        }
        return DATA_TABLE;
    }

//    public String listarPerfiles() {
//        System.out.println("Cargando perfiles...");
//        try {
//            SistemaHelper sistemaHelper = new SistemaHelper();
//            DcmSistemaTO sistemaTO = new DcmSistemaTO();
//            sistemaTO = sistemaHelper.buscar(Integer.parseInt(getCb_Sistema()));
//
//            PerfilesHelper perfilesHelper = new PerfilesHelper();
//            List<DcmPerfilUsuarioTO> lista_perfiles = perfilesHelper.listarPorSistema(sistemaTO);
//            listaPerfiles = lista_perfiles;
//
//        } catch (Exception e) {
//            System.out.println("Error UsuariosAction: " + e.getMessage());
//            addActionError("No se ha podido obtener los perfiles.");
//        }
//        return DATA_TABLE;
//    }
//
//    public String agregarUsuario() throws ParseException {
//
//        UsuariosHelper usuariosHelper = new UsuariosHelper();
//        DcmUsuarioTO usuarioTO = new DcmUsuarioTO();
//
////        SistemaHelper sistemaHelper = new SistemaHelper();
////        DcmSistemaTO sistemaTO = new DcmSistemaTO();
//        PerfilesHelper perfilHelper = new PerfilesHelper();
//        DcmPerfilUsuarioTO perfilUsuarioTO = new DcmPerfilUsuarioTO();
//        perfilUsuarioTO = perfilHelper.buscar(Integer.parseInt(getCb_Perfil()));
//
//        EstadoHelper estadoHelper = new EstadoHelper();
//        DcmEstadoTO estadoTO = new DcmEstadoTO();
//        estadoTO = estadoHelper.buscar(Integer.parseInt(getCb_Estado()));
//
//        int maxId = usuariosHelper.maximo() + 1;
//
//        Date fecCreacion = new Date();
//
//        String usuario = getsession();
//
//        if (usuariosHelper.buscarPorNombre(getInput_nomUsuario()) != null) {
//            addActionError("El usuario ya existe.");
//            listarUsuarios();
//            return ERROR;
//        } else {
//            try {
//                usuarioTO.setPkIdeFuncionario(maxId);
//                usuarioTO.setNomFuncionarios(getInput_nomFuncionario());
//                usuarioTO.setNomUsuario(getInput_nomUsuario());
//                usuarioTO.setFkDcmEstado(estadoTO);
//                usuarioTO.setFkDcmPerfil(perfilUsuarioTO);
//                usuarioTO.setFecCreacion(fecCreacion);
//                usuarioTO.setUsuCreacion(usuario);
//
//                usuariosHelper.insertar(usuarioTO);
//
//            } catch (Exception e) {
//
//                System.out.println("Error Add: " + e.getMessage());
//                listarUsuarios();
//                addActionError("No se ha podido completar el registro.");
//            }
//
//            addActionMessage("El usuario ha sido registrado con éxito");
//            listarUsuarios();
//
//            return DATA_TABLE;
//        }
//    }
//
//    public String editarUsuario() {
//        UsuariosHelper usuariosHelper = new UsuariosHelper();
//        DcmUsuarioTO usuarioTO = new DcmUsuarioTO();
//
//        PerfilesHelper perfilHelper = new PerfilesHelper();
//        DcmPerfilUsuarioTO perfilUsuarioTO = new DcmPerfilUsuarioTO();
//
//        EstadoHelper estadoHelper = new EstadoHelper();
//        DcmEstadoTO estadoTO = new DcmEstadoTO();
//
//        System.out.println(" ----- Datos editados ------");
//        System.out.println("ID Usuario " + getIdUsuarioModificar());
//        System.out.println("NomUsuario " + getNomUsuarioModificar());
//        System.out.println("Sistema " + getSelect_Sistema());
//        System.out.println("Perfil " + getSelect_Perfil());
//        System.out.println("Estado " + getSelect_Estado());
//        System.out.println(" ");
//
//        Date fecModifica = new Date();
//        String usuario = getsession();
//
//        try {
//
//            usuarioTO = usuariosHelper.buscar(getIdUsuarioModificar());
//            usuarioTO.setNomUsuario(getNomUsuarioModificar());
//            estadoTO = estadoHelper.buscar(Integer.parseInt(getSelect_Estado()));
//            usuarioTO.setFkDcmEstado(estadoTO);
//            perfilUsuarioTO = perfilHelper.buscar(Integer.parseInt(getSelect_Perfil()));
//            usuarioTO.setFkDcmPerfil(perfilUsuarioTO);
//            usuarioTO.setFecModifica(fecModifica);
//            usuarioTO.setUsuModifica(usuario);
//
//            usuariosHelper.actualizar(usuarioTO);
//
//        } catch (Exception e) {
//            System.out.println("Error Edit: " + e.getMessage());
//            listarUsuarios();
//            addActionError("No fue posible actualizar los datos");
//        }
//
//        listarUsuarios();
//
//        addActionMessage("Los datos han sido actualizados con éxito");
//        return DATA_TABLE;
//    }
//
//    public String eliminarUsuario() {
//        UsuariosHelper usuariosHelper = new UsuariosHelper();
//        UsuarioHistHelper usuariosHistHelper = new UsuarioHistHelper();
//
//        DcmUsuarioHistTO usuarioHistTO = new DcmUsuarioHistTO();
//        DcmUsuarioTO usuarioTO = new DcmUsuarioTO();
//
//        System.out.println(" ----- Usuario a Eliminar ------");
//        System.out.println("ID Usuario " + getIdUsuarioEliminar());
//        System.out.println(" ");
//
//        int maxIdHist = usuariosHistHelper.maximo() + 1;
//
//        try {
//            //Eliminar usuario
//            usuarioTO = usuariosHelper.buscar(getIdUsuarioEliminar());
//            usuariosHelper.eliminar(usuarioTO);
//
//            //Crear registro en historico
////            usuarioHistTO.setPkIdeUsuarioHist(maxIdHist);
////            usuarioHistTO.setNomFuncionario(usuarioTO.getNomFuncionarios()); 
////            usuarioHistTO.setNomUsuario(usuarioTO.getNomUsuario());
////            usuarioHistTO.setFkDcmEstado(usuarioTO.getFkDcmEstado());
////            usuarioHistTO.setFkDcmPerfil(usuarioTO.getFkDcmPerfil());
////            usuariosHistHelper.insertar(usuarioHistTO);
//        } catch (Exception e) {
//            System.out.println("Error Remove: " + e.getMessage());
//            listarUsuarios();
//            addActionError("No se ha eliminado al usuario");
//        }
//
//        listarUsuarios();
//
//        addActionMessage("El usuario ha sido eliminado con éxito");
//        return DATA_TABLE;
//    }

    // ------ Getters y Setters --------

    public void setSession(Map<String, Object> s) {
        this.session = s;

    }

    public String getsession() {
        return (String) session.get("usuario");
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public Integer getRecordEstado() {
        return recordEstado;
    }

    public void setRecordEstado(Integer recordEstado) {
        this.recordEstado = recordEstado;
    }

    public Integer getRecordSistema() {
        return recordSistema;
    }

    public void setRecordSistema(Integer recordSistema) {
        this.recordSistema = recordSistema;
    }

    public Integer getRecordPerfil() {
        return recordPerfil;
    }

    public void setRecordPerfil(Integer recordPerfil) {
        this.recordPerfil = recordPerfil;
    }

    public List<DcmPermisoUsuarioTO> getListaPermisos() {
        return listaPermisos;
    }

    public void setListaPermisos(List<DcmPermisoUsuarioTO> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }
    
    public List<DcmPerfilUsuarioTO> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(List<DcmPerfilUsuarioTO> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public List<DcmEstadoTO> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<DcmEstadoTO> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<DcmSistemaTO> getListaSistemas() {
        return listaSistemas;
    }

    public void setListaSistemas(List<DcmSistemaTO> listaSistemas) {
        this.listaSistemas = listaSistemas;
    }

    
    
}



