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
public class meGustaModel {

       
    private String nombreUsuario;
    private int codigoRevista;
    private String fechaMegusta; 

    public meGustaModel() {
    }

    public meGustaModel(String nombreUsuario, int codigoRevista, String fechaComentario) {
        this.nombreUsuario = nombreUsuario;
        this.codigoRevista = codigoRevista;
        this.fechaMegusta = fechaComentario;
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

    public String getFechaMegusta() {
        return fechaMegusta;
    }

    public void setFechaMegusta(String fechaMegusta) {
        this.fechaMegusta = fechaMegusta;
    }


    
    
    
    
    
    
}
