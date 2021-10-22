/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import com.google.protobuf.TextFormat;
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

/**
 * 
 * @author AndaryuS
 */
public class suscripcionDAO {

      private PreparedStatement query = null;
    private ResultSet result = null;
    private Connection conexion = null;
    
    
    
    public int registarSuscripcion(suscripcionModel sub,String tipoSUB, double ganancia){
        int registros = 0;
         String sql = "INSERT INTO suscriptores_revista ( codigo_revista,nombre_revista, usuario_editor, nombre_usuario,fecha_suscripcion,tipo_suscripcion,ganancia) VALUES (?,?, ?,?,?,?,?)";
         try {
             conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, sub.getRevista().getCodigo());
            query.setString(2, sub.getRevista().getNombreRevista());
            query.setString(3, sub.getRevista().getEditor());
            query.setString(4, sub.getNombreUsuario());
            query.setDate(5, getFecha(sub.getFechaSuscripcion()));
            query.setString(6, tipoSUB);
            query.setDouble(7, ganancia);
            registros = query.executeUpdate();
        } catch (SQLException | ParseException e) {
             System.out.println("error al registrar suscripcion");
            e.printStackTrace(System.out);
        }
        
        
        return registros;
    }



    public int registarGananciaSub(suscripcionModel sub, double ingreso, double ganancia){
        int registros = 0;
         String sql = "INSERT INTO ganancias_suscripciones ( codigo_revista,nombre_revista, usuario_editor, nombre_usuario,fecha_suscripcion,ingreso_sub,ganancia) VALUES (?,?,?,?,?,?,?)";
         try {
             conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, sub.getRevista().getCodigo());
            query.setString(2, sub.getRevista().getNombreRevista());
            query.setString(3, sub.getRevista().getEditor());
            query.setString(4, sub.getNombreUsuario());
            query.setDate(5, getFecha(sub.getFechaSuscripcion()));
            query.setDouble(6, ingreso);
            query.setDouble(7, ganancia);
            registros = query.executeUpdate();
        } catch (SQLException | ParseException e) {
             System.out.println("error al registrar suscripcion");
                         e.printStackTrace(System.out);
        }finally{
             
         }
        
        
        return registros;
    }

    
        public porcentaje porcentajeGananciasl(){
             String consulta = "SELECT * FROM porcentaje_ganancias WHERE fecha_asignacion = (SELECT MAX(fecha_asignacion) FROM porcentaje_ganancias)";
             porcentaje costo = new porcentaje();
            
            try {
                conexion=conexionDB.getConexion();
                query = conexion.prepareStatement(consulta);
                result=query.executeQuery();
                while (result.next()) {                    
                    costo.setPorcentajeUsuario(result.getInt("porcentaje_usuario"));
                    costo.setPorcentajeSistema(result.getInt("porcentaje_sistema"));
                }
                
            } catch (SQLException e) {
            
                System.out.println("error en el costo global");
            }
            
            
            return costo;
            
        }
        
     
    public List listarSuscripciones(String nombre) {
        String consulta = "SELECT * FROM suscriptores_revista WHERE nombre_usuario=?";
        List<Integer> codigos = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, nombre);
            result = query.executeQuery();
            while (result.next()) {
                etiquetaModel etiqueta = new etiquetaModel();
                etiqueta.setId(result.getInt("codigo_revista"));
                codigos.add(etiqueta.getId());
                System.out.println("id "+etiqueta.getId());
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        }

        return codigos;
    }

        

    
       public String genearSerie() {
        String numeroSerie = "";
        String sql = "SELECT MAX(codigo_revista) FROM revista";
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            result = query.executeQuery();
            while (result.next()) {
                numeroSerie = result.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al generar Serie");
            e.printStackTrace(System.out);
        }

        return numeroSerie;
    }
    
 

    
    
    
        private Date getFecha(String localDate) throws ParseException, java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        java.util.Date nFecha = formato.parse(localDate);
        fecha = new java.sql.Date(nFecha.getTime());

        return fecha;

    }
    
}
