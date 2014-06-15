/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;

import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.modelo.*;

import java.awt.Color;
import java.awt.Graphics;
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
    public static int factor =20;
    public static int cantidadSemaforos;
    public static int cantidadDeVehiculos=1000;
    public int dimensionX=4;
    public int dimensionY=4;
    public Vehiculo [] vehiculo;
    public Semaforo [] semaf;
    
    public byte eleccion=0;
    
    Cuadra cuadra;
    
    public Panel() {           
        this.setSize(MenuPrincipalSimulacion.ancho, MenuPrincipalSimulacion.alto);
        /*INSTANCIAMOS LOS VEHICULOS*/   // vehiculo= new Vehiculo(100, 100,400, 1);
    //    definirEstados();
        vehiculo= new Vehiculo[cantidadDeVehiculos];
        crearVehiculosHorizontales();
        crearVehiculosVerticales();
        crearSemaforos();
        
    }
    
    
    public void crearSemaforos() {
        
        ArrayList<Cruce> listaCruces = new ArrayList<Cruce>();
        
        try{
        listaCruces = ClienteSemaforos.solicitarCruces(MenuPrincipalSimulacion.posicionRelativaX*factor, MenuPrincipalSimulacion.posicionRelativaY*factor,MenuPrincipalSimulacion.posicionRelativaX*factor + MenuPrincipalSimulacion.ancho*factor, MenuPrincipalSimulacion.posicionRelativaY*factor + MenuPrincipalSimulacion.alto*factor);
        cantidadSemaforos=listaCruces.size();
        Thread.sleep(333);
        }catch(IOException e){} catch (InterruptedException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        semaf= new Semaforo[listaCruces.size()];
        int count=0;
        int Xo=factor,Yo=factor; 
        
        for(Cruce c : listaCruces){
            
            
             semaf[count]= new Semaforo(c.getPosX()/factor-MenuPrincipalSimulacion.posicionRelativaX, c.getPosY()/factor-MenuPrincipalSimulacion.posicionRelativaY, c.getEstadoLuz());
             count++;
             
        }
        
        
        
    }
    
    
    public void crearVehiculosHorizontales(){
        int velocidad;
        
        int count=1;
        for(int i=0; i<cantidadDeVehiculos/2; i++){
            velocidad=(int)Math.round(Math.random()*30);
            
            vehiculo[i]= new Vehiculo(0, Panel.factor*count, 900, velocidad+1 , 5, 5, 0);     //0 es para horizontal      
            
            if(count>30){
                count=0;
            }
            count++;
        }
    }
    
    public void crearVehiculosVerticales(){
        int velocidad;
        int count=1;
        for(int i=cantidadDeVehiculos/2; i<cantidadDeVehiculos; i++){
            velocidad=(int)Math.round(Math.random()*30);
            
            vehiculo[i]= new Vehiculo(Panel.factor*count,0, 800, velocidad+1 , 5, 5, 1);     //1 es para horizontal      
            
            if(count>20){
                count=0;
            }
            count++;
        }
    }
    
    public void paint(Graphics g){  
            dibujarZona(g);
            dibujarTodosLosSemaforos(g, semaf);
            dibujarTodosLosVehiculos(g, vehiculo);
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
                if(0==semaforo[i].getEstadoLuz()){
                g.setColor(Color.red);
                }
                else 
                g.setColor(Color.green);
                dibujaSemaforo(g, semaforo[i]);
            }
    }
        
        
    
    
    public void dibujaSemaforo(Graphics g, Semaforo semaforo){
        int offset= 1; 
        g.fillRect(semaforo.getPosicionX()-offset, semaforo.getPosicionY()-offset, semaforo.getDimensionX(), semaforo.getDimensionY());
    }
    
    private void dibujarTodosLosVehiculos(Graphics g, Vehiculo [] vehi){
        for (Vehiculo vehi1 : vehi) {
            //verificacion de si alcanzo la meta
            
            dibujaVehiculo(g, vehi1);
        }
    }
    

    public void dibujaVehiculo(Graphics g, Vehiculo vehi) {
        
         //g.drawImage(vehi.getImagen(), vehi.getActualX(), vehi.getActualY(), vehi.getDimensionX(), vehi.getDimensionY(), null);
        
          g.setColor(Color.blue);
          g.fillOval(vehi.getActualX(), vehi.getActualY(), 4, 4);
          
        
    }
}
