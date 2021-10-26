/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import service.controlRevista;
import com.google.gson.Gson;
import com.mycompany.revistas.app.backend.usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Runtime.version;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.servlet.http.MappingMatch.PATH;
import javax.servlet.http.Part;
import manejoGson.revistaConverter;
import modelo.revista;
import modelo.revistaDAO;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "uploadRevista", urlPatterns = {"/uploadRevista"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 100,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000
)
public class uploadRevista extends HttpServlet {

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

        String editor = request.getParameter("editor");
        String usuarioR= request.getParameter("usuario");
        String usuarioG= request.getParameter("general");

        if (editor !=null) {
            System.out.println(editor);
            Gson s = new Gson();
            revsitaDAO = new revistaDAO();
            List<revista> revistas= revsitaDAO.listarRevistaE(editor);
            for (int i = 0; i < revistas.size(); i++) {
               revista tmp = revistas.get(i);
               tmp.setEtiquetas((ArrayList<String>) revsitaDAO.listarEtiquetas(tmp.getCodigo()));
            }
            
            response.getWriter().append(s.toJson(revistas));
            
        }else if (usuarioR!=null) {
            
        }else if(usuarioG!=null){
              Gson s = new Gson();
            controlRevista= new controlRevista();
             List<revista> revistas= controlRevista.revistasRecomendacion(usuarioG);
             response.getWriter().append(s.toJson(revistas));
            
        }
        if (editor==null && usuarioG ==null && usuarioR==null) {
            Gson s = new Gson();
            revsitaDAO = new revistaDAO();
            List<revista> revistas= revsitaDAO.listarRevista();
            for (int i = 0; i < revistas.size(); i++) {
               revista tmp = revistas.get(i);
               tmp.setEtiquetas((ArrayList<String>) revsitaDAO.listarEtiquetas(tmp.getCodigo()));
            }
              response.getWriter().append(s.toJson(revistas));
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

        Part file = request.getPart("datafile");
        String fileName = file.getHeader("Content-type");
        String nombreArchivo = file.getSubmittedFileName();
        String path = this.getServletConfig().getServletContext().getRealPath("/archivo");
        File directorio = new File(path);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        file.write(path + "/" + control.generarCodigo() + nombreArchivo);
        File archivo = new File(path + "/" + control.generarCodigo() + nombreArchivo);
        control.publicarRevsita(revistaNueva, archivo.toString());
        System.out.println(archivo.toString());
    }
//                
//        InputStream fileStream = filePart.getInputStream();
//        System.out.println(fileName);
//        System.out.println(filePart.getHeader("Content-disposition"));

//        try (BufferedReader in = new BufferedReader(new InputStreamReader(fileStream))) {
//            String line = in.readLine();
//            while (line != null) {
//                System.out.println(line);
//                line = in.readLine();
//            }
//            String filePath = PATH + "/" + "archivo";
//            filePart.write(filePath);
//            System.out.println("Esto paso primero o no archivo");
//            
//        } catch (Exception ex) {
//            // manejo de error
//        }
}
