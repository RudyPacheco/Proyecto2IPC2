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
public class porcentaje {

    private int porcentajeUsuario;
    private int porcentajeSistema;

    public porcentaje() {
    }

    
    
    
    public porcentaje(int porcentajeUsuario, int porcentajeSistema) {
        this.porcentajeUsuario = porcentajeUsuario;
        this.porcentajeSistema = porcentajeSistema;
    }

    public int getPorcentajeUsuario() {
        return porcentajeUsuario;
    }

    public void setPorcentajeUsuario(int porcentajeUsuario) {
        this.porcentajeUsuario = porcentajeUsuario;
    }

    public int getPorcentajeSistema() {
        return porcentajeSistema;
    }

    public void setPorcentajeSistema(int porcentajeSistema) {
        this.porcentajeSistema = porcentajeSistema;
    }
    
    
    
    
    
    
}
