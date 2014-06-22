/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;



import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.cliente.ClienteVehiculos;
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
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JuanCarlos
 */
public class MenuPrincipalSimulacion extends JFrame{
    /*escala de mapa*/
    public int variacionEscala=1;
    
    
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
    public static int ancho=1000, alto=800;
    public static int defectoAncho =6;
    public static int defectoAlto=29;
    
  /*parametros de mapa a escala 1:10*/
    public static int dimensionXMapa=240000;
    public static int dimensionYMapa=160000;
    public Mapa m;
    
    /*Zona*/
    Zona z;
    
    /*PARAMETROS DE HILO*/
    public Thread hilo;
    
    public Simulacion simu;
    //public Thread hilo;
    
    public Color claro= new Color(217, 228, 232);
    public MenuPrincipalSimulacion(){
             
       /*caracteristicas basicas de la ventana*/ 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        //ven= new VentanaDeInformacion();
        simu= new Simulacion();
        simu.setMaximizable(true);
        this.add(simu);
     
        barraMenu.setBackground(claro);
        /*********************************************/
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jButton2 = new javax.swing.JButton();
        barraMenu = new javax.swing.JPanel();
        btnPause = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnReanudar = new javax.swing.JButton();
        btnReducirZoom = new javax.swing.JButton();
        btnAumentarZoom = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/pausa.png"))); // NOI18N
        btnPause.setFocusable(false);
        btnPause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/play.png"))); // NOI18N
        btnPlay.setFocusable(false);
        btnPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/detener.png"))); // NOI18N
        btnStop.setFocusable(false);
        btnStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnReanudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/reanudar.jpg"))); // NOI18N
        btnReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReanudarActionPerformed(evt);
            }
        });

        btnReducirZoom.setText("-");
        btnReducirZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirZoomActionPerformed(evt);
            }
        });

        btnAumentarZoom.setText("+");
        btnAumentarZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarZoomActionPerformed(evt);
            }
        });

        jLabel1.setText("Zoom");

        javax.swing.GroupLayout barraMenuLayout = new javax.swing.GroupLayout(barraMenu);
        barraMenu.setLayout(barraMenuLayout);
        barraMenuLayout.setHorizontalGroup(
            barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnReducirZoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAumentarZoom)
                .addGap(13, 13, 13))
        );
        barraMenuLayout.setVerticalGroup(
            barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraMenuLayout.createSequentialGroup()
                .addGroup(barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(barraMenuLayout.createSequentialGroup()
                .addGroup(barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReanudar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(barraMenuLayout.createSequentialGroup()
                        .addGroup(barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReducirZoom)
                            .addComponent(btnAumentarZoom)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 285, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
                Simulacion.run = true;
                Simulacion.seguir=true;
                
                try{
                    ClienteSemaforos.inicializarCruces();
                    ClienteSemaforos.actualizarCruces();
                }catch(IOException ex){}
                hilo= new Thread(simu);
                hilo.start();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        Simulacion.seguir=true;
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        Simulacion.seguir=false;
        try{
            ClienteSemaforos.cambiarVelocidad(0);
            ClienteVehiculos.cambiarVelocidad(0);
            Simulacion.velocidadSimulacion=0;
        }catch(IOException e){}
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReanudarActionPerformed
        Simulacion.seguir=true;
        try{
            ClienteSemaforos.cambiarVelocidad(1);
            ClienteVehiculos.cambiarVelocidad(1);
            Simulacion.velocidadSimulacion=1;
        }catch(IOException e){}
    }//GEN-LAST:event_btnReanudarActionPerformed

    private void btnReducirZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirZoomActionPerformed
        if(variacionEscala>1){
            variacionEscala--;
        
            if(variacionEscala==1)Panel.factor=20;
            else if(variacionEscala==2)Panel.factor=40;
            else if(variacionEscala==3)Panel.factor=100;
            
        }
    }//GEN-LAST:event_btnReducirZoomActionPerformed

    private void btnAumentarZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarZoomActionPerformed
        if(variacionEscala<3){
            variacionEscala++;
        
             if(variacionEscala==1)Panel.factor=20;
             else if(variacionEscala==2)Panel.factor=40;
             else if(variacionEscala==3)Panel.factor=100;
        
        }
    }//GEN-LAST:event_btnAumentarZoomActionPerformed

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
    private javax.swing.JPanel barraMenu;
    private javax.swing.JButton btnAumentarZoom;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnReanudar;
    private javax.swing.JButton btnReducirZoom;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables


    
}
