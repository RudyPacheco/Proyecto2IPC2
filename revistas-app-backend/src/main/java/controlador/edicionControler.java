/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import backend.controlEdicion;
import backend.controlRevista;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import manejoGson.revistaConverter;
import modelo.edicionDAO;
import modelo.edicionModel;
import modelo.revista;
import modelo.revistaDAO;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "edicionControler", urlPatterns = {"/edicionControler"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 100,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000
)
public class edicionControler extends HttpServlet {

     private revista revistaNueva;
    revistaDAO revsitaDAO;
    controlRevista controlRevista;


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
        
          String codigo = request.getParameter("codigo");
           
            if (codigo!=null) {
                 Gson s = new Gson();
            int codigoInt = Integer.parseInt(codigo);
                        edicionDAO edicionDAO = new edicionDAO();
            List<edicionModel> ediciones = edicionDAO.listarEdicion(codigoInt);
             response.getWriter().append(s.toJson(ediciones));
        }else{
                System.out.println("error do get ediciones");
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
        revistaNueva = converter.fromJson(body);
        System.out.println("Esto paso primero o no informacion");
        System.out.println("Pueba subida revista");
        System.out.println(revistaNueva.getNombreRevista());
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        controlRevista control = new controlRevista();
        controlEdicion controlEdicion = new controlEdicion();
        Part file = request.getPart("datafile");
        String fileName = file.getHeader("Content-type");
        String nombreArchivo = file.getSubmittedFileName();
        String path = this.getServletConfig().getServletContext().getRealPath("/archivo");
        File directorio = new File(path);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        file.write(path + "/" + revistaNueva.getFechaCreacion() + nombreArchivo);
        File archivo = new File(path + "/" + revistaNueva.getFechaCreacion() + nombreArchivo);
        controlEdicion.publicarEdicion(revistaNueva, archivo.toString());
       
        System.out.println(archivo.toString());
    }
//          
        
        

    }

  

