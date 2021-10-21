/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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
public class edicionDAO {

        private PreparedStatement query = null;
    private ResultSet result = null;
    private Connection conexion = null;
    
    
        public List listarEdicion(int codigo) {
        String consulta = "SELECT * FROM edicion_revista WHERE codigo_revista=?";

        List<edicionModel> ediciones = new ArrayList<>();
       
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            result = query.executeQuery();
            while (result.next()) {
                edicionModel tmp = new edicionModel();
                tmp.setCodigo(result.getInt("codigo"));
                tmp.setCodigoRevista(result.getInt("codigo_revista"));
                tmp.setDireccion(result.getString("direccion"));
                tmp.setFechaCreacion(result.getDate("fecha_creacion").toString());
               ediciones.add(tmp);
               
            }

        } catch (SQLException e) {
            System.out.println("Error ediciones");
        } finally {
            cierre();
        }

        return ediciones;
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
