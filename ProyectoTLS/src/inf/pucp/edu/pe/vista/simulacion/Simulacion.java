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
       //jPanel1.setBackground(claro);
       jPanel2.setBackground(claro);
       
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
        btnUP = new javax.swing.JButton();
        btnLEFT = new javax.swing.JButton();
        btnDOWN = new javax.swing.JButton();
        btnRIGHT = new javax.swing.JButton();

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReducirVelocidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAumentarVelocidad)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAumentarVelocidad)
                    .addComponent(btnReducirVelocidad)
                    .addComponent(txtVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

        lPosicionX.setText("Posicion X en el Mapa :    0");

        lPosicionY.setText("Posicion Y en el Mapa :    0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lPosicionX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(lPosicionY)
                .addGap(50, 50, 50))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPosicionX)
                    .addComponent(lPosicionY))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));
        jPanel2.setToolTipText("");

        btnUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/up.png"))); // NOI18N
        btnUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPActionPerformed(evt);
            }
        });

        btnLEFT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/left.png"))); // NOI18N
        btnLEFT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLEFTActionPerformed(evt);
            }
        });

        btnDOWN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/down.png"))); // NOI18N
        btnDOWN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDOWNActionPerformed(evt);
            }
        });

        btnRIGHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/pucp/edu/pe/Iconos/right.png"))); // NOI18N
        btnRIGHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRIGHTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLEFT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnUP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnLEFT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(336, 336, 336))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 588, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPActionPerformed
        
          p.moveUp();      
                
    }//GEN-LAST:event_btnUPActionPerformed

    private void btnLEFTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLEFTActionPerformed
        p.moveLeft();
    }//GEN-LAST:event_btnLEFTActionPerformed

    private void btnDOWNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDOWNActionPerformed
       p.moveDown();
    }//GEN-LAST:event_btnDOWNActionPerformed

    private void btnRIGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRIGHTActionPerformed
          p.moveRight();
    }//GEN-LAST:event_btnRIGHTActionPerformed

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
    private javax.swing.JButton btnDOWN;
    private javax.swing.JButton btnLEFT;
    private javax.swing.JButton btnRIGHT;
    private javax.swing.JButton btnReducirVelocidad;
    private javax.swing.JButton btnUP;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JLabel lPosicionX;
    public static javax.swing.JLabel lPosicionY;
    private javax.swing.JTextField txtVelocidad;
    // End of variables declaration//GEN-END:variables
}
