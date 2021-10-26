/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manejoGson.revistaConverter;
import modelo.revista;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "RevistaControler", urlPatterns = {"/RevistaControler"})
public class RevistaControler extends HttpServlet {



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
         String path = request.getParameter("paht");
          
          System.out.println("metodo do get");
        
        if (path != null) {
            showImage(response, path);
        }
   
        
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
        revistaConverter converter = new revistaConverter(revista.class);
            BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body += line;
            line = reader.readLine();
        }
        System.out.println("body");
        System.out.println(body);
        revista nuevo = converter.fromJson(body);
                   System.out.println("Esto paso primero o no informacion");
        System.out.println("Pueba subida revista");
        System.out.println(nuevo.getNombreRevista());
      //  System.out.println(nuevo.getRevsitaPDF().getAbsolutePath());
        
        
        
    }
    
    
    private void showImage(HttpServletResponse response, String path)
            throws ServletException, IOException {
        try (BufferedInputStream fileStream = new BufferedInputStream(new FileInputStream(path))) {
            response.setContentType("application/pdf");
            int data = fileStream.read();
            while (data > -1) {
                response.getOutputStream().write(data);
                data = fileStream.read();
            }
        }

    }


}
