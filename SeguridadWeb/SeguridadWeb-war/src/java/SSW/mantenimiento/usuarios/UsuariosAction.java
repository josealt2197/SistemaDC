package SSW.mantenimiento.usuarios;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import SSW.USUARIO.JAVABEANS.DcmUsuarioTO;
import SSW.USUARIO_HIST.JAVABEANS.DcmUsuarioHistTO;
import SSW.general.Estado.EstadoHelper;
import SSW.general.Sistema.SistemaHelper;
import SSW.historico.Usuarios.UsuarioHistHelper;
import SSW.mantenimiento.perfiles.PerfilesHelper;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class UsuariosAction extends ActionSupport implements SessionAware {

    private static final String CARGAR_PAGINA = "cargarPagina";
    private static final String DATA_TABLE = "data_Table";
    private static final String ERROR = "error";

    //Variables p/conteo de registros
    private Integer records = 0;
    private Integer recordEstado = 0;
    private Integer recordSistema = 0;
    private Integer recordPerfil = 0;

    //Variables p/almacenar registros
    private List<DcmUsuarioTO> listaUsuarios;
    private List<DcmPerfilUsuarioTO> listaPerfiles;
    private List<DcmEstadoTO> listaEstados;
    private List<DcmSistemaTO> listaSistemas;

    //Variables p/Agregar Nuevo Usuario 
    private String Input_nomFuncionario;
    private String Input_nomUsuario;
    private String Cb_Perfil;
    private String Cb_Estado;
    private String Cb_Sistema;

    //Variables p/Editar Usuario
    private int idUsuarioModificar;
    private String nomUsuarioModificar;
    private String select_Sistema;
    private String select_Perfil;
    private String select_Estado;

    //Variables p/Eliminar Usuario
    private int idUsuarioEliminar;

    private Map<String, Object> session;

    public UsuariosAction() {

    }

    public String listarUsuarios() {

        try {
            UsuariosHelper usuariosHelper = new UsuariosHelper();
            List<DcmUsuarioTO> lista_usuarios = usuariosHelper.listar();
            records = lista_usuarios.size();
            listaUsuarios = lista_usuarios;
            if (records == 0) {
                addActionError("No hay datos para mostrar");
            }

            SistemaHelper sistemasHelper = new SistemaHelper();
            List<DcmSistemaTO> lista_sistemas = sistemasHelper.listar();
            recordSistema = lista_sistemas.size();
            listaSistemas = lista_sistemas;

            EstadoHelper estadosHelper = new EstadoHelper();
            List<DcmEstadoTO> lista_estados = estadosHelper.listar();
            recordEstado = lista_estados.size();
            listaEstados = lista_estados;

            PerfilesHelper perfilesHelper = new PerfilesHelper();
            List<DcmPerfilUsuarioTO> lista_perfiles = perfilesHelper.listar();
            recordPerfil = lista_perfiles.size();
            listaPerfiles = lista_perfiles;

        } catch (Exception e) {
            System.out.println("Error UsuariosAction: " + e.getMessage());
            addActionError("No se ha encontrado ningun usuario registrado.");
        }
        return DATA_TABLE;
    }

    public String listarPerfiles() {
        System.out.println("Cargando perfiles...");
        try {
            SistemaHelper sistemaHelper = new SistemaHelper();
            DcmSistemaTO sistemaTO = new DcmSistemaTO();
            sistemaTO = sistemaHelper.buscar(Integer.parseInt(getCb_Sistema()));

            PerfilesHelper perfilesHelper = new PerfilesHelper();
            List<DcmPerfilUsuarioTO> lista_perfiles = perfilesHelper.listarPorSistema(sistemaTO);
            recordPerfil = lista_perfiles.size();
            System.out.println("Perfiles 2: "+ recordPerfil);
            listaPerfiles = lista_perfiles;

        } catch (Exception e) {
            System.out.println("Error UsuariosAction: " + e.getMessage());
            addActionError("No se ha podido obtener los perfiles.");
        }
        return DATA_TABLE;
    }
    

    public String agregarUsuario() throws ParseException {

        UsuariosHelper usuariosHelper = new UsuariosHelper();
        DcmUsuarioTO usuarioTO = new DcmUsuarioTO();

//        SistemaHelper sistemaHelper = new SistemaHelper();
//        DcmSistemaTO sistemaTO = new DcmSistemaTO();
        PerfilesHelper perfilHelper = new PerfilesHelper();
        DcmPerfilUsuarioTO perfilUsuarioTO = new DcmPerfilUsuarioTO();
        perfilUsuarioTO = perfilHelper.buscar(Integer.parseInt(getCb_Perfil()));

        EstadoHelper estadoHelper = new EstadoHelper();
        DcmEstadoTO estadoTO = new DcmEstadoTO();
        estadoTO = estadoHelper.buscar(Integer.parseInt(getCb_Estado()));

        int maxId = usuariosHelper.maximo() + 1;

        Date fecCreacion = new Date();

        String usuario = getsession();

        if (usuariosHelper.buscarPorNombre(getInput_nomUsuario()) != null) {
            addActionError("El usuario ya existe.");
            listarUsuarios();
            return ERROR;
        } else {
            try {
                usuarioTO.setPkIdeFuncionario(maxId);
                usuarioTO.setNomFuncionarios(getInput_nomFuncionario());
                usuarioTO.setNomUsuario(getInput_nomUsuario());
                usuarioTO.setFkDcmEstado(estadoTO);
                usuarioTO.setFkDcmPerfil(perfilUsuarioTO);
                usuarioTO.setFecCreacion(fecCreacion);
                usuarioTO.setUsuCreacion(usuario);

                usuariosHelper.insertar(usuarioTO);

            } catch (Exception e) {

                System.out.println("Error Add: " + e.getMessage());
                listarUsuarios();
                addActionError("No se ha podido completar el registro.");
            }

            addActionMessage("El usuario ha sido registrado con éxito");
            listarUsuarios();

            return DATA_TABLE;
        }
    }

    public String editarUsuario() {
        UsuariosHelper usuariosHelper = new UsuariosHelper();
        DcmUsuarioTO usuarioTO = new DcmUsuarioTO();

        PerfilesHelper perfilHelper = new PerfilesHelper();
        DcmPerfilUsuarioTO perfilUsuarioTO = new DcmPerfilUsuarioTO();

        EstadoHelper estadoHelper = new EstadoHelper();
        DcmEstadoTO estadoTO = new DcmEstadoTO();

        System.out.println(" ----- Datos editados ------");
        System.out.println("ID Usuario " + getIdUsuarioModificar());
        System.out.println("NomUsuario " + getNomUsuarioModificar());
        System.out.println("Sistema " + getSelect_Sistema());
        System.out.println("Perfil " + getSelect_Perfil());
        System.out.println("Estado " + getSelect_Estado());
        System.out.println(" ");

        Date fecModifica = new Date();
        String usuario = getsession();

        try {

            usuarioTO = usuariosHelper.buscar(getIdUsuarioModificar());
            usuarioTO.setNomUsuario(getNomUsuarioModificar());
            estadoTO = estadoHelper.buscar(Integer.parseInt(getSelect_Estado()));
            usuarioTO.setFkDcmEstado(estadoTO);
            perfilUsuarioTO = perfilHelper.buscar(Integer.parseInt(getSelect_Perfil()));
            usuarioTO.setFkDcmPerfil(perfilUsuarioTO);
            usuarioTO.setFecModifica(fecModifica);
            usuarioTO.setUsuModifica(usuario);

            usuariosHelper.actualizar(usuarioTO);

        } catch (Exception e) {
            System.out.println("Error Edit: " + e.getMessage());
            listarUsuarios();
            addActionError("No fue posible actualizar los datos");
        }

        listarUsuarios();

        addActionMessage("Los datos han sido actualizados con éxito");
        return DATA_TABLE;
    }

    public String eliminarUsuario() {
        UsuariosHelper usuariosHelper = new UsuariosHelper();
        UsuarioHistHelper usuariosHistHelper = new UsuarioHistHelper();

        DcmUsuarioHistTO usuarioHistTO = new DcmUsuarioHistTO();
        DcmUsuarioTO usuarioTO = new DcmUsuarioTO();

        System.out.println(" ----- Usuario a Eliminar ------");
        System.out.println("ID Usuario " + getIdUsuarioEliminar());
        System.out.println(" ");

//        int maxIdHist = usuariosHistHelper.maximo() + 1;

        try {
            //Eliminar usuario
            usuarioTO = usuariosHelper.buscar(getIdUsuarioEliminar());
            usuariosHelper.eliminar(usuarioTO);

            //Crear registro en historico
//            usuarioHistTO.setPkIdeUsuarioHist(maxIdHist);
//            usuarioHistTO.setNomFuncionario(usuarioTO.getNomFuncionarios()); 
//            usuarioHistTO.setNomUsuario(usuarioTO.getNomUsuario());
//            usuarioHistTO.setFkDcmEstado(usuarioTO.getFkDcmEstado());
//            usuarioHistTO.setFkDcmPerfil(usuarioTO.getFkDcmPerfil());
//            usuariosHistHelper.insertar(usuarioHistTO);
        } catch (Exception e) {
            System.out.println("Error Remove: " + e.getMessage());
            listarUsuarios();
            addActionError("No se ha eliminado al usuario");
        }

        listarUsuarios();

        addActionMessage("El usuario ha sido eliminado con éxito");
        return DATA_TABLE;
    }

    // ------ Getters y Setters --------
    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public List<DcmUsuarioTO> getListaUsuarios() {
        return listaUsuarios;
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

    public void setListaUsuarios(List<DcmUsuarioTO> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getInput_nomFuncionario() {
        return Input_nomFuncionario;
    }

    public void setInput_nomFuncionario(String Input_nomFuncionario) {
        this.Input_nomFuncionario = Input_nomFuncionario;
    }

    public String getInput_nomUsuario() {
        return Input_nomUsuario;
    }

    public void setInput_nomUsuario(String Input_nomUsuario) {
        this.Input_nomUsuario = Input_nomUsuario;
    }

    public List<DcmPerfilUsuarioTO> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(List<DcmPerfilUsuarioTO> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public String getCb_Perfil() {
        return Cb_Perfil;
    }

    public void setCb_Perfil(String Cb_Perfil) {
        this.Cb_Perfil = Cb_Perfil;
    }

    public String getCb_Sistema() {
        return Cb_Sistema;
    }

    public void setCb_Sistema(String Cb_Sistema) {
        this.Cb_Sistema = Cb_Sistema;
    }

    public String getCb_Estado() {
        return Cb_Estado;
    }

    public void setCb_Estado(String Cb_Estado) {
        this.Cb_Estado = Cb_Estado;
    }

    public int getIdUsuarioModificar() {
        return idUsuarioModificar;
    }

    public void setIdUsuarioModificar(int idUsuarioModificar) {
        this.idUsuarioModificar = idUsuarioModificar;
    }

    public String getSelect_Sistema() {
        return select_Sistema;
    }

    public void setSelect_Sistema(String select_Sistema) {
        this.select_Sistema = select_Sistema;
    }

    public String getSelect_Perfil() {
        return select_Perfil;
    }

    public void setSelect_Perfil(String select_Perfil) {
        this.select_Perfil = select_Perfil;
    }

    public String getSelect_Estado() {
        return select_Estado;
    }

    public void setSelect_Estado(String select_Estado) {
        this.select_Estado = select_Estado;
    }

    public String getNomUsuarioModificar() {
        return nomUsuarioModificar;
    }

    public void setNomUsuarioModificar(String nomUsuarioModificar) {
        this.nomUsuarioModificar = nomUsuarioModificar;
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

    public int getIdUsuarioEliminar() {
        return idUsuarioEliminar;
    }

    public void setIdUsuarioEliminar(int idUsuarioEliminar) {
        this.idUsuarioEliminar = idUsuarioEliminar;
    }

    public void setSession(Map<String, Object> s) {
        this.session = s;

    }

    public String getsession() {
        return (String) session.get("usuario");
    }

}
