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
public class usuarioLoged {

    String nombre;
    String apellido;
    String usuario;
    String informacion;
    ArrayList<String>  etiquetasInteres;
    
  //  String contrasenia;
    int tipoCuenta;
    String token;

    public usuarioLoged() {
    }

    
    
    
    public usuarioLoged(String nombre, String token) {
        this.nombre = nombre;
       // this.contrasenia = contrasenia;
        this.token = token;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public String getContrasenia() {
//        return contrasenia;
//    }
//
//    public void setContrasenia(String contrasenia) {
//        this.contrasenia = contrasenia;
//    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
