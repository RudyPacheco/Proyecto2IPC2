/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import service.controlRevista;
import service.controlSuscripcion;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manejoGson.suscripcionConveter;
import modelo.revista;
import modelo.revistaDAO;
import modelo.suscripcionModel;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "suscripcionControler", urlPatterns = {"/suscripcionControler"})
public class suscripcionControler extends HttpServlet {

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
        String usuario = request.getParameter("usuario");
        controlSuscripcion controlSub = new controlSuscripcion();
        revistaDAO revistaDAO  = new revistaDAO();
        System.out.println(usuario);
        Gson s = new Gson();
        List<revista> revistas = controlSub.listarSuscripciones(usuario);
           for (int i = 0; i < revistas.size(); i++) {
               revista tmp = revistas.get(i);
               tmp.setEtiquetas((ArrayList<String>) revistaDAO.listarEtiquetas(tmp.getCodigo()));
            }
        
           response.getWriter().append(s.toJson(revistas));
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
        controlSuscripcion control = new controlSuscripcion();
        suscripcionConveter converter = new suscripcionConveter(suscripcionModel.class);
        BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body += line;
            line = reader.readLine();
        }
        System.out.println("body");
        System.out.println(body);
        suscripcionModel sub = converter.fromJson(body);
        control.registrarEdicion(sub);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
