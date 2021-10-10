/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import com.google.gson.Gson;
import com.mycompany.revistas.app.backend.usuario;
import javax.ws.rs.core.Response;
import manejoGson.registroConverter;
import modelo.UsuarioNuevo;
import modelo.usuarioDAO;

/**
 *
 * @author AndaryuS
 */
public class controlUsuario {

   private usuarioDAO usuarioDAO;
    
    public String registrarUsuario(String json) {

        String jsonR = null;
        
        registroConverter converter = new registroConverter(UsuarioNuevo.class);
        UsuarioNuevo nuevo = converter.fromJson(json);
        usuarioDAO= new usuarioDAO();
        usuario temp= usuarioDAO.validarExistencia(nuevo.getNombre());
        if (temp.getNombre()==null) {
            usuarioDAO.guardarUsuario(nuevo);
            jsonR= converter.toJson(nuevo);
        }else{
            
        }
        
        return jsonR;
    }
    
    
    public void iniciarSesion(){
        
    }

    
    
}
