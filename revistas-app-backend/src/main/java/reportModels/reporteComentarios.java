/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reportModels;

import java.util.List;
import modelo.comentarioModel;

/**
 * 
 * @author AndaryuS
 */
public class reporteComentarios {

    
    private String nombreRevista;
    private List<comentarioModel> comentarios;

    public reporteComentarios() {
    }

    public reporteComentarios(String nombreRevista, List<comentarioModel> comentarios) {
        this.nombreRevista = nombreRevista;
        this.comentarios = comentarios;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public List<comentarioModel> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<comentarioModel> comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
    
    
    
    
}
