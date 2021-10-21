/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mycompany.revistas.app.backend.usuario;
import conexion.conexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
