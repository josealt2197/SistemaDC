
package infocoop.ldap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the infocoop.ldap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Validar_QNAME = new QName("http://ldap.infocoop/", "validar");
    private final static QName _Correo_QNAME = new QName("http://ldap.infocoop/", "correo");
    private final static QName _Nombre_QNAME = new QName("http://ldap.infocoop/", "nombre");
    private final static QName _ConsultarNombreUsuarioResponse_QNAME = new QName("http://ldap.infocoop/", "consultarNombreUsuarioResponse");
    private final static QName _CorreoResponse_QNAME = new QName("http://ldap.infocoop/", "correoResponse");
    private final static QName _ConsultarNombreUsuario_QNAME = new QName("http://ldap.infocoop/", "consultarNombreUsuario");
    private final static QName _ConsultarCorreoUsuarioResponse_QNAME = new QName("http://ldap.infocoop/", "consultarCorreoUsuarioResponse");
    private final static QName _ValidarResponse_QNAME = new QName("http://ldap.infocoop/", "validarResponse");
    private final static QName _ConsultarCorreoUsuario_QNAME = new QName("http://ldap.infocoop/", "consultarCorreoUsuario");
    private final static QName _NombreResponse_QNAME = new QName("http://ldap.infocoop/", "nombreResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: infocoop.ldap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Validar }
     * 
     */
    public Validar createValidar() {
        return new Validar();
    }

    /**
     * Create an instance of {@link Correo }
     * 
     */
    public Correo createCorreo() {
        return new Correo();
    }

    /**
     * Create an instance of {@link CorreoResponse }
     * 
     */
    public CorreoResponse createCorreoResponse() {
        return new CorreoResponse();
    }

    /**
     * Create an instance of {@link ConsultarNombreUsuario }
     * 
     */
    public ConsultarNombreUsuario createConsultarNombreUsuario() {
        return new ConsultarNombreUsuario();
    }

    /**
     * Create an instance of {@link ConsultarCorreoUsuarioResponse }
     * 
     */
    public ConsultarCorreoUsuarioResponse createConsultarCorreoUsuarioResponse() {
        return new ConsultarCorreoUsuarioResponse();
    }

    /**
     * Create an instance of {@link ValidarResponse }
     * 
     */
    public ValidarResponse createValidarResponse() {
        return new ValidarResponse();
    }

    /**
     * Create an instance of {@link ConsultarCorreoUsuario }
     * 
     */
    public ConsultarCorreoUsuario createConsultarCorreoUsuario() {
        return new ConsultarCorreoUsuario();
    }

    /**
     * Create an instance of {@link NombreResponse }
     * 
     */
    public NombreResponse createNombreResponse() {
        return new NombreResponse();
    }

    /**
     * Create an instance of {@link Nombre }
     * 
     */
    public Nombre createNombre() {
        return new Nombre();
    }

    /**
     * Create an instance of {@link ConsultarNombreUsuarioResponse }
     * 
     */
    public ConsultarNombreUsuarioResponse createConsultarNombreUsuarioResponse() {
        return new ConsultarNombreUsuarioResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Validar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "validar")
    public JAXBElement<Validar> createValidar(Validar value) {
        return new JAXBElement<Validar>(_Validar_QNAME, Validar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Correo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "correo")
    public JAXBElement<Correo> createCorreo(Correo value) {
        return new JAXBElement<Correo>(_Correo_QNAME, Correo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Nombre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "nombre")
    public JAXBElement<Nombre> createNombre(Nombre value) {
        return new JAXBElement<Nombre>(_Nombre_QNAME, Nombre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarNombreUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "consultarNombreUsuarioResponse")
    public JAXBElement<ConsultarNombreUsuarioResponse> createConsultarNombreUsuarioResponse(ConsultarNombreUsuarioResponse value) {
        return new JAXBElement<ConsultarNombreUsuarioResponse>(_ConsultarNombreUsuarioResponse_QNAME, ConsultarNombreUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CorreoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "correoResponse")
    public JAXBElement<CorreoResponse> createCorreoResponse(CorreoResponse value) {
        return new JAXBElement<CorreoResponse>(_CorreoResponse_QNAME, CorreoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarNombreUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "consultarNombreUsuario")
    public JAXBElement<ConsultarNombreUsuario> createConsultarNombreUsuario(ConsultarNombreUsuario value) {
        return new JAXBElement<ConsultarNombreUsuario>(_ConsultarNombreUsuario_QNAME, ConsultarNombreUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCorreoUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "consultarCorreoUsuarioResponse")
    public JAXBElement<ConsultarCorreoUsuarioResponse> createConsultarCorreoUsuarioResponse(ConsultarCorreoUsuarioResponse value) {
        return new JAXBElement<ConsultarCorreoUsuarioResponse>(_ConsultarCorreoUsuarioResponse_QNAME, ConsultarCorreoUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "validarResponse")
    public JAXBElement<ValidarResponse> createValidarResponse(ValidarResponse value) {
        return new JAXBElement<ValidarResponse>(_ValidarResponse_QNAME, ValidarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCorreoUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "consultarCorreoUsuario")
    public JAXBElement<ConsultarCorreoUsuario> createConsultarCorreoUsuario(ConsultarCorreoUsuario value) {
        return new JAXBElement<ConsultarCorreoUsuario>(_ConsultarCorreoUsuario_QNAME, ConsultarCorreoUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NombreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ldap.infocoop/", name = "nombreResponse")
    public JAXBElement<NombreResponse> createNombreResponse(NombreResponse value) {
        return new JAXBElement<NombreResponse>(_NombreResponse_QNAME, NombreResponse.class, null, value);
    }

}
