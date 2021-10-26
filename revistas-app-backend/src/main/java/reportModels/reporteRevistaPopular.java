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
public class reporteRevistaPopular {
    private String nombreRevista;
    private int totalSub;
    private List<reporteSuscripciones> suscripciones;

      public reporteRevistaPopular() {
    }
    
    
    public reporteRevistaPopular(String nombreRevista, int totalSub, List<reporteSuscripciones> suscripciones) {
        this.nombreRevista = nombreRevista;
        this.totalSub = totalSub;
        this.suscripciones = suscripciones;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public int getTotalSub() {
        return totalSub;
    }

    public void setTotalSub(int totalSub) {
        this.totalSub = totalSub;
    }

    public List<reporteSuscripciones> getSuscripciones() {
        return suscripciones;
    }

    public void setSuscripciones(List<reporteSuscripciones> suscripciones) {
        this.suscripciones = suscripciones;
    }
    
}
