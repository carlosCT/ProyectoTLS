/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;

import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.cliente.ClienteVehiculos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.*;


/**
 *
 * @author juancarlos
 */
public class Simulacion extends JInternalFrame implements Runnable{

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null; 
    
    
    public Panel p;
    private static int indice=0;
    public static boolean run = false;
    public static boolean seguir= false;
    public static int velocidadSimulacion= 1;
    Graphics g;
    Color claro = new Color(217, 228, 232);
    
    public VariablesSimulacion vs2= new VariablesSimulacion(); 
    /**
     * Creates new form Simulacion
     */
    public Simulacion() {
       initComponents();
       this.setPreferredSize(new Dimension(1024, 768));
       ocultarBarraTitulo();
       setSize(MenuPrincipalSimulacion.ancho+MenuPrincipalSimulacion.defectoAncho+350, MenuPrincipalSimulacion.alto+MenuPrincipalSimulacion.defectoAlto+50);
      // setTitle("Simulacion");
       setLocation(0, 28);
       
       setVisible(true);
        //se agrega el panel principal
       this.setBackground(claro);
       
       //indice++;
       p= new Panel();
       p.setBackground(claro);
       jPanel1.setBackground(claro);
       jPanel2.setBackground(claro);
       jPanel3.setBackground(claro);
       jPanel6.setBackground(claro);
       jPanel5.setBackground(claro);
       
       add(p);
       p.setVisible(true);
       

       txtVelocidad.setEditable(false);
    
       txtVelocidad.setText(""+velocidadSimulacion);
    }

    
    public void ocultarBarraTitulo()
    { 
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        dimBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint(); 
    }
   
  
  
 
  
  
  
  
  public void iniciarSimulacion(){
      p.repaint();
      p.actualizarSemaforos.start();
      p.actualizarVehiculos.start();
      p.actualizarInformacion.start();
      p.actualizarPaint.start();
  }
  
  public void run(){
        try{
                     p.actualizarSemaforos.start();
                     p.actualizarVehiculos.start();
                     p.actualizarInformacion.start();
                     p.actualizarPaint.start();
        }catch(Exception e){}
              
      while(run){
        try{
              p.actualizarSemaforos.join();
              
              p.actualizarVehiculos.join();              
              
              p.actualizarInformacion.join();
        }
        catch(Exception e){
              System.out.println("sleeping thread Error"); 
       }
   
   }
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        txtVelocidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAumentarVelocidad = new javax.swing.JButton();
        btnReducirVelocidad = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lPosicionX = new javax.swing.JLabel();
        lPosicionY = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnUP2 = new javax.swing.JButton();
        btnLEFT2 = new javax.swing.JButton();
        btnDOWN2 = new javax.swing.JButton();
        btnRIGHT2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCantidadVehiculos = new javax.swing.JLabel();
        lblCantidadSemaforos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTiempoSimulacion = new javax.swing.JLabel();

        setPreferredSize(new Dimension(1024, 768)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(210, 65));

        jLabel4.setText("Velocidad: ");

        btnAumentarVelocidad.setText("+");
        btnAumentarVelocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarVelocidadActionPerformed(evt);
            }
        });

        btnReducirVelocidad.setText("-");
        btnReducirVelocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirVelocidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnReducirVelocidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAumentarVelocidad))
                    .addComponent(txtVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAumentarVelocidad)
                    .addComponent(btnReducirVelocidad)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 65));

        lPosicionX.setText("Posicion X en el Mapa :    0");

        lPosicionY.setText("Posicion Y en el Mapa :    0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lPosicionX)
                    .addComponent(lPosicionY))
                .addGap(0, 69, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lPosicionX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPosicionY)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(110, 65));

        btnUP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/up.png"))); // NOI18N
        btnUP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUP2ActionPerformed(evt);
            }
        });

        btnLEFT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/left.png"))); // NOI18N
        btnLEFT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLEFT2ActionPerformed(evt);
            }
        });

        btnDOWN2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/down.png"))); // NOI18N
        btnDOWN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDOWN2ActionPerformed(evt);
            }
        });

        btnRIGHT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/right.png"))); // NOI18N
        btnRIGHT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRIGHT2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLEFT2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUP2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDOWN2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRIGHT2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnUP2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRIGHT2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnLEFT2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDOWN2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCantidadVehiculos.setText("#Vehiculos:");

        lblCantidadSemaforos.setText("#Semaforos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCantidadVehiculos)
                    .addComponent(lblCantidadSemaforos))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCantidadSemaforos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCantidadVehiculos)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Tiempo: ");

        lblTiempoSimulacion.setText("00: 00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTiempoSimulacion)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTiempoSimulacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 782, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUP2ActionPerformed
        
          p.moveUp();      
                
    }//GEN-LAST:event_btnUP2ActionPerformed

    private void btnLEFT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLEFT2ActionPerformed
        p.moveLeft();
    }//GEN-LAST:event_btnLEFT2ActionPerformed

    private void btnDOWN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDOWN2ActionPerformed
       p.moveDown();
    }//GEN-LAST:event_btnDOWN2ActionPerformed

    private void btnRIGHT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRIGHT2ActionPerformed
          p.moveRight();
    }//GEN-LAST:event_btnRIGHT2ActionPerformed

    private void btnReducirVelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirVelocidadActionPerformed
         
                if(velocidadSimulacion != 1){
                    
                    velocidadSimulacion--;
                    try{
                    ClienteSemaforos.cambiarVelocidad(velocidadSimulacion);
                    ClienteVehiculos.cambiarVelocidad(velocidadSimulacion);
                    }catch(IOException ioe){}
                    txtVelocidad.setText(""+velocidadSimulacion);
                }
    }//GEN-LAST:event_btnReducirVelocidadActionPerformed

    private void btnAumentarVelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarVelocidadActionPerformed
                        
                if(velocidadSimulacion != 4){
                    
                    velocidadSimulacion++;
                    try{
                    ClienteSemaforos.cambiarVelocidad(velocidadSimulacion);
                    ClienteVehiculos.cambiarVelocidad(velocidadSimulacion);
                    }catch(IOException ioe){}
                    txtVelocidad.setText(""+velocidadSimulacion);
                }
    }//GEN-LAST:event_btnAumentarVelocidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAumentarVelocidad;
    private javax.swing.JButton btnDOWN2;
    private javax.swing.JButton btnLEFT2;
    private javax.swing.JButton btnRIGHT2;
    private javax.swing.JButton btnReducirVelocidad;
    private javax.swing.JButton btnUP2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JLabel lPosicionX;
    public static javax.swing.JLabel lPosicionY;
    public static javax.swing.JLabel lblCantidadSemaforos;
    public static javax.swing.JLabel lblCantidadVehiculos;
    private javax.swing.JLabel lblTiempoSimulacion;
    private javax.swing.JTextField txtVelocidad;
    // End of variables declaration//GEN-END:variables
}
