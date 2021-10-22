/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.File;
import static java.lang.Runtime.version;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.Part;
import modelo.informacionDAO;
import modelo.revista;
import modelo.revistaDAO;
import modelo.usuarioDAO;

/**
 *
 * @author AndaryuS
 */
public class controlRevista {

    revistaDAO revistaDAO;
    usuarioDAO usuarioDAO;
    informacionDAO informacionDAO;
    int codigoR;

    public String publicarRevsita(revista revistaR, String direccion) {
        this.informacionDAO=new informacionDAO();
        int registros;
        String resultado = "";
        codigoR = generarCodigo();
        double costoGoblal = informacionDAO.obtenerCostoGlobal();
        registros = revistaDAO.guardarRevistaN(revistaR, codigoR);
        registros += revistaDAO.guardarEdicion(codigoR, direccion, revistaR.getFechaCreacion());
        registros += informacionDAO.asignarCostoRevista(codigoR, costoGoblal, revistaR.getFechaCreacion());
        for (int i = 0; i < revistaR.getEtiquetas().size(); i++) {
            registros += revistaDAO.guardarEtiquetasRevista(codigoR, revistaR.getEtiquetas().get(i));
            
        }

        return resultado;

    }

    public List<revista> revistasRecomendacion(String usuario) {
        System.out.println(usuario);
        this.revistaDAO = new revistaDAO();
        this.informacionDAO = new informacionDAO();

        ArrayList<revista> revistasE = new ArrayList<>();
        ArrayList<Integer> idRevista = null;
        ArrayList<String> tags = (ArrayList<String>) informacionDAO.listarEtiquetasUsuario(usuario);
        System.out.println(tags.size());
        for (int i = 0; i < tags.size(); i++) {
            System.out.println(tags.get(i));
            ArrayList<Integer> temp = (ArrayList<Integer>) revistaDAO.listarRevistaxEtiqueta(tags.get(i));
            for (int j = 0; j < temp.size(); j++) {
                System.out.println("temp "+temp.get(j));
                  revista tmp = revistaDAO.buscarRevista(temp.get(j));
                   revistasE.add(tmp);
               // idRevista.add(temp.get(i));
            }
        }

        
//        if (idRevista != null) {
//            for (int i = 0; i < idRevista.size(); i++) {
//                System.out.println("for"+idRevista.get(i));
//                revista tmp = revistaDAO.buscarRevista(idRevista.get(i));
//                System.out.println(tmp.getNombreRevista());
//                revistasE.add(tmp);
//            }
//
//        }else{
//            System.out.println("no encontro revistas");
//        }

        ArrayList<revista> revistasGeenerales = (ArrayList<revista>) revistaDAO.listarRevista();
//        for (int i = 0; i < revistasE.size(); i++) {
//                        revista tmp = revistasE.get(i);
//            
//            for (int j = 0; j < revistasGeenerales.size(); j++) {
//                
//            }
//        }
        
        
        for (int i = 0; i < revistasGeenerales.size(); i++) {
            revistasE.add(revistasGeenerales.get(i));
        }
       
        for (int i = 0; i < revistasE.size(); i++) {
            revista tmp = revistasE.get(i);
            tmp.setEtiquetas((ArrayList<String>) revistaDAO.listarEtiquetas(tmp.getCodigo()));
            
        }
        
        
        List<revista> revistasLImpias = new ArrayList<>();
        Map<Integer,revista>mapRevista = new HashMap<>(revistasE.size());
        for (revista rev : revistasE) {
            mapRevista.put(rev.getCodigo(), rev);
        }
        
        for (Map.Entry<Integer, revista> rev : mapRevista.entrySet()) {
            revistasLImpias.add(rev.getValue());
        }

//        for (int i = 0; i < revistasE.size(); i++) {
//               revista tmp = revistasE.get(i);
//               System.out.println("rev 1"+tmp.getCodigo());
//               for (int j = 1; j < revistasE.size(); j++) {
//                  revista tmp2 = revistasE.get(j);
//                                 System.out.println("rev 2"+tmp2.getCodigo());
//                   if (tmp.getCodigo()==tmp2.getCodigo()) {
//                       revistasE.remove(tmp2);
//                       System.out.println("eliminando"+tmp2.getCodigo());
//                   }
//            }
//        }
        Collections.reverse(revistasLImpias);
        

        return revistasLImpias;
    }

    public int generarCodigo() {

        this.revistaDAO = new revistaDAO();

        String codigo = revistaDAO.genearSerie();
        if (codigo == null) {
            codigo = "00000001";
        } else {
            int id = Integer.parseInt(codigo);
            codigo = numeroID(id);
        }

        int codigoINT = Integer.parseInt(codigo);

        return codigoINT;
    }

    public String numeroID(int datoR) {
        int dato;
        String numero = null;
        dato = datoR + 1;

        if (dato >= 10000000 && dato <= 100000000) {
            numero = "" + dato;
        }
        if (dato >= 1000000 && dato <= 10000000) {
            numero = "0" + dato;
        }
        if (dato >= 100000 && dato <= 1000000) {
            numero = "00" + dato;
        }
        if (dato >= 10000 && dato <= 100000) {
            numero = "000" + dato;
        }
        if (dato >= 1000 && dato <= 10000) {
            numero = "0000" + dato;
        }
        if (dato > 100 && dato <= 1000) {
            numero = "00000" + dato;
        }
        if (dato >= 10 && dato <= 100) {
            numero = "000000" + dato;
        }

        if (dato < 10) {
            numero = "0000000" + dato;
        }
        return numero;
    }

}
