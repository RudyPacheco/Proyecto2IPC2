/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import modelo.informacionDAO;
import modelo.revista;
import modelo.revistaDAO;
import modelo.usuarioDAO;

/**
 * 
 * @author AndaryuS
 */
public class controlEdicion {

       revistaDAO revistaDAO;
    usuarioDAO usuarioDAO;
    informacionDAO informacionDAO;
    int codigoR;

    public String publicarEdicion(revista revistaR, String direccion) {
        this.revistaDAO = new revistaDAO();
        int registros = 0;
        String resultado = "";
     

        registros += revistaDAO.guardarEdicion(revistaR.getCodigo(), direccion, revistaR.getFechaCreacion());

        return resultado;

    }
    
    
    
    
    
    
    
    
}
