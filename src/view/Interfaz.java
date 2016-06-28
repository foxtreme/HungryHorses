package view;
import data.Estado;
import data.Minimax;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Interfaz extends javax.swing.JFrame 
{
    private int filas = 8;
    private int columnas = 8;
    private GridLayout cuadricula1;
    int[][] miMatriz = new int[8][8];
    int [] botones = null;
    int nivel=0, contador=0, z=0,boton=0,ax=0,ay=0;
    String mostrar1="";
    Point [] punt = null;
    Point v = new Point(0, 0);
    Estado raiz= Estado.crearEstadoInicial(filas);
    Estado Nuevo=raiz.resultado(v); 

    public Interfaz() 
    {
        initComponents();
        comboDificultad.addItem("");
        comboDificultad.addItem("Facil");
        comboDificultad.addItem("Normal");
        comboDificultad.addItem("Dificil");
        
        cuadricula1 = new GridLayout(filas, columnas, 5, 5); 
        
        panelMatriz.setLayout(cuadricula1);
       
        int w = 0;
        
        for (int i = 0; i <8; i++) 
        {
            for (int j = 0; j <8; j++) 
            {
                panelMatriz.add(new JButton());
                w += 1;
            }
        }
        
        Component[] component = panelMatriz.getComponents();   
        JButton button = (JButton)component[w-1];
        button.setText("         ");
  
        this.setResizable(false);
        this.setVisible(true);
        inicio.setVisible(false);
        inicio2.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);

        mostrar (raiz.getTablero());
    }
    
    public void limpiar()
    {
        for (int i = 0; i < 64; i++) 
        {
            Component[] component = panelMatriz.getComponents();   
            JButton button = (JButton)component[i];
            button.setText("         ");
            button.setEnabled(false);
        }
        panelMatriz.getComponent(0).setEnabled(true);
        panelMatriz.getComponent(0).setEnabled(false);
        
    }
    
    public void mostrar(int[][] matriz) 
    {
        int h = 0;
        for (int i = 0; i < matriz.length; i++) 
        {
            for (int j = 0; j < matriz[i].length; j++) 
            {
                panelMatriz.getComponent(h).setBackground(pintar(matriz[i][j]));
                //panelMatriz.getComponent(h).setEnabled(false);
                h += 1;
            }
        }
    }
    
    private Color pintar(int tipo) 
    {
        
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
        inicio2 = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
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

        inicio2.setText("Jugador 2");
        inicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicio2ActionPerformed(evt);
            }
        });

        l1.setText("Columna");

        l2.setText("Fila");

        t2.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(13, 13, 13)
                                            .addComponent(inicio2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l1)
                                            .addComponent(l2))
                                        .addGap(18, 18, 18)
                                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dificultado)
                                .addGap(68, 68, 68))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(juegoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(juegoNuevo)
                        .addGap(44, 44, 44)
                        .addComponent(dificultado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(inicio)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l1)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l2)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(inicio2)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        limpiar();
        comboDificultad.setEnabled(false);
        inicio2.setVisible(true);
        l1.setVisible(true);
        l2.setVisible(true);
        t1.setVisible(true);
        t2.setVisible(true);
        t1.setText("");
        t2.setText("");
        if(comboDificultad.getSelectedItem()=="Facil"){  nivel=2; }
        else if(comboDificultad.getSelectedItem()=="Normal"){  nivel=4; }
        else if(comboDificultad.getSelectedItem()=="Dificil"){  nivel=6; }
                
        Estado.imprimirTablero(raiz);
        Minimax mov = new Minimax(raiz);
        mov.decisionMx(raiz,nivel); 
        Point movida = mov.getMovida();
        System.out.println("la jugada de blanco es: "+movida.toString());
        Nuevo = raiz.resultado(movida); 
            
        Thread hilo=new Thread()
        {
            public void run()
            {
                try {
                        mostrar(Nuevo.getTablero());
                        sleep(500);
                    } catch (InterruptedException ex) {      Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex); }
            }
        };
        hilo.start(); 
              
        Estado.imprimirTablero(Nuevo);
        Minimax mov1 = new Minimax(Nuevo);
        punt=mov1.decisionMn(Nuevo,nivel);
        Point movida1 = mov1.getMovida();
        System.out.println("la jugada de negro es: "+movida1.toString());            
        z=punt.length;
        int []valorz= new int[z];

        Component[] component1 = panelMatriz.getComponents();
        for (int i = 0; i < z; i++) 
        {
            Point nuevop=punt[i];    
            int ax= (int)nuevop.getX();
            int ay= (int)nuevop.getY();
            mostrar1="["+ax+","+ay+"]";
            boton=((ax*8)+(ay));
            valorz[i]=boton;
//            System.out.println(" botones"+ boton);
            JButton button = (JButton)component1[boton];
            button.setText(mostrar1);    
        }             
        inicio.setVisible(false);
        for (int i = 0; i < z; i++) {panelMatriz.getComponent(valorz[i]).setEnabled(true);}
        
       
    }//GEN-LAST:event_inicioActionPerformed

    
    private void juegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoNuevoActionPerformed
       
        raiz= Estado.crearEstadoInicial(filas);
        mostrar (raiz.getTablero());
        
        limpiar();
        comboDificultad.setEnabled(true);
        comboDificultad.removeAllItems();
        comboDificultad.addItem("");
        comboDificultad.addItem("Facil");
        comboDificultad.addItem("Normal");
        comboDificultad.addItem("Dificil");
        inicio.setVisible(false);
        inicio2.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);     
        
    }//GEN-LAST:event_juegoNuevoActionPerformed
    
    private void inicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicio2ActionPerformed


        if((t1.getText().length() == 0)||(t2.getText().length() == 0)){
            JOptionPane.showMessageDialog(null, "Debe ingresar la fila y la columna para jugar");
        }
        else{
        String ex=t1.getText();
        String ey=t2.getText();
        
            
        int entradax=Integer.parseInt(ex);
        int entraday=Integer.parseInt(ey);
        boolean val=false;
        
        for (int i = 0; i < punt.length; i++) 
        {
            Point nuevop=punt[i];    
            int axs= (int)nuevop.getX();
            int ays= (int)nuevop.getY();

            if((entradax==axs)&&(entraday==ays)){
            ax=axs;
            ay=ays;
            val=true;
            } 
        }
        
        if(val){
            
            Point movidanueva=new Point(ax, ay);
            raiz = Nuevo.resultado(movidanueva); 
            Estado.imprimirTablero(raiz);
            Thread hilo=new Thread()
            {
                public void run()
                {
                    try {
                            mostrar(raiz.getTablero());
                            sleep(500);
                        } catch (InterruptedException ex) {      Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex); }
                }
            };
            hilo.start(); 
            inicio.setVisible(true);

            t1.setText("");
            t2.setText("");
            inicio2.setVisible(false);
            l1.setVisible(false);
            l2.setVisible(false);
            t1.setVisible(false);
            t2.setVisible(false);
            limpiar();
        }
        else{  JOptionPane.showMessageDialog(null, "Ingreso una jugada no valida");}
            
        
     
        }
    }//GEN-LAST:event_inicio2ActionPerformed

    private void comboDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDificultadActionPerformed
        inicio.setVisible(true);
    }//GEN-LAST:event_comboDificultadActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() { public void run() { new Interfaz().setVisible(true);} });    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDificultad;
    private javax.swing.JLabel dificultado;
    private javax.swing.JButton inicio;
    private javax.swing.JButton inicio2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton juegoNuevo;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JPanel panelMatriz;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
