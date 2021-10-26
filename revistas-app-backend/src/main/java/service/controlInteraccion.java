/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mycompany.revistas.app.backend.usuario;
import manejoGson.comentarioConveter;
import manejoGson.meGustaConveter;
import manejoGson.permisosConverter;
import manejoGson.registroConverter;
import modelo.UsuarioNuevo;
import modelo.comentarioModel;
import modelo.interaccionDAO;
import modelo.meGustaModel;
import modelo.permisosModel;
import modelo.revistaDAO;
import modelo.usuarioDAO;

/**
 *
 * @author AndaryuS
 */
public class controlInteraccion {

    public String comentarRevista(String json) {
        interaccionDAO interaccionDAO = new interaccionDAO();
        
        comentarioConveter conveter = new comentarioConveter(comentarioModel.class);
        comentarioModel comentario = conveter.fromJson(json);
        interaccionDAO.agregarComentario(comentario);

        String jsonR = conveter.toJson(comentario);

        return jsonR;
    }
    
    
     public String darMegustaRevista(String json) {
        interaccionDAO interaccionDAO = new interaccionDAO();
        
       
        meGustaConveter conveter = new meGustaConveter(meGustaModel.class);
       meGustaModel like = conveter.fromJson(json);
        interaccionDAO.agregarMeGusta(like);

        String jsonR = conveter.toJson(like);

        return jsonR;
    }
     
     public String actualizarPermisos(String json){
         
         revistaDAO revistaDAO = new revistaDAO();
         
         permisosConverter conveter = new permisosConverter(permisosModel.class);
         permisosModel permisosN = conveter.fromJson(json);
         revistaDAO.actualizarInteraccion(permisosN);
         revistaDAO.actualizarBloqueSub(permisosN);
         
           String jsonR = conveter.toJson(permisosN);

        return jsonR;
         
     }
     
     

}
