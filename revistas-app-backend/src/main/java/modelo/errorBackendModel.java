/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 * 
 * @author AndaryuS
 */
public class errorBackendModel {
    private String mensaje;

    public errorBackendModel() {
    }

    public errorBackendModel(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
}
