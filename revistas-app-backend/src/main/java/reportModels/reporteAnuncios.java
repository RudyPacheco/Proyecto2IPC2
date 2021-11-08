package reportModels;

import java.util.List;
import modelo.anuncioModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author AndaryuS
 */
public class reporteAnuncios {

    private List<anuncioModel> anuncios;

    public reporteAnuncios() {
    }

    public reporteAnuncios(List<anuncioModel> anuncios) {
        this.anuncios = anuncios;
    }

    public List<anuncioModel> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<anuncioModel> anuncios) {
        this.anuncios = anuncios;
    }
    
    
    
}
