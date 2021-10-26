
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import modelo.comentarioModel;
import modelo.informacionDAO;
import modelo.interaccionDAO;
import modelo.reporteAdminDAO;
import modelo.revista;
import modelo.revistaDAO;
import modelo.suscripcionDAO;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reportModels.modeloGananciaSistema;
import reportModels.reporteComentarios;
import reportModels.reporteGananciaSistema;
import reportModels.reporteGanancias;
import reportModels.reporteRevistaPopular;
import reportModels.reporteSuscripciones;

/**
 *
 * @author AndaryuS
 */
public class reporteAdminService {

    private Connection connection;
    revistaDAO revistaDAO;
    informacionDAO informacionDAO;
    interaccionDAO interraccionDAO;
    suscripcionDAO suscripcionDAO;
    reporteAdminDAO reporteAdminDAO;

    public reporteAdminService(Connection connection) {
        this.connection = connection;
    }

    //falta el jasper
    public void reporteGananciasXRevista(String fechaInicial, String fechaFinal, String revista, OutputStream targetStream) throws JRException {
        InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("/reportes/ReporteGananciasRevistaAdmin.jasper");
        List<reporteGananciaSistema> gananciaSistemas = new ArrayList<>();

        suscripcionDAO = new suscripcionDAO();
        revistaDAO = new revistaDAO();
        informacionDAO = new informacionDAO();
        interraccionDAO = new interaccionDAO();
        reporteAdminDAO = new reporteAdminDAO();

        double ingresoTotal = 0;
        double gananciaTotal = 0;
        double costoTotal = 0;
        //  List<reporteSuscripciones> suscriciones = new ArrayList<>();
        //metodo sin codigo
//        if (revista.equalsIgnoreCase("")) {
//
//            //metodo con codigo
//        } else {
//
//        }

        //agreango fechas
        //metodo sin fechas
        if (fechaInicial.equalsIgnoreCase("") || fechaFinal.equalsIgnoreCase("")) {
            //sin codigo
            if (revista.equalsIgnoreCase("")) {

                List<Integer> codigos = reporteAdminDAO.listarCodigoRevistas();
                for (int i = 0; i < codigos.size(); i++) {
                    revista tmp = revistaDAO.buscarRevista(codigos.get(i));
                    List<modeloGananciaSistema> susripciones = reporteAdminDAO.listarSuscripcionesCodigo(tmp.getCodigo());
                    double costoRevista = informacionDAO.obtenerCostoRevistal(tmp.getCodigo());
                    if (susripciones.size() > 0) {
                        reporteGananciaSistema gananciaTMP = new reporteGananciaSistema();
                        gananciaTMP.setNombreRevista(tmp.getNombreRevista());
                        gananciaTMP.setSuscripciones(susripciones);
                        gananciaTMP.setCostoRevista(costoRevista);
                        for (int j = 0; j < susripciones.size(); j++) {
                            ingresoTotal += susripciones.get(j).getIngreso_sub();
                            gananciaTotal += susripciones.get(j).getGanancia();
                        }
                        gananciaTMP.setCostoTotal(costoRevista);
                        gananciaTMP.setGananciaTotal(gananciaTotal);
                        gananciaTMP.setIngresoTotal(ingresoTotal);
                        gananciaSistemas.add(gananciaTMP);
                    }

                }

                //con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revista revistaBuscada = revistaDAO.buscarRevistaNombreSinEditor(revista);
                double costoRevista = informacionDAO.obtenerCostoRevistal(revistaBuscada.getCodigo());
                List<modeloGananciaSistema> susripciones = reporteAdminDAO.listarSuscripcionesCodigo(revistaBuscada.getCodigo());
                reporteGananciaSistema gananciaTMP = new reporteGananciaSistema();
                for (int i = 0; i < susripciones.size(); i++) {
                    ingresoTotal += susripciones.get(i).getIngreso_sub();
                    gananciaTotal += susripciones.get(i).getGanancia();
                }
                gananciaTMP.setNombreRevista(revistaBuscada.getNombreRevista());
                gananciaTMP.setSuscripciones(susripciones);
                gananciaTMP.setCostoRevista(costoRevista);
                gananciaTMP.setGananciaTotal(gananciaTotal);
                gananciaTMP.setIngresoTotal(ingresoTotal);
                gananciaTMP.setCostoTotal(costoRevista);
                gananciaSistemas.add(gananciaTMP);
            }
            //metodo con fechas
        } else if (!fechaInicial.equalsIgnoreCase("") && !fechaFinal.equalsIgnoreCase("")) {

            //sin codigo
            if (revista.equalsIgnoreCase("")) {

                List<Integer> codigos = reporteAdminDAO.listarCodigoRevistas();
                for (int i = 0; i < codigos.size(); i++) {
                    revista tmp = revistaDAO.buscarRevista(codigos.get(i));
                    List<modeloGananciaSistema> susripciones = reporteAdminDAO.listarSuscripcionesCodigoFecha(tmp.getCodigo(), fechaInicial, fechaFinal);
                    double costoRevista = informacionDAO.obtenerCostoRevistal(tmp.getCodigo());
                    if (susripciones.size() > 0) {
                        reporteGananciaSistema gananciaTMP = new reporteGananciaSistema();
                        gananciaTMP.setNombreRevista(tmp.getNombreRevista());
                        gananciaTMP.setSuscripciones(susripciones);
                        gananciaTMP.setCostoRevista(costoRevista);
                        for (int j = 0; j < susripciones.size(); j++) {
                            ingresoTotal += susripciones.get(j).getIngreso_sub();
                            gananciaTotal += susripciones.get(j).getGanancia();
                        }
                        gananciaTMP.setCostoTotal(costoRevista);
                        gananciaTMP.setGananciaTotal(gananciaTotal);
                        gananciaTMP.setIngresoTotal(ingresoTotal);
                        gananciaSistemas.add(gananciaTMP);
                    }

                }
                //metodo con codigo
            } else if (!revista.equalsIgnoreCase("")) {

                revista revistaBuscada = revistaDAO.buscarRevistaNombreSinEditor(revista);
                double costoRevista = informacionDAO.obtenerCostoRevistal(revistaBuscada.getCodigo());
                List<modeloGananciaSistema> susripciones = reporteAdminDAO.listarSuscripcionesCodigoFecha(revistaBuscada.getCodigo(), fechaInicial, fechaFinal);
                reporteGananciaSistema gananciaTMP = new reporteGananciaSistema();
                for (int i = 0; i < susripciones.size(); i++) {
                    ingresoTotal += susripciones.get(i).getIngreso_sub();
                    gananciaTotal += susripciones.get(i).getGanancia();
                }
                gananciaTMP.setNombreRevista(revistaBuscada.getNombreRevista());
                gananciaTMP.setSuscripciones(susripciones);
                gananciaTMP.setCostoRevista(costoRevista);
                gananciaTMP.setGananciaTotal(gananciaTotal);
                gananciaTMP.setIngresoTotal(ingresoTotal);
                gananciaTMP.setCostoTotal(costoRevista);
                gananciaSistemas.add(gananciaTMP);

            }

        }

        JRDataSource source = new JRBeanCollectionDataSource(gananciaSistemas);
        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);
        JasperExportManager.exportReportToPdfStream(printer, targetStream);

    }

    public void reporteRevistasPopulares(String fechaInicial, String fechaFinal, OutputStream targetStream) throws JRException {
        InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("/reportes/reporteRevistasPopulares.jasper");

        suscripcionDAO = new suscripcionDAO();
        revistaDAO = new revistaDAO();
        informacionDAO = new informacionDAO();
        interraccionDAO = new interaccionDAO();
        reporteAdminDAO = new reporteAdminDAO();

        List<reporteRevistaPopular> populares = new ArrayList<>();

        //metodo sin fechas
        if (fechaInicial.equalsIgnoreCase("") || fechaFinal.equalsIgnoreCase("")) {
            List<Integer> codigosRevista = interraccionDAO.listarRevistasMegusta();
            for (int i = 0; i < codigosRevista.size(); i++) {
                revista tmp = revistaDAO.buscarRevista(codigosRevista.get(i));
                List<reporteSuscripciones> subs = suscripcionDAO.listarSuscripcionesCodigo(tmp.getCodigo());
                if (subs.size() > 0) {
                    reporteRevistaPopular popular = new reporteRevistaPopular();
                    popular.setNombreRevista(tmp.getNombreRevista());
                    popular.setSuscripciones(subs);
                    popular.setTotalSub(subs.size() + 1);
                    populares.add(popular);
                }
            }

            //metodo con fechas
        } else {

            List<Integer> codigosRevista = interraccionDAO.listarRevistasMegustaFecha(fechaInicial, fechaFinal);
            for (int i = 0; i < codigosRevista.size(); i++) {
                revista tmp = revistaDAO.buscarRevista(codigosRevista.get(i));
                List<reporteSuscripciones> subs = suscripcionDAO.listarSuscripcionesCodigo(tmp.getCodigo());
                if (subs.size() > 0) {
                    reporteRevistaPopular popular = new reporteRevistaPopular();
                    popular.setNombreRevista(tmp.getNombreRevista());
                    popular.setSuscripciones(subs);
                    popular.setTotalSub(subs.size() + 1);
                    populares.add(popular);
                }
            }

        }

        JRDataSource source = new JRBeanCollectionDataSource(populares);
        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);
        JasperExportManager.exportReportToPdfStream(printer, targetStream);

    }

    public void reporteRevistasComentadas(String fechaInicial, String fechaFinal, OutputStream targetStream) throws JRException {
         InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("/reportes/reporteRevistasComentadas.jasper");

        //metodo sin fechas
        suscripcionDAO = new suscripcionDAO();
        revistaDAO = new revistaDAO();
        informacionDAO = new informacionDAO();
        interraccionDAO = new interaccionDAO();
        reporteAdminDAO = new reporteAdminDAO();
        List<reporteComentarios> comentariosR = new ArrayList<>();

        //metodo sin fechas
        if (fechaInicial.equalsIgnoreCase("") || fechaFinal.equalsIgnoreCase("")) {
            List<Integer> codigosR = interraccionDAO.listarRevistasComentario();
            for (int i = 0; i < codigosR.size(); i++) {
                revista revista = revistaDAO.buscarRevista(codigosR.get(i));
                List<comentarioModel> cometarios = interraccionDAO.listarComentariosRevista(revista.getCodigo());
                if (cometarios.size() > 0) {
                    reporteComentarios reporte = new reporteComentarios();
                    reporte.setNombreRevista(revista.getNombreRevista());
                    reporte.setComentarios(cometarios);
                    comentariosR.add(reporte);
                }
            }

            //metodo con fechas
        } else {
            List<Integer> codigosR = interraccionDAO.listarRevistaComentarioFecha(fechaInicial, fechaFinal);
            for (int i = 0; i < codigosR.size(); i++) {
                revista revista = revistaDAO.buscarRevista(codigosR.get(i));
                List<comentarioModel> cometarios = interraccionDAO.listarComentariosRevista(revista.getCodigo());
                if (cometarios.size() > 0) {
                    reporteComentarios reporte = new reporteComentarios();
                    reporte.setNombreRevista(revista.getNombreRevista());
                    reporte.setComentarios(cometarios);
                    comentariosR.add(reporte);
                }
            }

        }
        
        JRDataSource source = new JRBeanCollectionDataSource(comentariosR);
        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);
        JasperExportManager.exportReportToPdfStream(printer, targetStream);

    }

}
