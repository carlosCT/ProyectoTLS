/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;

import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.cliente.ClienteVehiculos;
import inf.pucp.edu.pe.modelo.*;

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
public final class Panel extends JPanel{
    
    //Se manejara 3 escalas por defecto 1:1, 1:10, 1:20
    
    public static int escala=20;
    public static int factor =400/escala;
    
    public static int cantidadSemaforos;
    public static int cantidadDeVehiculos;
    public int dimensionX=4;
    public int dimensionY=4;
    
    //estructura de semaforo y vehiculo   
    ArrayList<Cruce> listaCruces = new ArrayList<Cruce>();
    ArrayList<Vehiculo> listaVehiculos= new ArrayList<Vehiculo>();
    
    public byte eleccion=0;
    
    Cuadra cuadra;
    
    public Panel() {           
        this.setSize(MenuPrincipalSimulacion.ancho, MenuPrincipalSimulacion.alto);
        //crearVehiculos();
        //crearSemaforos();
        
    }
    
    Thread actualizarSemaforos = new Thread(){
        
      public void run(){
        
        while(Simulacion.run){  
            while(Simulacion.seguir){  
                
                escala=400/factor;
                try{

                  listaCruces = ClienteSemaforos.solicitarCruces(MenuPrincipalSimulacion.posicionRelativaX*escala, MenuPrincipalSimulacion.posicionRelativaY*escala,MenuPrincipalSimulacion.posicionRelativaX*escala + MenuPrincipalSimulacion.ancho*escala, MenuPrincipalSimulacion.posicionRelativaY*escala + MenuPrincipalSimulacion.alto*escala);

                cantidadSemaforos=listaCruces.size();
                Thread.sleep(333);
                }catch(IOException e){} catch (InterruptedException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }  

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
                        listaVehiculos = ClienteVehiculos.solicitarVehiculos(MenuPrincipalSimulacion.posicionRelativaX*escala, MenuPrincipalSimulacion.posicionRelativaY*escala,MenuPrincipalSimulacion.posicionRelativaX*escala + MenuPrincipalSimulacion.ancho*escala, MenuPrincipalSimulacion.posicionRelativaY*escala + MenuPrincipalSimulacion.alto*escala);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cantidadDeVehiculos=listaVehiculos.size();                     
                         //carro[count]= new carro(Math.round(c.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX),Math.round(c.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY));                   
                }
            }
        }
        
    };
    
    
    public void paint(Graphics g){  
            dibujarZona(g);
            dibujarTodosLosSemaforos(g);
            //dibujarTodosLosVehiculos(g);
    }

    
    
    
    private void dibujarZona(Graphics g){
        /*dibujar la zona*/
        
        int Xo=0, Yo=0;
            /*DIBUJAR ZONA*/
            cuadra=  new Cuadra();
            for(int i=0; i<MenuPrincipalSimulacion.alto/factor; i++){

                for(int j=0; j<MenuPrincipalSimulacion.ancho/factor; j++){
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
            //Math.round(semaforo.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX),Math.round(semaforo.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY)
        g.fillRect(semaforo.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX-offset4, Math.round(semaforo.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY-offset4), 9, 9);
        }else
         if(factor==40){
        g.fillRect(semaforo.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX-offset10, Math.round(semaforo.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY-offset10), 6, 6);
        }else
          if(factor==20){
        g.fillRect(semaforo.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX-offset20, Math.round(semaforo.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY-offset20), 3, 3);
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
          g.fillOval(Math.round(vehi.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX),Math.round(vehi.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY), 7, 7);
        }else if(factor==40){
          g.setColor(Color.white);
          g.fillOval(Math.round(vehi.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX),Math.round(vehi.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY), 5, 5);
        }else if(factor==20){
          g.setColor(Color.white);
          g.fillOval(Math.round(vehi.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX),Math.round(vehi.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY), 3, 3);
        }        
    }
}
