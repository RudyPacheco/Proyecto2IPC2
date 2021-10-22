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
public class suscripcionModel {

    private revista revista;
    private String nombreUsuario;
    private String fechaSuscripcion;
    private int tipoSuscripcion;

    public suscripcionModel() {
    }

    public suscripcionModel(revista revista, String nombreUsuario, String fechaSuscripcion, int tipoSuscripcion) {
        this.revista = revista;
        this.nombreUsuario = nombreUsuario;
        this.fechaSuscripcion = fechaSuscripcion;
        this.tipoSuscripcion = tipoSuscripcion;
    }



    public revista getRevista() {
        return revista;
    }

    public void setRevista(revista revista) {
        this.revista = revista;
    }

    public String getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(String fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public int getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public void setTipoSuscripcion(int tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
    
    
    
    
    
    
}
