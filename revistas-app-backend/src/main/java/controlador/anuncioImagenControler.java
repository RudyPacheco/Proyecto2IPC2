/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import manejoGson.anuncioConverter;
import modelo.anuncioDAO;
import modelo.anuncioModel;
import service.controlAnuncios;
import service.controlRevista;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "anuncioImagenControler", urlPatterns = {"/anuncioImagenControler"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 100,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000
)
public class anuncioImagenControler extends HttpServlet {
        anuncioModel anuncioM;
    
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
            anuncioDAO anuncioDAO = new anuncioDAO();
            String anuncio = request.getParameter("anuncio");
            if (anuncio!=null) {
             int codigo = Integer.parseInt(anuncio);
             anuncioModel anuncioB = anuncioDAO.buscarAnuncio(codigo);
                showImage(response, anuncioB.getImagen(), anuncioB.getContentType());
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
          controlAnuncios control = new controlAnuncios();
          anuncioConverter converter = new anuncioConverter(anuncioModel.class);
    BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body += line;
            line = reader.readLine();
        }
        System.out.println("body");
        System.out.println(body);
        anuncioM = converter.fromJson(body);
      
    }
    
    
    
        @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        controlAnuncios control = new controlAnuncios();
        String revistaNom = "Foto.jpg";
        Part file = request.getPart("datafile");
        String fileName = file.getHeader("Content-type");
     //   String nombreArchivo = file.getSubmittedFileName();
        String path = this.getServletConfig().getServletContext().getRealPath("/archivo");
        File directorio = new File(path);
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        file.write(path + "/" + control.generarCodigo() + revistaNom);
        File archivo = new File(path + "/" + control.generarCodigo() + revistaNom);
        anuncioM.setImagen(archivo.toString());
        anuncioM.setContentType(fileName);
        control.publicarAnuncioImagen(anuncioM);
        System.out.println(archivo.toString());
    }
    
      private void showImage(HttpServletResponse response, String path, String type)
            throws ServletException, IOException {
        try (BufferedInputStream fileStream = new BufferedInputStream(new FileInputStream(path))) {
            response.setContentType(type);
            int data = fileStream.read();
            while (data > -1) {
                response.getOutputStream().write(data);
                data = fileStream.read();
            }
        }

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
