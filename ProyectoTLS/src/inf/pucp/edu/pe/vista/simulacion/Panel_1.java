/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;

import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.cliente.ClienteVehiculos;
import inf.pucp.edu.pe.modelo.*;
import static inf.pucp.edu.pe.vista.simulacion.Simulacion.lPosicionX;
import static inf.pucp.edu.pe.vista.simulacion.Simulacion.lPosicionY;
import static inf.pucp.edu.pe.vista.simulacion.Simulacion.run;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author juancarlos
 */
public final class Panel_1 extends JPanel{
    
    //Se manejara 3 escalas por defecto 1:1, 1:10, 1:20
    
    public static int escala=20;
    public static int factor =400/escala;
    
    public int dimensionX=4;
    public int dimensionY=4;
    
    //estructura de semaforo y vehiculo   
    ArrayList<Cruce> listaCruces = new ArrayList<Cruce>();
    ArrayList<Vehiculo> listaVehiculos= new ArrayList<Vehiculo>();
    
    public byte eleccion=0;
    public  VariablesSimulacion_1 vs;
    
    
    Cuadra cuadra;
    
    public Panel_1() {           
        this.setSize(MenuPrincipalSimulacion_1.ancho, MenuPrincipalSimulacion_1.alto);
        //crearVehiculos();
        //crearSemaforos();
       vs = new VariablesSimulacion_1();
        
        
    }
    
    Thread actualizarSemaforos = new Thread(){
        
      public void run(){
        
        while(Simulacion.run){  
            while(Simulacion.seguir){  
                
                escala=400/factor;
                try{

                  listaCruces = ClienteSemaforos.solicitarCruces(vs.getPosicionRelativaX()*escala, vs.getPosicionRelativaY()*escala,vs.getPosicionRelativaX()*escala + MenuPrincipalSimulacion_1.ancho*escala, vs.getPosicionRelativaY()*escala + MenuPrincipalSimulacion_1.alto*escala);

                  
                Thread.sleep(333);
                }catch(IOException e){} catch (InterruptedException ex) {
                    Logger.getLogger(Panel_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                vs.setCantidadSemaforos(listaCruces.size());

              }  
          }
      }
    };
    

    
    Thread actualizarVehiculos = new Thread(){
        public void run(){
            while(Simulacion.run){
                while(Simulacion.seguir){
                    escala=400/factor;
                    try {
                        listaVehiculos = ClienteVehiculos.solicitarVehiculos(vs.getPosicionRelativaX()*escala, vs.getPosicionRelativaY()*escala,vs.getPosicionRelativaX()*escala + MenuPrincipalSimulacion_1.ancho*escala, vs.getPosicionRelativaY()*escala + MenuPrincipalSimulacion_1.alto*escala);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    vs.setCantidadDeVehiculos(listaVehiculos.size());
                         
                }
            }
        }
    };
    
    Thread actualizarInformacion= new Thread(){
           
      public void run(){
          while(Simulacion.run){
               MenuPrincipalSimulacion_1.lblEscala1.setText("Escala del Mapa 1: "+Panel_1.escala);
            //    lZona.setText("Zona:     "+ MenuPrincipalSimulacion_1.zonaActual);
                Simulacion_1.lPosicionX2.setText("Posicion X en el Mapa:    "+ vs.getPosicionRelativaX()*Panel_1.escala);
                Simulacion_1.lPosicionY2.setText("Posicion Y en el Mapa:    "+ vs.getPosicionRelativaY()*Panel_1.escala);

                MenuPrincipalSimulacion_1.lblCantidadSemaforos1.setText("#Semaforos: "+vs.getCantidadSemaforos());
                MenuPrincipalSimulacion_1.lblCantidadVehiculos1.setText("#Vehiculos: "+vs.getCantidadDeVehiculos());    
          }
      } 
  };
    
    Thread actualizarPaint = new Thread(){
      public void run(){
          while(run){
            repaint();
          }
          
      }
  };

    public void moveUp(){
        int posY= vs.getPosicionRelativaY();
        int posX=vs.getPosicionRelativaX();
        if(posY>0){
                posY-=MenuPrincipalSimulacion_1.alto;
                MenuPrincipalSimulacion_1.zonaActual-=MenuPrincipalSimulacion_1.dimensionXMapa/(Panel_1.escala*MenuPrincipalSimulacion_1.ancho);
                }
              //  lZona.setText("Zona:     "+ MenuPrincipalSimulacion_1.zonaActual);
                Simulacion_1.lPosicionX2.setText("Posicion X en el Mapa:    "+ posX*Panel_1.escala);
                Simulacion_1.lPosicionY2.setText("Posicion Y en el Mapa:    "+ posY*Panel_1.escala);
                
                vs.setPosicionRelativaX(posX);
                vs.setPosicionRelativaY(posY);
    }
    
    public void moveLeft(){
        int posX= vs.getPosicionRelativaX();
        int posY= vs.getPosicionRelativaY();
        if(posX>0){
                posX-=MenuPrincipalSimulacion_1.ancho;
                MenuPrincipalSimulacion_1.zonaActual-=1;
                }
                
             //   lZona.setText("Zona:     "+ MenuPrincipalSimulacion_1.zonaActual);
                Simulacion_1.lPosicionX2.setText("Posicion X en el Mapa:    "+ posX*Panel_1.escala);
                Simulacion_1.lPosicionY2.setText("Posicion Y en el Mapa:    "+ posY*Panel_1.escala);
                
                vs.setPosicionRelativaX(posX);
                vs.setPosicionRelativaY(posY);
    }

    public void moveDown(){
        int posX=vs.getPosicionRelativaX();
        int posY= vs.getPosicionRelativaY();
        if(posY<=6400){
                posY+=MenuPrincipalSimulacion_1.alto;
                MenuPrincipalSimulacion_1.zonaActual+=MenuPrincipalSimulacion_1.dimensionXMapa/(Panel_1.escala*MenuPrincipalSimulacion_1.ancho);
                }
                 
             //   lZona.setText("Zona:     "+ MenuPrincipalSimulacion_1.zonaActual);
                Simulacion_1.lPosicionX2.setText("Posicion X en el Mapa:    "+ posX*Panel_1.escala);
                Simulacion_1.lPosicionY2.setText("Posicion Y en el Mapa:    "+ posY*Panel_1.escala);
               
        
            vs.setPosicionRelativaX(posX);
            vs.setPosicionRelativaY(posY);
    }
    
    public void moveRight(){
         int posX=vs.getPosicionRelativaX();
        int posY= vs.getPosicionRelativaY();
        if(posX<=10000){
                posX+=MenuPrincipalSimulacion_1.ancho;
                MenuPrincipalSimulacion_1.zonaActual+=1;
                }
                
           //     lZona.setText("Zona:     "+ MenuPrincipalSimulacion_1.zonaActual);
                Simulacion_1.lPosicionX2.setText("Posicion X en el Mapa:    "+ posX*Panel_1.escala);
                Simulacion_1.lPosicionY2.setText("Posicion Y en el Mapa:    "+ posY*Panel_1.escala);
          
        vs.setPosicionRelativaX(posX);
        vs.setPosicionRelativaY(posY);
        
    }
    
    public void paint(Graphics g){  
            dibujarZona(g);
            dibujarTodosLosSemaforos(g);
            dibujarTodosLosVehiculos(g);
    }

    
    
    
    private void dibujarZona(Graphics g){
        /*dibujar la zona*/
        
        int Xo=0, Yo=0;
            /*DIBUJAR ZONA*/
            cuadra=  new Cuadra();
            for(int i=0; i<MenuPrincipalSimulacion_1.alto/factor; i++){

                for(int j=0; j<MenuPrincipalSimulacion_1.ancho/factor; j++){
                    //contiene imagen, posX, posY, Ancho,Alto
                    g.drawImage(cuadra.getCuadra(), Xo, Yo,factor,factor,null);
 
                    Xo+=factor;
                }
                Yo+=factor;
                Xo=0;
                
            }
    }
    
    
    private void dibujarTodosLosSemaforos(Graphics g) {
        try{
            for(int i=0; i<listaCruces.size(); i++){
                if(1==listaCruces.get(i).getEstadoLuz()){
                    g.setColor(Color.red);
                }
                else{
                    g.setColor(Color.green);
                }
               // System.out.println( "pos x: pos y:" +listaCruces.get(i).getPosX()+" : "+listaCruces.get(i).getPosY());
            dibujaSemaforo(g, listaCruces.get(i));
            }
        }catch(Exception e){}
    }
        
        
    
    
    public void dibujaSemaforo(Graphics g, Cruce semaforo){
        int offset20= 1, offset10=3, offset4=7; 
        if(factor==100){
            //Math.round(semaforo.getPosX()/escala-MenuPrincipalSimulacion_1.posicionRelativaX),Math.round(semaforo.getPosY()/escala-MenuPrincipalSimulacion_1.posicionRelativaY)
        g.fillRect(semaforo.getPosX()/escala-vs.getPosicionRelativaX()-offset4, Math.round(semaforo.getPosY()/escala-vs.getPosicionRelativaY()-offset4), 9, 9);
        }else
         if(factor==40){
        g.fillRect(semaforo.getPosX()/escala-vs.getPosicionRelativaX()-offset10, Math.round(semaforo.getPosY()/escala-vs.getPosicionRelativaY()-offset10), 6, 6);
        }else
          if(factor==20){
        g.fillRect(semaforo.getPosX()/escala-vs.getPosicionRelativaX()-offset20, Math.round(semaforo.getPosY()/escala-vs.getPosicionRelativaY()-offset20), 3, 3);
        }
    }
    
    private void dibujarTodosLosVehiculos(Graphics g){
        try{
            for(int i=0; i< listaVehiculos.size(); i++){
                dibujaVehiculo(g, listaVehiculos.get(i));
            }
        }
        catch(Exception e){}
    }
    

    public void dibujaVehiculo(Graphics g, Vehiculo vehi) {        
        if(factor==100){
          g.setColor(Color.WHITE);
          g.fillOval(Math.round(vehi.getPosX()/escala-vs.getPosicionRelativaX()),Math.round(vehi.getPosY()/escala-vs.getPosicionRelativaY()), 7, 7);
        }else if(factor==40){
          g.setColor(Color.white);
          g.fillOval(Math.round(vehi.getPosX()/escala-vs.getPosicionRelativaX()),Math.round(vehi.getPosY()/escala-vs.getPosicionRelativaY()), 5, 5);
        }else if(factor==20){
          g.setColor(Color.white);
          g.fillOval(Math.round(vehi.getPosX()/escala-vs.getPosicionRelativaX()),Math.round(vehi.getPosY()/escala-vs.getPosicionRelativaY()), 3, 3);
        }        
    }
}
