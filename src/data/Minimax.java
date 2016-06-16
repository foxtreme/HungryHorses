package data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ''Steven''
 */
public class Minimax {

    private Estado actual;
    private int profundidad;
    private Point movida;

    public Estado getActual() {
        return actual;
    }

    public void setActual(Estado actual) {
        this.actual = actual;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public Minimax(Estado actual, int profundidad) {
        this.actual = actual;
        this.profundidad = profundidad;
    }

    public void decision(Estado actual, int limite) {
        Point decision = new Point();
        List acciones = actual.movidasValidas();
        Point accionRep;
        Double utilidad = Double.NEGATIVE_INFINITY;
        Iterator it = acciones.iterator();
        while (it.hasNext()) {
            Object accion = it.next();
            accionRep = (Point) accion;
            Estado siguiente = actual.resultado(accionRep);
            Double utilidadSiguiente = valorMin(siguiente, limite);
            if (utilidadSiguiente > utilidad) {
                decision = accionRep;
                utilidad = utilidadSiguiente;
            }
            System.out.println("accion max: " + decision.toString() + " utilidad: " + utilidad);
        }
        movida = decision;
    }

    public Double valorMax(Estado actual, int limite) {
        Double utilidad = Double.NEGATIVE_INFINITY;
        List acciones = new ArrayList<Point>();
        Point accionRep;
        if (actual.terminal(limite)) {
            utilidad = actual.calcularUtilidad();
        } else {
            actual.setUtilidad(Double.NEGATIVE_INFINITY);
        }
        acciones = actual.movidasValidas();
        Iterator it = acciones.iterator();
        while (it.hasNext()) {
            Object accion = it.next();
            accionRep = (Point) accion;
            utilidad = Math.max(utilidad, valorMin(actual.resultado(accionRep), limite));
        }
        return utilidad;
    }

    public double valorMin(Estado actual, int limite) {
        Double utilidad = Double.POSITIVE_INFINITY;
        List acciones = new ArrayList<Point>();
        Point accionRep;
        if (actual.terminal(limite)) {
            utilidad = actual.calcularUtilidad();
        } else {
            actual.setUtilidad(Double.POSITIVE_INFINITY);
        }
        acciones = actual.movidasValidas();
        Iterator it = acciones.iterator();
        while (it.hasNext()) {
            Object accion = it.next();
            accionRep = (Point) accion;
            utilidad = Math.min(utilidad, valorMin(actual.resultado(accionRep), limite));
        }

        return utilidad;
    }
    
    public static void main(String args[]){
        Estado inicial = Estado.crearEstadoInicial(8);
        Minimax m = new Minimax(inicial,2);
        m.decision(inicial,2);
        System.out.println("la jugada de blanco es: ");
    }

}
