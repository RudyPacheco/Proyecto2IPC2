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
public class usuarioTag {

    private String nombreUsuario;
    private ArrayList<String> etiquetas;

    public usuarioTag(String nombreUsuario, ArrayList<String> etiquetas) {
        this.nombreUsuario = nombreUsuario;
        this.etiquetas = etiquetas;
    }

    
    
    
    
    public usuarioTag() {
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

  
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    
}
