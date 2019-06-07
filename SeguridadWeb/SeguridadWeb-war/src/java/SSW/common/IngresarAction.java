package SSW.common;

import SSW.ESTADO.JAVABEANS.DcmEstadoTO;
import SSW.PERFIL_USUARIO.JAVABEANS.DcmPerfilUsuarioTO;
import SSW.USUARIO.JAVABEANS.DcmUsuarioTO;
import SSW.mantenimiento.usuarios.UsuariosHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IngresarAction extends ActionSupport {

    private static final String INGRESAR = "ingresar";
    private static final String ERROR = "error";

    private String usuario;
    private String clave;

    private String tipoCambio;
    private String ipc;

    public IngresarAction() {
    }

    @Override
    public String execute() throws Exception {
        UsuariosHelper usuariosHelper = new UsuariosHelper();
        ControlSession control = new ControlSession();
        try {

            //if (!getUsuario().equals("") && !getClave().equals("")) {
            if (!getUsuario().equals("")) {
                Boolean acceso = true;
                if (acceso) {
                    String nomUsuario = getUsuario();
                    
                    System.out.println("getUsuario() =" + nomUsuario);

                    DcmUsuarioTO usuariosTO = usuariosHelper.buscarPorNombre(nomUsuario);
                    DcmEstadoTO estadoUsuario = usuariosTO.getFkDcmEstado();
                    DcmPerfilUsuarioTO perfilUsuario = usuariosTO.getFkDcmPerfil();
                    
                     //Usuario Activo
                    if (estadoUsuario.getNomEstado().equals("Activo")) {

                        Map session = ActionContext.getContext().getSession();

                        session.clear();
                        session.put("ideUsuario", usuariosTO.getPkIdeFuncionario());
                        session.put("usuario", usuariosTO.getNomUsuario());
                        session.put("nomUsuario", usuariosTO.getNomFuncionarios());
                        session.put("ideTipoUsuario", usuariosTO.getFkDcmPerfil());
                        session.put("desTipoUsuario", perfilUsuario.getNomPerfil());
                        session.put("menu", AppConstants.MENU_SSW);

                        System.out.println("Session: " + session);

//switch (tipoUsuario) {
//    case 1:
//         session.put("menu", AppConstants.MENU_ADMINISTRADOR);
//        break;
//    case 2:
//        session.put("menu", AppConstants.MENU_ASISTENCIA_TECNICA);
//        break;
//    case 3:
//        session.put("menu", AppConstants.MENU_CONSULTA);
//        break;
//}
                        // ------- Web Services ------ 
                        try {
                            cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos service = new cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos();
                            cr.fi.bccr.sdde.ws.WsIndicadoresEconomicosSoap port = service.getWsIndicadoresEconomicosSoap();

                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = new Date();
                            java.lang.String hoy = dateFormat.format(date);
                            /*Parametros = indicador(317 COMPRA 318 VENTA), fechaIncicio, fechaFinal, nombre, Subniveles(S SI N NO)*/
                            java.lang.String result = port.obtenerIndicadoresEconomicosXML("423", hoy, hoy, "jimmysalazar86@gmail.com", "N");
                            String[] sp1 = result.split("<NUM_VALOR>");
                            String[] sp2 = sp1[1].split("</NUM_VALOR>");
                            String valor = sp2[0];
                            double tipoCambio = Double.parseDouble(valor);
                            setTipoCambio(valor);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            System.out.println("Error Tasa Básica Diaria " + ex);
                            tipoCambio = "0.0";
                            setTipoCambio("0");
                        }

                        try {
                            cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos service = new cr.fi.bccr.sdde.ws.WsIndicadoresEconomicos();
                            cr.fi.bccr.sdde.ws.WsIndicadoresEconomicosSoap port = service.getWsIndicadoresEconomicosSoap();

                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = new Date();
                            java.lang.String hoy = dateFormat.format(date);
                            /*Parametros = indicador(317 COMPRA 318 VENTA), fechaIncicio, fechaFinal, nombre, Subniveles(S SI N NO)*/
                            java.lang.String result = port.obtenerIndicadoresEconomicosXML("25485", "01/12/2018", "31/12/2018", "jimmysalazar86@gmail.com", "N");
                            String[] sp1 = result.split("<NUM_VALOR>");
                            String[] sp2 = sp1[1].split("</NUM_VALOR>");
                            String valor = sp2[0];
                            double tipoCambio = Double.parseDouble(valor);
                            setIpc(String.valueOf(tipoCambio));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            System.out.println("Error IPC " + ex);
                            tipoCambio = "0.0";
                            setIpc("0");
                        }

                        return INGRESAR;

                    } else if (estadoUsuario.getNomEstado().equals("Inactivo")) {
                        //Usuario no activo
                        addActionError("Usuario inactivo");
                        return ERROR;
                    } else {
                        //Usuario eliminado
                        addActionError("Datos incorrectos");
                        return ERROR;
                    }
                } else {
                    //Acceso es false
                    addActionError("Datos incorrectos");
                    return ERROR;
                }
            } else {
                //Campos vacíos
                addActionError("Escribe el usuario y contraseña");
                return ERROR;
            }

        } catch (Exception e) {
            addActionError("Usuario no registrado.");
            System.out.println("Excepción: " + e);
            return ERROR;
        }

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getIpc() {
        return ipc;
    }

    public void setIpc(String ipc) {
        this.ipc = ipc;
    }

}
