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
public class Simulador extends javax.swing.JFrame implements KeyListener, Runnable{

    /**
     * Creates new form Simulador
     */
    public static boolean run=false;
    public static boolean seguir=false;
    private static int velocidadSimulacion=1;
    
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public Mapa p;
    public static int nivelZoom=10;
    public int velocidad=30;
    
  
    public Simulador() {
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
    
    public Mapa configMapa(){
        Mapa p= new Mapa();
        p.setLocation(0, 80);
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
            Mapa.movHorizontal+=velocidad;
           // System.out.println("se movio");
            
        } else if(valor==KeyEvent.VK_LEFT){
            Mapa.movHorizontal-=velocidad;
            //System.out.println("se movio");
          
        }else if(valor==KeyEvent.VK_UP){
            Mapa.movVertical-=velocidad;
           // System.out.println("se movio");
          
        }else if(valor==KeyEvent.VK_DOWN){
            Mapa.movVertical+=velocidad;
            //System.out.println("se movio");
    
            
            //ZOOM//
        }else if(valor==KeyEvent.VK_1){
           Mapa.zoom+=10;
           nivelZoom++;
            
        }else if(valor==KeyEvent.VK_2){
           if(Mapa.zoom>10){
            Mapa.zoom-=10;
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
        lblCantVehiculos = new javax.swing.JLabel();
        lblCantSemaforos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalVehiculos = new javax.swing.JLabel();
        lblTotalSemaforos1 = new javax.swing.JLabel();
        panelTrafico1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();
        btnMas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtVelocidad = new javax.swing.JTextField();
        btnNewWindows = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnZoomMenos = new javax.swing.JButton();
        btnZoomMas = new javax.swing.JButton();
        lblTiempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 30));

        lblVPromedio.setText("VPromedio: ");

        lblCantVehiculos.setText("#VehiculosZona: ");

        lblCantSemaforos.setText("#SemaforosZona:");

        jLabel4.setText("ZONA:");

        jLabel5.setText("MAPA:");

        lblTotalVehiculos.setText("TotalVehiculos: ");

        lblTotalSemaforos1.setText("TotalSemaforos:  239000");

        panelTrafico1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelTrafico1Layout = new javax.swing.GroupLayout(panelTrafico1);
        panelTrafico1.setLayout(panelTrafico1Layout);
        panelTrafico1Layout.setHorizontalGroup(
            panelTrafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        panelTrafico1Layout.setVerticalGroup(
            panelTrafico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblCantVehiculos)
                .addGap(77, 77, 77)
                .addComponent(lblCantSemaforos)
                .addGap(116, 116, 116)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lblVPromedio)
                .addGap(75, 75, 75)
                .addComponent(lblTotalVehiculos)
                .addGap(89, 89, 89)
                .addComponent(lblTotalSemaforos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTrafico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTrafico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVPromedio)
                        .addComponent(lblCantVehiculos)
                        .addComponent(lblCantSemaforos)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(lblTotalVehiculos)
                        .addComponent(lblTotalSemaforos1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnNewWindows.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/nuevaVentana1.png"))); // NOI18N
        btnNewWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewWindowsActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Zoom: ");

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

        lblTiempo.setText("Tiempo: ");

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
                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(lblTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNewWindows, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMas)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZoomMenos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZoomMas)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPause)
            .addComponent(btnStop)
            .addComponent(btnRestart)
            .addComponent(btnNewWindows)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnPlay)
                .addComponent(btnMenos)
                .addComponent(btnMas)
                .addComponent(jLabel2)
                .addComponent(txtVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(btnZoomMenos)
                .addComponent(btnZoomMas)
                .addComponent(lblTiempo))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
       Simulador.seguir=false;
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        Simulador.run = true;
        Simulador.seguir=true;
                
                try{
                ClienteVehiculos.actualizarVehiculos();
                ClienteSemaforos.actualizarCruces();
                }catch(IOException ex){}
                new Thread(this).start();
               
                
        this.requestFocus();
        this.setFocusable(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        Simulador.seguir=false;
        this.requestFocus();
        this.setFocusable(true);
        try{
            ClienteSemaforos.cambiarVelocidad(0);
            ClienteVehiculos.cambiarVelocidad(0);
            Simulador.velocidadSimulacion=0;
        }catch(IOException e){}
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
           Simulador.seguir=true;
           this.requestFocus();
           this.setFocusable(true);
        try{
            ClienteSemaforos.cambiarVelocidad(1);
            ClienteVehiculos.cambiarVelocidad(1);
            Simulador.velocidadSimulacion=1;
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
       if(velocidadSimulacion != 4){
                    
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

    private void btnNewWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewWindowsActionPerformed
       Simulador_1 simu= new Simulador_1();
       simu.setVisible(true);
       
        simu.requestFocus();
        simu.setFocusable(true);
    }//GEN-LAST:event_btnNewWindowsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.requestFocus();
        this.setFocusable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnZoomMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomMenosActionPerformed
         if(Mapa.zoom>10){
            Mapa.zoom-=10;
            nivelZoom--;
           }
         this.requestFocus();
        this.setFocusable(true);
    }//GEN-LAST:event_btnZoomMenosActionPerformed

    private void btnZoomMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomMasActionPerformed
        
        Mapa.zoom+=10;
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
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnNewWindows;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnZoomMas;
    private javax.swing.JButton btnZoomMenos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblCantSemaforos;
    public static javax.swing.JLabel lblCantVehiculos;
    public static javax.swing.JLabel lblTiempo;
    public static javax.swing.JLabel lblTotalSemaforos1;
    public static javax.swing.JLabel lblTotalVehiculos;
    public static javax.swing.JLabel lblVPromedio;
    public static javax.swing.JPanel panelTrafico1;
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
              
              p.updateInformation.start();
        }
        catch(Exception e){
              System.out.println("sleeping thread Error"); 
       }
   
   }  
    }
    
}
