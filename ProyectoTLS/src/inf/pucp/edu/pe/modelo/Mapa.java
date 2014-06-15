/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

import inf.pucp.edu.pe.vista.simulacion.MenuPrincipalSimulacion;
import inf.pucp.edu.pe.vista.simulacion.MenuPrincipalSimulacion;
import java.awt.Graphics;


/**
 *
 * @author juancarlos
 */
public class Mapa {
    
    public Zona z= new Zona();
    public Semaforo s= new Semaforo();
    public int SXo, SYo;
    //semaforos
    public int separacionSemaforos=100;
    
    public Mapa() {
        
    }
    
    
    //generar zonas del mapa
    public Zona[] generarZonasMapa(int dimensionMapaX, int dimensionMapaY){
            //arreglo de zonas
            int Xo=0, Yo=0;
            int count=1;
            int cantidadZonas= (dimensionMapaX/MenuPrincipalSimulacion.ancho)*(dimensionMapaY/MenuPrincipalSimulacion.alto+1);
            Zona[] zona= new Zona[cantidadZonas];
            
            for(int i=1; i<=dimensionMapaY/MenuPrincipalSimulacion.alto; i++){
                for(int j=1; j<=dimensionMapaX/MenuPrincipalSimulacion.ancho; j++){
                    zona[count]= new Zona();
                    zona[count].setPosXInicial(Xo);
                    zona[count].setPosYInicial(Yo);
                    zona[count].setPosXFinal(Xo+MenuPrincipalSimulacion.ancho);
                    zona[count].setPosYFinal(Yo+MenuPrincipalSimulacion.alto); 
                 
                    
                    //contiene imagen, posX, posY, Ancho,Alto
                    //System.out.println(" x "+ zona[count].PosXInicial+"   y: " +zona[count].PosYInicial + "x final: "+ zona[count].posXFinal+ "y final: "+zona[count].posYFinal);
                    
                    //cantidad de zonas
                    count++;
                Xo+=MenuPrincipalSimulacion.ancho;
                }
                Yo+=MenuPrincipalSimulacion.alto;
                Xo=0;
            }
                 //System.out.println("Cantidad de zonas: "+count);
            return zona;
            
       
    }
    
    
    //generar semafros de la zona
    public Semaforo[] generarSemaforos(int posRelatX, int posRelatY, Zona zona){
        Graphics g=null;
        int i,j;
        SXo=100;
        SYo=100;
        int count=0;
        Semaforo[] semaforo= new Semaforo[MenuPrincipalSimulacion.ancho/separacionSemaforos*MenuPrincipalSimulacion.alto/separacionSemaforos+1];
        for(i=1; i<=MenuPrincipalSimulacion.ancho/separacionSemaforos;i++){
            for(j=1; i<=MenuPrincipalSimulacion.alto/separacionSemaforos;i++){
                semaforo[count]= new Semaforo();
                semaforo[count].setPosicionX(posRelatX+SXo);
                semaforo[count].setPosicionY(posRelatY+SYo);     
                SXo+=separacionSemaforos;
            }
            SYo+=separacionSemaforos;
            SXo=100;
        }
        return semaforo;
    }

    
}
