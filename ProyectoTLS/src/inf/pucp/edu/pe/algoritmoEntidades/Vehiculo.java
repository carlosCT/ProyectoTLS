/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.algoritmoEntidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import inf.pucp.edu.pe.algoritmoSimulacion.Simulacion;

/**
 *
 * @author Luis Espinoza
 */
public class Vehiculo {
    
    //<editor-fold desc="Atributos">
    public int id;
    
    private int posActualX;
    private int posActualY;
    private Date tiempoActual;
    
    private int posAnteriorX;
    private int posAnteriorY;
    private Date tiempoAnterior;
    private int direccion;          //0:horizontal, 1:vertical.
    
    private double velActual;

    private double velMaxima;
    private int destinoX;
    private int destinoY;
    
    private Via viaActual = null;
    private int indexVia;
    
    
    private int posInicialX;
    private int posInicialY;
    
    public double velocidadPromedio = 0;
    
    //</editor-fold>
        
    //<editor-fold desc="Métodos Get">
    
    public int getPosActualX() {
        return posActualX;
    }

    public int getPosActualY() {
        return posActualY;
    }

    public Date getTiempoActual() {
        return tiempoActual;
    }

    public int getPosAnteriorX() {
        return posAnteriorX;
    }

    public int getPosAnteriorY() {
        return posAnteriorY;
    }

    public Date getTiempoAnterior() {
        return tiempoAnterior;
    }

    public double getVelActual() {
        return velActual;
    }

    public int getDireccion() {
        return direccion;
    }

    public Via getViaActual() {
        return viaActual;
    }       

    public double getVelMaxima() {
        return velMaxima;
    }

    public int getDestinoX() {
        return destinoX;
    }

    public int getDestinoY() {
        return destinoY;
    }

    public int getIndexVia() {
        return indexVia;
    }

    public int getPosInicialX() {
        return posInicialX;
    }

    public int getPosInicialY() {
        return posInicialY;
    }
    //</editor-fold>
        
    //<editor-fold desc="Métodos Set">
    public void setPosActualX(int posActualX) {
        this.posActualX = posActualX;
    }

    public void setPosActualY(int posActualY) {
        this.posActualY = posActualY;
    }

    public void setTiempoActual(Date tiempoActual) {
        this.tiempoActual = tiempoActual;
    }

    public void setPosAnteriorX(int posAnteriorX) {
        this.posAnteriorX = posAnteriorX;
    }

    public void setPosAnteriorY(int posAnteriorY) {
        this.posAnteriorY = posAnteriorY;
    }

    public void setTiempoAnterior(Date tiempoAnterior) {
        this.tiempoAnterior = tiempoAnterior;
    }

    public void setVelActual(double velActual) {
        this.velActual = velActual;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void setViaActual(Via viaActual) {
        this.viaActual = viaActual;
    }

    public void setVelMaxima(double velMaxima) {
        this.velMaxima = velMaxima;
    }

    public void setDestinoX(int destinoX) {
        this.destinoX = destinoX;
    }

    public void setDestinoY(int destinoY) {
        this.destinoY = destinoY;
    }

    public void setIndexVia(int indexVia) {
        this.indexVia = indexVia;
    }

    public void setPosInicialX(int posInicialX) {
        this.posInicialX = posInicialX;
    }

    public void setPosInicialY(int posInicialY) {
        this.posInicialY = posInicialY;
    }
    
    
    
    
    
    //</editor-fold>
    
    //<editor-fold desc="Método Obtener Velocidad">
    
    public void obtenerVelocidad(){
        
       if(posActualX == posAnteriorX && posActualY == posAnteriorY){
           
           velActual = 0;
           
       }else if(posActualX != posAnteriorX){
           
           velActual = ((Math.abs(posActualX - posAnteriorX)/((int)(Math.abs(tiempoActual.getTime() - tiempoAnterior.getTime())))/1000));
           direccion = 0;
       
       }else if(posActualX != posAnteriorX){
           
           velActual = ((Math.abs(posActualY - posAnteriorY)/((int)(Math.abs(tiempoActual.getTime() - tiempoAnterior.getTime())))/1000));
           direccion = 0;       
          //Para que sea km/h: (velActual/1000)*60*60;
           
       }
        
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Método Actualizar">
    
    public void actualizar(Simulacion simulacion){
        
        Cruce cruceDestino; //Cruce al que se dirige el vehiculo
        
        this.establecerViaActual(simulacion);
        
        this.calcularVelocidadPromedio();
        
        if(this.posActualX == this.destinoX && this.posActualY == this.destinoY) return;
        
        //<editor-fold desc="si la via es null (no respeta cruces)">
        
        if(this.viaActual == null){
        
            if(direccion == 0){
                
                if(this.posActualX < this.destinoX){
                
                    this.posActualX += this.velActual; 
                    if(this.posActualX >= this.destinoX){
                        
                        this.posActualX = this.destinoX;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(this.posActualY > this.destinoY){
                            
                            if(this.velMaxima > 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualY < this.destinoY){
                                          
                            if(this.velMaxima < 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualY == this.destinoY){
                            
                            return;
                            
                        }
                    }
                    
                    
                }else if(this.posActualX > this.destinoX){
                    
                    this.posActualX += this.velActual;
                    
                    if(this.posActualX <= this.destinoX){
                        
                        this.posActualX = this.destinoX;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(this.posActualY > this.destinoY){
                            
                            if(this.velMaxima > 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualY < this.destinoY){
                                          
                            if(this.velMaxima < 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualY == this.destinoY){
                            
                            return;
                            
                        }                                                
                    }
                }
                
                
            }else{
                
                if(this.posActualY < this.destinoY){
                
                    this.posActualY += this.velActual; 
                    if(this.posActualY >= this.destinoY){
                        
                        this.posActualY = this.destinoY;
                        this.direccion = Math.abs(this.direccion - 1);
                                                
                    }
                    
                    
                }else if(this.posActualY > this.destinoY){
                    
                    this.posActualY -= this.velActual;
                    if(this.posActualY <= this.destinoY){
                        
                        this.posActualY = this.destinoY;
                        this.direccion = Math.abs(this.direccion - 1);
                                                
                    }
                }
            }
            
        //</editor-fold>    
            
        }else{ // Si la via no es null. Osea hay existencia de semaforo
            
            cruceDestino = this.obtenerCruceDestino();
            
            if(direccion == 0){
                
                if(this.posActualX < this.destinoX){
                
                    this.posActualX += this.velActual; 
                    
                    if(cruceDestino.getEstadoLuz()== 0){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.velActual = this.velMaxima;
                        
                    }
                    
                    if(cruceDestino.getEstadoLuz()== 1 && this.posActualX >= cruceDestino.getPosX()){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.posActualX = cruceDestino.getPosX() - 1;
                        this.velActual = 0;
                        return;                        
                        
                    }
                    
                    if(this.posActualX >= this.destinoX){
                        
                        this.posActualX = this.destinoX;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(this.posActualY > this.destinoY){
                            
                            if(this.velMaxima > 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualY < this.destinoY){
                                          
                            if(this.velMaxima < 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualY == this.destinoY){
                            
                            return;
                            
                        }
                    }
                    
                    
                }else if(this.posActualX > this.destinoX){
                    
                    if(cruceDestino.getEstadoLuz()== 0){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.velActual = this.velMaxima;
                        
                    }
                    
                    if(cruceDestino.getEstadoLuz()== 1 && this.posActualX <= cruceDestino.getPosX()){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.posActualX = cruceDestino.getPosX() + 1;
                        this.velActual = 0;
                        return;                        
                        
                    }
                    
                    this.posActualX += this.velActual;
                    
                    if(this.posActualX <= this.destinoX){
                        
                        this.posActualX = this.destinoX;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(this.posActualY > this.destinoY){
                            
                            if(this.velMaxima > 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualY < this.destinoY){
                                          
                            if(this.velMaxima < 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualY == this.destinoY){
                            
                            return;
                            
                        }                                                
                    }
                }
                
                
            }else{  //Direccion vertical
                
                
                if(this.posActualY < this.destinoY){
                
                    this.posActualY += this.velActual; 
                    
                    if(cruceDestino.getEstadoLuz()== 1){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.velActual = this.velMaxima;
                        
                    }
                    
                    if(cruceDestino.getEstadoLuz()== 0 && this.posActualY >= cruceDestino.getPosY()){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.posActualY = cruceDestino.getPosY() - 1;
                        this.velActual = 0;
                        return;                        
                        
                    }
                    
                    if(this.posActualY >= this.destinoY){
                        
                        this.posActualY = this.destinoY;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(this.posActualX > this.destinoX){
                            
                            if(this.velMaxima > 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualX < this.destinoX){
                                          
                            if(this.velMaxima < 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualX == this.destinoX){
                            
                            return;
                            
                        }
                    }
                    
                    
                }else if(this.posActualY > this.destinoY){
                    
                    if(cruceDestino.getEstadoLuz()== 1){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.velActual = this.velMaxima;
                        
                    }
                    
                    if(cruceDestino.getEstadoLuz()== 0 && this.posActualY <= cruceDestino.getPosY()){       //0 = horizontal verde, vertical rojo; 1 = horizontal rojo, vertical verde;
                        
                        this.posActualY = cruceDestino.getPosY() + 1;
                        this.velActual = 0;
                        return;                        
                        
                    }
                    
                    this.posActualY += this.velActual;
                    
                    if(this.posActualY <= this.destinoY){
                        
                        this.posActualY = this.destinoY;
                        this.direccion = Math.abs(this.direccion - 1);
                        
                        if(this.posActualX > this.destinoX){
                            
                            if(this.velMaxima > 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualX < this.destinoX){
                                          
                            if(this.velMaxima < 0) this.velMaxima = this.velMaxima *-1;
                            
                        }else if(this.posActualX == this.destinoX){
                            
                            return;
                            
                        }                                                
                    }
                }
                
            }
            
        }
    }
    
    //</editor-fold>
    
    //<editor-fold desc="Actualiza todos los vehiculos de una simulacion">
    public static void actualizarTodos(Simulacion simulacion){
        
        for(Vehiculo v : simulacion.listaCarros){
            
            v.actualizar(simulacion);
            
        }
        
        
    }
    //</editor-fold>
    
    //<editor-fold desc="Método establecer Via Actual">
    public void establecerViaActual(Simulacion simulacion){
        
        int i = 0;
        
        if(viaActual == null){
            
            for(Via element:simulacion.vias){
                
                if(element.getCruceInicial() != null && element.getCruceFinal() != null){
                
                if(direccion == 0){             //O:horizontal, 1:vertical.
                    
                    if(posActualY == element.getPuntoYInicial() && 
                            posActualX > element.getPuntoXInicial() && 
                            posActualX < element.getPuntoXFinal()){
                        
                        viaActual = element;
                        indexVia = i;
                        
                        if(velActual >0){
                        
                            element.getVehVelPos().add(this);
                        
                        }else{
                            
                            element.getVehVelNeg().add(this);
                            
                        }                      
                        
                    }
                    
                }else{
                    
                if(posActualX == element.getPuntoXInicial() && 
                            posActualY > element.getPuntoYInicial() && 
                            posActualY < element.getPuntoYFinal()){    
                    
                        viaActual = element;
                        indexVia = i;
                        
                        if(velActual >0){
                        
                            element.getVehVelPos().add(this);
                        
                        }else{
                            
                            element.getVehVelNeg().add(this);
                            
                        } 
                     }
                    
                }
            }
                i++;
                
            }
            
        
        }else{
              
            
            for(Via element:simulacion.vias){
                
                if(element.getCruceInicial() != null && element.getCruceFinal() != null){
                
                if(direccion == 0){             //O:horizontal, 1:vertical.
                    
                    if(posActualY == element.getPuntoYInicial() && 
                            posActualX > element.getPuntoXInicial() && 
                            posActualX < element.getPuntoXFinal()){
                        
                        viaActual = element;
                                                
                        if(velActual >0){
                            simulacion.vias.get(indexVia).getVehVelPos().remove(this);
                            simulacion.vias.get(indexVia).getVehVelNeg().remove(this);
                            element.getVehVelPos().add(this);
                            indexVia = i;
                        
                        }else{
                           
                            simulacion.vias.get(indexVia).getVehVelNeg().remove(this);
                            simulacion.vias.get(indexVia).getVehVelPos().remove(this);
                            element.getVehVelNeg().add(this);
                            indexVia = i;
                            
                        }
                        
                        break;
                        
                    }
                    
                }else{
                    
                     if(posActualX == element.getPuntoXInicial() && 
                            posActualY > element.getPuntoYInicial() && 
                            posActualY < element.getPuntoYFinal()){  
                        
                        viaActual = element;
                        
                        if(velActual >0){
                        
                            element.getVehVelPos().add(this);
                            simulacion.vias.get(indexVia).getVehVelPos().remove(this);
                            simulacion.vias.get(indexVia).getVehVelNeg().remove(this);
                            indexVia = i;
                        
                        }else{
                            
                            element.getVehVelNeg().add(this);
                            simulacion.vias.get(indexVia).getVehVelNeg().remove(this);
                            simulacion.vias.get(indexVia).getVehVelPos().remove(this);
                            indexVia = i;
                            
                        }
                        
                        break;
                     }
                    
                }
            }
                i++;
                
            }
        }
    }
    //</editor-fold>
    
    //<editor-fold desc="Metodo leer Posicion inicial y destino de cada vehiculo">
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
    
    public void imprimirDatosVehiculo(){
        
        System.out.println("Posicion (X,Y): " +"("+ this.posActualX +", "+ this.posActualY+")");
        
    }
    
    public Cruce obtenerCruceDestino(){
        
        Cruce cruceDestino;
        
        if(this.viaActual == null){
            
            return null;
            
        }else{
           
            if(this.velMaxima > 0){
                
                cruceDestino = this.viaActual.getCruceFinal();
                
            }else{
                
                cruceDestino = this.viaActual.getCruceInicial();
                
            }
           
        }
        
        return cruceDestino;
        
    }
    
    public void calcularVelocidadPromedio(){
        
        this.velocidadPromedio = ((this.velocidadPromedio + Math.abs(this.velActual))/2);
        
        
    }
}
