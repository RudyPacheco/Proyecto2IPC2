/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import static service.controlUsuario.getMD5;
import com.mycompany.revistas.app.backend.usuario;
import java.util.ArrayList;
import manejoGson.errorConverter;
import manejoGson.loginControlerAPI;
import manejoGson.sesionControler;
import modelo.errorBackendModel;
import modelo.informacionDAO;
import modelo.usuarioDAO;
import modelo.usuarioLoged;

/**
 * 
 * @author AndaryuS
 */
public class controlEditor {

    
    private usuarioDAO usuarioDAO;
    private informacionDAO informacionDAO;
    
    
    
    
    public usuarioLoged buscaerEditor(String editor){
        this.usuarioDAO= new usuarioDAO();
        this.informacionDAO= new informacionDAO();
        
        usuarioLoged user = usuarioDAO.buscarUsuario(editor);
         if (user.getNombre() != null) {
            user.setEtiquetasInteres((ArrayList<String>) informacionDAO.listarEtiquetasUsuario(user.getUsuario()));
        
        
    }
         
         return user;
    }
    
    public String iniciarSesion(String json) {
        String jsonR = null;
        loginControlerAPI controler = new loginControlerAPI(usuario.class);
        sesionControler converter = new sesionControler(usuarioLoged.class);
        System.out.println("objeto");
        usuario login = controler.fromJson(json);
        //usuarioLoged loged = controlerB.fromJson(body);
        System.out.println(login);
        System.out.println("devuelve");
        //        response.getWriter().append(controler.toJson(login));
        // System.out.println(loged.getNombre());
        //System.out.println(loged.getToken());
        informacionDAO= new informacionDAO();
        usuarioDAO DAO = new usuarioDAO();
        usuarioLoged validar = DAO.validarUsuario(login.getNombre(), getMD5(login.getContrasenia()));
        if (validar.getNombre() != null) {
            validar.setEtiquetasInteres((ArrayList<String>) informacionDAO.listarEtiquetasUsuario(validar.getUsuario()));
            System.out.println(validar.getEtiquetasInteres().size());
//            this.error=false;
//            validar.setToken(generarToken());
            // usuarioLoged sesion = new usuarioLoged(validar.getNombre(), validar.getContrasenia(), generarToken());
            //  sesion.setTipoCuenta(validar.getTipoCuenta());

            jsonR = converter.toJson(validar);

        } else {
        //   this.error=true;
            errorConverter errorConverter = new errorConverter(errorBackendModel.class);
            errorBackendModel error = new errorBackendModel("El usuario no existe");
            
            jsonR= errorConverter.toJson(error);
            
        }

        return jsonR;

    }
    
    
}
