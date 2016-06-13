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
    
    Estado actual;
    int profundidad;
    Point movida;

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
    
   public void decision (Estado actual){
       Point decision = new Point ();
       
       movida=decision;
   }
   
   public Double valorMax(Estado actual,int limite){
       Double utilidad=Double.NEGATIVE_INFINITY; 
       List acciones = new ArrayList <Point>();
       Point accionRep;
       if(actual.terminal(limite)){
           utilidad = actual.calcularUtilidad();
       }else{
           actual.setUtilidad(Double.NEGATIVE_INFINITY);
       }
       acciones = actual.movidasValidas();
       Iterator it = acciones.iterator();
       while(it.hasNext()){
           Object accion = it.next();
           accionRep=(Point)accion;
           utilidad = Math.max(utilidad, valorMin(actual.resultado(accionRep),limite));
       }
       return utilidad;
   }
   
   public double valorMin(Estado actual,int limite){
       Double utilidad=Double.POSITIVE_INFINITY; 
       List acciones = new ArrayList <Point>();
       Point accionRep;
       if(actual.terminal(limite)){
           utilidad = actual.calcularUtilidad();
       }else{
           actual.setUtilidad(Double.POSITIVE_INFINITY);
       }
       acciones = actual.movidasValidas();
       Iterator it = acciones.iterator();
       while(it.hasNext()){
           Object accion = it.next();
           accionRep=(Point)accion;
           utilidad = Math.min(utilidad, valorMin(actual.resultado(accionRep),limite));
       }
       
       return utilidad;
   }
   
}
