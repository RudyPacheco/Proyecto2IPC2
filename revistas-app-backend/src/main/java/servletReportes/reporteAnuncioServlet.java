/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletReportes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import service.reporteAdminService;

/**
 *
 * @author AndaryuS
 */
@WebServlet(name = "reporteAnuncioServlet", urlPatterns = {"/reporteAnuncioServlet"})
public class reporteAnuncioServlet extends HttpServlet {

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
        try {
            reporteAdminService reporte = new reporteAdminService(conexion.conexionDB.getConexion());
            String descargar = request.getParameter("descargar");
            String fechaI = request.getParameter("fechaI");
            String fechaF = request.getParameter("fechaF");
            System.out.println("datos reporte");
            System.out.println(descargar + fechaI + fechaF);
            response.setContentType("application/pdf");
            if (descargar != null) {
                response.setHeader("Content-disposition", "attachment; filename=ReporteComentario.pdf");
            }

            reporte.reporteAnuncios(fechaI, fechaF, response.getOutputStream());

        } catch (JRException ex) {
            Logger.getLogger(reporteSuscripcionesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
