/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reportModels;

/**
 * 
 * @author AndaryuS
 */
public class modeloGananciaSistema {

     private int codigoRevista;
    private String nombreRevista;
    private String usuarioEditor;
    private String nombre_usuario;
    private String fecha_suscripcion;
    private String tipSuscripcion;
    private double ingreso_sub;
    private double ganancia;

    public modeloGananciaSistema() {
    }

    public modeloGananciaSistema(int codigoRevista, String nombreRevista, String usuarioEditor, String nombre_usuario, String fecha_suscripcion, String tipSuscripcion, double ingreso_sub, double ganancia) {
        this.codigoRevista = codigoRevista;
        this.nombreRevista = nombreRevista;
        this.usuarioEditor = usuarioEditor;
        this.nombre_usuario = nombre_usuario;
        this.fecha_suscripcion = fecha_suscripcion;
        this.tipSuscripcion = tipSuscripcion;
        this.ingreso_sub = ingreso_sub;
        this.ganancia = ganancia;
    }

    public int getCodigoRevista() {
        return codigoRevista;
    }

    public void setCodigoRevista(int codigoRevista) {
        this.codigoRevista = codigoRevista;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getUsuarioEditor() {
        return usuarioEditor;
    }

    public void setUsuarioEditor(String usuarioEditor) {
        this.usuarioEditor = usuarioEditor;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getFecha_suscripcion() {
        return fecha_suscripcion;
    }

    public void setFecha_suscripcion(String fecha_suscripcion) {
        this.fecha_suscripcion = fecha_suscripcion;
    }

    public String getTipSuscripcion() {
        return tipSuscripcion;
    }

    public void setTipSuscripcion(String tipSuscripcion) {
        this.tipSuscripcion = tipSuscripcion;
    }

    public double getIngreso_sub() {
        return ingreso_sub;
    }

    public void setIngreso_sub(double ingreso_sub) {
        this.ingreso_sub = ingreso_sub;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }
    
    
    
    
    
}
