/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;

import inf.pucp.edu.pe.cliente.Cliente;
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
    
    public int factor =40;
    public int cantidadDeVehiculos=10;
    public int cantidadDeSemaforos=400;
    
    public int [] estado= new int[cantidadDeSemaforos];
    public int dimensionX=4;
    public int dimensionY=4;
    public Vehiculo [] vehiculo;
    public Semaforo [] semaf;
    
    
    
    Cuadra cuadra;
    
    public Panel() {           
        this.setSize(MenuPrincipalSimulacion.ancho, MenuPrincipalSimulacion.alto);
        /*INSTANCIAMOS LOS VEHICULOS*/   // vehiculo= new Vehiculo(100, 100,400, 1);
    //    definirEstados();
        crearVehiculos();
        crearSemaforos();
        
    }
    
    public void definirEstados(){
        for(int i=0; i<estado.length;i++){        
        estado[i]=(int)Math.round(Math.random());
        }
    }
    
    
    public void crearSemaforos() {
        
        ArrayList<Cruce> listaCruces = new ArrayList<Cruce>();
        
        try{
        listaCruces = Cliente.solicitarCruces(MenuPrincipalSimulacion.posicionRelativaX*10, MenuPrincipalSimulacion.posicionRelativaY*10,MenuPrincipalSimulacion.posicionRelativaX*10 + MenuPrincipalSimulacion.ancho*10, MenuPrincipalSimulacion.posicionRelativaY*10 + MenuPrincipalSimulacion.alto*10);
        Thread.sleep(333);
        }catch(IOException e){} catch (InterruptedException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        semaf= new Semaforo[listaCruces.size()];
        int count=0;
        int Xo=factor,Yo=factor; 
        
        for(Cruce c : listaCruces){
            
            
             semaf[count]= new Semaforo(c.getPosX()/10-MenuPrincipalSimulacion.posicionRelativaX, c.getPosY()/10-MenuPrincipalSimulacion.posicionRelativaY, c.getEstadoLuz());
             count++;
             
        }
        
        /*int k=0;
        while(k<4000){
            k++;
        }
        semaf= new Semaforo[cantidadDeSemaforos];
        int count=0;
        int Xo=factor,Yo=factor; 
        for(int i=0; i<MenuPrincipalSimulacion.alto/factor; i++){
            for(int j=0; j<MenuPrincipalSimulacion.ancho/factor; j++){            
                semaf[count]= new Semaforo(Xo, Yo, estado[count]);
                if(count>semaf.length)break;
                Xo+=factor;
                count++;
            }
            if(count>semaf.length)break;
            Yo+=factor;
            Xo=factor;
        }
        */
        
    }
    
    
    public void crearVehiculos(){
        int velocidad;
        vehiculo= new Vehiculo[cantidadDeVehiculos];
        int count=1;
        for(int i=0; i<vehiculo.length; i++){
            velocidad=(int)Math.round(Math.random()*30);
            
            vehiculo[i]= new Vehiculo(0, 40*count, 700, velocidad+1 , 5, 5, true);     //true es para horizontal      
            
//            else{
//            vehiculo[i]= new Vehiculo(40*i, 40*i, 800, 4, 5, 5, true);           
//            }
            if(count>15){
                count=0;
            }
            count++;
        }
    }
    
    //pintar el mapa
    
    public void paint(Graphics g){  
            dibujarZona(g);
            /*DIBUJAR SEMAFOROS*/
     //       dibujarSemaforos(g);
        /*************************************/
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
        int offset= 3; 
        g.fillRect(semaforo.getPosicionX()-offset, semaforo.getPosicionY()-offset, semaforo.getDimensionX(), semaforo.getDimensionY());
    }
    
    private void dibujarTodosLosVehiculos(Graphics g, Vehiculo [] vehi){
        for (Vehiculo vehi1 : vehi) {
            //verificacion de si alcanzo la meta
            
            dibujaVehiculo(g, vehi1);
        }
    }
    

    public void dibujaVehiculo(Graphics g, Vehiculo vehi) {
        
          g.drawImage(vehi.getImagen(), vehi.getActualX(), vehi.getActualY(), vehi.getDimensionX(), vehi.getDimensionY(), null);
          
    }
}
