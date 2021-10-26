/*0
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import service.controlInteraccion;
import service.controlUsuario;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.comentarioModel;
import modelo.interaccionDAO;
import modelo.meGustaModel;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "comentarioControler", urlPatterns = {"/comentarioControler"})
public class comentarioControler extends HttpServlet {



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
        int codigoINT = Integer.parseInt(codigo);
        interaccionDAO interraccionDAO = new interaccionDAO();
        System.out.println(codigoINT);

        Gson s = new Gson();

        List<comentarioModel> comentarios = interraccionDAO.listarComentariosRevista(codigoINT);
         for (int i = 0; i < comentarios.size(); i++) {
             System.out.println(comentarios.get(i).getCodigoRevista());
        }
        
           response.getWriter().append(s.toJson(comentarios));
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
 
    
        controlInteraccion control = new controlInteraccion();
        BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body += line;
            line = reader.readLine();
        }
        System.out.println("body");
        System.out.println(body);
       response.getWriter().append(control.comentarRevista(body));
      
        // response.getWriter().append(body);
    

}
        
    

}





