
package cr.fi.bccr.sdde.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tcIndicador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tcFechaInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tcFechaFinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tcNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tnSubNiveles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tcIndicador",
    "tcFechaInicio",
    "tcFechaFinal",
    "tcNombre",
    "tnSubNiveles"
})
@XmlRootElement(name = "ObtenerIndicadoresEconomicos")
public class ObtenerIndicadoresEconomicos {

    protected String tcIndicador;
    protected String tcFechaInicio;
    protected String tcFechaFinal;
    protected String tcNombre;
    protected String tnSubNiveles;

    /**
     * Gets the value of the tcIndicador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcIndicador() {
        return tcIndicador;
    }

    /**
     * Sets the value of the tcIndicador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcIndicador(String value) {
        this.tcIndicador = value;
    }

    /**
     * Gets the value of the tcFechaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcFechaInicio() {
        return tcFechaInicio;
    }

    /**
     * Sets the value of the tcFechaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcFechaInicio(String value) {
        this.tcFechaInicio = value;
    }

    /**
     * Gets the value of the tcFechaFinal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcFechaFinal() {
        return tcFechaFinal;
    }

    /**
     * Sets the value of the tcFechaFinal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcFechaFinal(String value) {
        this.tcFechaFinal = value;
    }

    /**
     * Gets the value of the tcNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcNombre() {
        return tcNombre;
    }

    /**
     * Sets the value of the tcNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcNombre(String value) {
        this.tcNombre = value;
    }

    /**
     * Gets the value of the tnSubNiveles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTnSubNiveles() {
        return tnSubNiveles;
    }

    /**
     * Sets the value of the tnSubNiveles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTnSubNiveles(String value) {
        this.tnSubNiveles = value;
    }

}
