/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.List;
import modelo.porcentaje;
import modelo.revista;
import modelo.revistaDAO;
import modelo.suscripcionDAO;
import modelo.suscripcionModel;

/**
 *
 * @author AndaryuS
 */
public class controlSuscripcion {

    suscripcionDAO suscripcionDAO;
    revistaDAO revistaDAO;

    public void registrarEdicion(suscripcionModel sub) {
        this.suscripcionDAO = new suscripcionDAO();
        System.out.println("imprimiendo sub");
        System.out.println(sub.getRevista().getCodigo());
        System.out.println(sub.getTipoSuscripcion());
        System.out.println(sub.getRevista().getPrecioRevista());
        porcentaje porcentaje = suscripcionDAO.porcentajeGananciasl();
        System.out.println(porcentaje.getPorcentajeUsuario());
        System.out.println(porcentaje.getPorcentajeSistema());
        double porcentajeUsuario = ((double) porcentaje.getPorcentajeUsuario() / 100);
        double porcentajeGanancia = ((double) porcentaje.getPorcentajeSistema() / 100);
        System.out.println(porcentajeGanancia);
        System.out.println(porcentajeGanancia);
        if (sub.getTipoSuscripcion() == 1) {

            double gananciaUsr = ((double) sub.getRevista().getPrecioRevista() * porcentajeUsuario);
            double gananciaSistema = ((double) sub.getRevista().getPrecioRevista() * porcentajeGanancia);
            System.out.println(gananciaUsr);
            System.out.println(gananciaSistema);

            suscripcionDAO.registarSuscripcion(sub, "mensual", gananciaUsr);
            suscripcionDAO.registarGananciaSub(sub, sub.getRevista().getPrecioRevista(), gananciaSistema);

        } else if (sub.getTipoSuscripcion() == 2) {
            double ingresoTotal = (sub.getRevista().getPrecioRevista() * 12);

            double gananciaUsr = ((double) ingresoTotal * porcentajeUsuario);
            double gananciaSistema = ((double) ingresoTotal * porcentajeGanancia);
            System.out.println(gananciaUsr);
            System.out.println(gananciaSistema);

            suscripcionDAO.registarSuscripcion(sub, "anual", gananciaUsr);
            suscripcionDAO.registarGananciaSub(sub, ingresoTotal, gananciaSistema);

        }

    }

    public List listarSuscripciones(String usuario) {
        this.suscripcionDAO = new suscripcionDAO();
        this.revistaDAO = new revistaDAO();
        List<revista> revistasSuscritas = new ArrayList<>();

        ArrayList<Integer> temp = (ArrayList<Integer>) suscripcionDAO.listarSuscripciones(usuario);
        if (temp.size() > 0) {
            for (int i = 0; i < temp.size(); i++) {
                revista tmp = revistaDAO.buscarRevista(temp.get(i));
                revistasSuscritas.add(tmp);
            }
        }

        
        return revistasSuscritas;
    }

}
