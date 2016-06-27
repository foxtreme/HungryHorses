package data;
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estado {

    private int[][] tablero;
    private Point posB;
    private Point posA;
    private Double puntosB;
    private Double puntosA;
    private Double utilidad;
    private int turno;
    private int profundidad;

    public int getProfundidad() {        return profundidad;    }

    public void setProfundidad(int profundidad) {   this.profundidad = profundidad;    }

    public int getTurno() {        return turno;    }

    public void setTurno(int turno) {        this.turno = turno;    }

    public int[][] getTablero() {        return tablero;    }

    public void setTablero(int[][] tablero) {        this.tablero = tablero;    }

    public Point getPosB() {        return posB;    }

    public void setPosB(Point posB) {        this.posB = posB;    }

    public Point getPosA() {        return posA;    }

    public void setPosA(Point posA) {        this.posA = posA;    }

    public Double getPuntosB() {        return puntosB;    }
    
    public void setPuntosB(Double puntosB) {        this.puntosB += puntosB;    }

    public Double getPuntosA() {        return puntosA;    }

    public void setPuntosA(Double puntosA) {        this.puntosA += puntosA;    }

    public void setUtilidad(Double utilidad) {        this.utilidad = utilidad;    }

    public Estado(int turno, int[][] tablero, Point posB, Point posA, Double puntosB, Double puntosA) {
        this.turno = turno;
        this.tablero = tablero;
        this.posB = posB;
        this.posA = posA;
        this.puntosB = puntosB;
        this.puntosA = puntosA;
    }

    public Estado() {   this.puntosA = 0.0;     this.puntosB = 0.0;   }

   public Estado resultado(Point accion) {
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

    public List movidasValidas() {
        
        List movidas = new ArrayList<>();
        Point posicion = new Point();
        Point posicionOponente = new Point();
        if (this.turno == 1) {//blanco
            posicion.setLocation(this.posB.x, this.posB.y);
            posicionOponente.setLocation(this.posA.x, this.posA.y);
        }
        if (this.turno == 2) {//negro
            posicion.setLocation(this.posA.x, this.posA.y);
            posicionOponente.setLocation(this.posB.x, this.posB.y);
        }
        //posiciones
        //-------arriba izq
        int x = posicion.x - 2;
        int y = posicion.y -1;
        Point movida = verificarMovimiento(x,y,posicionOponente);
        if(movida!=null){movidas.add(movida);}
        //-------arriba der
        y = posicion.y+1;
        movida = null;//se resetea la movida para verificar el sgte movimiento
        movida = verificarMovimiento(x,y,posicionOponente);
        if(movida!=null){movidas.add(movida);}
        //-------abajo izq
        x = posicion.x+2;
        y = posicion.y-1;
        movida = null;//se resetea la movida para verificar el sgte movimiento
        movida = verificarMovimiento(x,y,posicionOponente);
        if(movida!=null){movidas.add(movida);}
        //-------abajo der
        y = posicion.y+1;
        movida = null;//se resetea la movida para verificar el sgte movimiento
        movida = verificarMovimiento(x,y,posicionOponente);
        if(movida!=null){movidas.add(movida);}
        //-------izq arriba
        x = posicion.x-1;
        y = posicion.y-2;
        movida = null;//se resetea la movida para verificar el sgte movimiento
        movida = verificarMovimiento(x,y,posicionOponente);
        if(movida!=null){movidas.add(movida);}
        //-------izq abajo
        x = posicion.x+1;
        movida = null;//se resetea la movida para verificar el sgte movimiento
        movida = verificarMovimiento(x,y,posicionOponente);
        if(movida!=null){movidas.add(movida);}
        //-------der arriba
        x = posicion.x-1;
        y = posicion.y+2;
        movida = null;//se resetea la movida para verificar el sgte movimiento
        movida = verificarMovimiento(x,y,posicionOponente);
        if(movida!=null){movidas.add(movida);}
        //-------der abajo
        x = posicion.x+1;
        movida = null;//se resetea la movida para verificar el sgte movimiento
        movida = verificarMovimiento(x,y,posicionOponente);
        if(movida!=null){movidas.add(movida);}
        
        
        return movidas;
    }
    
    /**
     * Verifica si un movimiento a la posicion x,y esta en el tablero
     * y no esta ocupado por el oponente
     * @param x fila de la matrix
     * @param y columna de la matrix
     * @param posicionOponente lugar del oponente
     * @return null si no se puede, y Point si se puede
     */
    private Point verificarMovimiento(int x, int y, Point posicionOponente){
        Point movimiento = null;
        if((x >= 0) && (x<=7) && (y>=0) && (y<=7)){
            boolean ocupada = ((posicionOponente.distance(new Point(x, y))) == 0); 
            if (!ocupada) {
                movimiento = new Point(x, y);
            }
        }
        return movimiento;
    }
    
    /**
     * Crea el estado inicial del problema aleatoriamente
     * @param tamanio el tamanio del tablero
     * @return el estado inicial
     */
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
                casillas.add(new Point(fila,col));
                tablero[fila][col]=0;
            }
        } 
        //ubicar las figuras
        for(int i=0;i<27;i++){
            int max = casillas.size(); //desde 64 disminuyendo
            Random rand = new Random(System.currentTimeMillis());
            int idx = rand.nextInt(max);//indice al azar
            //System.out.println("idx "+idx);
            Point figura = (Point)casillas.get(idx);//coordenada x,y del tablero al azar
            //System.out.println("point "+figura);
            
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
            casillas.remove(idx);//retiro el indice que acabe de escoger para evitarlo
        }
        
        Estado inicial = new Estado(turno, tablero, posB,posA,  puntosB, puntosA);
        inicial.setProfundidad(profundidad);
        inicial.setUtilidad(utilidad);
        
        return inicial;
    }
    
    static public void imprimirTablero(Estado estado){
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


    public Double calcularUtilidad() {
        Double utilidad = (Double) this.puntosB - this.puntosA;
        this.utilidad = utilidad;
        return utilidad;
    }

    public boolean terminal(int limite) {
        boolean seAcaba = false;
            
        if ((profundidad >= limite)) {
            //System.out.println("entro");
            seAcaba = true;
            return seAcaba;
        }else{
            if((35 - puntosA - puntosB) == 0){
                seAcaba = true;
                return seAcaba;
            }else{
                return seAcaba;
            }   
        }     
    }
    
}
