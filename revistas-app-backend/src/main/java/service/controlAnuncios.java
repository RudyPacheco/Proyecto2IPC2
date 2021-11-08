/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import manejoGson.anuncioConverter;
import modelo.anuncioDAO;
import modelo.anuncioModel;
import modelo.revistaDAO;

/**
 *
 * @author AndaryuS
 */
public class controlAnuncios {

    private anuncioDAO anuncioDAO;

    public String publicarAnuncio(String body) {
        anuncioDAO = new anuncioDAO();
        String json = "";
        anuncioConverter conveter = new anuncioConverter(anuncioModel.class);

        anuncioModel nuevo = conveter.fromJson(body);
        System.out.println("anunciante" + nuevo.getAnunciante());
        int codigoN = generarCodigo();
        switch (nuevo.getTipoAnuncio()) {
            case 1:
                int precio = nuevo.getCantidadDias()*5;
                nuevo.setPrecio(precio);
                anuncioDAO.guardarAnuncioTexto(nuevo, codigoN);
                for (int i = 0; i < nuevo.getEtiquetas().size(); i++) {
                    anuncioDAO.guardarEtiquetasAnuncio(codigoN, nuevo.getEtiquetas().get(i));
                }
                break;
            case 2:

                break;
            case 3:
                  int precioV = nuevo.getCantidadDias()*15;
                nuevo.setPrecio(precioV);
                anuncioDAO.guardarAnuncioVideo(nuevo, codigoN);
                for (int i = 0; i < nuevo.getEtiquetas().size(); i++) {
                    anuncioDAO.guardarEtiquetasAnuncio(codigoN, nuevo.getEtiquetas().get(i));
                }
                break;
            default:
                break;
        }

        return json;
    }
    
    
    public void publicarAnuncioImagen(anuncioModel anuncio){
        int ganancia = anuncio.getCantidadDias()*10;
        anuncio.setPrecio(ganancia);
         anuncioDAO = new anuncioDAO();
         if (anuncio!=null) {
                int codigoN = generarCodigo();
        anuncioDAO.guardarAnucioImagen(anuncio, codigoN);
             for (int i = 0; i < anuncio.getEtiquetas().size(); i++) {
                    anuncioDAO.guardarEtiquetasAnuncio(codigoN, anuncio.getEtiquetas().get(i));
                }
        }
    }

    public int generarCodigo() {
        anuncioDAO= new anuncioDAO();
        //      this.revistaDAO = new revistaDAO();
        String codigo = anuncioDAO.genearSerie();
        if (codigo == null) {
            codigo = "00000001";
        } else {
            int id = Integer.parseInt(codigo);
            codigo = numeroID(id);
        }

        int codigoINT = Integer.parseInt(codigo);

        return codigoINT;
    }

    public String numeroID(int datoR) {
        int dato;
        String numero = null;
        dato = datoR + 1;

        if (dato >= 10000000 && dato <= 100000000) {
            numero = "" + dato;
        }
        if (dato >= 1000000 && dato <= 10000000) {
            numero = "0" + dato;
        }
        if (dato >= 100000 && dato <= 1000000) {
            numero = "00" + dato;
        }
        if (dato >= 10000 && dato <= 100000) {
            numero = "000" + dato;
        }
        if (dato >= 1000 && dato <= 10000) {
            numero = "0000" + dato;
        }
        if (dato > 100 && dato <= 1000) {
            numero = "00000" + dato;
        }
        if (dato >= 10 && dato <= 100) {
            numero = "000000" + dato;
        }

        if (dato < 10) {
            numero = "0000000" + dato;
        }
        return numero;
    }

}
