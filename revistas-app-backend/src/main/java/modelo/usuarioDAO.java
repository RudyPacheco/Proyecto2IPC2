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

/**
 *
 * @author AndaryuS
 */
public class usuarioDAO {

    private PreparedStatement query = null;
    private ResultSet result = null;
    private Connection conexion = null;

    public usuario validarUsuario(String nombre, String contrasenia) {
        usuario temp = new usuario();
        String consulta = "SELECT * FROM usuario WHERE nombre_usuario=? and contrasenia=?";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, nombre);
            query.setString(2, contrasenia);
            result = query.executeQuery();
            while (result.next()) {
                temp.setNombre(result.getString("nombre_usuario"));
                temp.setContrasenia(result.getString("contrasenia"));
            }
        } catch (SQLException ex) {
            System.out.println("error en bucarUsuario");
        } finally {
            cierre();
        }

        return temp;
    }

    public usuario validarExistencia(String nombre) {
        usuario temp = new usuario();
        String consulta = "SELECT * FROM usuario WHERE nombre_usuario=?";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, nombre);
            result = query.executeQuery();
            while (result.next()) {
                temp.setNombre(result.getString("nombre_usuario"));
            }
        } catch (SQLException ex) {
            System.out.println("error en bucarUsuario");
        } finally {
            cierre();
        }

        return temp;
    }

    public void guardarUsuario(UsuarioNuevo usuario) {
        String sql = "INSERT INTO usuario ( nombre,apellido, nombre_usuario, contrasenia, codigo_area) VALUES ( ?,?,?, ?, ?)";
        int registros = 0;
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setString(1, usuario.getNombre());
            query.setString(2, usuario.getApellido());
            query.setString(3, usuario.getUsuario());
            query.setString(4, usuario.getContrasenia());
            query.setInt(5, usuario.getTipoCuenta());

        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        }
      
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
