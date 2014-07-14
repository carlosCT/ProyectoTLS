package inf.pucp.edu.pe.vista.simulacion;


import inf.pucp.edu.pe.algoritmoSimulacion.Simulacion;
import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.cliente.ClienteVehiculos;
import inf.pucp.edu.pe.modelo.Cruce;
import inf.pucp.edu.pe.modelo.Vehiculo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juancarlos
 */
public class Mapa extends javax.swing.JPanel {

    /**
     * Creates new form Mapa
     */
    public static int ancho=240000;
    public static int alto= 160000;
    
    public static int movHorizontal=0;
    public static int movVertical=0;
    public static int zoom=100;
    
    public int factor;
  
    
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    
    
      //estructura de semaforo y vehiculo   
    ArrayList<Cruce> listaCruces1 = new ArrayList<Cruce>();
                   
    ArrayList<Vehiculo> listaVehiculos= new ArrayList<Vehiculo>();
    
    public Mapa() {
        
        initComponents();
    }

    
    
    public void paint(Graphics g){
       // g.drawLine(50, 50, 400, 400);
      
         super.paint(g);
         int i;
         for(i=0; i<ancho; i=i+zoom){
            factor=i; 
            g.drawLine(i-movHorizontal, 0-movVertical, i-movHorizontal, alto-movVertical);//vertical
            g.drawLine(0-movHorizontal, i-movVertical, ancho-movHorizontal, i-movVertical);//horizontal
         }
         
            paintAll1Semaphore(g);
//          
          paintALlCar(g);
    }
      
      
    
    
    public void update(Graphics g){
       paint(g);
    }

        
        
        Thread actualizarSemaforos = new Thread(){
            
            public void run(){
                
                while(Simulador.run){
                    while(Simulador.seguir){
                        
                        try {
                            //                escala=400/factor;
                           listaCruces1 = ClienteSemaforos.solicitarCruces(Math.round(movHorizontal/zoom)*100, Math.round(movVertical/zoom)*100, Math.round(screenSize.width/zoom)*100+ Math.round(movHorizontal/zoom)*100, Math.round(screenSize.height/zoom)*100+ Math.round(movVertical/zoom)*100);
//                          
                            try {
                                Thread.sleep(333);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
           //                 int cant= listaCruces1.size()+listaCruces2.size()+listaCruces3.size()+listaCruces4.size()+listaCruces5.size()+listaCruces6.size()+listaCruces7.size()+listaCruces8.size()+listaCruces9.size()+listaCruces10.size()+listaCruces11.size()+listaCruces12.size()+listaCruces13.size()+listaCruces14.size()+listaCruces15.size()+listaCruces16.size();
             int cant=listaCruces1.size();
                           Simulador.lblCantSemaforos.setText("#SemaforosZona: "+cant);
                            //  System.out.println("cantidad de semaforos "+listaCruces.size());
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                }
            }
        };
        
        
          Thread actualizarVehiculos = new Thread(){
        public void run(){
            while(Simulador.run){
                while(Simulador.seguir){
                  //  escala=400/factor;
                    try {
                        listaVehiculos = ClienteVehiculos.solicitarVehiculos(Math.round(movHorizontal/zoom)*100, Math.round(movVertical/zoom)*100, Math.round(screenSize.width/zoom)*100+ Math.round(movHorizontal/zoom)*100, Math.round(screenSize.height/zoom)*100+ Math.round(movVertical/zoom)*100);
                    } catch (IOException ex) {
                        Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   Simulador.lblCantVehiculos.setText("#VehiculosZona: "+ listaVehiculos.size());
                         
                }
            }
        }
    };
          
          Thread updateInformation= new Thread(){
              public void run(){
                  while(Simulador.run){
                      while(Simulador.seguir){
                          
                          try{
                          /*INFORMACION DE TOTAL DE VEHICULOS*/
                            Simulador.lblTotalVehiculos.setText("TotalVehiculos: " + ClienteVehiculos.solicitarVehiculosCiudad());
                            
                          /*iNFORMACION DE TRAFICO*/
                            Simulador.lblVPromedio.setText("VPromedio: "+ ClienteVehiculos.solicitarVelocidadPromedio());
                            
                            /*INFORMACION DE TIEMPO DE SIMULACION*/
                                Simulador.lblTiempo.setText("Tiempo: " + ClienteVehiculos.solicitarTiempo() );
                            
                          }catch(IOException e){}
                          
                          nivelDeTrafico();
                      }
                  }
                  
              }
          };
          
          
         public void nivelDeTrafico(){
             try{
                 
                if(listaVehiculos.size()>0.01*Integer.parseInt(ClienteVehiculos.solicitarVehiculosCiudad())){
                    Simulador.panelTrafico1.setBackground(Color.red);
                }else{
                    Simulador.panelTrafico1.setBackground(Color.green);
                }
             
             }catch(IOException e){}
             
         } 
          
        Thread actualizarPaint= new Thread(){
            public void run(){
                while(Simulador.run){
                  repaint();
                }
            }
          
        };
    
   
//   
  
        
        
     private void paintAll1Semaphore(Graphics g) {
         try{
            for(int i=0; i<listaCruces1.size(); i++){
                if(1==listaCruces1.get(i).getEstadoLuz()){
                    g.setColor(Color.red);
                }
                else{
                    g.setColor(Color.green);
                }
               // System.out.println( "pos x: pos y:" +listaCruces.get(i).getPosX()+" : "+listaCruces.get(i).getPosY());
                paintSemaphore(g, listaCruces1.get(i));
            }
        }catch(Exception e){}
    }   
     
     
     
     
       public void paintSemaphore(Graphics g, Cruce semaforo){
           int offset=9;
           if (Simulador.nivelZoom==10){
           g.fillRect(semaforo.getPosX()-offset-movHorizontal,semaforo.getPosY()-movVertical-offset, 20, 20);
           }else if (Simulador.nivelZoom==9){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.9-offset+1-movHorizontal),(int)Math.round(semaforo.getPosY()*0.9-movVertical-offset+1), 18, 18);
           }else if (Simulador.nivelZoom==8){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.8-offset+2-movHorizontal),(int)Math.round(semaforo.getPosY()*0.8-movVertical-offset+2), 16, 16);
           }else if (Simulador.nivelZoom==7){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.7-offset+3-movHorizontal),(int)Math.round(semaforo.getPosY()*0.7-movVertical-offset+3), 14, 14);
           }else if (Simulador.nivelZoom==6){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.6-offset+4-movHorizontal),(int)Math.round(semaforo.getPosY()*0.6-movVertical-offset+4), 12, 12);
           }else if (Simulador.nivelZoom==5){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.5-offset+5-movHorizontal),(int)Math.round(semaforo.getPosY()*0.5-movVertical-offset+5), 10, 10);
           }else if (Simulador.nivelZoom==4){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.4-offset+6-movHorizontal),(int)Math.round(semaforo.getPosY()*0.4-movVertical-offset+6), 8, 8);
           }else if (Simulador.nivelZoom==3){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.3-offset+7-movHorizontal),(int)Math.round(semaforo.getPosY()*0.3-movVertical-offset+7), 6, 6);
           }else if (Simulador.nivelZoom==2){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.2-offset+8-movHorizontal),(int)Math.round(semaforo.getPosY()*0.2-movVertical-offset+8), 5, 5);
           }else if (Simulador.nivelZoom==1){
           g.fillRect((int)Math.round(semaforo.getPosX()*0.1-offset+9-movHorizontal),(int)Math.round(semaforo.getPosY()*0.1-movVertical-offset+9), 4, 4);
           }else if (Simulador.nivelZoom==11){
           g.fillRect((int)Math.round(semaforo.getPosX()*1.1-offset-1-movHorizontal),(int)Math.round(semaforo.getPosY()*1.1-movVertical-offset-1), 22, 22);
           }else if (Simulador.nivelZoom==12){
           g.fillRect((int)Math.round(semaforo.getPosX()*1.2-offset-2-movHorizontal),(int)Math.round(semaforo.getPosY()*1.2-movVertical-offset-2), 24, 24);
           }else if (Simulador.nivelZoom==13){
           g.fillRect((int)Math.round(semaforo.getPosX()*1.3-offset-3-movHorizontal),(int)Math.round(semaforo.getPosY()*1.3-movVertical-offset-3), 26, 26);
           }else if (Simulador.nivelZoom==14){
           g.fillRect((int)Math.round(semaforo.getPosX()*1.4-offset-4-movHorizontal),(int)Math.round(semaforo.getPosY()*1.4-movVertical-offset+4), 28, 28);
           }else if (Simulador.nivelZoom==15){
           g.fillRect((int)Math.round(semaforo.getPosX()*1.5-offset-5-movHorizontal),(int)Math.round(semaforo.getPosY()*1.5-movVertical-offset+5), 30, 30);
           }
       }
        
       
        private void paintALlCar(Graphics g){
        try{
            for(int i=0; i< listaVehiculos.size(); i++){
                paintCar(g, listaVehiculos.get(i));
            }
        }
        catch(Exception e){}
        }
        
       public void paintCar(Graphics g, Vehiculo vehi) {        
          int offset=9;
          g.setColor(Color.darkGray);
          
           if (Simulador.nivelZoom==10){
           g.fillRect(vehi.getPosX()-offset-movHorizontal,vehi.getPosY()-movVertical-offset, 20, 20);
           }else if (Simulador.nivelZoom==9){
           g.fillRect((int)Math.round(vehi.getPosX()*0.9-offset+1-movHorizontal),(int)Math.round(vehi.getPosY()*0.9-movVertical-offset+1), 18, 18);
           }else if (Simulador.nivelZoom==8){
           g.fillRect((int)Math.round(vehi.getPosX()*0.8-offset+2-movHorizontal),(int)Math.round(vehi.getPosY()*0.8-movVertical-offset+2), 16, 16);
           }else if (Simulador.nivelZoom==7){
           g.fillRect((int)Math.round(vehi.getPosX()*0.7-offset+3-movHorizontal),(int)Math.round(vehi.getPosY()*0.7-movVertical-offset+3), 14, 14);
           }else if (Simulador.nivelZoom==6){
           g.fillRect((int)Math.round(vehi.getPosX()*0.6-offset+4-movHorizontal),(int)Math.round(vehi.getPosY()*0.6-movVertical-offset+4), 12, 12);
           }else if (Simulador.nivelZoom==5){
           g.fillRect((int)Math.round(vehi.getPosX()*0.5-offset+5-movHorizontal),(int)Math.round(vehi.getPosY()*0.5-movVertical-offset+5), 10, 10);
           }else if (Simulador.nivelZoom==4){
           g.fillRect((int)Math.round(vehi.getPosX()*0.4-offset+6-movHorizontal),(int)Math.round(vehi.getPosY()*0.4-movVertical-offset+6), 8, 8);
           }else if (Simulador.nivelZoom==3){
           g.fillRect((int)Math.round(vehi.getPosX()*0.3-offset+7-movHorizontal),(int)Math.round(vehi.getPosY()*0.3-movVertical-offset+7), 6, 6);
           }else if (Simulador.nivelZoom==2){
           g.fillRect((int)Math.round(vehi.getPosX()*0.2-offset+8-movHorizontal),(int)Math.round(vehi.getPosY()*0.2-movVertical-offset+8), 5, 5);
           }else if (Simulador.nivelZoom==1){
           g.fillRect((int)Math.round(vehi.getPosX()*0.1-offset+9-movHorizontal),(int)Math.round(vehi.getPosY()*0.1-movVertical-offset+9), 4, 4);
           }else if (Simulador.nivelZoom==11){
           g.fillRect((int)Math.round(vehi.getPosX()*1.1-offset-1-movHorizontal),(int)Math.round(vehi.getPosY()*1.1-movVertical-offset-1), 22, 22);
           }else if (Simulador.nivelZoom==12){
           g.fillRect((int)Math.round(vehi.getPosX()*1.2-offset-2-movHorizontal),(int)Math.round(vehi.getPosY()*1.2-movVertical-offset-2), 24, 24);
           }else if (Simulador.nivelZoom==13){
           g.fillRect((int)Math.round(vehi.getPosX()*1.3-offset-3-movHorizontal),(int)Math.round(vehi.getPosY()*1.3-movVertical-offset-3), 26, 26);
           }else if (Simulador.nivelZoom==14){
           g.fillRect((int)Math.round(vehi.getPosX()*1.4-offset-4-movHorizontal),(int)Math.round(vehi.getPosY()*1.4-movVertical-offset+4), 28, 28);
           }else if (Simulador.nivelZoom==15){
           g.fillRect((int)Math.round(vehi.getPosX()*1.5-offset-5-movHorizontal),(int)Math.round(vehi.getPosY()*1.5-movVertical-offset+5), 30, 30);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
