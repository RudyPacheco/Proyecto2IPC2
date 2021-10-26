/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mycompany.revistas.app.backend.usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import manejoGson.errorConverter;
import manejoGson.infoConverter;
import manejoGson.loginControlerAPI;
import manejoGson.registroConverter;
import manejoGson.sesionControler;
import manejoGson.usuarioActualizacionConverter;
import manejoGson.usuarioTagConverter;
import modelo.UsuarioNuevo;
import modelo.errorBackendModel;
import modelo.informacionDAO;
import modelo.usuarioActualizacion;
import modelo.usuarioDAO;
import modelo.usuarioInformacion;
import modelo.usuarioLoged;
import modelo.usuarioTag;

/**
 *
 * @author AndaryuS
 */
public class controlUsuario {

    private usuarioDAO usuarioDAO;
    private informacionDAO informacionDAO;
    private boolean error = false;

    public String registrarUsuario(String json) {

        String jsonR = null;

        registroConverter converter = new registroConverter(UsuarioNuevo.class);
        UsuarioNuevo nuevo = converter.fromJson(json);
        usuarioDAO = new usuarioDAO();
        usuario temp = usuarioDAO.validarExistencia(nuevo.getNombre());
        if (temp.getNombre() == null) {
            usuarioDAO.guardarUsuario(nuevo);
            jsonR = converter.toJson(nuevo);
        } else {

        }

        return jsonR;
    }

    public String guardarInformacion(String json) {

        String jsonR = null;

        infoConverter converter = new infoConverter(usuarioInformacion.class);
        usuarioInformacion nuevo = converter.fromJson(json);
        usuarioDAO = new usuarioDAO();
        int registros = usuarioDAO.guardarInformacion(nuevo);
        for (int i = 0; i < nuevo.getEtiquetasUsuario().size(); i++) {
            registros += usuarioDAO.guardarTag(nuevo.getNombreUsuario(), nuevo.getEtiquetasUsuario().get(i));
        }
        System.out.println("PRUEBA");
        System.out.println(nuevo.getNombreUsuario());
        System.out.println(nuevo.getInformacion());
        if (registros != 0) {
            jsonR = converter.toJson(nuevo);
        } else {

        }

        return jsonR;
    }

    public String guardarTags(String json) {

        String jsonR = null;
        int registros = 0;
        usuarioTagConverter converter = new usuarioTagConverter(usuarioTag.class);
        usuarioTag nuevo = converter.fromJson(json);
        usuarioDAO = new usuarioDAO();
        for (int i = 0; i < nuevo.getEtiquetas().size(); i++) {
            System.out.println(nuevo.getNombreUsuario());
            System.out.println(nuevo.getEtiquetas().get(i));
            registros += usuarioDAO.guardarTag(nuevo.getNombreUsuario(), nuevo.getEtiquetas().get(i));
        }
        if (registros != 0) {
            jsonR = converter.toJson(nuevo);
        } else {

        }

        return jsonR;
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
        informacionDAO = new informacionDAO();
        usuarioDAO DAO = new usuarioDAO();
        usuarioLoged validar = DAO.validarUsuario(login.getNombre(), getMD5(login.getContrasenia()));
        if (validar.getNombre() != null) {
            validar.setEtiquetasInteres((ArrayList<String>) informacionDAO.listarEtiquetasUsuario(validar.getUsuario()));
            System.out.println(validar.getEtiquetasInteres().size());
            this.error = false;
            validar.setToken(generarToken());
            // usuarioLoged sesion = new usuarioLoged(validar.getNombre(), validar.getContrasenia(), generarToken());
            //  sesion.setTipoCuenta(validar.getTipoCuenta());

            jsonR = converter.toJson(validar);

        } else {
            this.error = true;
            errorConverter errorConverter = new errorConverter(errorBackendModel.class);
            errorBackendModel error = new errorBackendModel("El usuario no existe");

            jsonR = errorConverter.toJson(error);

        }

        return jsonR;

    }

    public String actualizarDatosUsuario(String usuario) {
        usuarioDAO = new usuarioDAO();
        informacionDAO = new informacionDAO();
        String jsonR;
          sesionControler converterLoged = new sesionControler(usuarioLoged.class);
        
        usuarioActualizacionConverter converter = new usuarioActualizacionConverter(usuarioActualizacion.class);
       
        usuarioActualizacion usuarioNuevo = converter.fromJson(usuario);
        usuarioLoged usuarioB = usuarioDAO.buscarUsuario(usuarioNuevo.getUsuarioAntiguo().getUsuario());
        usuarioB.setEtiquetasInteres((ArrayList<String>) informacionDAO.listarEtiquetasUsuario(usuarioB.getUsuario()));
        if (!usuarioNuevo.getNombre().equals(usuarioB.getNombre())) {
            System.out.println("nombres no iguales");
            usuarioDAO.cambiarNombre(usuarioNuevo.getNombre(), usuarioB.getUsuario());
        } 
        if (!usuarioNuevo.getApellido().equals(usuarioB.getApellido())) {
            System.out.println("apellido no iguales");
            usuarioDAO.cambiarApellido(usuarioNuevo.getApellido(), usuarioB.getUsuario());
        } 
        if (!usuarioNuevo.getInformacion().equals(usuarioB.getInformacion())) {
             System.out.println("info no iguales ");
            usuarioDAO.cambiarInformacion(usuarioNuevo.getInformacion(), usuarioB.getUsuario());
        }

        informacionDAO.eliminarInteresUsuario(usuarioB.getUsuario());
        for (int i = 0; i < usuarioNuevo.getEtiquetasInteres().size(); i++) {
            usuarioDAO.guardarTag(usuarioB.getUsuario(), usuarioNuevo.getEtiquetasInteres().get(i));
        }
        
       usuarioLoged  usuarioCambios= usuarioDAO.buscarUsuario(usuarioB.getUsuario());
       jsonR=converterLoged.toJson(usuarioCambios);
       
        return jsonR;
    }

    public boolean isError() {
        return this.error;
    }
    
    
    
    

    private String generarToken() {
        // El banco de caracteres
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < 12; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }

        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 15) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
