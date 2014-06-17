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
    
    public static int escala=4;
    public static int factor =400/escala;
    
    public static int cantidadSemaforos;
    public static int cantidadDeVehiculos;
    public int dimensionX=4;
    public int dimensionY=4;
    public carro [] carro;
    
    public Semaforo [] semaf;
    
    public byte eleccion=0;
    
    Cuadra cuadra;
    
    public Panel() {           
        this.setSize(MenuPrincipalSimulacion.ancho, MenuPrincipalSimulacion.alto);
        crearVehiculos();
        //crearVehiculosVerticales();
        crearSemaforos();
        
    }
    
    
    public void crearSemaforos() {
        
        ArrayList<Cruce> listaCruces = new ArrayList<Cruce>();
        escala=400/factor;
        try{
                   
          listaCruces = ClienteSemaforos.solicitarCruces(MenuPrincipalSimulacion.posicionRelativaX*escala, MenuPrincipalSimulacion.posicionRelativaY*escala,MenuPrincipalSimulacion.posicionRelativaX*escala + MenuPrincipalSimulacion.ancho*escala, MenuPrincipalSimulacion.posicionRelativaY*escala + MenuPrincipalSimulacion.alto*escala);
          
        cantidadSemaforos=listaCruces.size();
        Thread.sleep(333);
        }catch(IOException e){} catch (InterruptedException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        semaf= new Semaforo[listaCruces.size()];
        int count=0;
        
        for(Cruce c : listaCruces){
            
            
             semaf[count]= new Semaforo(c.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX, c.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY, c.getEstadoLuz());
             count++;
             
        }
        
        
        
    }
    
    
    public void crearVehiculos(){
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        escala=400/factor;
        
                   
        try {
            listaVehiculos = ClienteVehiculos.solicitarVehiculos(MenuPrincipalSimulacion.posicionRelativaX*escala, MenuPrincipalSimulacion.posicionRelativaY*escala,MenuPrincipalSimulacion.posicionRelativaX*escala + MenuPrincipalSimulacion.ancho*escala, MenuPrincipalSimulacion.posicionRelativaY*escala + MenuPrincipalSimulacion.alto*escala);
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        cantidadDeVehiculos=listaVehiculos.size();
        
        
        carro= new carro[listaVehiculos.size()];
        int count=0;
        
        for(Vehiculo c: listaVehiculos){                        
             carro[count]= new carro(Math.round(c.getPosX()/escala-MenuPrincipalSimulacion.posicionRelativaX),Math.round(c.getPosY()/escala-MenuPrincipalSimulacion.posicionRelativaY));
             count++;             
        }               
    }

    
    public void paint(Graphics g){  
            dibujarZona(g);
            dibujarTodosLosSemaforos(g, semaf);
    //        dibujarTodosLosVehiculos(g, carro);
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
    
    
    private void dibujarTodosLosSemaforos(Graphics g, Semaforo [] semaforo) {
            for(int i=0;i<semaforo.length; i++){
                if(1==semaforo[i].getEstadoLuz()){
                g.setColor(Color.red);
                }
                else 
                g.setColor(Color.green);
                dibujaSemaforo(g, semaforo[i]);
            }
    }
        
        
    
    
    public void dibujaSemaforo(Graphics g, Semaforo semaforo){
        int offset20= 1, offset10=3, offset4=7; 
        if(factor==100){
        g.fillRect(semaforo.getPosicionX()-offset4, semaforo.getPosicionY()-offset4, 14, 14);
        }else
         if(factor==40){
        g.fillRect(semaforo.getPosicionX()-offset10, semaforo.getPosicionY()-offset10, 7, 7);
        }else
          if(factor==20){
        g.fillRect(semaforo.getPosicionX()-offset20, semaforo.getPosicionY()-offset20, 3, 3);
        }
    }
    
    private void dibujarTodosLosVehiculos(Graphics g, carro [] vehi){
        for (carro vehi1 : vehi) {
            //verificacion de si alcanzo la meta
            dibujaVehiculo(g, vehi1);
        }
    }
    

    public void dibujaVehiculo(Graphics g, carro vehi) {        
         //g.drawImage(vehi.getImagen(), vehi.getActualX(), vehi.getActualY(), vehi.getDimensionX(), vehi.getDimensionY(), null);
        if(factor==100){
          g.setColor(Color.WHITE);
          g.fillOval(vehi.getActualX(), vehi.getActualY(), 7, 7);
        }else if(factor==40){
          g.setColor(Color.white);
          g.fillOval(vehi.getActualX(), vehi.getActualY(), 5, 5);
        }else if(factor==20){
          g.setColor(Color.white);
          g.fillOval(vehi.getActualX(), vehi.getActualY(), 3, 3);
        }        
    }
}
