
package infocoop.ldap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WS_LDAP", targetNamespace = "http://ldap.infocoop/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSLDAP {


    /**
     * 
     * @param usr
     * @param pwd
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "correo", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.Correo")
    @ResponseWrapper(localName = "correoResponse", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.CorreoResponse")
    @Action(input = "http://ldap.infocoop/WS_LDAP/correoRequest", output = "http://ldap.infocoop/WS_LDAP/correoResponse")
    public String correo(
        @WebParam(name = "usr", targetNamespace = "")
        String usr,
        @WebParam(name = "pwd", targetNamespace = "")
        String pwd);

    /**
     * 
     * @param usrAuth
     * @param usrConsulta
     * @param pwd
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultarCorreoUsuario", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.ConsultarCorreoUsuario")
    @ResponseWrapper(localName = "consultarCorreoUsuarioResponse", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.ConsultarCorreoUsuarioResponse")
    @Action(input = "http://ldap.infocoop/WS_LDAP/consultarCorreoUsuarioRequest", output = "http://ldap.infocoop/WS_LDAP/consultarCorreoUsuarioResponse")
    public String consultarCorreoUsuario(
        @WebParam(name = "usrAuth", targetNamespace = "")
        String usrAuth,
        @WebParam(name = "pwd", targetNamespace = "")
        String pwd,
        @WebParam(name = "usrConsulta", targetNamespace = "")
        String usrConsulta);

    /**
     * 
     * @param usrAuth
     * @param usrConsulta
     * @param pwd
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultarNombreUsuario", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.ConsultarNombreUsuario")
    @ResponseWrapper(localName = "consultarNombreUsuarioResponse", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.ConsultarNombreUsuarioResponse")
    @Action(input = "http://ldap.infocoop/WS_LDAP/consultarNombreUsuarioRequest", output = "http://ldap.infocoop/WS_LDAP/consultarNombreUsuarioResponse")
    public String consultarNombreUsuario(
        @WebParam(name = "usrAuth", targetNamespace = "")
        String usrAuth,
        @WebParam(name = "pwd", targetNamespace = "")
        String pwd,
        @WebParam(name = "usrConsulta", targetNamespace = "")
        String usrConsulta);

    /**
     * 
     * @param usr
     * @param pwd
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validar", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.Validar")
    @ResponseWrapper(localName = "validarResponse", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.ValidarResponse")
    @Action(input = "http://ldap.infocoop/WS_LDAP/validarRequest", output = "http://ldap.infocoop/WS_LDAP/validarResponse")
    public Boolean validar(
        @WebParam(name = "usr", targetNamespace = "")
        String usr,
        @WebParam(name = "pwd", targetNamespace = "")
        String pwd);

    /**
     * 
     * @param usr
     * @param pwd
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "nombre", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.Nombre")
    @ResponseWrapper(localName = "nombreResponse", targetNamespace = "http://ldap.infocoop/", className = "infocoop.ldap.NombreResponse")
    @Action(input = "http://ldap.infocoop/WS_LDAP/nombreRequest", output = "http://ldap.infocoop/WS_LDAP/nombreResponse")
    public String nombre(
        @WebParam(name = "usr", targetNamespace = "")
        String usr,
        @WebParam(name = "pwd", targetNamespace = "")
        String pwd);

}
