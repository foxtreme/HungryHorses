package data;

import java.awt.Point;
import java.util.List;
/**
 *
 * @author ''Steven''
 */
public class Estado {
    
    private int [][] tablero;
    private Point posB;
    private Point posA;
    private Double puntosB;
    private Double puntosA;
    private Double utilidad;
    private int turno;
    private int profundidad;

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public Point getPosB() {
        return posB;
    }

    public void setPosB(Point posB) {
        this.posB = posB;
    }

    public Point getPosA() {
        return posA;
    }

    public void setPosA(Point posA) {
        this.posA = posA;
    }

    public Double getPuntosB() {
        return puntosB;
    }

    public void setPuntosB(Double puntosB) {
        this.puntosB += puntosB;
    }

    public Double getPuntosA() {
        return puntosA;
    }

    public void setPuntosA(Double puntosA) {
        this.puntosA += puntosA;
    }

    public Estado(int turno, int[][] tablero, Point posB, Point posA, Double puntosB, Double puntosA) {
        this.turno = turno;
        this.tablero = tablero;
        this.posB = posB;
        this.posA = posA;
        this.puntosB = puntosB;
        this.puntosA = puntosA;
    }
    
    public Estado(){
  
    }

    Estado resultado(Point accion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List movidasValidas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setUtilidad(Double utilidad) {
        this.utilidad = utilidad;
    }

    Double calcularUtilidad() {
        return (Double)this.puntosB - this.puntosA;
    }

    boolean terminal(int limite) {
        boolean seAcaba=false;
        
        if(((35-puntosA-puntosB)==0) || (profundidad>limite)){
            seAcaba=true;
        }
        
        return seAcaba;
    }
}
