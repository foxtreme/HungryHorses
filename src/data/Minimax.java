package data;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Minimax {

    private Estado actual;
    private int profundidad;
    private Point movida;

       
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
            //System.out.println("accion max: " + decision.toString() + " utilidad: " + utilidad);
        }
        movida = decision;
    }

    public Point [] decisionMn(Estado actual, int limite) {
        Point decision = new Point();
        List acciones = actual.movidasValidas();
        /*
        for(int j=0; j>acciones.size();j++){
            System.out.println(" movida "+acciones.get(j));
        }
        */    
        Point accionRep;
        Double utilidad = Double.NEGATIVE_INFINITY;
        Iterator it = acciones.iterator();
        Point [] puntos=new Point [acciones.size()];
        int z=-1;
        
        while (it.hasNext()) {
            z=z+1;
            Object accion = it.next();
            accionRep = (Point) accion;
            puntos [z]=accionRep;
            Estado siguiente = actual.resultado(accionRep);
            Double utilidadSiguiente = valorMax(siguiente, limite);
            decision = accionRep;
            utilidad = utilidadSiguiente;
            //System.out.println("accion min: " + decision.toString() + " utilidad: " + utilidad);
        }
        
        movida = decision;
        
        return puntos;
    }

    /**
     * Calcula el maximo de las opciones disponibles
     * @param actual
     * @param limite
     * @return 
     */
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

    /**
     * Calcula el minimo de las opciones disponibles
     * @param actual
     * @param limite
     * @return 
     */
    public double valorMin(Estado actual, int limite) {
        Double utilidad2 = Double.POSITIVE_INFINITY;
        if (actual.terminal(limite)) {
            return actual.calcularUtilidad();
        } 
        List acciones = actual.movidasValidas();
        Point accionRep;
        Iterator it = acciones.iterator();
        while (it.hasNext()) {
            Object accion = it.next();
            accionRep = (Point) accion;
            utilidad2 = Math.min(utilidad2, valorMax(actual.resultado(accionRep), limite));
        }
        return utilidad2;
    }
    
    public Estado getActual() {        return actual;    }

    public void setActual(Estado actual) {        this.actual = actual;    }

    public int getProfundidad() {        return profundidad;    }

    public void setProfundidad(int profundidad) {        this.profundidad = profundidad;    }

    public Point getMovida() {        return movida;    }

    public Minimax(Estado actual) {        this.actual = actual;    }
}
   

/* public static void main(String args[]){
        Estado inicial = Estado.crearEstadoInicial(8);
        Estado.imprimirTablero(inicial);
        Minimax m = new Minimax(inicial);
        
        m.decisionMx(inicial,6);
        Point movida = m.getMovida();
        System.out.println("la jugada de blanco es: "+movida.toString());
        
    }

}*/
