
package infocoop.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarCorreoUsuario complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultarCorreoUsuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usrAuth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usrConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarCorreoUsuario", propOrder = {
    "usrAuth",
    "pwd",
    "usrConsulta"
})
public class ConsultarCorreoUsuario {

    protected String usrAuth;
    protected String pwd;
    protected String usrConsulta;

    /**
     * Gets the value of the usrAuth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsrAuth() {
        return usrAuth;
    }

    /**
     * Sets the value of the usrAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsrAuth(String value) {
        this.usrAuth = value;
    }

    /**
     * Gets the value of the pwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Sets the value of the pwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwd(String value) {
        this.pwd = value;
    }

    /**
     * Gets the value of the usrConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsrConsulta() {
        return usrConsulta;
    }

    /**
     * Sets the value of the usrConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsrConsulta(String value) {
        this.usrConsulta = value;
    }

}
