package view;
import data.Estado;
import data.Minimax;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class Interfaz extends javax.swing.JFrame {
   int[][] miMatriz = new int[8][8];
    private int filas = 8;
    private int columnas = 8;
    private GridLayout cuadricula1;
    
    Estado raiz= Estado.crearEstadoInicial(filas);


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
                panelMatriz.add(new JButton());
                panelMatriz.getComponent(z).setEnabled(false);
                z += 1;
            }
        }
               
        this.setResizable(false);
        this.setVisible(true);

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
        jLabel1 = new javax.swing.JLabel();
        labelPuntos = new javax.swing.JLabel();

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

        titulo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        titulo.setText("Hungry Horses V 1.0");

        dificultado.setText("Selecciona una dificultad");

        inicio.setText("Iniciar");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        jLabel1.setText("Puntaje Actual: ");

        labelPuntos.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPuntos))
                            .addComponent(dificultado)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dificultado)
                        .addGap(18, 18, 18)
                        .addComponent(inicio)
                        .addGap(29, 29, 29)
                        .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelPuntos))
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        // TODO add your handling code here:
        Estado.imprimirTablero(raiz);
        Minimax mov = new Minimax(raiz);
        
        mov.decision(raiz,6);
        Point movida = mov.getMovida();
        System.out.println("la jugada de blanco es: "+movida.toString());
            
       // Point accion = new Point(5,6);
        final Estado nuevo = raiz.resultado(movida); 
        
                Thread hilo=new Thread(){
                public void run(){
                   
                        try {
                            mostrar(nuevo.getTablero());
                            sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                }
            };
            hilo.start(); 

    }//GEN-LAST:event_inicioActionPerformed

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
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JPanel panelMatriz;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
