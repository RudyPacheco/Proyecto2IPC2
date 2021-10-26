/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportModels;

import java.util.List;

/**
 *
 * @author AndaryuS
 */
public class reporteGananciaSistema {

    private String nombreRevista;
    private double costoRevista;
    private double ingresoTotal;
    private double costoTotal;
    private double gananciaTotal;
    private List<modeloGananciaSistema> suscripciones;

    public reporteGananciaSistema() {
    }

    public reporteGananciaSistema(String nombreRevista, double costoRevista, double ingresoTotal, double costoTotal, double gananciaTotal, List<modeloGananciaSistema> suscripciones) {
        this.nombreRevista = nombreRevista;
        this.costoRevista = costoRevista;
        this.ingresoTotal = ingresoTotal;
        this.costoTotal = costoTotal;
        this.gananciaTotal = gananciaTotal;
        this.suscripciones = suscripciones;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public double getCostoRevista() {
        return costoRevista;
    }

    public void setCostoRevista(double costoRevista) {
        this.costoRevista = costoRevista;
    }

    public double getIngresoTotal() {
        return ingresoTotal;
    }

    public void setIngresoTotal(double ingresoTotal) {
        this.ingresoTotal = ingresoTotal;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public double getGananciaTotal() {
        return gananciaTotal;
    }

    public void setGananciaTotal(double gananciaTotal) {
        this.gananciaTotal = gananciaTotal;
    }

    public List<modeloGananciaSistema> getSuscripciones() {
        return suscripciones;
    }

    public void setSuscripciones(List<modeloGananciaSistema> suscripciones) {
        this.suscripciones = suscripciones;
    }
    
    
    
    
    
    

}
