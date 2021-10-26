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
import modelo.meGustaModel;
import modelo.revista;
import modelo.revistaDAO;
import modelo.suscripcionDAO;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reportModels.reporteComentarios;
import reportModels.reporteGanancias;
import reportModels.reporteMeGusta;
import reportModels.reporteSuscripciones;

/**
 *
 * @author AndaryuS
 */
public class reporteEditorService {

    private Connection connection;
    revistaDAO revistaDAO;
    informacionDAO informacionDAO;
    interaccionDAO interraccionDAO;
    suscripcionDAO suscripcionDAO;

    public reporteEditorService(Connection connection) {
        this.connection = connection;
    }

    public void reportComentarios(String fechaInicial, String fechaFinal, String editor, String revista, OutputStream targetStream) throws JRException {

        InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("/reportes/reporteComentario.jasper");

        revistaDAO = new revistaDAO();
        informacionDAO = new informacionDAO();
        interraccionDAO = new interaccionDAO();
        revista revistaBuscada;
        List<revista> revistasEditor = revistaDAO.listarRevistaE(editor);
        List<reporteComentarios> comentarioReporte = new ArrayList<>();

        //metodo sin fechas
        if (fechaInicial.equalsIgnoreCase("") || fechaFinal.equalsIgnoreCase("")) {
            //sin codigo
            if (revista.equalsIgnoreCase("")) {
                for (int i = 0; i < revistasEditor.size(); i++) {
                    List<comentarioModel> comenTMP = interraccionDAO.listarComentariosRevista(revistasEditor.get(i).getCodigo());
                    if (comenTMP.size() > 0) {
                        reporteComentarios tmp = new reporteComentarios();
                        tmp.setComentarios(comenTMP);
                        tmp.setNombreRevista(revistasEditor.get(i).getNombreRevista());
                        comentarioReporte.add(tmp);
                    }

                }
                //con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revistaBuscada = revistaDAO.buscarRevistaNombre(revista, editor);
                //   revista revista = revistaDAO.buscarRevista();
                List<comentarioModel> comenTMP = interraccionDAO.listarComentariosRevista(revistaBuscada.getCodigo());

                reporteComentarios tmp = new reporteComentarios();
                tmp.setNombreRevista(revistaBuscada.getNombreRevista());
                tmp.setComentarios(comenTMP);
                comentarioReporte.add(tmp);
            }

            //metodo con fechas
        } else if (!fechaInicial.equalsIgnoreCase("") && !fechaFinal.equalsIgnoreCase("")) {

            //sin codigo
            if (revista.equalsIgnoreCase("")) {
                for (int i = 0; i < revistasEditor.size(); i++) {
                    List<comentarioModel> comenTMP = interraccionDAO.listarComentariosRevistaFechas(fechaInicial, fechaFinal, revistasEditor.get(i).getCodigo());
                    if (comenTMP.size() > 0) {
                        reporteComentarios tmp = new reporteComentarios();
                        tmp.setComentarios(comenTMP);
                        tmp.setNombreRevista(revistasEditor.get(i).getNombreRevista());
                        comentarioReporte.add(tmp);
                    }

                }
                //metodo con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revistaBuscada = revistaDAO.buscarRevistaNombre(revista, editor);
                //  revista revista = revistaDAO.buscarRevista(codigo);
                List<comentarioModel> comenTMP = interraccionDAO.listarComentariosRevistaFechas(fechaInicial, fechaFinal, revistaBuscada.getCodigo());
                reporteComentarios tmp = new reporteComentarios();
                tmp.setNombreRevista(revistaBuscada.getNombreRevista());
                tmp.setComentarios(comenTMP);
                comentarioReporte.add(tmp);
            }

        }

        JRDataSource source = new JRBeanCollectionDataSource(comentarioReporte);
        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);
        JasperExportManager.exportReportToPdfStream(printer, targetStream);

    }

    public void reporteSuscripcion(String fechaInicial, String fechaFinal, String editor, String revista, OutputStream targetStream) throws JRException {

        InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("/reportes/reporteSuscripciones.jasper");

        suscripcionDAO = new suscripcionDAO();
        revistaDAO = new revistaDAO();
        revista revistaBuscada;
        List<reporteSuscripciones> suscriciones = new ArrayList<>();

        //metodo sin fechas
        if (fechaInicial.equalsIgnoreCase("") || fechaFinal.equalsIgnoreCase("")) {
            //sin codigo
            if (revista.equalsIgnoreCase("")) {
                suscriciones = suscripcionDAO.listarSuscripcionesEditor(editor);
                //con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revistaBuscada = revistaDAO.buscarRevistaNombre(revista, editor);
                suscriciones = suscripcionDAO.listarSuscripcionesCodigo(revistaBuscada.getCodigo());
            }

            //metodo con fechas
        } else if (!fechaInicial.equalsIgnoreCase("") && !fechaFinal.equalsIgnoreCase("")) {

            //sin codigo
            if (revista.equalsIgnoreCase("")) {
                suscriciones = suscripcionDAO.listarSuscripcionesEditoFechas(editor, fechaInicial, fechaFinal);
                //metodo con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revistaBuscada = revistaDAO.buscarRevistaNombre(revista, editor);
                suscriciones = suscripcionDAO.listarSuscripcionesCodigoFecha(revistaBuscada.getCodigo(), fechaInicial, fechaFinal);

            }

        }

        JRDataSource source = new JRBeanCollectionDataSource(suscriciones);
        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);
        JasperExportManager.exportReportToPdfStream(printer, targetStream);

    }

    public void reporteRevistaGustada(String fechaInicial, String fechaFinal, String editor, String revista, OutputStream targetStream) throws JRException {
        InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("/reportes/reporteMeGusta.jasper");

        revistaDAO = new revistaDAO();
        interraccionDAO = new interaccionDAO();
        List<revista> revistasEditor = revistaDAO.listarRevistaE(editor);
        List<reporteMeGusta> listaMegusta = new ArrayList<>();
        revista revistaBuscada;

        //metodo sin fechas
        if (fechaInicial.equalsIgnoreCase("") || fechaFinal.equalsIgnoreCase("")) {
            //sin codigo
            if (revista.equalsIgnoreCase("")) {
                for (int i = 0; i < revistasEditor.size(); i++) {
                    List<meGustaModel> likes = interraccionDAO.listarMeGustaRevista(revistasEditor.get(i).getCodigo());
                    if (likes.size() > 0) {
                        reporteMeGusta tmp = new reporteMeGusta();
                        tmp.setNombreRevista(revistasEditor.get(i).getNombreRevista());
                        tmp.setMeGustas(likes);
                        listaMegusta.add(tmp);
                    }

                }
                //con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revistaBuscada = revistaDAO.buscarRevistaNombre(revista, editor);
                List<meGustaModel> likes = interraccionDAO.listarMeGustaRevista(revistaBuscada.getCodigo());
                reporteMeGusta tmp = new reporteMeGusta();
                tmp.setNombreRevista(revistaBuscada.getNombreRevista());
                tmp.setMeGustas(likes);
                listaMegusta.add(tmp);

            }

            //metodo con fechas
        } else if (!fechaInicial.equalsIgnoreCase("") && !fechaFinal.equalsIgnoreCase("")) {

            //sin codigo
            if (revista.equalsIgnoreCase("")) {
                for (int i = 0; i < revistasEditor.size(); i++) {
                    List<meGustaModel> likes = interraccionDAO.listarMeGustaRevistaFechas(revistasEditor.get(i).getCodigo(), fechaInicial, fechaFinal);
                    if (likes.size() > 0) {
                        reporteMeGusta tmp = new reporteMeGusta();
                        tmp.setNombreRevista(revistasEditor.get(i).getNombreRevista());
                        tmp.setMeGustas(likes);
                        listaMegusta.add(tmp);
                    }

                }

                //metodo con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revistaBuscada = revistaDAO.buscarRevistaNombre(revista, editor);
                List<meGustaModel> likes = interraccionDAO.listarMeGustaRevistaFechas(revistaBuscada.getCodigo(), fechaInicial, fechaFinal);
                reporteMeGusta tmp = new reporteMeGusta();
                tmp.setNombreRevista(revistaBuscada.getNombreRevista());
                tmp.setMeGustas(likes);
                listaMegusta.add(tmp);
            }

        }

        JRDataSource source = new JRBeanCollectionDataSource(listaMegusta);
        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);
        JasperExportManager.exportReportToPdfStream(printer, targetStream);

    }

    public void reporteGananciasXtiempo(String fechaInicial, String fechaFinal, String editor, String revista, OutputStream targetStream) throws JRException {
        InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("/reportes/reporteGananciasEditor.jasper");

        List<reporteGanancias> gananciasR = new ArrayList<>();
        suscripcionDAO = new suscripcionDAO();
        revistaDAO = new revistaDAO();
        informacionDAO = new informacionDAO();
        interraccionDAO = new interaccionDAO();
        double gananciaTOTAL = 0;
        List<revista> revistasEditor = revistaDAO.listarRevistaE(editor);

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
                for (int i = 0; i < revistasEditor.size(); i++) {
                    List<reporteSuscripciones> subs = suscripcionDAO.listarSuscripcionesCodigo(revistasEditor.get(i).getCodigo());
                    if (subs.size() > 0) {
                        reporteGanancias tmp = new reporteGanancias();
                        tmp.setNombreRevista(revistasEditor.get(i).getNombreRevista());
                        tmp.setSuscripciones(subs);
                        for (int j = 0; j < subs.size(); j++) {
                            gananciaTOTAL += subs.get(j).getGanancia();
                        }
                        tmp.setGananciaTotal(gananciaTOTAL);
                        gananciasR.add(tmp);
                    }
                }

                //con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revista revistaBuscada = revistaDAO.buscarRevistaNombre(revista, editor);
                List<reporteSuscripciones> suscriciones = suscripcionDAO.listarSuscripcionesCodigo(revistaBuscada.getCodigo());
                reporteGanancias tmp = new reporteGanancias();
                tmp.setNombreRevista(revistaBuscada.getNombreRevista());
                tmp.setSuscripciones(suscriciones);
                for (int j = 0; j < suscriciones.size(); j++) {
                    gananciaTOTAL += suscriciones.get(j).getGanancia();
                }
                tmp.setGananciaTotal(gananciaTOTAL);
                gananciasR.add(tmp);

            }
            //metodo con fechas
        } else if (!fechaInicial.equalsIgnoreCase("") && !fechaFinal.equalsIgnoreCase("")) {

            //sin codigo
            if (revista.equalsIgnoreCase("")) {

                for (int i = 0; i < revistasEditor.size(); i++) {
                    List<reporteSuscripciones> subs = suscripcionDAO.listarSuscripcionesCodigoFecha(revistasEditor.get(i).getCodigo(), fechaInicial, fechaFinal);
                    if (subs.size() > 0) {
                        reporteGanancias tmp = new reporteGanancias();
                        tmp.setNombreRevista(revistasEditor.get(i).getNombreRevista());
                        tmp.setSuscripciones(subs);
                        for (int j = 0; j < subs.size(); j++) {
                            gananciaTOTAL += subs.get(j).getGanancia();
                        }
                        tmp.setGananciaTotal(gananciaTOTAL);
                        gananciasR.add(tmp);
                    }
                }

                //metodo con codigo
            } else if (!revista.equalsIgnoreCase("")) {
                revista revistaBuscada = revistaDAO.buscarRevistaNombre(revista, editor);

                List<reporteSuscripciones> suscriciones = suscripcionDAO.listarSuscripcionesCodigoFecha(revistaBuscada.getCodigo(), fechaInicial, fechaFinal);
                reporteGanancias tmp = new reporteGanancias();
                tmp.setNombreRevista(revistaBuscada.getNombreRevista());
                tmp.setSuscripciones(suscriciones);
                for (int j = 0; j < suscriciones.size(); j++) {
                    gananciaTOTAL += suscriciones.get(j).getGanancia();
                }
                tmp.setGananciaTotal(gananciaTOTAL);
                gananciasR.add(tmp);
            }

        }

        JRDataSource source = new JRBeanCollectionDataSource(gananciasR);
        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);
        JasperExportManager.exportReportToPdfStream(printer, targetStream);

    }
}
