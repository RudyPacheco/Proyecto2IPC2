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
public class reporteGanancias {
    
    private String nombreRevista;
    private List<reporteSuscripciones> suscripciones;
    private double gananciaTotal;

    public reporteGanancias() {
    }

    public reporteGanancias(String nombreRevista, List<reporteSuscripciones> suscripciones, double gananciaTotal) {
        this.nombreRevista = nombreRevista;
        this.suscripciones = suscripciones;
        this.gananciaTotal = gananciaTotal;
    }
    
    

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public List<reporteSuscripciones> getSuscripciones() {
        return suscripciones;
    }

    public void setSuscripciones(List<reporteSuscripciones> suscripciones) {
        this.suscripciones = suscripciones;
    }

    public double getGananciaTotal() {
        return gananciaTotal;
    }

    public void setGananciaTotal(double gananciaTotal) {
        this.gananciaTotal = gananciaTotal;
    }
    
    
    
    
    
    
}
