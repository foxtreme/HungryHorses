package view;

import data.Estado;
import data.Minimax;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static java.lang.Thread.sleep;

public class Interfaz extends javax.swing.JFrame {

    private int filas = 8;
    private int columnas = 8;
    private GridLayout cuadricula1;
    int[][] miMatriz = new int[8][8];
    int[] valorz = null;
    int[] botones = null;
    int nivel = 0, contador = 0, z = 0, boton = 0, ax = 0, ay = 0, variable = -1;
    double ptsBlanco = 0.0, ptsNegro = 0.0;
    String textoPosicionBtn = "", coloricono = "";
    Point[] punt = null; //areglo de posiciones de los botones
    Point v = new Point(0, 0);
    Estado raiz = Estado.crearEstadoInicial(filas);
    Estado Nuevo;

    public Interfaz() {
        initComponents();
        comboDificultad.addItem("");
        comboDificultad.addItem("Facil");
        comboDificultad.addItem("Normal");
        comboDificultad.addItem("Dificil");

        cuad();
        btnJugador1.setVisible(false);
        btnJugador2.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        campoFila.setVisible(false);
        campoColumna.setVisible(false);

        mostrar(raiz.getTablero());
    }

    /**
     * Cuadricula con los botones que componen el tablero
     */
    public void cuad() {
        cuadricula1 = new GridLayout(filas, columnas, 5, 5);
        panelMatriz.setLayout(cuadricula1);
        int w = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                panelMatriz.add(new JButton());
                w += 1;
            }
        }

        this.setResizable(false);
        this.setVisible(true);

    }

    /**
     * borrar los textos de los botones
     */
    public void limpiar() {
        for (int i = 0; i < 64; i++) {
            Component[] component = panelMatriz.getComponents();
            JButton button = (JButton) component[i];
            button.setText("");
        }
    }

    /**
     * Se encarga de pintar el tablero
     * @param matriz el tablero a pintar
     */
    public void mostrar(int[][] matriz) {
        int h = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                panelMatriz.getComponent(h).setBackground(pintar(matriz[i][j]));
                Component[] component = panelMatriz.getComponents();
                JButton button = (JButton) component[h];
                button.setIcon(new javax.swing.ImageIcon(getClass().getResource(pintarI(matriz[i][j]))));
                Dimension panela = new Dimension(70, 70);
                button.setPreferredSize(panela);
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setIconTextGap(-35);

                h += 1;
            }
        }

    }

    /**
     * Dependiendo del tipo de casilla, asigna un color
     * @param tipo numero correspondiente a un tipo de casilla
     * @return Color correspondiente al tipo de casilla
     */
    private Color pintar(int tipo) {
        switch (tipo) {
            case 0: //limpio    
                return Color.ORANGE;
            case 1://caballo blanco
                return Color.ORANGE;
            case 2://caballo negro
                return Color.ORANGE;
            case 3://cesped
                return Color.GREEN;
            case 4://flor
                return Color.RED;
            default:
                return Color.BLUE;
        }
    }

    /**
     * De acuerdo al tipo de casilla, añade el icono que la representa
     * @param tipo numero correspondiente a un tipo de casilla
     * @return Un string correspondiente a la ruta del icono
     */
    private String pintarI(int tipo) {
        switch (tipo) {
            case 0: //limpio    
                return coloricono = "";
            case 1://caballo blanco
                return coloricono = "/view/caballob.png";
            case 2://caballo negro
                return coloricono = "/view/caballon.png";
            case 3://cesped
                return coloricono = "/view/pasto.png";
            case 4://flor
                return coloricono = "/view/flor.png";
            default:
                return coloricono = "";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        labelDificultad = new javax.swing.JLabel();
        comboDificultad = new javax.swing.JComboBox<>();
        btnJugador1 = new javax.swing.JButton();
        btnJuegoNuevo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelPuntajeBlanco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelPuntajeNegro = new javax.swing.JLabel();
        btnJugador2 = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        campoFila = new javax.swing.JTextField();
        campoColumna = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hungry Horses");
        setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        titulo.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        titulo.setText("Hungry Horses");

        labelDificultad.setText("Selecciona una dificultad");

        comboDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDificultadActionPerformed(evt);
            }
        });

        btnJugador1.setText("Jugador 1");
        btnJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador1ActionPerformed(evt);
            }
        });

        btnJuegoNuevo.setText("Nuevo Juego");
        btnJuegoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuegoNuevoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Puntaje Blanco: ");

        labelPuntajeBlanco.setText("0");

        jLabel2.setText("Puntaje Negro:");

        labelPuntajeNegro.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPuntajeNegro, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(labelPuntajeBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelPuntajeBlanco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelPuntajeNegro))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnJugador2.setText("Jugador 2");
        btnJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador2ActionPerformed(evt);
            }
        });

        l1.setText("Columna");

        l2.setText("Fila");

        campoColumna.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnJuegoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(labelDificultad)
                            .addGap(68, 68, 68))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(l1)
                                            .addComponent(l2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoFila, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(25, 25, 25)))
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnJuegoNuevo)
                        .addGap(32, 32, 32)
                        .addComponent(labelDificultad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnJugador1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoFila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l1)
                            .addComponent(campoColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnJugador2)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Jugador 1
     *  Es la jugada del caballo blanco
     * @param evt
     */
    private void btnJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador1ActionPerformed
        comboDificultad.setEnabled(false);
        btnJugador2.setVisible(true);
        l1.setVisible(true);
        l2.setVisible(true);
        campoFila.setVisible(true);
        campoColumna.setVisible(true);
        campoFila.setText("");
        campoColumna.setText("");
        if (comboDificultad.getSelectedItem() == "Facil") {
            nivel = 2;
        } else if (comboDificultad.getSelectedItem() == "Normal") {
            nivel = 4;
        } else if (comboDificultad.getSelectedItem() == "Dificil") {
            nivel = 6;
        }
        //Estado.imprimirTablero(raiz);
        Minimax mov = new Minimax(raiz);
        mov.decisionMx(raiz, nivel);
        Point movida = mov.getMovida();
        Nuevo = raiz.resultado(movida);
        ptsBlanco = ptsBlanco + Nuevo.getPuntosB();
        String puntosBlanco = Double.toString(ptsBlanco);
        labelPuntajeBlanco.setText(puntosBlanco);
        Thread hilo = new Thread() {
            public void run() {
                try {
                    mostrar(Nuevo.getTablero());
                    sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        hilo.start();

        //Estado.imprimirTablero(Nuevo);
        Minimax mov1 = new Minimax(Nuevo);
        punt = mov1.decisionMn(Nuevo, nivel);
        Point movida1 = mov1.getMovida();
        System.out.println("la jugada recomendada de negro es: " + movida1.toString());
        z = punt.length;
        valorz = new int[z];

        Component[] component1 = panelMatriz.getComponents();
        for (int i = 0; i < z; i++) {
            Point nuevop = punt[i];
            int ax = (int) nuevop.getX();
            int ay = (int) nuevop.getY();
            textoPosicionBtn = "[" + ax + "," + ay + "]";
            boton = ((ax * 8) + (ay));
            valorz[i] = boton;
//            System.out.println(" botones"+ boton);
            JButton button = (JButton) component1[boton];
            button.setText(textoPosicionBtn);
            button.setForeground(Color.DARK_GRAY);

        }
        
        crearbotones();
        btnJugador1.setVisible(false);

    }//GEN-LAST:event_btnJugador1ActionPerformed

    /**
     * Inicia un juego nuevo
     *
     * @param evt
     */
    private void btnJuegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuegoNuevoActionPerformed
        ptsBlanco = 0;
        ptsNegro = 0;
        raiz = Estado.crearEstadoInicial(filas);
        comprobar();
        limpiar();
        comboDificultad.setEnabled(true);
        comboDificultad.removeAllItems();
        comboDificultad.addItem("");
        comboDificultad.addItem("Facil");
        comboDificultad.addItem("Normal");
        comboDificultad.addItem("Dificil");
        btnJugador1.setVisible(false);
        btnJugador2.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        campoFila.setVisible(false);
        campoColumna.setVisible(false);

    }//GEN-LAST:event_btnJuegoNuevoActionPerformed

    /**
     * Jugador Negro
     *
     * @param evt
     */
    private void btnJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador2ActionPerformed
        System.out.println(ptsBlanco + " ------- " + ptsNegro);
        if ((Double.parseDouble(labelPuntajeBlanco.getText()) + Double.parseDouble(labelPuntajeNegro.getText())) <= 35) {

            if ((campoFila.getText().length() == 0) || (campoColumna.getText().length() == 0)) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la fila y la columna para jugar");
            } else {
                String ex = campoFila.getText();
                String ey = campoColumna.getText();

                int entradax = Integer.parseInt(ex);
                int entraday = Integer.parseInt(ey);
                boolean val = false;

                for (int i = 0; i < punt.length; i++) {
                    Point nuevop = punt[i];
                    int axs = (int) nuevop.getX();
                    int ays = (int) nuevop.getY();

                    if ((entradax == axs) && (entraday == ays)) {
                        ax = axs;
                        ay = ays;
                        val = true;
                    }
                }

                if (val) {

                    Point movidanueva = new Point(ax, ay);
                    raiz = Nuevo.resultado(movidanueva);
                    if (raiz.getPuntosA() == 3) {
                        ptsNegro = ptsNegro + 3;
                    } else {
                        ptsNegro = ptsNegro + raiz.getPuntosA();
                    }

                    labelPuntajeNegro.setText(Double.toString(ptsNegro));
                    //Estado.imprimirTablero(raiz);
                    Thread hilo = new Thread() {
                        public void run() {
                            try {
                                mostrar(raiz.getTablero());
                                sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    };
                    hilo.start();
                    btnJugador1.setVisible(true);

                    campoFila.setText("");
                    campoColumna.setText("");
                    btnJugador2.setVisible(false);
                    l1.setVisible(false);
                    l2.setVisible(false);
                    campoFila.setVisible(false);
                    campoColumna.setVisible(false);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingreso una jugada no valida");
                }

            }
        } else {//si el puntaje ha alcanzado su maximo
            System.out.println("fin " + ptsBlanco + " ------- " + ptsNegro);
            String victoria;
            if (ptsBlanco > ptsNegro) {
                victoria = "Ganado";
            } else {
                victoria = "Perdido";
            }
            JOptionPane.showConfirmDialog(null, "Usted Ha " + victoria, "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_btnJugador2ActionPerformed

    private void comboDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDificultadActionPerformed
        btnJugador1.setVisible(true);
    }//GEN-LAST:event_comboDificultadActionPerformed

    private void comprobar() {

        panelMatriz.removeAll();
        cuad();
        mostrar(raiz.getTablero());

    }

    private void hacerboton(int otro) {
        if ((Double.parseDouble(labelPuntajeBlanco.getText()) + Double.parseDouble(labelPuntajeNegro.getText())) <= 35) {
            
            Point nuevop = punt[otro];//escoje la jugada
            int axs = (int) nuevop.getX();
            int ays = (int) nuevop.getY();
            ax = axs;
            ay = ays;
            Point movidanueva = new Point(ax, ay);
            raiz = Nuevo.resultado(movidanueva);
            //Estado.imprimirTablero(raiz);
            ptsNegro = ptsNegro + raiz.getPuntosA();
            labelPuntajeNegro.setText(Double.toString(ptsNegro));
            variable = -1;
            btnJugador1.setVisible(true);
            campoFila.setText("");
            campoColumna.setText("");
            btnJugador2.setVisible(false);
            l1.setVisible(false);
            l2.setVisible(false);
            campoFila.setVisible(false);
            campoColumna.setVisible(false);
            limpiar();
        } else {//si el puntaje ha alcanzado su maximo
            System.out.println("fin " + ptsBlanco + " ------- " + ptsNegro);
            String victoria;
            if (ptsBlanco > ptsNegro) {
                victoria = "Ganado";
            } else {
                victoria = "Perdido";
            }
            JOptionPane.showConfirmDialog(null, "Usted Ha " + victoria, "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private void button1xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 0;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button2xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 1;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button3xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 2;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button4xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 3;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button5xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 4;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button6xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 5;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button7xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 6;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button8xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 7;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button9xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 8;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button10xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 9;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button11xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 10;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button12xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 11;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button13xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 12;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button14xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 13;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button15xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 14;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button16xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 15;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button17xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 16;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button18xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 17;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button19xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 18;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button20xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 19;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button21xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 20;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button22xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 21;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button23xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 22;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button24xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 23;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button25xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 24;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button26xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 25;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button27xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 26;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button28xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 27;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button29xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 28;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button30xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 29;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button31xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 30;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button32xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 31;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button33xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 32;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button34xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 33;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button35xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 34;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button36xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 35;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button37xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 36;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button38xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 37;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button39xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 38;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button40xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 39;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button41xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 40;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button42xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 41;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button43xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 42;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button44xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 43;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button45xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 44;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button46xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 45;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button47xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 46;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button48xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 47;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button49xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 48;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button50xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 49;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button51xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 50;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button52xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 51;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button53xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 52;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button54xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 53;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button55xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 54;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button56xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 55;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button57xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 56;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button58xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 57;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button59xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 58;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button60xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 59;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button61xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 60;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button62xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 61;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button63xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 62;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    private void button64xActionPerformed(java.awt.event.ActionEvent evt) {
        int nboton = 63;
        variable = 0;
        for (int i = 0; i < punt.length; i++) {
            if (nboton == valorz[i]) {
                hacerboton(i);
                comprobar();
            }
        }
        if (variable == 0) {
            variable = -1;
            JOptionPane.showMessageDialog(null, "Escogio una jugada no valida");
        }
    }

    public void crearbotones() {

        Component[] component = panelMatriz.getComponents();
        JButton button1x = (JButton) component[0];
        button1x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1xActionPerformed(evt);
            }
        });
        JButton button2x = (JButton) component[1];
        button2x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2xActionPerformed(evt);
            }
        });
        JButton button3x = (JButton) component[2];
        button3x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3xActionPerformed(evt);
            }
        });
        JButton button4x = (JButton) component[3];
        button4x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4xActionPerformed(evt);
            }
        });
        JButton button5x = (JButton) component[4];
        button5x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5xActionPerformed(evt);
            }
        });
        JButton button6x = (JButton) component[5];
        button6x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6xActionPerformed(evt);
            }
        });
        JButton button7x = (JButton) component[6];
        button7x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7xActionPerformed(evt);
            }
        });
        JButton button8x = (JButton) component[7];
        button8x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8xActionPerformed(evt);
            }
        });
        JButton button9x = (JButton) component[8];
        button9x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9xActionPerformed(evt);
            }
        });
        JButton button10x = (JButton) component[9];
        button10x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10xActionPerformed(evt);
            }
        });
        JButton button11x = (JButton) component[10];
        button11x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11xActionPerformed(evt);
            }
        });
        JButton button12x = (JButton) component[11];
        button12x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12xActionPerformed(evt);
            }
        });
        JButton button13x = (JButton) component[12];
        button13x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button13xActionPerformed(evt);
            }
        });
        JButton button14x = (JButton) component[13];
        button14x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button14xActionPerformed(evt);
            }
        });
        JButton button15x = (JButton) component[14];
        button15x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15xActionPerformed(evt);
            }
        });
        JButton button16x = (JButton) component[15];
        button16x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button16xActionPerformed(evt);
            }
        });
        JButton button17x = (JButton) component[16];
        button17x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button17xActionPerformed(evt);
            }
        });
        JButton button18x = (JButton) component[17];
        button18x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button18xActionPerformed(evt);
            }
        });
        JButton button19x = (JButton) component[18];
        button19x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button19xActionPerformed(evt);
            }
        });
        JButton button20x = (JButton) component[19];
        button20x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button20xActionPerformed(evt);
            }
        });
        JButton button21x = (JButton) component[20];
        button21x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button21xActionPerformed(evt);
            }
        });
        JButton button22x = (JButton) component[21];
        button22x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button22xActionPerformed(evt);
            }
        });
        JButton button23x = (JButton) component[22];
        button23x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button23xActionPerformed(evt);
            }
        });
        JButton button24x = (JButton) component[23];
        button24x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button24xActionPerformed(evt);
            }
        });
        JButton button25x = (JButton) component[24];
        button25x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button25xActionPerformed(evt);
            }
        });
        JButton button26x = (JButton) component[25];
        button26x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button26xActionPerformed(evt);
            }
        });
        JButton button27x = (JButton) component[26];
        button27x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button27xActionPerformed(evt);
            }
        });
        JButton button28x = (JButton) component[27];
        button28x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button28xActionPerformed(evt);
            }
        });
        JButton button29x = (JButton) component[28];
        button29x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button29xActionPerformed(evt);
            }
        });
        JButton button30x = (JButton) component[29];
        button30x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button30xActionPerformed(evt);
            }
        });
        JButton button31x = (JButton) component[30];
        button31x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button31xActionPerformed(evt);
            }
        });
        JButton button32x = (JButton) component[31];
        button32x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button32xActionPerformed(evt);
            }
        });
        JButton button33x = (JButton) component[32];
        button33x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button33xActionPerformed(evt);
            }
        });
        JButton button34x = (JButton) component[33];
        button34x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button34xActionPerformed(evt);
            }
        });
        JButton button35x = (JButton) component[34];
        button35x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button35xActionPerformed(evt);
            }
        });
        JButton button36x = (JButton) component[35];
        button36x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button36xActionPerformed(evt);
            }
        });
        JButton button37x = (JButton) component[36];
        button37x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button37xActionPerformed(evt);
            }
        });
        JButton button38x = (JButton) component[37];
        button38x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button38xActionPerformed(evt);
            }
        });
        JButton button39x = (JButton) component[38];
        button39x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button39xActionPerformed(evt);
            }
        });
        JButton button40x = (JButton) component[39];
        button40x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button40xActionPerformed(evt);
            }
        });
        JButton button41x = (JButton) component[40];
        button41x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button41xActionPerformed(evt);
            }
        });
        JButton button42x = (JButton) component[41];
        button42x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button42xActionPerformed(evt);
            }
        });
        JButton button43x = (JButton) component[42];
        button43x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button43xActionPerformed(evt);
            }
        });
        JButton button44x = (JButton) component[43];
        button44x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button44xActionPerformed(evt);
            }
        });
        JButton button45x = (JButton) component[44];
        button45x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button45xActionPerformed(evt);
            }
        });
        JButton button46x = (JButton) component[45];
        button46x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button46xActionPerformed(evt);
            }
        });
        JButton button47x = (JButton) component[46];
        button47x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button47xActionPerformed(evt);
            }
        });
        JButton button48x = (JButton) component[47];
        button48x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button48xActionPerformed(evt);
            }
        });
        JButton button49x = (JButton) component[48];
        button49x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button49xActionPerformed(evt);
            }
        });
        JButton button50x = (JButton) component[49];
        button50x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button50xActionPerformed(evt);
            }
        });
        JButton button51x = (JButton) component[50];
        button51x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button51xActionPerformed(evt);
            }
        });
        JButton button52x = (JButton) component[51];
        button52x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button52xActionPerformed(evt);
            }
        });
        JButton button53x = (JButton) component[52];
        button53x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button53xActionPerformed(evt);
            }
        });
        JButton button54x = (JButton) component[53];
        button54x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button54xActionPerformed(evt);
            }
        });
        JButton button55x = (JButton) component[54];
        button55x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15xActionPerformed(evt);
            }
        });
        JButton button56x = (JButton) component[55];
        button56x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button56xActionPerformed(evt);
            }
        });
        JButton button57x = (JButton) component[56];
        button57x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button57xActionPerformed(evt);
            }
        });
        JButton button58x = (JButton) component[57];
        button58x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button58xActionPerformed(evt);
            }
        });
        JButton button59x = (JButton) component[58];
        button59x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button59xActionPerformed(evt);
            }
        });
        JButton button60x = (JButton) component[59];
        button60x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button60xActionPerformed(evt);
            }
        });
        JButton button61x = (JButton) component[60];
        button61x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button61xActionPerformed(evt);
            }
        });
        JButton button62x = (JButton) component[61];
        button62x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button62xActionPerformed(evt);
            }
        });
        JButton button63x = (JButton) component[62];
        button63x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button63xActionPerformed(evt);
            }
        });
        JButton button64x = (JButton) component[63];
        button64x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button64xActionPerformed(evt);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJuegoNuevo;
    private javax.swing.JButton btnJugador1;
    private javax.swing.JButton btnJugador2;
    private javax.swing.JTextField campoColumna;
    private javax.swing.JTextField campoFila;
    private javax.swing.JComboBox<String> comboDificultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel labelDificultad;
    private javax.swing.JLabel labelPuntajeBlanco;
    private javax.swing.JLabel labelPuntajeNegro;
    private javax.swing.JPanel panelMatriz;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
