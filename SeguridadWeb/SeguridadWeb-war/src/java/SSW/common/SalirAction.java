/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SSW.common;

import com.opensymphony.xwork2.ActionContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 *
 * @author barce
 */
public class SalirAction {

    private static final String SALIR = "salir";
    private InputStream stream;
    
    public SalirAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.remove("ideUsuario");
        session.remove("usuario");
        session.remove("nomUsuario");
        session.remove("ideTipoUsuario");
        session.remove("desTipoUsuario");
        session.clear();
        return SALIR;
    }
    
    public String Verificar_Sesion() throws UnsupportedEncodingException {
        String str = "pasa";
        Map session = ActionContext.getContext().getSession();
        if(session.get("usuario") == null) str = "cerrar";
        setStream(new ByteArrayInputStream(str.getBytes("UTF-8")));
        return "resultado";
    }
    
    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }
}

