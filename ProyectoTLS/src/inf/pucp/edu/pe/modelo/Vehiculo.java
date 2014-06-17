/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Vehiculo implements Serializable {
    
    //<editor-fold desc="Atributos">
    public String id;
    public int posX;
    public int posY;
    public int direccion;          //0:horizontal, 1:vertical.
    public double velActual;
    public double velMaxima;
    public double velocidadPromedio = 0;
    
    public ArrayList<Ruta> rutas;    
    
    //private int posAnteriorX;
    //private int posAnteriorY;
    //private Date tiempoAnterior; 
    //private Date tiempoActual;
    //private int destinoX;
    //private int destinoY;
    //private Via viaActual = null;
    //private int indexVia;
    //private int posInicialX;
    //private int posInicialY;
    //</editor-fold>
    
    public Vehiculo(String id,ArrayList<Ruta> rutas){
        this.id=id;        
        this.posX = rutas.get(0).ruta.get(0).x;        
        this.posY = rutas.get(0).ruta.get(0).y;
        this.velActual=0;
        this.velocidadPromedio=0.0;
        this.rutas = rutas;
        
    };
    
    //<editor-fold desc="Métodos Get">
    public String getId() {
        return id;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getDireccion() {
        return direccion;
    }

    public double getVelActual() {
        return velActual;
    }

    public double getVelMaxima() {
        return velMaxima;
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }
       
    //</editor-fold>
    
    //<editor-fold desc="Métodos Set">
    public void setId(String id) {
        this.id = id;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void setVelActual(double velActual) {
        this.velActual = velActual;
    }

    public void setVelMaxima(double velMaxima) {
        this.velMaxima = velMaxima;
    }

    public void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }  
        
    
    //</editor-fold>
    
    //<editor-fold desc="Método Obtener Velocidad Maxima segun el multiplo de la via">
    
    public void obtenerVelocidadMaxima(){
        
        int destinoX = rutas.get(0).getRuta().get(1).getX();
        int destinoY = rutas.get(0).getRuta().get(1).getY();  
        
        //Para movimiento horizontal
       if(this.direccion == 0){
           
           if(posY%4000 == 0){
               
               if(posX <= destinoX){
               
               this.velMaxima = 70 * 0.28;
               
               }else{
                   
                this.velMaxima = 70 * 0.28 * -1
                        ;   
               }
               
               return;                              
           }
           
           if(posY%2000 == 0){
               
               if(posX < destinoX){
               
               this.velMaxima = 60 * 0.28;
               
               }else{
                   
                this.velMaxima = 60 * 0.28 * -1
                        ;   
               }
               
               
               return;                              
           }
           
           if(posY%500 == 0) {
               
               if(posX < destinoX){
               
               this.velMaxima = 50 * 0.28;
               
               }else{
                   
                this.velMaxima = 50 * 0.28 *-1
                        ;   
               }
               
               return;
           }
           
           if(posX < destinoX){
               
                this.velMaxima = 40 * 0.28;
               
            }else{
                   
                this.velMaxima = 40 * 0.28 *-1;   
            }
           
       //Para movimiento vertical    
       }else{
           
           if(posX%4000 == 0){
               
               if(posY <= destinoY){
               
               this.velMaxima = 70 * 0.28;
               
               }else{
                   
                this.velMaxima = 70 * 0.28 * -1
                        ;   
               }
               
               return;                              
           }
           
           if(posX%2000 == 0){
               
               if(posY < destinoY){
               
               this.velMaxima = 60 * 0.28;
               
               }else{
                   
                this.velMaxima = 60 * 0.28 * -1
                        ;   
               }
               
               
               return;                              
           }
           
           if(posX%500 == 0) {
               
               if(posY < destinoY){
               
               this.velMaxima = 50 * 0.28;
               
               }else{
                   
                this.velMaxima = 50 * 0.28 *-1
                        ;   
               }
               
               return;
           }
           
           if(posY < destinoY){
               
                this.velMaxima = 40 * 0.28;
               
            }else{
                   
                this.velMaxima = 40 * 0.28 *-1;   
            }
           
       }
        
        
    }
    
    //</editor-fold>
    
    public void vehiculoLlegoDestino(){
        
        if(posX == rutas.get(0).getRuta().get(1).getX()){
            
            if(posY == rutas.get(0).getRuta().get(1).getY()){
                
                if(rutas.get(0).getRuta().size() == 2){
                    
                    rutas.remove(0);
                    return;
                    
                }else{
                    
                    rutas.get(0).getRuta().remove(0);
                    return;
                    
                }
                
            }
                        
        }
        
    }
    
    public void actualizar(int velocidadSimulacion){
        
        obtenerVelocidadMaxima();
        this.calcularVelocidadPromedio();
        vehiculoLlegoDestino();
        
        if(rutas.isEmpty()) return;     //BORRAR DEL ARREGLO EL VEHICULO
                
        int destinoX = rutas.get(0).getRuta().get(1).getX();
        int destinoY = rutas.get(0).getRuta().get(1).getY();        
        
        //<editor-fold desc="si la via es null (no respeta cruces)">
        boolean pasaSemaforo = true;
        
        //ESTA ES LA LLAMADA AL SERVIDOR DE CRUCES PARA VERIFICAR SI EL VEHICULO PUEDE AVANZAR.
        //pasaSemaforo = Cliente.consultarVehiculo(posX, posY, direccion, velMaxima);
        
        /*
            if(!puedeAvanzar){
                velActual = 0;
                return;
            }
            */
        
            if(direccion == 0){
                
                //Moviendo Derecha
                if(this.posX < destinoX){
                    
                    velActual = velMaxima;
                    int posSemaforoX = (((Math.round(posX/400) + 1) * 400));
                    this.posX += (this.velActual * velocidadSimulacion); 
                    
                    if(!pasaSemaforo && (posX >= posSemaforoX)){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.posX = posSemaforoX - 1;
                        this.velActual = 0;
                        return;      
                    
                    }  
                    
                    //Verificar Si ha llegado a su destino en X (o pasado)
                    if(this.posX >= destinoX){
                        
                        this.posX = destinoX;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(posY == destinoY){
                            
                            return;
                            
                        }
                    }
                    
                //Movimiento hacia la izquierda.    
                }else if(this.posX > destinoX){
                    
                    velActual = velMaxima;
                    int posSemaforoX = (((Math.round(posX/400)) * 400));
                    this.posX += (this.velActual * velocidadSimulacion); 
                    
                    if(!pasaSemaforo && (posX <= posSemaforoX)){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.posX = posSemaforoX + 1;
                        this.velActual = 0;
                        return;      
                    
                    }
                                         
                    
                    //Verificar Si ha llegado a su destino en X (o pasado)
                    if(this.posX <= destinoX){
                        
                        this.posX = destinoX;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(posY == destinoY){
                            
                            return;
                            
                        }
                    }
                }
                
                
            }else{  //Direccion vertical
                
                //Moviendo hacia Abajo
                if(this.posY < destinoY){
                    
                    velActual = velMaxima;
                    int posSemaforoY = (((Math.round(posY/400) + 1) * 400));
                    this.posY += (this.velActual * velocidadSimulacion); 
                    
                    if(!pasaSemaforo && (posY >= posSemaforoY)){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.posY = posSemaforoY - 1;
                        this.velActual = 0;
                        return;      
                    
                    }  
                    
                    //Verificar Si ha llegado a su destino en Y (o pasado)
                    if(this.posY >= destinoY){
                        
                        this.posY = destinoY;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(posX == destinoX){
                            
                            return;
                            
                        }
                    }
                    
                //Movimiento hacia Arriba   
                }else if(this.posY > destinoY){
                    
                    velActual = velMaxima;
                    int posSemaforoY = (((Math.round(posY/400)) * 400));
                    this.posY += (this.velActual * velocidadSimulacion); 
                    
                    if(!pasaSemaforo && (posY <= posSemaforoY)){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.posY = posSemaforoY + 1;
                        this.velActual = 0;
                        return;      
                    
                    }
                                         
                    
                    //Verificar Si ha llegado a su destino en X (o pasado)
                    if(this.posY <= destinoY){
                        
                        this.posY = destinoY;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(posX == destinoX){
                            
                            return;
                            
                        }
                    }
                }
            }
    }
    
    public void imprimirDatosVehiculo(){
        
        System.out.println("VEH"+ this.id +" Posicion (X,Y): " +"("+ this.posX +", "+ this.posY+")");
        
    }
    
    public void calcularVelocidadPromedio(){
        
        this.velocidadPromedio = ((this.velocidadPromedio + Math.abs(this.velActual))/2);
        
        
    }
    
    //Lo que hacia este metodo ahora debe ser enviado
    //<editor-fold desc="Metodo leer Posicion inicial y destino de cada vehiculo">
    /*
    public static ArrayList<Vehiculo> leerInicioDestino(String archivo) throws IOException, Exception{
        
        ArrayList<Vehiculo> vehiculos;
        Vehiculo veh;
        BufferedReader reader;
        String line;
        String []contenidoLinea;
        int x,y;
        
        vehiculos = new ArrayList<Vehiculo>();
        reader = null;
        line = null;
        
        try{
            
            reader = new BufferedReader(new FileReader(archivo));
            int k = 0;
            while((line=reader.readLine())!=null){
                
                veh = new Vehiculo();
                contenidoLinea = line.split("-");
                veh.setPosActualX(Integer.parseInt(contenidoLinea[0]));
                veh.setPosActualY(Integer.parseInt(contenidoLinea[1]));
                veh.setPosInicialX(Integer.parseInt(contenidoLinea[0]));
                veh.setPosInicialY(Integer.parseInt(contenidoLinea[1]));
                veh.setDestinoX(Integer.parseInt(contenidoLinea[2]));
                veh.setDestinoY(Integer.parseInt(contenidoLinea[3]));
                veh.setVelMaxima(11.11); //40km/h
                veh.setVelActual(11.11);
                veh.velocidadPromedio = 11.11;
                veh.id = k;
                
                if(veh.posActualX < veh.destinoX || veh.posActualX > veh.destinoX ) veh.direccion=0;
                else veh.direccion = 1;
                
                if(veh.direccion == 0){
                    
                    if(veh.posActualX > veh.destinoX){
                        veh.velActual = veh.velActual*-1;
                        veh.velMaxima = veh.velMaxima*-1;
                    }
                    
                }else{
                    
                    if(veh.posActualY > veh.destinoY){
                        veh.velActual = veh.velActual*-1;
                        veh.velMaxima = veh.velMaxima*-1;
                    }
                    
                }
                
                vehiculos.add(veh);
                k++;
            }
            
            
        }catch(IOException e){
            
            System.out.println("leerInicioDestino[0]: error de IO]");
            System.out.println("leerInicioDestino[1]: " + e.toString());
            throw  new IOException();
            
        }catch(Exception e){
            
            System.out.println("leerInicioDestino[0]: error inesperado");
            System.out.println("leerInicioDestino[1]: " + e.toString());
            throw  new Exception();
            
        }finally{
            
            if(reader!=null){
                reader.close();
            }
            
            line = null;
        }
        
        System.out.println("Numero de Vehiculos: " + vehiculos.size());
        
        return vehiculos;
    }
    
    //</editor-fold>
    */
    //</editor-fold>
    
}

