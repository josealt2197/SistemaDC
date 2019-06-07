package SSW.mantenimiento.perfiles;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.SISTEMA.JAVABEANS.DcmSistemaTO;
import SSW.general.Estado.EstadoHelper;
import SSW.general.Sistema.SistemaHelper;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class PerfilesAction extends ActionSupport implements SessionAware {

    private static final String DATA_TABLE = "data_Table";
    private static final String ERROR = "error";

    //Variables p/conteo de registros
    private Integer records = 0;
    private Integer recordEstado = 0;
    private Integer recordSistema = 0;

    //Variables p/almacenar registros
    private List<DcmPerfilUsuarioTO> listaPerfiles;
    private List<DcmEstadoTO> listaEstados;
    private List<DcmSistemaTO> listaSistemas;

    //Variables p/Agregar 
    private String Input_Perfil;
    private String Cb_Estado;
    private String Cb_Sistema;

    //Variables p/Editar
    private String idperfilModificar;
    private String perfilModificar;
    private String select_Estado;
    private String idsistemaModificar;
    private String sistemaModificar;

    //Variables p/Eliminar Usuario
    private int idPerfilEliminar;

    private Map<String, Object> session;

    public String listarPerfiles() {
        try {
            //Listar en la tabla
            PerfilesHelper perfilesHelper = new PerfilesHelper();
            List<DcmPerfilUsuarioTO> lista = perfilesHelper.listar();
            records = lista.size();
            listaPerfiles = lista;
            if (records == 0) {
                addActionError("No hay datos para mostrar");
                return ERROR;
            }

            SistemaHelper sistemasHelper = new SistemaHelper();
            List<DcmSistemaTO> lista_sistemas = sistemasHelper.listar();
            recordEstado = lista_sistemas.size();
            listaSistemas = lista_sistemas;
            if (recordEstado == 0) {
                addActionError("No hay sistemas para mostrar");
                return ERROR;
            }

            EstadoHelper estadosHelper = new EstadoHelper();
            List<DcmEstadoTO> lista_estados = estadosHelper.listar();
            recordSistema = lista_estados.size();
            listaEstados = lista_estados;
            if (recordSistema == 0) {
                addActionError("No hay estados para mostrar");
                return ERROR;
            }

        } catch (Exception e) {
            addActionError("Error UsuariosAction: " + e.getMessage());
            return ERROR;
        }
        return DATA_TABLE;
    }

    public String agregarPerfil() {
        System.out.println("Entra");

        PerfilesHelper perfilHelper = new PerfilesHelper();
        DcmPerfilUsuarioTO perfilUsuarioTO = new DcmPerfilUsuarioTO();

        System.out.println(getInput_Perfil());

        SistemaHelper sistemaHelper = new SistemaHelper();
        DcmSistemaTO sistemaTO = new DcmSistemaTO();
        sistemaTO = sistemaHelper.buscar(Integer.parseInt(getCb_Sistema()));
        System.out.println("Trae Sistemas");

        EstadoHelper estadoHelper = new EstadoHelper();
        DcmEstadoTO estadoTO = new DcmEstadoTO();
        estadoTO = estadoHelper.buscar(Integer.parseInt(getCb_Estado()));
        System.out.println("Trae Estado");

        int maxId = perfilHelper.maximo() + 1;

        Date fecCreacion = new Date();

        String usuario = getsession();

        if (perfilHelper.buscarPorSistema(getInput_Perfil(), sistemaTO) != null) {
            addActionError("El perfil ya existe dentro del sistema seleccionado.");
            listarPerfiles();
            return ERROR;
        } else {
            try {
                perfilUsuarioTO.setPkIdePerfil(maxId);
                perfilUsuarioTO.setNomPerfil(getInput_Perfil());
                perfilUsuarioTO.setFkDcmSistema(sistemaTO);
                perfilUsuarioTO.setFkDcmEstado(estadoTO);
                perfilUsuarioTO.setFecCreacion(fecCreacion);
                perfilUsuarioTO.setUsuCreacion(usuario);

                perfilHelper.insertar(perfilUsuarioTO);

            } catch (Exception e) {
                System.out.println("Error Add: " + e.getMessage());
                addActionError("No se ha podido completar la acción");
                return ERROR;
            }

            addActionMessage("Los datos han sido ingresados con éxito.");
            listarPerfiles();

            return DATA_TABLE;
        }
    }

    public String editarPerfil() {
        PerfilesHelper perfilHelper = new PerfilesHelper();
        DcmPerfilUsuarioTO perfilUsuarioTO = new DcmPerfilUsuarioTO();

        SistemaHelper sistemaHelper = new SistemaHelper();
        DcmSistemaTO sistemaTO = new DcmSistemaTO();

        EstadoHelper estadoHelper = new EstadoHelper();
        DcmEstadoTO estadoTO = new DcmEstadoTO();

        System.out.println(" ----- Datos editados ------");
        System.out.println("ID Perfil " + getIdperfilModificar());
        System.out.println("ID Sistema " + getIdsistemaModificar());
        System.out.println("Sistema " + getSistemaModificar());
        System.out.println("NomPerfil " + getPerfilModificar());
        System.out.println("Estado " + getSelect_Estado());
        System.out.println(" ");

        Date fecModifica = new Date();

        String usuario = getsession();

        try {
            perfilUsuarioTO = perfilHelper.buscar(Integer.parseInt(getIdperfilModificar()));
            perfilUsuarioTO.setNomPerfil(getPerfilModificar());
            estadoTO = estadoHelper.buscar(Integer.parseInt(getSelect_Estado()));
            perfilUsuarioTO.setFkDcmEstado(estadoTO);
            perfilUsuarioTO.setFecModifica(fecModifica);
            perfilUsuarioTO.setUsuModifica(usuario);

            perfilHelper.actualizar(perfilUsuarioTO);

        } catch (Exception e) {
            System.out.println("Error Edit: " + e.getMessage());
            addActionError("No se actualizaron los datos");
            return ERROR;
        }

        listarPerfiles();

        addActionMessage("Los datos han sido actualizados con éxito");
        return DATA_TABLE;
    }

    public String eliminarPerfil() {
        PerfilesHelper perfilHelper = new PerfilesHelper();
        DcmPerfilUsuarioTO perfilUsuarioTO = new DcmPerfilUsuarioTO();

        System.out.println(" ----- Perfil a Eliminar ------");
        System.out.println("ID Usuario " + getIdPerfilEliminar());
        System.out.println(" ");

        try {

            perfilUsuarioTO = perfilHelper.buscar(getIdPerfilEliminar());
            perfilHelper.eliminar(perfilUsuarioTO);

        } catch (Exception e) {
            System.out.println("Error Remove: " + e.getMessage());
            listarPerfiles();
            addActionError("No se ha eliminado el perfil");
            System.out.println("No se ha eliminado el perfil");
        }

        listarPerfiles();

        addActionMessage("El perfil ha sido eliminado con éxito");
        return DATA_TABLE;
    }

    // ------ Getters y Setters --------
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

    public String getInput_Perfil() {
        return Input_Perfil;
    }

    public void setInput_Perfil(String Input_Perfil) {
        this.Input_Perfil = Input_Perfil;
    }

    public String getCb_Estado() {
        return Cb_Estado;
    }

    public void setCb_Estado(String Cb_Estado) {
        this.Cb_Estado = Cb_Estado;
    }

    public String getCb_Sistema() {
        return Cb_Sistema;
    }

    public void setCb_Sistema(String Cb_Sistema) {
        this.Cb_Sistema = Cb_Sistema;
    }

    public String getIdperfilModificar() {
        return idperfilModificar;
    }

    public void setIdperfilModificar(String idperfilModificar) {
        this.idperfilModificar = idperfilModificar;
    }

    public String getPerfilModificar() {
        return perfilModificar;
    }

    public void setPerfilModificar(String perfilModificar) {
        this.perfilModificar = perfilModificar;
    }

    public String getSelect_Estado() {
        return select_Estado;
    }

    public void setSelect_Estado(String select_Estado) {
        this.select_Estado = select_Estado;
    }

    public String getSistemaModificar() {
        return sistemaModificar;
    }

    public void setSistemaModificar(String sistemaModificar) {
        this.sistemaModificar = sistemaModificar;
    }

    public String getIdsistemaModificar() {
        return idsistemaModificar;
    }

    public void setIdsistemaModificar(String idsistemaModificar) {
        this.idsistemaModificar = idsistemaModificar;
    }

    public int getIdPerfilEliminar() {
        return idPerfilEliminar;
    }

    public void setIdPerfilEliminar(int idPerfilEliminar) {
        this.idPerfilEliminar = idPerfilEliminar;
    }

    public void setSession(Map<String, Object> s) {
        this.session = s;

    }

    public String getsession() {
        return (String) session.get("usuario");
    }

}
