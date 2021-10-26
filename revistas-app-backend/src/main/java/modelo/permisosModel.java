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
public class permisosModel {

    private int codigoRevista;
    private boolean interaccion;
    private boolean bloqueo_sub;

    public permisosModel() {
    }

    public permisosModel(int codigoRevista, boolean interaccion, boolean bloqueo_sub) {
        this.codigoRevista = codigoRevista;
        this.interaccion = interaccion;
        this.bloqueo_sub = bloqueo_sub;
    }

    public int getCodigoRevista() {
        return codigoRevista;
    }

    public void setCodigoRevista(int codigoRevista) {
        this.codigoRevista = codigoRevista;
    }

    public boolean isInteraccion() {
        return interaccion;
    }

    public void setInteraccion(boolean interaccion) {
        this.interaccion = interaccion;
    }

    public boolean isBloqueo_sub() {
        return bloqueo_sub;
    }

    public void setBloqueo_sub(boolean bloqueo_sub) {
        this.bloqueo_sub = bloqueo_sub;
    }

    
    
    
    
}
