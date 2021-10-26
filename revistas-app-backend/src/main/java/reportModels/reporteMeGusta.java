/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reportModels;

import java.util.List;
import modelo.meGustaModel;

/**
 * 
 * @author AndaryuS
 */
public class reporteMeGusta {

    private String nombreRevista;
    private List<meGustaModel> meGustas;

    public reporteMeGusta() {
    }
    
    

    public reporteMeGusta(String nombreRevista, List<meGustaModel> meGustas) {
        this.nombreRevista = nombreRevista;
        this.meGustas = meGustas;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public List<meGustaModel> getMeGustas() {
        return meGustas;
    }

    public void setMeGustas(List<meGustaModel> meGustas) {
        this.meGustas = meGustas;
    }
    
    
    
    
    
    
}
