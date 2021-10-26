/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.conexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reportModels.modeloGananciaSistema;
import reportModels.reporteSuscripciones;

/**
 *
 * @author AndaryuS
 */
public class reporteAdminDAO {

    private PreparedStatement query = null;
    private ResultSet result = null;
    private Connection conexion = null;

    
    
    
    public List listarCodigoRevistas(){
        String consulta = "SELECT DISTINCT codigo_revista FROM ganancias_suscripciones";
        
        List<Integer> codigos = new ArrayList<>();
             try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            result = query.executeQuery();
            while (result.next()) {
                int codigoTmp = result.getInt("codigo_revista");
                codigos.add(codigoTmp);
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        } finally {
            cierre();
        }
        
        return codigos;
    }
    
    
    
    public List listarSuscripcionesEditor() {
        String consulta = "SELECT * FROM ganancias_suscripciones";

        List<modeloGananciaSistema> suscripciones = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            result = query.executeQuery();
            while (result.next()) {
                modeloGananciaSistema tmp = new modeloGananciaSistema();
                tmp.setCodigoRevista(result.getInt("codigo_revista"));
                tmp.setNombreRevista(result.getString("nombre_revista"));
                tmp.setNombre_usuario(result.getString("nombre_usuario"));
                tmp.setUsuarioEditor(result.getString("usuario_editor"));
                tmp.setGanancia(result.getDouble("ganancia"));
                tmp.setIngreso_sub(result.getDouble("ingreso_sub"));
                tmp.setFecha_suscripcion(result.getDate("fecha_suscripcion").toString());
                suscripciones.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        } finally {
            cierre();
        }

        return suscripciones;
    }

    public List listarSuscripcionesFechas( String fechaInicial, String fechaFinal) {
        String consulta = "SELECT * FROM ganancias_suscripcionesa WHERE fecha_suscripcion BETWEEN ? AND ?";

        List<modeloGananciaSistema> suscripciones = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setDate(1, getFecha(fechaInicial));
            query.setDate(2, getFecha(fechaFinal));
            result = query.executeQuery();
            while (result.next()) {
                modeloGananciaSistema tmp = new modeloGananciaSistema();
                tmp.setCodigoRevista(result.getInt("codigo_revista"));
                tmp.setNombreRevista(result.getString("nombre_revista"));
                tmp.setNombre_usuario(result.getString("nombre_usuario"));
                tmp.setUsuarioEditor(result.getString("usuario_editor"));
                tmp.setGanancia(result.getDouble("ganancia"));
                tmp.setIngreso_sub(result.getDouble("ingreso_sub"));
                tmp.setFecha_suscripcion(result.getDate("fecha_suscripcion").toString());
                suscripciones.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        } catch (ParseException ex) {
            Logger.getLogger(suscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }

        return suscripciones;
    }

    public List listarSuscripcionesCodigo(int codigo) {
        String consulta = "SELECT * FROM ganancias_suscripciones WHERE codigo_revista=?";

        List<modeloGananciaSistema> suscripciones = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            result = query.executeQuery();
            while (result.next()) {
                modeloGananciaSistema tmp = new modeloGananciaSistema();
                tmp.setCodigoRevista(result.getInt("codigo_revista"));
                tmp.setNombreRevista(result.getString("nombre_revista"));
                tmp.setNombre_usuario(result.getString("nombre_usuario"));
                tmp.setUsuarioEditor(result.getString("usuario_editor"));
                tmp.setGanancia(result.getDouble("ganancia"));
                tmp.setIngreso_sub(result.getDouble("ingreso_sub"));
                tmp.setFecha_suscripcion(result.getDate("fecha_suscripcion").toString());
                suscripciones.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
             e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return suscripciones;
    }

    public List listarSuscripcionesCodigoFecha(int codigo, String fechaInicial, String fechaFinal) {
        String consulta = "SELECT * FROM ganancias_suscripciones WHERE codigo_revista=? AND  fecha_suscripcion BETWEEN ? AND ?";

        List<modeloGananciaSistema> suscripciones = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            query.setDate(2, getFecha(fechaInicial));
            query.setDate(3, getFecha(fechaFinal));
            result = query.executeQuery();
            while (result.next()) {
                modeloGananciaSistema tmp = new modeloGananciaSistema();
                tmp.setCodigoRevista(result.getInt("codigo_revista"));
                tmp.setNombreRevista(result.getString("nombre_revista"));
                tmp.setNombre_usuario(result.getString("nombre_usuario"));
                tmp.setUsuarioEditor(result.getString("usuario_editor"));
                tmp.setGanancia(result.getDouble("ganancia"));
                  tmp.setIngreso_sub(result.getDouble("ingreso_sub"));
                tmp.setFecha_suscripcion(result.getDate("fecha_suscripcion").toString());
                suscripciones.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
             e.printStackTrace(System.out);
        } catch (ParseException ex) {
            Logger.getLogger(suscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }

        return suscripciones;
    }

    private Date getFecha(String localDate) throws ParseException, java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        java.util.Date nFecha = formato.parse(localDate);
        fecha = new java.sql.Date(nFecha.getTime());

        return fecha;

    }

    private void cierre() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar sql  db");
            }
        }
        if (result != null) {
            try {
                result.close();
            } catch (SQLException ex) {
                System.out.println("error al cerrar resul");
            }
        }
        if (query != null) {
            try {
                query.close();
            } catch (SQLException ex) {
                System.out.println("error al cerrar query");
            }
        }

    }

}
