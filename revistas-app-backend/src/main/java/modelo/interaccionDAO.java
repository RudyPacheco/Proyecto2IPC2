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
public class interaccionDAO {

    private PreparedStatement query = null;
    private ResultSet result = null;
    private Connection conexion = null;

    public int agregarComentario(comentarioModel comentario) {
        String sql = "INSERT INTO comentario (codigo_revista,nombre_usuario,comentario,fecha_comentario) VALUES (?,?,?,?)";
        int cambios = 0;

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, comentario.getCodigoRevista());
            query.setString(2, comentario.getNombreUsuario());
            query.setString(3, comentario.getComentario());
            query.setDate(4, getFecha(comentario.getFechaComentario()));
            cambios = query.executeUpdate();
        } catch (TextFormat.ParseException | SQLException | ParseException e) {
            System.out.println("error al comentar");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return cambios;
    }

    public List listarComentariosRevista(int codigo) {
        String consulta = "SELECT * FROM comentario WHERE codigo_revista=?";
        List<comentarioModel> comentarios = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            result = query.executeQuery();
            while (result.next()) {
                comentarioModel comentarioTMP = new comentarioModel();
                comentarioTMP.setCodigoRevista(result.getInt("codigo_revista"));
                comentarioTMP.setComentario(result.getString("comentario"));
                comentarioTMP.setNombreUsuario(result.getString("nombre_usuario"));
                comentarioTMP.setFechaComentario(result.getDate("fecha_comentario").toString());

                comentarios.add(comentarioTMP);

            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return comentarios;
    }
    
    
    
        public List listarComentariosRevistaFechas(String fechaInicial,String fechaFinal, int codigo)  {
        String consulta = "SELECT * FROM comentario WHERE codigo_revista=? AND  fecha_comentario BETWEEN ? AND ?";
        List<comentarioModel> comentarios = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            query.setDate(2, getFecha(fechaInicial));
            query.setDate(3, getFecha(fechaFinal));
            result = query.executeQuery();
            while (result.next()) {
                comentarioModel comentarioTMP = new comentarioModel();
                comentarioTMP.setCodigoRevista(result.getInt("codigo_revista"));
                comentarioTMP.setComentario(result.getString("comentario"));
                comentarioTMP.setNombreUsuario(result.getString("nombre_usuario"));
                comentarioTMP.setFechaComentario(result.getDate("fecha_comentario").toString());

                comentarios.add(comentarioTMP);

            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(interaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(interaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }

        return comentarios;
    }
    

    public int agregarMeGusta(meGustaModel megusta) {
        String sql = "INSERT INTO megusta (codigo_revista,nombre_usuario,fecha_megusta) VALUES (?,?,?)";
        int cambios = 0;

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, megusta.getCodigoRevista());
            query.setString(2, megusta.getNombreUsuario());
            query.setDate(3, getFecha(megusta.getFechaMegusta()));
            cambios = query.executeUpdate();
        } catch (TextFormat.ParseException | SQLException | ParseException e) {
            System.out.println("error al dar liker");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return cambios;
    }

    public List listarMeGustaUsuario(String usuario) {
        String consulta = "SELECT * FROM megusta WHERE nombre_usuario=?";
        List<meGustaModel> megusta = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setString(1, usuario);
            result = query.executeQuery();
            while (result.next()) {

                meGustaModel megustaTMP = new meGustaModel();

                megustaTMP.setCodigoRevista(result.getInt("codigo_revista"));
                megustaTMP.setNombreUsuario(result.getString("nombre_usuario"));
                megustaTMP.setFechaMegusta(result.getDate("fecha_megusta").toString());
                megusta.add(megustaTMP);

            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return megusta;
    }
   public List listarRevistasComentario(){
        String consulta ="SELECT codigo_revista, count(codigo_revista) as total FROM comentario GROUP BY codigo_revista ORDER BY total DESC LIMIT 5";
        List<Integer> codigos= new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            result = query.executeQuery();
            while (result.next()) {
                int codigo = result.getInt("codigo_revista");
                codigos.add(codigo);
            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        
        return codigos;
    }
    
    public List listarRevistaComentarioFecha(String fechaI,String fechaF){
        String consulta ="SELECT codigo_revista, count(codigo_revista) as total FROM comentario WHERE fecha_megusta BETWEEN ? AND ? GROUP BY codigo_revista ORDER BY total DESC LIMIT 5";
        List<Integer> codigos= new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setDate(1, getFecha(fechaI));
            query.setDate(2, getFecha(fechaF));
            result = query.executeQuery();
            while (result.next()) {
                int codigo = result.getInt("codigo_revista");
                codigos.add(codigo);
            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(interaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(interaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }
        
        return codigos;
    }    
    
    public List listarRevistasMegustaFecha(String fechaI,String fechaF){
        String consulta ="SELECT codigo_revista, count(codigo_revista) as total FROM megusta WHERE fecha_megusta BETWEEN ? AND ? GROUP BY codigo_revista ORDER BY total DESC LIMIT 5";
        List<Integer> codigos= new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setDate(1, getFecha(fechaI));
            query.setDate(2, getFecha(fechaF));
            result = query.executeQuery();
            while (result.next()) {
                int codigo = result.getInt("codigo_revista");
                codigos.add(codigo);
            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(interaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(interaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }
        
        return codigos;
    }
    
     public List listarRevistasMegusta(){
        String consulta ="SELECT codigo_revista, count(codigo_revista) as total FROM megusta GROUP BY codigo_revista ORDER BY total DESC LIMIT 5";
        List<Integer> codigos= new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            result = query.executeQuery();
            while (result.next()) {
                int codigo = result.getInt("codigo_revista");
                codigos.add(codigo);
            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        
        return codigos;
    }


    public List listarMeGustaRevista(int codigo) {
        String consulta = "SELECT * FROM megusta WHERE codigo_revista=?";
        List<meGustaModel> megusta = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            result = query.executeQuery();
            while (result.next()) {

                meGustaModel megustaTMP = new meGustaModel();

                megustaTMP.setCodigoRevista(result.getInt("codigo_revista"));
                megustaTMP.setNombreUsuario(result.getString("nombre_usuario"));
                megustaTMP.setFechaMegusta(result.getDate("fecha_megusta").toString());
                megusta.add(megustaTMP);

            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return megusta;
    }
    
    public List listarMeGustaRevistaFechas(int codigo,String fechaInicial,String fechaFinal) {
        String consulta = "SELECT * FROM megusta WHERE codigo_revista=? AND  fecha_comentario BETWEEN ? AND ?";
        List<meGustaModel> megusta = new ArrayList<>();

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            query.setDate(2, getFecha(fechaInicial));
            query.setDate(3, getFecha(fechaFinal));
            result = query.executeQuery();
            while (result.next()) {

                meGustaModel megustaTMP = new meGustaModel();

                megustaTMP.setCodigoRevista(result.getInt("codigo_revista"));
                megustaTMP.setNombreUsuario(result.getString("nombre_usuario"));
                megustaTMP.setFechaMegusta(result.getDate("fecha_megusta").toString());
                megusta.add(megustaTMP);

            }

        } catch (SQLException e) {
            System.out.println("Error listar likes");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException | ParseException ex) {
            Logger.getLogger(interaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }

        return megusta;
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
