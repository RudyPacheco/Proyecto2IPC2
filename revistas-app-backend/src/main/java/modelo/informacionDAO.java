/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.google.protobuf.TextFormat;
import com.mycompany.revistas.app.backend.usuario;
import conexion.conexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AndaryuS
 */
public class informacionDAO {

    private PreparedStatement query = null;
    private ResultSet result = null;
    private Connection conexion = null;

    public List listarEtiquetas() {
        String consulta = "SELECT * FROM etiqueta ";
        List<String> tags = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            result = query.executeQuery();
            while (result.next()) {                
                etiquetaModel etiqueta = new etiquetaModel();
                etiqueta.setId(result.getInt("codigo"));
                etiqueta.setNombreEtiqueta(result.getString("nombre_etiqueta"));
                tags.add(etiqueta.getNombreEtiqueta());
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        }finally{
            cierre();
        }

        return tags;
    }
    
    public List listarCategorias() {
        String consulta = "SELECT * FROM categoria ";
        List<String> categorias = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            result = query.executeQuery();
            while (result.next()) {                
                etiquetaModel etiqueta = new etiquetaModel();
                etiqueta.setId(result.getInt("codigo"));
                etiqueta.setNombreEtiqueta(result.getString("nombre_categoria"));
                categorias.add(etiqueta.getNombreEtiqueta());
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        }finally{
            cierre();
        }

        return categorias;
    }
    
        public List listarEtiquetasUsuario(String usuario) {
        String consulta = "SELECT * FROM interes WHERE nombre_usuario=?";
        List<String> tags = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, usuario);
            result = query.executeQuery();
            while (result.next()) {                
                System.out.println(result.getString("etiqueta"));
                etiquetaModel etiqueta = new etiquetaModel();
                
                etiqueta.setId(result.getInt("codigo"));
                etiqueta.setNombreEtiqueta(result.getString("etiqueta"));
             //   System.out.println(etiqueta.getNombreEtiqueta());
                tags.add(etiqueta.getNombreEtiqueta());
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        }finally{
            cierre();
        }

        return tags;
    }
    
        
           public int asignarCostoRevista( int codigo, double costo, String fecha) {

        int cambios = 0;
        String sql = "INSERT INTO costo_revista ( codigo_revista,costo_dia,fecha_asignacion) VALUES (?,?,?)";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, codigo);
            query.setDouble(2, costo);
            query.setDate(3, getFecha(fecha));
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar costo a la revista");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException | java.text.ParseException ex) {
            Logger.getLogger(revistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }
        return cambios;
    }
        
        
        
        public double obtenerCostoGlobal(){
             String consulta = "SELECT * FROM costoglobal_revista WHERE fecha_asignacion = (SELECT MAX(fecha_asignacion) FROM costoglobal_revista)";
            double costo = 0;
            
            try {
                conexion=conexionDB.getConexion();
                query = conexion.prepareStatement(consulta);
                result=query.executeQuery();
                while (result.next()) {                    
                    System.out.println(result.getDouble("costo_dia"));
                    costo=result.getDouble("costo_dia");
                }
                
            } catch (SQLException e) {
            
                System.out.println("error en el costo global");
            }
            
            
            return costo;
            
        }
        
        
        
   
    
    
    
        private Date getFecha(String localDate) throws TextFormat.ParseException, java.text.ParseException {
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
