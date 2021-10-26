/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author AndaryuS
 */
public class usuarioActualizacion {

    private usuarioLoged usuarioAntiguo;
    private String nombre;
    private String apellido;
    private String informacion;
    private  ArrayList<String> etiquetasInteres;

    public usuarioActualizacion() {
    }

    public usuarioActualizacion(usuarioLoged usuarioAntiguo, String nombre, String apellido, String informacion, ArrayList<String> etiquetasInteres) {
        this.usuarioAntiguo = usuarioAntiguo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.informacion = informacion;
        this.etiquetasInteres = etiquetasInteres;
    }

    public usuarioLoged getUsuarioAntiguo() {
        return usuarioAntiguo;
    }

    public void setUsuarioAntiguo(usuarioLoged usuarioAntiguo) {
        this.usuarioAntiguo = usuarioAntiguo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public ArrayList<String> getEtiquetasInteres() {
        return etiquetasInteres;
    }

    public void setEtiquetasInteres(ArrayList<String> etiquetasInteres) {
        this.etiquetasInteres = etiquetasInteres;
    }

    
    
    
    
    
}
