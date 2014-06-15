/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;



import inf.pucp.edu.pe.cliente.Cliente;
import inf.pucp.edu.pe.modelo.Mapa;
import inf.pucp.edu.pe.modelo.Semaforo;
import inf.pucp.edu.pe.modelo.Zona;
import inf.pucp.edu.pe.vista.principal.PanelImagenVentana;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
/**
 *
 * @author JuanCarlos
 */
public class MenuPrincipalSimulacion extends JFrame{

    /*Semaforos*/
    Semaforo[] semaforo;
    
    
    /*parametros para cambio de zona*/
    Zona zona;
    Zona [] zonaGeneradas;
    //CambioDeZona cambioDeZona;
    public static int posicionRelativaX=0;
    public static int posicionRelativaY=0;
    public static int zonaActual= 1;
    
 /*parametros de la frame*/    
    public static String name="Simulador";
    public static int ancho=800, alto=800;
    public static int defectoAncho =6;
    public static int defectoAlto=29;
    
  /*parametros de mapa a escala 1:10*/
    public static int dimensionXMapa=24000;
    public static int dimensionYMapa=16000;
    public Mapa m;
    
    /*Zona*/
    Zona z;
    
    /*PARAMETROS DE HILO*/
    public Thread hilo;
    
    public VentanaSimulacion venSim;
    public VentanaDeInformacion ven;
    //public Thread hilo;
    
    public MenuPrincipalSimulacion() {
             
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        ven= new VentanaDeInformacion();
        ven.setLocation(1030, 64);
        ven.setVisible(true);
        this.add(ven);
        
        
        jToolBar1.setBackground(Color.WHITE);
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jButton2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuInformacionDeLaSimulacion = new javax.swing.JMenuItem();
        mnuInformacionDeLosSemaforos = new javax.swing.JMenuItem();
        mnuInformacionDeLosVehiculos = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnuSimulador = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuAgregarTiempoDeSimulacion = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/abriArchivo2.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/abriArchivo.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/detener.png"))); // NOI18N
        btnStop.setFocusable(false);
        btnStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        jToolBar1.add(btnStop);

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/play.png"))); // NOI18N
        btnPlay.setFocusable(false);
        btnPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPlay);

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/pausa.png"))); // NOI18N
        btnPause.setFocusable(false);
        btnPause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPause);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/configuracion.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Cargar data histórica");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cargar datos de los vehiculos");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Salir");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vistas");

        mnuInformacionDeLaSimulacion.setText("Información de la simulación");
        mnuInformacionDeLaSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformacionDeLaSimulacionActionPerformed(evt);
            }
        });
        jMenu2.add(mnuInformacionDeLaSimulacion);

        mnuInformacionDeLosSemaforos.setText("Información de los semaforos");
        mnuInformacionDeLosSemaforos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformacionDeLosSemaforosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuInformacionDeLosSemaforos);

        mnuInformacionDeLosVehiculos.setText("Información de los vehiculos");
        mnuInformacionDeLosVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInformacionDeLosVehiculosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuInformacionDeLosVehiculos);

        jMenuBar1.add(jMenu2);

        jMenu7.setText("Simulacion");

        jMenuItem7.setText("Ejecutar");
        jMenu7.add(jMenuItem7);

        jMenuItem8.setText("Pausa");
        jMenu7.add(jMenuItem8);

        jMenuItem9.setText("Reiniciar");
        jMenu7.add(jMenuItem9);

        jMenuItem10.setText("Detener");
        jMenu7.add(jMenuItem10);

        mnuSimulador.setText("Simulador");
        mnuSimulador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSimuladorActionPerformed(evt);
            }
        });
        jMenu7.add(mnuSimulador);

        jMenuBar1.add(jMenu7);

        jMenu3.setText("Parametros");

        mnuAgregarTiempoDeSimulacion.setText("Tiempo de simulación");
        mnuAgregarTiempoDeSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgregarTiempoDeSimulacionActionPerformed(evt);
            }
        });
        jMenu3.add(mnuAgregarTiempoDeSimulacion);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 226, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAgregarTiempoDeSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgregarTiempoDeSimulacionActionPerformed
        // TODO add your handling code here:
        AgregarTiempoDeSimulacion ats= new AgregarTiempoDeSimulacion();
        ats.setVisible(true);
    }//GEN-LAST:event_mnuAgregarTiempoDeSimulacionActionPerformed

    private void mnuInformacionDeLaSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformacionDeLaSimulacionActionPerformed
        MostrarInformacionDeSimulacion mis= new MostrarInformacionDeSimulacion();
        this.add(mis);
        mis.setVisible(true);
    }//GEN-LAST:event_mnuInformacionDeLaSimulacionActionPerformed

    private void mnuInformacionDeLosSemaforosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformacionDeLosSemaforosActionPerformed
        MostrarInformacionDeSemaforos mise= new MostrarInformacionDeSemaforos();
        this.add(mise);
        mise.setVisible(true);
        
    }//GEN-LAST:event_mnuInformacionDeLosSemaforosActionPerformed

    private void mnuInformacionDeLosVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInformacionDeLosVehiculosActionPerformed
        MostrarInformacionvehicular miv= new MostrarInformacionvehicular();
        this.add(miv);
        miv.setVisible(true);
    }//GEN-LAST:event_mnuInformacionDeLosVehiculosActionPerformed

    private void mnuSimuladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSimuladorActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_mnuSimuladorActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
                VentanaSimulacion.run = true;
                VentanaSimulacion.seguir=true;
                VentanaSimulacion vs= new VentanaSimulacion();
                this.add(vs);
                try{
                Cliente.inicializarCruces();
                }catch(IOException ex){}
                hilo= new Thread(vs);
                hilo.start();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        VentanaSimulacion.seguir=true;
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        VentanaSimulacion.seguir=false;
    }//GEN-LAST:event_btnPauseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalSimulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnuAgregarTiempoDeSimulacion;
    private javax.swing.JMenuItem mnuInformacionDeLaSimulacion;
    private javax.swing.JMenuItem mnuInformacionDeLosSemaforos;
    private javax.swing.JMenuItem mnuInformacionDeLosVehiculos;
    private javax.swing.JMenuItem mnuSimulador;
    // End of variables declaration//GEN-END:variables


    
}
