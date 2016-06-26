package view;
import data.Estado;
import data.Minimax;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class Interfaz extends javax.swing.JFrame {
   int[][] miMatriz = new int[8][8];
    private int filas = 8;
    private int columnas = 8;
    private GridLayout cuadricula1;
    int nivel=0, contador=0,z=0;
    Estado raiz= Estado.crearEstadoInicial(filas);
    Point v = new Point(0, 0);
    Estado Nuevo=raiz.resultado(v); 
    Point [] punt = null;
    int [] botones = null;



    public Interfaz() {
        initComponents();
        
        comboDificultad.addItem("Facil");
        comboDificultad.addItem("Normal");
        comboDificultad.addItem("Dificil");
        cuadricula1 = new GridLayout(filas, columnas, 5, 5); 
        panelMatriz.setLayout(cuadricula1);
       
        int z = 0;
        for (int i = 0; i <8; i++) 
        {
            for (int j = 0; j <8; j++) 
            {
                String nameb= ""+z;
                panelMatriz.add(new JButton()).setName(nameb);
                panelMatriz.getComponent(z).setEnabled(false);
                z += 1;
            }
        }
               
        this.setResizable(false);
        this.setVisible(true);
        inicio.setVisible(false);
        mostrar (raiz.getTablero());
    }
    
    
    public void mostrar(int[][] matriz) {
        int z = 0;
        for (int i = 0; i < matriz.length; i++) 
        {
            for (int j = 0; j < matriz[i].length; j++) 
            {
                panelMatriz.getComponent(z).setBackground(pintar(matriz[i][j]));
                panelMatriz.getComponent(z).setEnabled(false);
                z += 1;
            }
        }
    }
    
    private Color pintar(int tipo) {
        
        switch (tipo) 
        {
            case 0: //limpio    
                return Color.BLUE;
            case 1://caballo blanco
                return Color.WHITE;
            case 2://caballo negro
                return Color.BLACK;
            case 3://cesped
                return Color.GREEN;
            case 4://flor
                return Color.RED;
            default:
                return Color.BLUE;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        dificultado = new javax.swing.JLabel();
        comboDificultad = new javax.swing.JComboBox<String>();
        inicio = new javax.swing.JButton();
        juegoNuevo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelPuntos = new javax.swing.JLabel();
        jugador2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        titulo.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        titulo.setText("Hungry Horses V 1.0");

        dificultado.setText("Selecciona una dificultad");

        comboDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDificultadActionPerformed(evt);
            }
        });

        inicio.setText("Jugador 1");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        juegoNuevo.setText("Nuevo Juego");
        juegoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juegoNuevoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Puntaje Actual: ");

        labelPuntos.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(labelPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPuntos)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jugador2.setText("Jugador 2");
        jugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugador2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(dificultado))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(juegoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(75, 75, 75))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(juegoNuevo)
                        .addGap(44, 44, 44)
                        .addComponent(dificultado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inicio)
                        .addGap(32, 32, 32)
                        .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 82, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
       
            Estado.imprimirTablero(raiz);
            Minimax mov = new Minimax(raiz);
            mov.decisionMx(raiz,2); 
            Point movida = mov.getMovida();
            System.out.println("la jugada de blanco es: "+movida.toString());
            Nuevo = raiz.resultado(movida); 
            
            Thread hilo=new Thread(){
                public void run(){
                            try {
                                mostrar(Nuevo.getTablero());
                                sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
            };
            hilo.start(); 
            
        
            Estado.imprimirTablero(Nuevo);
            Minimax mov1 = new Minimax(Nuevo);
            
            punt=mov1.decisionMn(Nuevo,nivel);
            
            Point movida1 = mov1.getMovida();
            System.out.println("la jugada de negro es: "+movida1.toString());
            
            z=punt.length;
            
            for (int i = 0; i < z; i++) {
            Point nuevop=punt[i];    
            int ax= (int)nuevop.getX();
            int ay= (int)nuevop.getY();
            int boton=((ax*8)+(ay));
              //  System.out.println(" botones"+ boton);
            panelMatriz.getComponent(boton).setEnabled(true);
            
            }
            
    }//GEN-LAST:event_inicioActionPerformed
 
 
     public Point actionPerformed(java.awt.event.ActionEvent e) {
        
    int elboton=0;
    Point elpunto=null;   
    
    for (int i = 0; i < z; i++) {
    
        elboton=botones[i];
        String names=""+elboton;

        if (e.getSource().equals(names)) { 
            System.out.println("entro");
            elpunto=punt[i];     
        }
        
        panelMatriz.getComponent(elboton).setEnabled(false);                            
       }
        return elpunto;
    } 
   
    
    private void juegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoNuevoActionPerformed
        comboDificultad.setVisible(true);

        raiz= Estado.crearEstadoInicial(filas);
        mostrar (raiz.getTablero());
        comboDificultad.removeAllItems();
        comboDificultad.addItem("Facil");
        comboDificultad.addItem("Normal");
        comboDificultad.addItem("Dificil");
        inicio.setVisible(false);
        
        
    }//GEN-LAST:event_juegoNuevoActionPerformed

    private void comboDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDificultadActionPerformed
                inicio.setVisible(true);
    }//GEN-LAST:event_comboDificultadActionPerformed

    private void jugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugador2ActionPerformed
       // Point ax=actionPerformed(evt);
    }//GEN-LAST:event_jugador2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                new Interfaz().setVisible(true);
            }
        });    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDificultad;
    private javax.swing.JLabel dificultado;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton juegoNuevo;
    private javax.swing.JButton jugador2;
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JPanel panelMatriz;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
