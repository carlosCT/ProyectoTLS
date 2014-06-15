/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;

import inf.pucp.edu.pe.modelo.Vehiculo;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JInternalFrame;


/**
 *
 * @author juancarlos
 */
public class VentanaSimulacion extends JInternalFrame implements Runnable{
    public Panel p;
    public static boolean run = false;
    public static boolean seguir= false;
    Graphics g;
    
    
    public VentanaSimulacion(){
        
       setSize(MenuPrincipalSimulacion.ancho+MenuPrincipalSimulacion.defectoAncho, MenuPrincipalSimulacion.alto+MenuPrincipalSimulacion.defectoAlto);
       setTitle("Simulacion");
       setLocation(0, 63);
       setResizable(false);
       setVisible(true);
        //se agrega el panel principal
       p= new Panel();
       add(p);
        
    }
    

   
  public void moverVehiculos(){
     boolean estado=false; 
      for(int i=0; i<p.vehiculo.length; i++){
         if(p.vehiculo[i].getActualX()<p.vehiculo[i].getMeta()){
             //verificamos si se encuentra cerca de un semaforo y si esta en verde avansa
             estado= estaElCruceEnRojo(p.vehiculo[i]);
             if(estado==false && p.vehiculo[i].isDireccion()){//si la direccion es true se mueve por la horizontal
             p.vehiculo[i].setActualX(p.vehiculo[i].getActualX()+p.vehiculo[i].getVelocidad());        
             }

         }
         
     }
  }
  
  
  private boolean estaElCruceEnRojo(Vehiculo veh){//necesita mejorar
      boolean estado= false;
      for(int i=0; i<p.semaf.length; i++){
          if(p.semaf[i].getBounds().intersects(veh.getBounds())){
              //se cruza
              if(p.semaf[i].getEstadoLuz()==0){
                  estado=true;
                  break;
              }
              
          }
         
      }
      return estado;
  }
  

 
  public void run(){
   
   while(run){
       
        while(seguir){
        try{           
           /*determinamos por vehiculo si se encuentra en zona de cruce o semaforo*/
           /*verificamos que tipo de luz se tenga*/           
//           moverVehiculos();
//           p.repaint();
//           Thread.sleep(2000);
//           //cambiosDeEstadoSemaforo
//           p.definirEstados();
//           p.crearSemaforos();
             /*determinamos por vehiculo si se encuentra en zona de cruce o semaforo*/
           /*verificamos que tipo de luz se tenga*/           
           moverVehiculos();
            p.crearSemaforos();
            p.repaint();
        }
        catch(Exception e){
               System.out.println("sleeping thread Error");
        }
       }
   
   }
  }

       
}

