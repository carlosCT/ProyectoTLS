/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.algoritmoGG;

import inf.pucp.edu.pe.algoritmoEntidades.Cruce;
import inf.pucp.edu.pe.algoritmoSimulacion.Simulacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author edesdo
 */
public class AlgoritmoGrasp {
    
    //<editor-fold desc="Atributos">
    
    private int numIteraciones;
    private double cRelajacion;

    //</editor-fold>
    
    //<editor-fold desc="Metodos Get">
    public int getNumIteraciones() {
        return numIteraciones;
    }
    
    public double getcRelajacion() {
        return cRelajacion;
    }
    //</editor-fold>
    
    //<editor-fold desc="Metodos Set">
    public void setcRelajacion(double cRelajacion) {
        this.cRelajacion = cRelajacion;
    }
    
    public void setNumIteraciones(int numIteraciones) {
        this.numIteraciones = numIteraciones;
    }
    //</editor-fold>    
    
    //<editor-fold desc="Iniciar Grasp">
    public ArrayList<Cruce> iniciarGrasp(Simulacion simulacion){
        
        numIteraciones = 10;
        cRelajacion = 0.5;
        
        ArrayList<Cruce> cruces = new ArrayList<Cruce>();
        
        for(int i=0; i<simulacion.numCrucesEnColumna; i++){
            
            for(int j=0; j<simulacion.numCrucesEnFila; j++){
                
               cruces.add(simulacion.matrizCruces[i][j]);
                
            }              
        }
        
        ArrayList<Cruce> solucionLocal;
        ArrayList<Cruce> solucionGlobal;
        
        //for(int i=0; i<numIteraciones; i++){
            
            solucionLocal = graspConstruccion(cruces, simulacion);
            System.out.println("Exito Construccion");
            
            solucionLocal = busquedaSolucionLocal(simulacion, solucionLocal);
            System.out.println("Exito optimizacion");
            
        //}
        
        
        System.out.println("exito " + cruces.size());
        
        
        
        
        return null;
    }
    //</editor-fold>
    
    //Por el momento solo esta devolviendo tiempos random para todos los semaforos. 
    //La relajacion sera usada mas adelante para determinar que semaforos se usaran.
    //Esto se determinara por medio de la densidad.
    //Falta inicializar densidad. Para ello sera necesario mas datos de vehiculos.
    
    //<editor-fold desc="Grasp Construccion">
    
    private ArrayList<Cruce> graspConstruccion(ArrayList<Cruce> cruces, Simulacion simulacion){
        
        int contador = 0;
        int condicionParada = cruces.size();
        
        //Se inicializa variable random para asignar los tiempos a los semaforos.
        Random randomNum = new Random();
        
        ArrayList<Cruce> solucion = new ArrayList<Cruce>();
        
        //Se genera una solucion inicial con tiempo de semaforo aleatorio;
        for(int i=0; i<cruces.size(); i++){
            
            Cruce cruce = new Cruce(); 
            cruce.setSeCambioTiempo(false);
            int tiempoCruce = randomNum.nextInt(120);
            cruce.setTiempoLuz(tiempoCruce);
            
            solucion.add(cruce);
            
        }
        
        /*
         
        while(contador != condicionParada){
                        
            ArrayList<Integer> candidatos = simulacion.densidadCruces();
            
            int valorMaximo = Integer.MIN_VALUE;
            int valorMinimo = Integer.MAX_VALUE;
            
            for(int i=0; i<candidatos.size(); i++){
                
                if(solucion.get(i).isSeCambioTiempo() == false){
                    if(candidatos.get(i)<valorMaximo) valorMaximo = candidatos.get(i);
                    if(candidatos.get(i)>valorMinimo) valorMinimo = candidatos.get(i);                               
                }
            }
            
            double limiteSuperior = valorMaximo;
            double limiteInferior = (valorMaximo - (this.getcRelajacion()*(valorMaximo-valorMinimo)));
            
            ArrayList<Integer> RCL = new ArrayList<Integer>();
            ArrayList<Integer> identificadorCandidatos = new ArrayList<Integer>();
            
            for(int i=0; i<candidatos.size();i++){
                
                if((candidatos.get(i) <= (int)limiteSuperior) && (candidatos.get(i) >= (int)limiteInferior)){
                    
                    identificadorCandidatos.add(i);
                    RCL.add(new Integer(candidatos.get(i)));                
                }    
            }
            
            int val = identificadorCandidatos.size();
            Collections.sort(RCL);
            
            
            if(val> 0){
                
                int seleccion = randomNum.nextInt(val);
                int elegido = RCL.get(seleccion);
                
                int cruceElegido = 0;
                
                for(int i=0; i<candidatos.size(); i++){
                    
                    if(Integer.compare(candidatos.get(i), elegido) == 0){
                        
                        cruceElegido=i;
                        break;
                    }
                }
                solucion.get(cruceElegido).setSeCambioTiempo(true);
            }
            
            contador++;
            
        }
        */
        
        return solucion;
        
    }
    
    //</editor-fold>  
    
    //<editor-fold desc="Busqueda de la solucion local">
    public ArrayList<Cruce> busquedaSolucionLocal(Simulacion simulacion, ArrayList<Cruce> solucionLocal){
        
        int contador = 0;
        
        ArrayList<Cruce> solucionGlobal = new ArrayList<Cruce>();
        
        for (int i=0;i<solucionLocal.size(); i++){
            
            solucionGlobal.add(new Cruce(solucionLocal.get(i)));
            
        }
        
        double actual = Simulacion.iniciarSimulacion(simulacion, solucionLocal);
        
        System.out.println("Velocidad promedio total de la ciudad: " + actual + " m/s = " + actual*3.6 + " km/h");
        
        return null;
    }
    
    
}
