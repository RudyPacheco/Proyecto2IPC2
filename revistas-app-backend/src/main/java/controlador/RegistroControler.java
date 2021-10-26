/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import service.controlRevista;
import service.controlUsuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import manejoGson.registroConverter;
import modelo.UsuarioNuevo;
import modelo.usuarioDAO;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "RegistroControler", urlPatterns = {"/RegistroControler"})
public class RegistroControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
        controlUsuario control = new controlUsuario();
        
           BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body += line;
            line = reader.readLine();
        }
        System.out.println("body");
        System.out.println(body);
        control.registrarUsuario(body);

        response.getWriter().append(control.registrarUsuario(body));
        
        
        
        
//        usuarioDAO usuarioDAO = new usuarioDAO();
//        usuarioDAO.validarExistencia(nuevo.getNombre());

//        registroConverter converter = new registroConverter(UsuarioNuevo.class);
//        UsuarioNuevo nuevo = converter.fromJson(body);
//        
        
    }
    
    
    
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        controlUsuario control = new controlUsuario();
       BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body += line;
            line = reader.readLine();
        }
        System.out.println("body");
        System.out.println(body);
        
         

        response.getWriter().append(control.actualizarDatosUsuario(body));
        
   
        
    }
    
    
    
    

}