/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mycompany.revistas.app.backend.usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manejoGson.loginControlerAPI;
import manejoGson.sesionControler;
import modelo.usuarioDAO;
import modelo.usuarioLoged;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "LoginControler", urlPatterns = {"/LoginControler"})
public class LoginControler extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body += line;
            line = reader.readLine();
        }
        System.out.println("body");
        System.out.println(body);
        loginControlerAPI controler = new loginControlerAPI(usuario.class);
        sesionControler controlerB = new sesionControler(usuarioLoged.class);
        System.out.println("objeto");
        usuario login = controler.fromJson(body);
        usuarioLoged loged = controlerB.fromJson(body);
        System.out.println(login);
        System.out.println("devuelve");
        //        response.getWriter().append(controler.toJson(login));
        System.out.println(loged.getNombre());
        System.out.println(loged.getToken());
        usuarioDAO DAO = new usuarioDAO();
        usuario validar = DAO.validarUsuario(login.getNombre(), login.getContrasenia());
        if (validar.getNombre() != null) {

            usuarioLoged sesion = new usuarioLoged(validar.getNombre(), validar.getContrasenia(), "asfddasfds146");
            response.getWriter().append(controlerB.toJson(sesion));

        } else {
            usuarioLoged sesion = new usuarioLoged(validar.getNombre(), validar.getContrasenia(), null);
            response.getWriter().append(controlerB.toJson(sesion));
        }

        // response.getWriter().append(body);
    }

}
