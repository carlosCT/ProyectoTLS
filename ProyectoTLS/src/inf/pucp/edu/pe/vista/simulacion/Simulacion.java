/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;

import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.modelo.carro;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JComponent;

/**
 *
 * @author juancarlos
 */
public class Simulacion extends javax.swing.JInternalFrame implements Runnable{

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null; 
    
    
    public Panel p;
    public static boolean run = false;
    public static boolean seguir= false;
    public static int velocidadSimulacion= 1;
    Graphics g;
    Color claro = new Color(217, 228, 232);
    /**
     * Creates new form Simulacion
     */
    public Simulacion() {
       initComponents();
       ocultarBarraTitulo();
       setSize(MenuPrincipalSimulacion.ancho+MenuPrincipalSimulacion.defectoAncho+350, MenuPrincipalSimulacion.alto+MenuPrincipalSimulacion.defectoAlto);
      // setTitle("Simulacion");
       setLocation(0, 28);
       
       setVisible(true);
        //se agrega el panel principal
       this.setBackground(claro);
       
       
       p= new Panel();
       p.setBackground(claro);
       jPanel1.setBackground(claro);
       jPanel2.setBackground(claro);
       jPanel3.setBackground(claro);
       jPanel4.setBackground(claro);
       jPanel5.setBackground(claro);
       
       add(p);
       p.setVisible(true);
       
       jTextField1.setEditable(false);
       jTextField2.setEditable(false);
       
       lblCantidadSemaforos.setText("Cantidad de Semaforos: "+Panel.cantidadSemaforos);
       lblCantidadVehiculos.setText("Cantidad de Vehiculos: "+Panel.cantidadDeVehiculos );
    }

    
    public void ocultarBarraTitulo()
    { 
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        dimBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint(); 
    }
//   
//  public void moverVehiculos(){
//     byte estado=0; // esta en verde
//      for(int i=0; i<p.vehiculo.length; i++){
//         if(p.vehiculo[i].getActualX()<p.vehiculo[i].getMeta()){
//             //verificamos si se encuentra cerca de un semaforo y si esta en verde avansa
//             estado= estaElCruceEnRojo(p.vehiculo[i]); // 1 si esta en rojo
//             if(estado==0 &&  p.vehiculo[i].getDireccion()==0){//si la direccion es true se mueve por la horizontal
//             p.vehiculo[i].setActualX(p.vehiculo[i].getActualX()+p.vehiculo[i].getVelocidad());        
//             }
//
//         }
//         
//     }
//  }
  
  
  private byte estaElCruceEnRojo(carro veh){//necesita mejorar
      byte estado= 0; //esta en verde
      for(int i=0; i<p.semaf.length; i++){
          if(p.semaf[i].getBounds().intersects(veh.getBounds())){
              //se cruza
              if(p.semaf[i].getEstadoLuz()==1){
                  estado=1; //esta en rojo
                  break;
              }
              
          }
         
      }
      return estado;
  }
   
  public void actualizarInformacionDeSimulacion(){
           lblEscala.setText("Escala del Mapa 1: "+Panel.escala);
           lZona.setText("Zona:     "+ MenuPrincipalSimulacion.zonaActual);
           lPosicionX.setText("Posicion X en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaX*Panel.escala);
           lPosicionY.setText("Posicion Y en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaY*Panel.escala);
           
           lblCantidadSemaforos.setText("Cantidad de Semaforos: "+Panel.cantidadSemaforos);
           lblCantidadVehiculos.setText("Cantidad de Vehiculos: "+Panel.cantidadDeVehiculos );
  }
 
  public void run(){
   
   
   
   while(run){
       
        while(seguir){
        try{
           actualizarInformacionDeSimulacion();
           p.crearVehiculos();
           p.crearSemaforos();
           p.repaint();
           
        }
        catch(Exception e){
               System.out.println("sleeping thread Error");
        }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnUP = new javax.swing.JButton();
        btnLEFT = new javax.swing.JButton();
        btnDOWN = new javax.swing.JButton();
        btnRIGHT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblCantidadVehiculos = new javax.swing.JLabel();
        lblCantidadSemaforos = new javax.swing.JLabel();
        lPosicionY = new javax.swing.JLabel();
        lPosicionX = new javax.swing.JLabel();
        lZona = new javax.swing.JLabel();
        lblEscala = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAumentarVelocidad = new javax.swing.JButton();
        btnReducirVelocidad = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Controles de Cambio de Zona:"));
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLEFT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnRIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDOWN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLEFT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRIGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ir a la Zona: ")));

        jLabel1.setText("Zona :");

        jButton1.setText("ACEPTAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Información de la Zona:"));

        lblCantidadVehiculos.setText("Cantidad de Vehiculos: ");

        lblCantidadSemaforos.setText("Cantidad de Semaforos: ");

        lPosicionY.setText("Posicion Y en el Mapa :    0");

        lPosicionX.setText("Posicion X en el Mapa :    0");

        lZona.setText("Zona:     1 ");

        lblEscala.setText("Escala del Mapa: 1 : 20");

        jLabel3.setText("Velocidad Promedio: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCantidadVehiculos)
                    .addComponent(lblCantidadSemaforos)
                    .addComponent(lPosicionY)
                    .addComponent(lPosicionX)
                    .addComponent(lZona)
                    .addComponent(lblEscala)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEscala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lZona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPosicionX)
                .addGap(16, 16, 16)
                .addComponent(lPosicionY)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCantidadSemaforos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCantidadVehiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Velocidad de la Simulación: "));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnReducirVelocidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAumentarVelocidad))
                    .addComponent(jTextField2))
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAumentarVelocidad)
                    .addComponent(btnReducirVelocidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(277, 277, 277))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 789, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPActionPerformed
        if(MenuPrincipalSimulacion.posicionRelativaY>0){
                MenuPrincipalSimulacion.posicionRelativaY-=MenuPrincipalSimulacion.alto;
                MenuPrincipalSimulacion.zonaActual-=MenuPrincipalSimulacion.dimensionXMapa/(Panel.escala*MenuPrincipalSimulacion.ancho);
                }
                lZona.setText("Zona:     "+ MenuPrincipalSimulacion.zonaActual);
                lPosicionX.setText("Posicion X en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaX*Panel.escala);
                lPosicionY.setText("Posicion Y en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaY*Panel.escala);
    }//GEN-LAST:event_btnUPActionPerformed

    private void btnLEFTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLEFTActionPerformed
        if(MenuPrincipalSimulacion.posicionRelativaX>0){
                MenuPrincipalSimulacion.posicionRelativaX-=MenuPrincipalSimulacion.ancho;
                MenuPrincipalSimulacion.zonaActual-=1;
                }
                
                lZona.setText("Zona:     "+ MenuPrincipalSimulacion.zonaActual);
                lPosicionX.setText("Posicion X en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaX*Panel.escala);
                lPosicionY.setText("Posicion Y en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaY*Panel.escala);
    }//GEN-LAST:event_btnLEFTActionPerformed

    private void btnDOWNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDOWNActionPerformed
       if(MenuPrincipalSimulacion.posicionRelativaY<=6400){
                MenuPrincipalSimulacion.posicionRelativaY+=MenuPrincipalSimulacion.alto;
                MenuPrincipalSimulacion.zonaActual+=MenuPrincipalSimulacion.dimensionXMapa/(Panel.escala*MenuPrincipalSimulacion.ancho);
                }
                 
                lZona.setText("Zona:     "+ MenuPrincipalSimulacion.zonaActual);
                lPosicionX.setText("Posicion X en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaX*Panel.escala);
                lPosicionY.setText("Posicion Y en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaY*Panel.escala);
    }//GEN-LAST:event_btnDOWNActionPerformed

    private void btnRIGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRIGHTActionPerformed
          if(MenuPrincipalSimulacion.posicionRelativaX<=10000){
                MenuPrincipalSimulacion.posicionRelativaX+=MenuPrincipalSimulacion.ancho;
                MenuPrincipalSimulacion.zonaActual+=1;
                }
                
                lZona.setText("Zona:     "+ MenuPrincipalSimulacion.zonaActual);
                lPosicionX.setText("Posicion X en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaX*Panel.escala);
                lPosicionY.setText("Posicion Y en el Mapa:    "+ MenuPrincipalSimulacion.posicionRelativaY*Panel.escala);
    }//GEN-LAST:event_btnRIGHTActionPerformed

    private void btnReducirVelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirVelocidadActionPerformed
         
                if(velocidadSimulacion != 1){
                    
                    velocidadSimulacion--;
                    try{
                    ClienteSemaforos.cambiarVelocidad(velocidadSimulacion);
                    }catch(IOException ioe){}
                }
    }//GEN-LAST:event_btnReducirVelocidadActionPerformed

    private void btnAumentarVelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarVelocidadActionPerformed
                        
                if(velocidadSimulacion != 4){
                    
                    velocidadSimulacion++;
                    try{
                    ClienteSemaforos.cambiarVelocidad(velocidadSimulacion);
                    }catch(IOException ioe){}
                    
                }
    }//GEN-LAST:event_btnAumentarVelocidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAumentarVelocidad;
    private javax.swing.JButton btnDOWN;
    private javax.swing.JButton btnLEFT;
    private javax.swing.JButton btnRIGHT;
    private javax.swing.JButton btnReducirVelocidad;
    private javax.swing.JButton btnUP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lPosicionX;
    private javax.swing.JLabel lPosicionY;
    private javax.swing.JLabel lZona;
    private javax.swing.JLabel lblCantidadSemaforos;
    private javax.swing.JLabel lblCantidadVehiculos;
    private javax.swing.JLabel lblEscala;
    // End of variables declaration//GEN-END:variables
}
