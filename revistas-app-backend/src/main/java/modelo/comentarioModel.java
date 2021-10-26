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
public class comentarioModel {
    
    private String nombreUsuario;
    private int codigoRevista;
    private String comentario;
    private String fechaComentario; 

    public comentarioModel() {
    }

    public comentarioModel(String nombreUsuario, int codigoRevista, String comentario, String fechaComentario) {
        this.nombreUsuario = nombreUsuario;
        this.codigoRevista = codigoRevista;
        this.comentario = comentario;
        this.fechaComentario = fechaComentario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getCodigoRevista() {
        return codigoRevista;
    }

    public void setCodigoRevista(int codigoRevista) {
        this.codigoRevista = codigoRevista;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(String fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
    
    
    

}
