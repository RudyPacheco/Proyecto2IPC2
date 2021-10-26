/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.File;
import java.util.ArrayList;

/**
 * 
 * @author AndaryuS
 */
public class revista {
    
    private int codigo;
    private String nombreRevista;
    private String categoria;
    private double precioRevista;
    private String descripcion;
    private String fechaCreacion;
    private String editor;
    private boolean interaccion;
    private boolean bloqueoSub;
    private ArrayList<String> etiquetas;


    public revista() {
    }

    public revista(int codigo, String nombreRevista, String categoria, double precioRevista, String descripcion, String fechaCreacion, String editor, boolean interaccion, boolean bloqueoSub, ArrayList<String> etiquetas) {
        this.codigo = codigo;
        this.nombreRevista = nombreRevista;
        this.categoria = categoria;
        this.precioRevista = precioRevista;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.editor = editor;
        this.interaccion = interaccion;
        this.bloqueoSub = bloqueoSub;
        this.etiquetas = etiquetas;
    }

 


    
   

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public double getPrecioRevista() {
        return precioRevista;
    }

    public void setPrecioRevista(double precioRevista) {
        this.precioRevista = precioRevista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public boolean isInteraccion() {
        return interaccion;
    }

    public void setInteraccion(boolean interaccion) {
        this.interaccion = interaccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isBloqueoSub() {
        return bloqueoSub;
    }

    public void setBloqueoSub(boolean bloqueoSub) {
        this.bloqueoSub = bloqueoSub;
    }

 
    
    
    
    
    
    
    
    
    
}
