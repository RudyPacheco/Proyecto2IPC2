/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import service.controlUsuario;
import com.google.protobuf.TextFormat.ParseException;
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
public class revistaDAO {

    private PreparedStatement query = null;
    private ResultSet result = null;
    private Connection conexion = null;

    public int guardarRevistaN(revista revistaR, int codigo) {

        int cambios = 0;
        String sql = "INSERT INTO revista ( codigo_revista,nombre_revista, nombre_editor, categoria,descripcion,precio_sub,interaccion,bloqueo_sub, fecha_creacion) VALUES (?,?, ?,?,?,?,?,?,?)";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, codigo);
            query.setString(2, revistaR.getNombreRevista());
            query.setString(3, revistaR.getEditor());
            query.setString(4, revistaR.getCategoria());
            query.setString(5, revistaR.getDescripcion());
            query.setDouble(6, revistaR.getPrecioRevista());
            query.setBoolean(7, true);
            query.setBoolean(8, true);
            query.setDate(9, getFecha(revistaR.getFechaCreacion()));
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        } catch (ParseException | java.text.ParseException ex) {
            Logger.getLogger(revistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }
        return cambios;
    }

    public revista buscarRevistaNombre(String nombreRevista,String nombreEditor) {
        String consulta = "SELECT * FROM revista WHERE nombre_revista=? AND nombre_editor=?";
        revista revistaEncontrada = new revista();
        List<String> tags = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, nombreRevista);
            query.setString(2, nombreEditor);
            result = query.executeQuery();
            while (result.next()) {
                revistaEncontrada.setCodigo(result.getInt("codigo_revista"));
                revistaEncontrada.setNombreRevista(result.getString("nombre_revista"));
                revistaEncontrada.setCategoria(result.getString("categoria"));
                revistaEncontrada.setPrecioRevista(result.getDouble("precio_sub"));
                revistaEncontrada.setDescripcion(result.getString("descripcion"));
                revistaEncontrada.setFechaCreacion(result.getDate("fecha_creacion").toString());
                revistaEncontrada.setEditor(result.getString("nombre_editor"));
                revistaEncontrada.setInteraccion(result.getBoolean("interaccion"));
                revistaEncontrada.setBloqueoSub(result.getBoolean("bloqueo_sub"));
                
                //  tags=listarEtiquetasRevista(result.getInt("codigo_revista"));
                //   revistaEncontrada.setEtiquetas((ArrayList<String>) tags);
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        } finally {
            cierre();
        }

        return revistaEncontrada;
    }
    
    
      public revista buscarRevistaNombreSinEditor(String nombreRevista) {
        String consulta = "SELECT * FROM revista WHERE nombre_revista=?";
        revista revistaEncontrada = new revista();
        List<String> tags = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, nombreRevista);
            
            result = query.executeQuery();
            while (result.next()) {
                revistaEncontrada.setCodigo(result.getInt("codigo_revista"));
                revistaEncontrada.setNombreRevista(result.getString("nombre_revista"));
                revistaEncontrada.setCategoria(result.getString("categoria"));
                revistaEncontrada.setPrecioRevista(result.getDouble("precio_sub"));
                revistaEncontrada.setDescripcion(result.getString("descripcion"));
                revistaEncontrada.setFechaCreacion(result.getDate("fecha_creacion").toString());
                revistaEncontrada.setEditor(result.getString("nombre_editor"));
                revistaEncontrada.setInteraccion(result.getBoolean("interaccion"));
                revistaEncontrada.setBloqueoSub(result.getBoolean("bloqueo_sub"));
                
                //  tags=listarEtiquetasRevista(result.getInt("codigo_revista"));
                //   revistaEncontrada.setEtiquetas((ArrayList<String>) tags);
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
             e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return revistaEncontrada;
    }
    
    
    
    public revista buscarRevista(int codigo) {
        String consulta = "SELECT * FROM revista WHERE codigo_revista=?";
        revista revistaEncontrada = new revista();
        List<String> tags = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            result = query.executeQuery();
            while (result.next()) {
                revistaEncontrada.setCodigo(result.getInt("codigo_revista"));
                revistaEncontrada.setNombreRevista(result.getString("nombre_revista"));
                revistaEncontrada.setCategoria(result.getString("categoria"));
                revistaEncontrada.setPrecioRevista(result.getDouble("precio_sub"));
                revistaEncontrada.setDescripcion(result.getString("descripcion"));
                revistaEncontrada.setFechaCreacion(result.getDate("fecha_creacion").toString());
                revistaEncontrada.setEditor(result.getString("nombre_editor"));
                revistaEncontrada.setInteraccion(result.getBoolean("interaccion"));
                revistaEncontrada.setBloqueoSub(result.getBoolean("bloqueo_sub"));
                
                //  tags=listarEtiquetasRevista(result.getInt("codigo_revista"));
                //   revistaEncontrada.setEtiquetas((ArrayList<String>) tags);
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
             e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return revistaEncontrada;
    }

    public int guardarEdicion(int codigo, String direccion, String fecha) {

        int cambios = 0;
        String sql = "INSERT INTO edicion_revista (codigo_revista,direccion, fecha_creacion) VALUES ( ?,?,?)";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, codigo);
            query.setString(2, direccion);
            query.setDate(3, getFecha(fecha));
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        } catch (ParseException | java.text.ParseException ex) {
            Logger.getLogger(revistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }
        return cambios;
    }

    public int guardarEtiquetasRevista(int codigo, String etiqueta) {

        int cambios = 0;
        String sql = "INSERT INTO etiqueta_revista ( codigo_revista,etiqueta) VALUES ( ?,?)";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, codigo);
            query.setString(2, etiqueta);
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        return cambios;
    }

    public List listarEtiquetas(int codigo) {
        String consulta = "SELECT * FROM etiqueta_revista WHERE codigo_revista=?";
        List<String> tags = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            result = query.executeQuery();
            while (result.next()) {
                etiquetaModel etiqueta = new etiquetaModel();
                etiqueta.setId(result.getInt("codigo"));
                etiqueta.setNombreEtiqueta(result.getString("etiqueta"));
                tags.add(etiqueta.getNombreEtiqueta());
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        }finally {
            cierre();
        }

        return tags;
    }

    public List listarRevistaxEtiqueta(String etiquetaR) {
        String consulta = "SELECT * FROM etiqueta_revista WHERE etiqueta=?";
        List<Integer> codigos = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, etiquetaR);
            result = query.executeQuery();
            while (result.next()) {
                etiquetaModel etiqueta = new etiquetaModel();
                etiqueta.setId(result.getInt("codigo_revista"));
                etiqueta.setNombreEtiqueta(result.getString("etiqueta"));
                codigos.add(etiqueta.getId());
                System.out.println("id "+etiqueta.getId());
            }

        } catch (SQLException e) {
            System.out.println("Error etiquetas");
        }finally {
            cierre();
        }

        return codigos;
    }

    public List<revista> listarRevistaE(String editor) {
        List<revista> revistas = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        try {

            String consulta = "SELECT * FROM revista WHERE nombre_editor=?";
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, editor);
            result = query.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("nombre_revista"));
                revista tmp = new revista();
                tmp.setCodigo(result.getInt("codigo_revista"));
                tmp.setNombreRevista(result.getString("nombre_revista"));
                tmp.setCategoria(result.getString("categoria"));
                tmp.setPrecioRevista(result.getDouble("precio_sub"));
                tmp.setDescripcion(result.getString("descripcion"));
                tmp.setFechaCreacion(result.getDate("fecha_creacion").toString());
                tmp.setEditor(result.getString("nombre_editor"));
                tmp.setInteraccion(result.getBoolean("interaccion"));
                tmp.setBloqueoSub(result.getBoolean("bloqueo_sub"));
//                tags=listarEtiquetas(result.getInt("codigo_revista"));
//                tmp.setEtiquetas((ArrayList<String>) tags);
                revistas.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println("error listar");
            Logger.getLogger(revistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            cierre();
        }

        return revistas;
    }

    public List<revista> listarRevista() {
        List<revista> revistas = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        try {

            String consulta = "SELECT * FROM revista";
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            result = query.executeQuery();
            while (result.next()) {
                revista tmp = new revista();
                tmp.setCodigo(result.getInt("codigo_revista"));
                tmp.setNombreRevista(result.getString("nombre_revista"));
                tmp.setCategoria(result.getString("categoria"));
                tmp.setPrecioRevista(result.getDouble("precio_sub"));
                tmp.setDescripcion(result.getString("descripcion"));
                tmp.setFechaCreacion(result.getDate("fecha_creacion").toString());
                tmp.setEditor(result.getString("nombre_editor"));
                tmp.setInteraccion(result.getBoolean("interaccion"));
                  tmp.setBloqueoSub(result.getBoolean("bloqueo_sub"));
                //  tags=listarEtiquetasRevista(result.getInt("codigo_revista"));
                // tmp.setEtiquetas((ArrayList<String>) tags);
                revistas.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println("error listar");
            Logger.getLogger(revistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            cierre();
        }

        return revistas;
    }
    
    
     public int actualizarInteraccion(permisosModel permisos) {
        int cambios = 0;
        String sql = "UPDATE revista SET interaccion=? WHERE codigo_revista=?;";
        int registros = 0;
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setBoolean(1,permisos.isInteraccion() );
            query.setInt(2, permisos.getCodigoRevista());
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al cambiar permisos");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        return cambios;
    }
     
     
     public int actualizarBloqueSub(permisosModel permisos) {
        int cambios = 0;
        String sql = "UPDATE revista SET bloqueo_sub=? WHERE codigo_revista=?;";
        int registros = 0;
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setBoolean(1,permisos.isBloqueo_sub() );
            query.setInt(2, permisos.getCodigoRevista());
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al cambiar permisos");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        return cambios;
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
        }finally {
            cierre();
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
