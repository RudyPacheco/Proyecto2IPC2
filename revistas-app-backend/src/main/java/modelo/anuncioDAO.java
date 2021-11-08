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
public class anuncioDAO {

    private PreparedStatement query = null;
    private ResultSet result = null;
    private Connection conexion = null;

    public int guardarAnuncioTexto(anuncioModel anuncio, int codigo) {

        int cambios = 0;
        String sql = "INSERT INTO anuncio (codigo,anunciante,cantidad_dias,fecha_publicaion,tipo_anuncio,texto_anuncio,precio,bloqueado) VALUES (?,?, ?,?,?,?,?,?)";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, codigo);
            query.setString(2, anuncio.getAnunciante());
            query.setInt(3, anuncio.getCantidadDias());
            query.setDate(4, getFecha(anuncio.getFechaPublicacion()));
            query.setInt(5, anuncio.getTipoAnuncio());
            query.setString(6, anuncio.getTextoAnuncio());
            query.setDouble(7, anuncio.getPrecio());
            query.setBoolean(8, false);
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar anuncio");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException | java.text.ParseException ex) {
            Logger.getLogger(revistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }
        return cambios;
    }

    public int guardarAnuncioVideo(anuncioModel anuncio, int codigo) {

        int cambios = 0;
        String sql = "INSERT INTO anuncio (codigo,anunciante,cantidad_dias,fecha_publicaion,tipo_anuncio,video_anuncio,precio,bloqueado) VALUES (?,?, ?,?,?,?,?,?)";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, codigo);
            query.setString(2, anuncio.getAnunciante());
            query.setInt(3, anuncio.getCantidadDias());
            query.setDate(4, getFecha(anuncio.getFechaPublicacion()));
            query.setInt(5, anuncio.getTipoAnuncio());
            query.setString(6, anuncio.getVideo());
            query.setDouble(7, anuncio.getPrecio());
            query.setBoolean(8, false);
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar anuncio");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException | java.text.ParseException ex) {
            Logger.getLogger(revistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }
        return cambios;
    }

    public int guardarAnucioImagen(anuncioModel anuncio, int codigo) {

        int cambios = 0;
        String sql = "INSERT INTO anuncio (codigo,anunciante,cantidad_dias,fecha_publicaion,tipo_anuncio,imagen_anuncio,content_type,precio,bloqueado) VALUES (?,?, ?,?,?,?,?,?,?)";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, codigo);
            query.setString(2, anuncio.getAnunciante());
            query.setInt(3, anuncio.getCantidadDias());
            query.setDate(4, getFecha(anuncio.getFechaPublicacion()));
            query.setInt(5, anuncio.getTipoAnuncio());
            query.setString(6, anuncio.getImagen());
            query.setString(7, anuncio.getContentType());
            query.setDouble(8, anuncio.getPrecio());
            query.setBoolean(9, false);
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar anuncio imagen");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException | java.text.ParseException ex) {
            Logger.getLogger(revistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }
        return cambios;
    }

    public int guardarEtiquetasAnuncio(int codigo, String etiqueta) {

        int cambios = 0;
        String sql = "INSERT INTO etiqueta_anuncio ( codigo_anuncio,etiqueta) VALUES ( ?,?)";

        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(sql);
            query.setInt(1, codigo);
            query.setString(2, etiqueta);
            cambios = query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar tag anuncio");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }
        return cambios;
    }

    public anuncioModel buscarAnuncio(int codigo) {
        String consulta = "SELECT * FROM anuncio WHERE codigo=?";
        revista revistaEncontrada = new revista();
        anuncioModel anuncioB = new anuncioModel();
        List<String> tags = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);
            query.setInt(1, codigo);
            result = query.executeQuery();
            while (result.next()) {
                anuncioB.setCodigo(result.getInt("codigo"));
                anuncioB.setAnunciante(result.getString("anunciante"));
                anuncioB.setCantidadDias(result.getInt("cantidad_dias"));
                anuncioB.setImagen(result.getString("imagen_anuncio"));
                anuncioB.setContentType(result.getString("content_type"));
                anuncioB.setTipoAnuncio(result.getInt("tipo_anuncio"));
            }

        } catch (SQLException e) {
            System.out.println("Error buscando anuncio");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return anuncioB;
    }

    public List listarAnuncios() {
        String consulta = "SELECT * FROM anuncio";
        revista revistaEncontrada = new revista();
        List<anuncioModel> anuncios = new ArrayList<>();

        List<String> tags = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();
            query = conexion.prepareStatement(consulta);

            result = query.executeQuery();
            while (result.next()) {
                anuncioModel anuncioB = new anuncioModel();
                anuncioB.setCodigo(result.getInt("codigo"));
                anuncioB.setAnunciante(result.getString("anunciante"));
                anuncioB.setCantidadDias(result.getInt("cantidad_dias"));
                anuncioB.setImagen(result.getString("imagen_anuncio"));
                anuncioB.setContentType(result.getString("content_type"));
                anuncioB.setTextoAnuncio(result.getString("texto_anuncio"));
                anuncioB.setVideo(result.getString("video_anuncio"));
                anuncioB.setTipoAnuncio(result.getInt("tipo_anuncio"));
                anuncioB.setFechaPublicacion(result.getDate("fecha_publicaion").toString());
                anuncios.add(anuncioB);
            }

        } catch (SQLException e) {
            System.out.println("Error listando  anuncio");
            e.printStackTrace(System.out);
        } finally {
            cierre();
        }

        return anuncios;
    }

    public List listarAnunciosFecha(String fechaI, String fechaF) {
        String consulta = "SELECT * FROM anuncio WHERE fecha_publicaion BETWEEN ? AND ?";

        revista revistaEncontrada = new revista();
        List<anuncioModel> anuncios = new ArrayList<>();

        List<String> tags = new ArrayList<>();
        try {
            conexion = conexionDB.getConexion();

            query = conexion.prepareStatement(consulta);
            query.setDate(1, getFecha(fechaI));
            query.setDate(2, getFecha(fechaF));
            result = query.executeQuery();
            while (result.next()) {
                anuncioModel anuncioB = new anuncioModel();
                anuncioB.setCodigo(result.getInt("codigo"));
                anuncioB.setAnunciante(result.getString("anunciante"));
                anuncioB.setCantidadDias(result.getInt("cantidad_dias"));
                anuncioB.setImagen(result.getString("imagen_anuncio"));
                anuncioB.setContentType(result.getString("content_type"));
                anuncioB.setTextoAnuncio(result.getString("texto_anuncio"));
                anuncioB.setVideo(result.getString("video_anuncio"));
                anuncioB.setTipoAnuncio(result.getInt("tipo_anuncio"));
                anuncioB.setFechaPublicacion(result.getDate("fecha_publicaion").toString());
                anuncios.add(anuncioB);
            }

        } catch (SQLException e) {
            System.out.println("Error listando  anuncio");
            e.printStackTrace(System.out);
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(anuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(anuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cierre();
        }

        return anuncios;
    }

    public String genearSerie() {
        String numeroSerie = "";
        String sql = "SELECT MAX(codigo) FROM anuncio";
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
        } finally {
            cierre();
        }

        return numeroSerie;
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
