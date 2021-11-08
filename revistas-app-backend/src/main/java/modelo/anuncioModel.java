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
public class anuncioModel {

    private int codigo;
    private String anunciante;
    private int cantidadDias;
    private String fechaPublicacion;
    private String textoAnuncio;
    private String imagen;
    private String contentType;
    private String video;
    private ArrayList<String> etiquetas;
    private int tipoAnuncio;
    private double precio;

    public anuncioModel() {
        
    }

    public anuncioModel(int codigo, String anunciante, int cantidadDias, String fechaPublicacion, String textoAnuncio, String imagen, String contentType, String video, ArrayList<String> etiquetas, int tipoAnuncio, double precio) {
        this.codigo = codigo;
        this.anunciante = anunciante;
        this.cantidadDias = cantidadDias;
        this.fechaPublicacion = fechaPublicacion;
        this.textoAnuncio = textoAnuncio;
        this.imagen = imagen;
        this.contentType = contentType;
        this.video = video;
        this.etiquetas = etiquetas;
        this.tipoAnuncio = tipoAnuncio;
        this.precio = precio;
    }





    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTextoAnuncio() {
        return textoAnuncio;
    }

    public void setTextoAnuncio(String textoAnuncio) {
        this.textoAnuncio = textoAnuncio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getTipoAnuncio() {
        return tipoAnuncio;
    }

    public void setTipoAnuncio(int tipoAnuncio) {
        this.tipoAnuncio = tipoAnuncio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    
    
    
    
    
}
