package data;

import java.awt.Point;
import java.util.ArrayList;
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
        List movidas = new ArrayList<Point>();
        Point posicion = new Point();
        Point posicionOponente = new Point();
        if (this.turno == 1) {
            posicion.setLocation(this.posB.x, this.posB.y);
            posicionOponente.setLocation(this.posA.x, this.posA.y);
        }
        if (this.turno == 2) {
            posicion.setLocation(this.posA.x, this.posA.y);
            posicionOponente.setLocation(this.posB.x, this.posB.y);
        }
        if ((posicion.x - 2) >= 0 && (posicion.y - 1) >= 0) {//arriba izq
            boolean ocupada = posicionOponente.equals(new Point((posicion.x - 2), (posicion.y - 1)));
            if (!ocupada) {
                movidas.add(new Point((posicion.x - 2), (posicion.y - 1)));
            }
        }
        if ((posicion.x - 2) >= 0 && (posicion.y + 1) <= 7) {//arriba der
            boolean ocupada = posicionOponente.equals(new Point((posicion.x - 2), (posicion.y + 1)));
            if (!ocupada) {
                movidas.add(new Point((posicion.x - 2), (posicion.y + 1)));
            }
        }
        if ((posicion.x + 2) <= 7 && (posicion.y - 1) >= 0) {//abajo izq
            boolean ocupada = posicionOponente.equals(new Point((posicion.x + 2), (posicion.y - 1)));
            if (!ocupada) {
                movidas.add(new Point((posicion.x - 2), (posicion.y - 1)));
            }
        }
        if ((posicion.x + 2) <= 7 && (posicion.y + 1) <= 7) {//abajo der
            boolean ocupada = posicionOponente.equals(new Point((posicion.x + 2), (posicion.y + 1)));
            if (!ocupada) {
                movidas.add(new Point((posicion.x - 2), (posicion.y - 1)));
            }
        }
        if ((posicion.y - 2) >= 0 && (posicion.x - 1) >= 0) {//izq arriba
            boolean ocupada = posicionOponente.equals(new Point((posicion.y - 2), (posicion.x - 1)));
            if (!ocupada) {
                movidas.add(new Point((posicion.x - 1), (posicion.y - 2)));
            }
        }
        if ((posicion.y - 2) >= 0 && (posicion.x + 1) <= 7) {//izq abajo
            boolean ocupada = posicionOponente.equals(new Point((posicion.y - 2), (posicion.x + 1)));
            if (!ocupada) {
                movidas.add(new Point((posicion.x + 1), (posicion.y - 2)));
            }
        }
        if ((posicion.y + 2) <= 7 && (posicion.x - 1) >= 0) {//der arriba
            boolean ocupada = posicionOponente.equals(new Point((posicion.y + 2), (posicion.x - 1)));
            if (!ocupada) {
                movidas.add(new Point((posicion.x - 1), (posicion.y + 2)));
            }
        }
        if ((posicion.y + 2) <= 7 && (posicion.x + 1) <= 7) {//der abajo
            boolean ocupada = posicionOponente.equals(new Point((posicion.y + 2), (posicion.x + 1)));
            if (!ocupada) {
                movidas.add(new Point((posicion.x + 1), (posicion.y + 2)));
            }
        }
        return movidas;
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
