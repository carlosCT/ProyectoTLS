/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.algoritmoSimulacion;

import inf.pucp.edu.pe.algoritmoEntidades.Cruce;
import inf.pucp.edu.pe.algoritmoEntidades.Vehiculo;
import inf.pucp.edu.pe.algoritmoEntidades.Via;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Luis Espinzoa
 */
public class Simulacion {
    
    //<editor-fold desc="Atributos">
    
    public int mapaX = 600;     //Tamaño X: debe ser 240000
    public int mapaY = 600;     //Tamaño Y:debe ser 160000
    public int numCruces;
    
    public int numCrucesEnFila;
    public int numCrucesEnColumna;
    
    public int metrosCadaSemaforo = 100; //metros entre cada semaforo
    public int distCalle = 100;          //distancia de las calles  
    
    public ArrayList<Via> vias = new ArrayList<Via>();

    public ArrayList<Vehiculo> listaCarros = new ArrayList<Vehiculo>();
    
    public ArrayList<String> resultadoPorVehiculo = new ArrayList<String>();
    
    public Cruce[][] matrizCruces;
    
    public double vpromActual;
    public double vpromTotal;

    //</editor-fold>
    
    //<editor-fold desc="Main">
    public static void main(String[] args) {
        
         Simulacion simulacion = new Simulacion();
         simulacion.iniCrucesVias();
         
         
         
         /*
         simulacion.iniCrucesVias();
         try{
             
         simulacion.listaCarros = Vehiculo.leerInicioDestino("vehiculos.txt");
         
         }catch(Exception e){
             
             System.out.println(e.toString());
         }
         
         for(Vehiculo v : simulacion.listaCarros){
             
             v.imprimirDatosVehiculo();;
             
         }
         * 
         */
    }
    //</editor-fold>
    
    //<editor-fold desc="Metodo Inicializar Cruces y Vias">
    public void iniCrucesVias(){
        
        numCrucesEnFila = (mapaX/metrosCadaSemaforo)-1;
        numCrucesEnColumna = (mapaY/metrosCadaSemaforo)-1;
        
        numCruces = numCrucesEnFila * numCrucesEnColumna;
        matrizCruces = new Cruce[numCrucesEnColumna][numCrucesEnFila];
        
        
        this.generarCruces();
        this.generarVias();
        this.establecerCrucesaVias();
        this.imprimirMatrizCruces(this);
        
        
        //imprimirVias();
        
        
        
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Metodo Iniciar Simulacion">
    public static double iniciarSimulacion(Simulacion simulacion, ArrayList<Cruce> solucion){
        
        int iteraciones;
        double densidadPromedio;
        double velocidadPromedio;
        double velocidadPromedioTotal = 0;
        
        velocidadPromedio = 0;
        densidadPromedio = 0;
        
        
        try{
            
            simulacion.iniCrucesVias();
            simulacion.ingresarSolucionMapa(solucion);
            simulacion.listaCarros = Vehiculo.leerInicioDestino("vehiculos.txt");
            
            iteraciones = 1000; //1 iteracion = 1 segundo, 10 minutos
            
            for(int i =0; i < iteraciones; i++){
                
                //actualiza semaforos
                Cruce.actualizarTodosCruces(simulacion);
                
                //actualiza posicion de vehiculos
                Vehiculo.actualizarTodos(simulacion);
                
                //actualiza velocidades promedio
                
                velocidadPromedio = velocidadPromedio + simulacion.obtenerVelocidadPromedio();
                
                //Borrar vehiculos que llegaro na su destino
                
                simulacion.limpiarCarros(i);
                
                if(simulacion.listaCarros.isEmpty()) break;
                
            }
            
            velocidadPromedioTotal = velocidadPromedio/iteraciones;
            
            
        }catch(Exception e){
        
           System.out.println("Simulacion fallo: ocurrio una excepcion EN INICIARSIMULACION");
           System.out.println(e.toString());
            
        }finally{
           System.gc();
       }
        
        for(String s : simulacion.resultadoPorVehiculo){
            
            System.out.println(s);
            
        }
        
       return (velocidadPromedioTotal);
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Metodo Generar Vias">
    public void generarVias(){
        
        for(int j=this.metrosCadaSemaforo; j<mapaY - this.metrosCadaSemaforo; j=j+this.metrosCadaSemaforo){
            
            for(int i=this.metrosCadaSemaforo; i<mapaX - this.metrosCadaSemaforo; i=i+this.metrosCadaSemaforo){
                
                //Via Horizntal
                
                Via viaH = new Via();
                viaH.setPuntoXInicial(i);
                viaH.setPuntoXFinal(i+this.metrosCadaSemaforo);
                viaH.setPuntoYInicial(j);
                viaH.setPuntoYFinal(j);
                viaH.setVehVelNeg(new ArrayList<Vehiculo>());
                viaH.setVehVelPos(new ArrayList<Vehiculo>());
                
                if(j!=0 && j!=this.mapaY)
                    vias.add(viaH);
                
                //Via Vertical
                
                Via viaV = new Via();
                viaV.setPuntoXInicial(i);
                viaV.setPuntoXFinal(i);
                viaV.setPuntoYInicial(j);
                viaV.setPuntoYFinal(j+this.metrosCadaSemaforo);
                viaV.setVehVelNeg(new ArrayList<Vehiculo>());
                viaV.setVehVelPos(new ArrayList<Vehiculo>());
                
                if(i!=0 && j!=this.mapaX)    
                    vias.add(viaV);
                
            }
            
            
        }
        
        
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Metodo Establecer Cruces en Vias">
    public void establecerCrucesaVias(){
        
        for(Via v : this.vias){
            
            boolean seEncontroInicial = false; //cruces que se encontraron cuando sea 2 se saldra del metodo
            boolean seEncontroFinal = false;
            
            v.setCruceInicial(null);
            v.setCruceFinal(null);
            
            for(int i=0; i<this.numCrucesEnColumna; i++){
            
                for(int j=0; j<this.numCrucesEnFila; j++){
                    
                    if((this.matrizCruces[i][j].getPosX() == v.getPuntoXInicial()) 
                            &&(this.matrizCruces[i][j].getPosY() == v.getPuntoYInicial())){
                        
                        v.setCruceInicial(this.matrizCruces[i][j]);
                        seEncontroInicial = true;
                        if(seEncontroInicial && seEncontroFinal) break;
                    }
                    
                    if((this.matrizCruces[i][j].getPosX() == v.getPuntoXFinal()) 
                            &&(this.matrizCruces[i][j].getPosY() == v.getPuntoYFinal())){
                        
                        v.setCruceFinal(this.matrizCruces[i][j]);
                        seEncontroFinal = true;
                        if(seEncontroInicial && seEncontroFinal) break;
                    }
                    
                    if(seEncontroInicial && seEncontroFinal) break;

                }  
                
                if(seEncontroInicial && seEncontroFinal) break;
           
            }
        }
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Metodo Generar Cruces">
    public void generarCruces(){
        
        int x = 0;
        int y = 0;
        
        for(int i = this.metrosCadaSemaforo; i < mapaY; i = i + metrosCadaSemaforo){
            
            for(int j = this.metrosCadaSemaforo; j < mapaX; j = j + metrosCadaSemaforo){
                
                Cruce cruce = new Cruce();
                
                cruce.setPosX(i);
                cruce.setPosY(j);
                cruce.setEstadoLuz(0);
                cruce.setTiempoLuz(60);
                
                //listaCruces.add(cruce);
                
                matrizCruces[x][y] = cruce;
                y++;
                
                
            }
            y = 0;
            x++;
        }
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Metodo Imprimir matriz de cruces">
    public void imprimirMatrizCruces(Simulacion simulacion){
        
        int i = 0;
        int j = 0;
        
        System.out.println("Numero de cruces: " + simulacion.numCruces);
        
        for(i=0; i<simulacion.numCrucesEnColumna; i++){
            
            for(j=0; j<simulacion.numCrucesEnFila; j++){
                
                System.out.print(simulacion.matrizCruces[i][j].getPosX() +" "+ simulacion.matrizCruces[i][j].getPosY() +" | ");
               
            }            
            System.out.println();
           
        }
        
        
    }
    
    //</editor-fold>
    
    //<editor-fold desc=" Metodo obtener densidad en cada Cruce">
    public ArrayList<Integer> densidadCruces(){
        
        ArrayList<Integer> densidades = new ArrayList<Integer>();
        
        int i = 0;
        int j = 0;
        
       
        
        for(i=0; i<this.numCrucesEnColumna; i++){
            
            for(j=0; j<this.numCrucesEnFila; j++){
                
                int densidadCruce = 0;
                densidadCruce = this.matrizCruces[i][j].densidadEnRojo();
                densidades.add(densidadCruce);
               
            }    
        }
        
        return densidades;
        
    }
    
    //</editor-fold>
    
    public void ingresarSolucionMapa(ArrayList<Cruce> solucion){
        
        int k = 0;
        
        for(int i=0; i<this.numCrucesEnColumna; i++){
            
            for(int j=0; j<this.numCrucesEnFila; j++){
                
                    this.matrizCruces[i][j].setSeCambioTiempo(solucion.get(k).isSeCambioTiempo());
                    this.matrizCruces[i][j].setTiempoLuz(solucion.get(k).getTiempoLuz());
                    k++;
            }            
           
        }
        
    }
    
    public double obtenerVelocidadPromedio(){
        
        int carrosActivos;
        double vprom = 0;
        
        for(Vehiculo v: this.listaCarros){
            
            vprom = vprom + Math.abs(v.getVelActual());
            
        }
        
        vprom = vprom/this.listaCarros.size();
        
        return vprom;
    }
    
    public void imprimirVias(){
        
        for(Via v: this.vias){
            
            if(v.getCruceInicial() != null && v.getCruceFinal() != null ){
            
            System.out.println(v.getCruceInicial().getPosX() +" "+ v.getCruceInicial().getPosY()
                    +"| "+ v.getCruceFinal().getPosX() +" "+ v.getCruceFinal().getPosY());
            
            }
            
            if(v.getCruceFinal() ==  null || v.getCruceInicial() == null) System.out.println("NULL");
            
        }
        
        
    }
    
    public void limpiarCarros(int tiempo){
        
        ArrayList<Integer> identificador = new ArrayList<Integer>();
        int i = 0;
        
        if(this.listaCarros.size() > 0){
        
            for(Vehiculo v : this.listaCarros){

                if(v.getPosActualX() == v.getDestinoX() 
                        && v.getPosActualY() == v.getDestinoY()){

                    identificador.add(i);


                }

                i++;
            }

            int minuto = (int)(tiempo/60);
            int segundo = (int)(tiempo%60);
            

            for(Integer j : identificador){

                String resultado = new String();
                double vpromKM = (this.listaCarros.get(j.intValue()).velocidadPromedio)*3.6;
                
                resultado = "Vehiculo " + this.listaCarros.get(j.intValue()).id + 
                        ": Vprom = " + this.listaCarros.get(j.intValue()).velocidadPromedio+ "m/s = " + vpromKM + " km/h" ;
                resultadoPorVehiculo.add(resultado);
                System.out.println("Llego a su destino Vehiculo numero :" + 
                        this.listaCarros.get(j.intValue()).id + "Llego en tiempo: Minuto " + minuto + " Segundo" + segundo);
                this.listaCarros.remove(j.intValue());


            }
        
        
        }
        
    }
        
}     
        
        
        
    
    


