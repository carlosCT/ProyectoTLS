package inf.pucp.edu.pe.algoritmoEntidades;

import java.util.ArrayList;
import inf.pucp.edu.pe.algoritmoSimulacion.Simulacion;

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
public class Cruce {
    
    //<editor-fold desc="Atributos">
    
    public Cruce(Cruce cruce){
        
        this.posX = cruce.posX;
        this.posY = cruce.posY;
        this.estadoLuz = cruce.estadoLuz;
        
        this.tiempoLuz = cruce.tiempoLuz;
        this.viaDerecha = cruce.viaDerecha;
        this.viaInferior = cruce.viaInferior;
        this.viaIzquierda = cruce.viaIzquierda;
        this.viaSuperior = cruce.viaSuperior;
        this.seCambioTiempo = cruce.seCambioTiempo;
        
    }
    
    public Cruce(){}      
    
    
    private int posX;
    private int posY;
    
    private int estadoLuz; // 0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
    private int tiempoLuz; // tiempo en segundos de la luz.
    private boolean seCambioTiempo; 
    private int tiempoActual;
    
    private Via viaSuperior = null;
    private Via viaInferior = null;
    private Via viaIzquierda = null;
    private Via viaDerecha = null;
    
    
    //</editor-fold>
    
    //<editor-fold desc="Métodos get">
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

    public int getTiempoLuz() {
        return tiempoLuz;
    }

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

    public boolean isSeCambioTiempo() {
        return seCambioTiempo;
    }
    
    
    
    //</editor-fold>
        
    //<editor-fold desc="Métodos Set">
    
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setEstadoLuz(int estadoLuz) {
        this.estadoLuz = estadoLuz;
    }

    public void setTiempoLuz(int tiempoLuz) {
        this.tiempoLuz = tiempoLuz;
    }

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

    public void setSeCambioTiempo(boolean seCambioTiempo) {
        this.seCambioTiempo = seCambioTiempo;
    }
    
    //</editor-fold>
    
    
    
    public void actualizarCruce(){
        
        this.tiempoActual--;
        
        if(this.tiempoActual < 0){
            
           this.tiempoActual = this.tiempoLuz;
           this.estadoLuz = Math.abs(this.estadoLuz-1);
            
        }
    }    
    
    public static void actualizarTodosCruces(Simulacion simulacion){
                
        for(int i=0; i<simulacion.numCrucesEnColumna; i++){
            
            for(int j=0; j<simulacion.numCrucesEnFila; j++){
                
                    simulacion.matrizCruces[i][j].actualizarCruce();
            }            
           
        }
        
    }
    
    public void establecerVias(ArrayList<Via> Vias){
        
        int n = 0;
        
        for(Via element: Vias){
            
            if(element.getPuntoXFinal() == this.posX && element.getPuntoYFinal() == this.posY){
                
                if(this.posX == element.getPuntoXInicial()){
                    
                    this.viaSuperior = element;
                    n++;
                    
                }else{
                    
                    this.viaIzquierda = element;
                    n++;
                    
                }                
            }
            
            if(element.getPuntoXInicial() == this.posX && element.getPuntoYInicial() == this.posY){
                
                if(this.posX == element.getPuntoXFinal()){
                    
                    this.viaInferior = element;
                    n++;
                    
                }else{
                    
                    this.viaDerecha = element;
                    n++;
                    
                }                
            }
            
            if(n == 3) break;
            
        }
        
    }
    
    
    private int densidadVertical(){
     
        int densidad = 0;
        
       if(this.viaSuperior == null && this.viaInferior != null){
           
           densidad = this.viaInferior.getVehVelNeg().size();
           
       } else if(this.viaSuperior != null && this.viaInferior == null){
           
           densidad = this.viaSuperior.getVehVelPos().size();
           
       }else if(this.viaSuperior != null && this.viaInferior != null) {
        densidad = this.viaSuperior.getVehVelPos().size() + this.viaInferior.getVehVelNeg().size();
       }
       
       return densidad;        
    }
        
    private int densidadHorizontal(){
     
       
       int densidad = 0;
        
       if(this.viaDerecha == null && this.viaIzquierda != null){
           
           densidad = this.viaIzquierda.getVehVelPos().size();
           
       } else if(this.viaDerecha != null && this.viaIzquierda == null){
           
           densidad = this.viaDerecha.getVehVelNeg().size();
           
       }
        
       if(this.viaDerecha != null && this.viaIzquierda != null) {
        densidad = this.viaDerecha.getVehVelNeg().size() + this.viaInferior.getVehVelPos().size();
       }
       
       return densidad;  
        
       
    }
    
    
    //Metodo que devuelve la cantidad de carros acumulados en los semaforos
    //rojos de lcruce.
    
    // 0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
    
    public int densidadEnRojo(){
        
        int densidad = 0;
        
        if(this.estadoLuz == 0){
            
            densidad = this.densidadVertical();
            
        }else if(this.estadoLuz == 1){
            
            densidad = this.densidadHorizontal();
            
        }
        
        return densidad;
    }
    
    
    
     
}
