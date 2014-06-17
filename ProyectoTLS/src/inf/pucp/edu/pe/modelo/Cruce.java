package inf.pucp.edu.pe.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    
    //</editor-fold>
    
    //<editor-fold desc="Método Establecer Via">    
    //metodo que establece las vias para un cruce. De esta forma se puede
    //saber que vias estan relacionadas a que cruce.
/**
 *
 * @author Luis Espinoza
 */
public class Cruce implements Serializable{
    
    //<editor-fold desc="Atributos">
    
    public Cruce(Cruce cruce){
        
        this.posX = cruce.posX;
        this.posY = cruce.posY;
        this.estadoLuz = cruce.estadoLuz;
        
        this.tiempoLuzVerde = cruce.tiempoLuzVerde;
        this.tiempoLuzRoja = cruce.tiempoLuzRoja;
        //this.viaDerecha = cruce.viaDerecha;
        //this.viaInferior = cruce.viaInferior;
        //this.viaIzquierda = cruce.viaIzquierda;
        //this.viaSuperior = cruce.viaSuperior;
        this.seCambioTiempo = cruce.seCambioTiempo;
        
    }
    
    public Cruce(){}      
    
    private int id;
    private int posX;
    private int posY;
    
    private int estadoLuz; // 0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
    private int tiempoLuzVerde; // tiempo en segundos de la luz verde. HORIZONTAL
    private int tiempoLuzRoja;  // tiempo en segundos de la luz roja. HORIZONTAL
    private boolean seCambioTiempo; 
    private int tiempoActual;
    
    //private Via viaSuperior = null;
    //private Via viaInferior = null;
    //private Via viaIzquierda = null;
    //private Via viaDerecha = null;
    
    
    //</editor-fold>
    
    //<editor-fold desc="Métodos get">
    
    
    public int getId() {
        return id;
    }
    
    public void setTiempoActual(int tiempoActual) {
        this.tiempoActual = tiempoActual;
    }

    public int getTiempoActual() {
        return tiempoActual;
    }
    
  
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getEstadoLuz() {
        return estadoLuz;
    }

    public int getTiempoLuzVerde() {
        return tiempoLuzVerde;
    }
    
    public int getTiempoLuzRoja() {
        return tiempoLuzRoja;
    }
/*
    public Via getViaSuperior() {
        return viaSuperior;
    }

    public Via getViaInferior() {
        return viaInferior;
    }

    public Via getViaIzquierda() {
        return viaIzquierda;
    }

    public Via getViaDerecha() {
        return viaDerecha;
    }
*/
    public boolean isSeCambioTiempo() {
        return seCambioTiempo;
    }
    
    
    
    //</editor-fold>
        
    //<editor-fold desc="Métodos Set">
          
    public void setId(int id) {
        this.id = id;
    }
        
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setEstadoLuz(int estadoLuz) {
        this.estadoLuz = estadoLuz;
    }

    public void setTiempoLuzVerde(int tiempoLuzVerde) {
        this.tiempoLuzVerde = tiempoLuzVerde;
    }
    
    public void setTiempoLuzRoja(int tiempoLuzRoja) {
        this.tiempoLuzRoja = tiempoLuzRoja;
    }
    
/*
    public void setViaSuperior(Via viaSuperior) {
        this.viaSuperior = viaSuperior;
    }

    public void setViaInferior(Via viaInferior) {
        this.viaInferior = viaInferior;
    }

    public void setViaIzquierda(Via viaIzquierda) {
        this.viaIzquierda = viaIzquierda;
    }

    public void setViaDerecha(Via viaDerecha) {
        this.viaDerecha = viaDerecha;
    }    
*/
    public void setSeCambioTiempo(boolean seCambioTiempo) {
        this.seCambioTiempo = seCambioTiempo;
    }
    
    //</editor-fold>
    
    
    
    public void actualizarCruce(int tiempoReducir){
        
        this.tiempoActual = this.tiempoActual - tiempoReducir;
        
        if(this.tiempoActual < 0 ){
            
            
           if(tiempoActual == -1){
               
               if(this.getEstadoLuz() == 0){
                this.tiempoActual = this.tiempoLuzRoja;
               }else{
                this.tiempoActual = this.tiempoLuzVerde;
               }
               
           }else{
               
               if(this.getEstadoLuz() == 0){
                    this.tiempoActual = this.tiempoLuzRoja + tiempoActual + 1;
               }else{
                   
                    this.tiempoActual = this.tiempoLuzVerde + tiempoActual + 1;
               }
           }
              
           this.estadoLuz = Math.abs(this.estadoLuz-1);
            
        }
    }
    
}

    
 
