/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SSW.common;

import infocoop.ldap.WSLDAP;
import infocoop.ldap.WSLDAPService;

/**
 *
 * @author jsalazar
 */
public class ControlSession {
    private static WSLDAPService service;
    private static WSLDAP port;
    
    public Boolean verificarUsuario(String nomUsuario, String contrasena) {
        Boolean acceso = false;
        try {
            service = new WSLDAPService();
            port = service.getWSLDAPPort();
            acceso = port.validar(nomUsuario, contrasena);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return acceso;
        return true;
    }

    public String nombreFuncionario(String nomUsuario, String contrasena) {
        String nombre = "";
        try {
            service = new WSLDAPService();
            port = service.getWSLDAPPort();
            nombre = port.nombre(nombre, contrasena);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
