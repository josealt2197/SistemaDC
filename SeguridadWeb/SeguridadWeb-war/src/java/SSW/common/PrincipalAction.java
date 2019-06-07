/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.common;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author jsalazar
 */
public class PrincipalAction extends ActionSupport {
    
    public PrincipalAction() {
    }

    public String ir() throws Exception {
        return "ir";
    }
}
