/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import backend.controlUsuario;
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

    public usuarioLoged validarUsuario(String nombre, String contrasenia) {
        usuarioLoged temp = new usuarioLoged();
        String consulta = "SELECT * FROM usuario WHERE nombre_usuario=? and contrasenia=?";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, nombre);
            query.setString(2, contrasenia);
            result = query.executeQuery();
            while (result.next()) {
                temp.setNombre(result.getString("nombre"));
                temp.setApellido(result.getString("apellido"));
                temp.setUsuario(result.getString("nombre_usuario"));
                temp.setInformacion(result.getString("informacion"));
                temp.setTipoCuenta(result.getInt("codigo_area"));
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

    public int guardarUsuario(UsuarioNuevo usuario) {

        int cambios = 0;
        String sql = "INSERT INTO usuario ( nombre,apellido, nombre_usuario, contrasenia, codigo_area) VALUES ( ?,?,?, ?, ?)";
        int registros = 0;
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setString(1, usuario.getNombre());
            query.setString(2, usuario.getApellido());
            query.setString(3, usuario.getUsuario());
            query.setString(4, controlUsuario.getMD5(usuario.getContrasenia()));
            query.setInt(5, usuario.getTipoCuenta());
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        return cambios;
    }

    public int guardarInformacion(usuarioInformacion usuario) {
        int cambios = 0;
        String sql = "UPDATE usuario SET informacion=? WHERE nombre_usuario=?";
        int registros = 0;
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setString(1, usuario.getInformacion());
            query.setString(2, usuario.getNombreUsuario());
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        return cambios;
    }

    public int guardarTag(String nombreUsuario, String tag) {
        int cambios = 0;
        String sql = "INSERT INTO interes ( nombre_usuario, etiqueta) VALUES ( ?,?)";
        int registros = 0;
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setString(1, nombreUsuario);
            query.setString(2, tag);

            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        return cambios;
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
