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
public class usuarioInformacion {

    private String nombreUsuario;
    private String informacionUsuario;
    private ArrayList<String> etiquetasUsuario;

    public String getInformacionUsuario() {
        return informacionUsuario;
    }

    public void setInformacionUsuario(String informacionUsuario) {
        this.informacionUsuario = informacionUsuario;
    }

    public ArrayList<String> getEtiquetasUsuario() {
        return etiquetasUsuario;
    }

    public void setEtiquetasUsuario(ArrayList<String> etiquetasUsuario) {
        this.etiquetasUsuario = etiquetasUsuario;
    }

    public usuarioInformacion() {
    }

    public usuarioInformacion(String nombreUsuario, String informacion) {
        this.nombreUsuario = nombreUsuario;
        this.informacionUsuario = informacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getInformacion() {
        return informacionUsuario;
    }

    public void setInformacion(String informacion) {
        this.informacionUsuario = informacion;
    }
    
    
    
    
    
    
    
}
