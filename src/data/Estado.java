package data;

import java.awt.Point;
import java.util.List;

/**
 *
 * @author ''Steven''
 */
public class Estado {

    private int[][] tablero;
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

    public Estado() {

    }

    Estado resultado(Point accion) {
        Estado proximo = new Estado();
        int tamanio = this.tablero.length;
        Double puntos = 0.0;
        int[][] tablero = new int[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                tablero[i][j] = this.tablero[i][j];
            }
        }
        if (tablero[accion.x][accion.y] == 3) {//3 para hierba (pendiente)
            puntos = 1.0;
        }
        if (tablero[accion.x][accion.y] == 4) {//4 para flor (pendiente)
            puntos = 3.0;
        }
        if (this.turno == 1) {//para el caballo blanco (pendiente)
            tablero[posB.x][posB.y] = 0;//el caballo deja la posicion donde estaba
            tablero[accion.x][accion.y] = 1; //1 para el caballo (pendiente)
            proximo.setPosA(this.posA);
            proximo.setPosB(accion);
            proximo.setPuntosA(this.puntosA);
            proximo.setPuntosB(puntos);
            proximo.setTurno(2);//cambia el turno para el caballo negro
        }
        if (this.turno == 2) {//para el caballo negro (pendiente)
            tablero[posA.x][posA.y] = 0;//el caballo deja la posicion donde estaba
            tablero[accion.x][accion.y] = 2; //2 para el caballo (pendiente)
            proximo.setPosB(this.posB);
            proximo.setPosA(accion);
            proximo.setPuntosB(this.puntosB);
            proximo.setPuntosA(puntos);
            proximo.setTurno(1);//cambia el turno para el caballo negro
        }
        
        proximo.setProfundidad(this.profundidad + 1);
        proximo.setTablero(tablero);
        return proximo;
    }

    List movidasValidas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setUtilidad(Double utilidad) {
        this.utilidad = utilidad;
    }

    Double calcularUtilidad() {
        return (Double) this.puntosB - this.puntosA;
    }

    boolean terminal(int limite) {
        boolean seAcaba = false;

        if (((35 - puntosA - puntosB) == 0) || (profundidad > limite)) {
            seAcaba = true;
        }

        return seAcaba;
    }
}
