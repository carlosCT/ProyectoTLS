package inf.pucp.edu.pe.vista.simulacion;


import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.cliente.ClienteVehiculos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juancarlos
 */
public class Simulador_1 extends javax.swing.JFrame implements KeyListener, Runnable{

    /**
     * Creates new form Simulador
     */
    public static boolean run=false;
    public static boolean seguir=false;
    private static int velocidadSimulacion=1;
    
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public Mapa_1 p;
    public static int nivelZoom=10;
    public int velocidad=30;
    
  
    public Simulador_1() {
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
     //   JPanel p2= configBotones();
    //    JPanel p1= informacionMapa();
        p= configMapa();
        this.addKeyListener(this);
             
        
        try{
                ClienteSemaforos.inicializarCruces();
        }catch(IOException ex){}
         
        
       txtVelocidad.setEditable(false);
    
       txtVelocidad.setText(""+velocidadSimulacion);
       
      
    }
    
    public Mapa_1 configMapa(){
        Mapa_1 p= new Mapa_1();
        p.setLocation(0,80);
        p.setSize(240000, 160000);
        this.getContentPane().add(p);
        p.setBackground(Color.gray);
        this.setFocusable(true);
         return p;
    }


    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int valor= e.getKeyCode();
        if(valor==KeyEvent.VK_RIGHT){
            Mapa_1.movHorizontal+=velocidad;
           // System.out.println("se movio");
            
        } else if(valor==KeyEvent.VK_LEFT){
            Mapa_1.movHorizontal-=velocidad;
            //System.out.println("se movio");
          
        }else if(valor==KeyEvent.VK_UP){
            Mapa_1.movVertical-=velocidad;
           // System.out.println("se movio");
          
        }else if(valor==KeyEvent.VK_DOWN){
            Mapa_1.movVertical+=velocidad;
            //System.out.println("se movio");
    
            
            //ZOOM//
        }else if(valor==KeyEvent.VK_1){
           Mapa_1.zoom+=10;
           nivelZoom++;
            
        }else if(valor==KeyEvent.VK_2){
           if(Mapa_1.zoom>10){
            Mapa_1.zoom-=10;
            nivelZoom--;
           }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
        repaint();
       
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblVPromedio = new javax.swing.JLabel();
        lblCantVehiculos2 = new javax.swing.JLabel();
        lblCantSemaforos2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalVehiculos2 = new javax.swing.JLabel();
        lblTotalSemaforos2 = new javax.swing.JLabel();
        PanelTrafico2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        btnMas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtVelocidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnZoomMenos = new javax.swing.JButton();
        btnZoomMas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 30));

        lblVPromedio.setText("VPromedio: ");

        lblCantVehiculos2.setText("#VehiculosZona: ");

        lblCantSemaforos2.setText("#SemaforosZona: ");

        jLabel4.setText("ZONA: ");

        jLabel5.setText("MAPA: ");

        lblTotalVehiculos2.setText("TotalVehiculos: ");

        lblTotalSemaforos2.setText("TotalSemaforos: 239 000");

        PanelTrafico2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PanelTrafico2Layout = new javax.swing.GroupLayout(PanelTrafico2);
        PanelTrafico2.setLayout(PanelTrafico2Layout);
        PanelTrafico2Layout.setHorizontalGroup(
            PanelTrafico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        PanelTrafico2Layout.setVerticalGroup(
            PanelTrafico2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(lblCantVehiculos2)
                .addGap(71, 71, 71)
                .addComponent(lblCantSemaforos2)
                .addGap(114, 114, 114)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVPromedio)
                .addGap(72, 72, 72)
                .addComponent(lblTotalVehiculos2)
                .addGap(67, 67, 67)
                .addComponent(lblTotalSemaforos2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(PanelTrafico2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCantVehiculos2)
                        .addComponent(jLabel4)
                        .addComponent(lblCantSemaforos2)
                        .addComponent(jLabel5)
                        .addComponent(lblVPromedio)
                        .addComponent(lblTotalVehiculos2)
                        .addComponent(lblTotalSemaforos2))
                    .addComponent(PanelTrafico2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/play.png"))); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/pausa.png"))); // NOI18N
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/detener.png"))); // NOI18N
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnRestart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/reanudar.png"))); // NOI18N
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        btnMenos.setText("-");
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });

        btnMas.setText("+");
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });

        jLabel2.setText("Velocidad: ");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblTiempo.setText("Tiempo: 00:00:00");

        jLabel8.setText("Zoom:");

        btnZoomMenos.setText("-");
        btnZoomMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomMenosActionPerformed(evt);
            }
        });

        btnZoomMas.setText("+");
        btnZoomMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomMasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(lblTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMas)
                .addGap(45, 45, 45)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZoomMenos)
                .addGap(1, 1, 1)
                .addComponent(btnZoomMas))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPause)
            .addComponent(btnStop)
            .addComponent(btnRestart)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnPlay)
                .addComponent(btnMenos)
                .addComponent(btnMas)
                .addComponent(jLabel2)
                .addComponent(txtVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTiempo)
                .addComponent(jLabel8)
                .addComponent(btnZoomMenos)
                .addComponent(btnZoomMas))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
       Simulador_1.seguir=false;
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
            Simulador_1.run = true;
                Simulador_1.seguir=true;
                
//                try{
////                ClienteSemaforos.inicializarCruces();
////                ClienteSemaforos.actualizarCruces();
//                }catch(IOException ex){}
              new Thread(this).start();
                
        this.requestFocus();
        this.setFocusable(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        Simulador_1.seguir=false;
        this.requestFocus();
        this.setFocusable(true);
        try{
            ClienteSemaforos.cambiarVelocidad(0);
            ClienteVehiculos.cambiarVelocidad(0);
            Simulador_1.velocidadSimulacion=0;
        }catch(IOException e){}
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
           Simulador_1.seguir=true;
           this.requestFocus();
           this.setFocusable(true);
        try{
            ClienteSemaforos.cambiarVelocidad(1);
            ClienteVehiculos.cambiarVelocidad(1);
            Simulador_1.velocidadSimulacion=1;
        }catch(IOException e){}
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
       if(velocidadSimulacion != 1){
                    
                    velocidadSimulacion--;
                    try{
                    ClienteSemaforos.cambiarVelocidad(velocidadSimulacion);
                    ClienteVehiculos.cambiarVelocidad(velocidadSimulacion);
                    }catch(IOException ioe){}
                    txtVelocidad.setText(""+velocidadSimulacion);
                }
        this.requestFocus();
           this.setFocusable(true);
    }//GEN-LAST:event_btnMenosActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
       if(velocidadSimulacion != 10){
                    
                    velocidadSimulacion++;
                    try{
                    ClienteSemaforos.cambiarVelocidad(velocidadSimulacion);
                    ClienteVehiculos.cambiarVelocidad(velocidadSimulacion);
                    }catch(IOException ioe){}
                    txtVelocidad.setText(""+velocidadSimulacion);
                }
       
           this.requestFocus();
           this.setFocusable(true);
    }//GEN-LAST:event_btnMasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.requestFocus();
        this.setFocusable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnZoomMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomMenosActionPerformed
         if(Mapa_1.zoom>10){
            Mapa_1.zoom-=10;
            nivelZoom--;
           }
         
         
        this.requestFocus();
        this.setFocusable(true);
    }//GEN-LAST:event_btnZoomMenosActionPerformed

    private void btnZoomMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomMasActionPerformed
         Mapa_1.zoom+=10;
           nivelZoom++;
           
        this.requestFocus();
        this.setFocusable(true);
    }//GEN-LAST:event_btnZoomMasActionPerformed

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
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel PanelTrafico2;
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnZoomMas;
    private javax.swing.JButton btnZoomMenos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblCantSemaforos2;
    public static javax.swing.JLabel lblCantVehiculos2;
    public static javax.swing.JLabel lblTiempo;
    public static javax.swing.JLabel lblTotalSemaforos2;
    public static javax.swing.JLabel lblTotalVehiculos2;
    public static javax.swing.JLabel lblVPromedio;
    private javax.swing.JTextField txtVelocidad;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
          try{
                     p.actualizarSemaforos.start();
                     p.actualizarVehiculos.start();
                     p.actualizarPaint.start();
                     p.updateInformation.start();
        }catch(Exception e){}
          
         while(run){
        try{
              p.actualizarSemaforos.join();
              
              p.actualizarVehiculos.join();              
              
              p.actualizarPaint.join();
              
              p.updateInformation.join();
        }
        catch(Exception e){
              System.out.println("sleeping thread Error"); 
       }
   
   }  
    }
    
}
