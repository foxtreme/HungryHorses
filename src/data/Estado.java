package data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
        this.puntosA = 0.0;
        this.puntosB = 0.0;
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
    
    public static Estado crearEstadoInicial(int tamanio){
        List casillas = new ArrayList<Point>();
        Point posA = new Point();//caballo negro
        Point posB = new Point();//caballo blanco
        Double puntosA = 0.0;
        Double puntosB = 0.0;
        Double utilidad = Double.NEGATIVE_INFINITY;
        int turno = 1;
        int profundidad = 0;
        int [][] tablero = new int[tamanio][tamanio];
        //lleno el arreglo de indices y el tablero por defecto        
        for(int fila=0; fila<tamanio; fila++){
            for(int col=0;col<tamanio;col++){
                Point casilla = new Point(fila,col);
                casillas.add(casilla);
                tablero[fila][col]=0;
            }
        }
        //ubicar las figuras
        for(int i=0;i<27;i++){
            int max = casillas.size();
            Random rand = new Random(System.currentTimeMillis());
            int idx = rand.nextInt(max);
            Point figura = (Point)casillas.get(idx);
            if(i<20){//cesped
                tablero[figura.x][figura.y]=3;
            }
            if(i>=20 && i<25){//flores
                tablero[figura.x][figura.y]=4;
            }
            if(i==25){
                tablero[figura.x][figura.y]=1;//caballo blanco
                posB.setLocation(figura.x, figura.y);
            }
            if(i==26){
                tablero[figura.x][figura.y]=2;//caballo negro
                posA.setLocation(figura.x, figura.y);
            }
            casillas.remove(idx);
        }
        
        Estado inicial = new Estado(turno, tablero, posB,posA,  puntosB, puntosA);
        inicial.setProfundidad(profundidad);
        inicial.setUtilidad(utilidad);
        
        return inicial;
    }
    
    public void imprimirTablero(Estado estado){
        int [][] tablero = estado.getTablero();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("posBlanco: "+estado.getPosB());
        System.out.println("posNegro: "+estado.getPosA());
        System.out.println("ptsBlanco: "+estado.getPuntosB());
        System.out.println("ptsNegro: "+estado.getPuntosA());
        System.out.println("utilidad: "+estado.calcularUtilidad());
        System.out.println("profundidad: "+estado.getProfundidad());
        System.out.println("turno (1) blanco (2) negro: "+estado.getTurno());
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
    
    public static void main(String args[]){
        Estado objEstado = new Estado();
        Estado inicial = objEstado.crearEstadoInicial(8);
        objEstado.imprimirTablero(inicial);
        
    }
}
