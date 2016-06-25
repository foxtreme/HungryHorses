package data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Minimax {

    private Estado actual;
    private int profundidad;
    private Point movida;

    public Estado getActual() {        return actual;    }

    public void setActual(Estado actual) {        this.actual = actual;    }

    public int getProfundidad() {        return profundidad;    }

    public void setProfundidad(int profundidad) {        this.profundidad = profundidad;    }

    public Point getMovida() {        return movida;    }

    public Minimax(Estado actual) {        this.actual = actual;    }
    
    
    public void decisionMx(Estado actual, int limite) {
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

    public void decisionMn(Estado actual, int limite) {
        Point decision = new Point();
        List acciones = actual.movidasValidas();
        for(int j=0; j>acciones.size();j++){
            System.out.println(" movida "+acciones.get(j));
        }
        Point accionRep;
        Double utilidad = Double.NEGATIVE_INFINITY;
        Iterator it = acciones.iterator();
        while (it.hasNext()) {
            Object accion = it.next();
            accionRep = (Point) accion;
            Estado siguiente = actual.resultado(accionRep);
            Double utilidadSiguiente = valorMax(siguiente, limite);
            if (utilidadSiguiente > utilidad) {
                decision = accionRep;
                utilidad = utilidadSiguiente;
            }
            System.out.println("accion min: " + decision.toString() + " utilidad: " + utilidad);
        }
        movida = decision;
    }

    public Double valorMax(Estado actual, int limite) {
        Double utilidad = Double.NEGATIVE_INFINITY;
        if (actual.terminal(limite)) {
            return actual.calcularUtilidad();
        } 
        List acciones = actual.movidasValidas();
        Point accionRep;
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
        if (actual.terminal(limite)) {
            return actual.calcularUtilidad();
        } 
        List acciones = actual.movidasValidas();
        Point accionRep;
        Iterator it = acciones.iterator();
        while (it.hasNext()) {
            Object accion = it.next();
            accionRep = (Point) accion;
            utilidad = Math.min(utilidad, valorMax(actual.resultado(accionRep), limite));
        }
        return utilidad;
    }
    
    public static void main(String args[]){
        Estado inicial = Estado.crearEstadoInicial(8);
        Estado.imprimirTablero(inicial);
        Minimax m = new Minimax(inicial);
        
        m.decisionMx(inicial,6);
        Point movida = m.getMovida();
        System.out.println("la jugada de blanco es: "+movida.toString());
        
    }

}
