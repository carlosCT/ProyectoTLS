/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.cliente;


import inf.pucp.edu.pe.modelo.Cruce;
import java.io.*;
import java.net.*;
import java.util.ArrayList;


/**
 *
 * @author fatima
 */
public class ClienteSemaforos {

   public static String ipS = "";
   public static int puertoSemaforo=0;
    
    public ClienteSemaforos(){
        
    }
    
    private static BufferedReader stdin1=new BufferedReader(new InputStreamReader(System.in));
    private static BufferedReader stdin2=new BufferedReader(new InputStreamReader(System.in));
    
    public static ArrayList<Cruce> solicitarCruces(int xi, int yi, int xf, int yf) throws IOException{
    
        String IP_SERVIDOR= ipS;
        //String IP_SERVIDOR="127.0.0.1";
        int PUERTO_SERVIDOR=puertoSemaforo;
        String lista[];
        ArrayList<Cruce> listaCruces = new ArrayList<Cruce>();
                      
        
            try{
                
                String valor="cc " + xi +" " + yi + " " + xf + " " + yf;
                //String valor= "cc 0 0 8000 8000";
                lista = valor.split(" ");
                                                                
                listaCruces = pedirCruces(IP_SERVIDOR, PUERTO_SERVIDOR, valor);
                System.out.println("Numero de cruces: " + listaCruces.size());
                
//                for(Cruce c : listaCruces){
//                    
//                    System.out.println("Pos x: " + c.getPosX() + " Pos y: " + c.getPosY() + " Estado: " + c.getEstadoLuz());
//                }
                
            }catch(Exception e){
                System.err.println(e);
            }
            
            System.out.print("Fin Cliente");
        
        return listaCruces;
    }
    
    public static void inicializarCruces() throws IOException{
    
        String IP_SERVIDOR=ipS;
        int PUERTO_SERVIDOR=puertoSemaforo;
        String lista[];
        String resultado = null;
        
            try{
                
                String valor="ini";                                                               
                resultado = realizar_operacion(IP_SERVIDOR, PUERTO_SERVIDOR, valor);
                
                
//                for(Cruce c : listaCruces){
//                    
//                    System.out.println("Pos x: " + c.getPosX() + " Pos y: " + c.getPosY() + " Estado: " + c.getEstadoLuz());
//                }
                
            }catch(Exception e){
                System.err.println(e);
            }
            
            System.out.print("Fin Cliente");
            
    }
    
    public static void actualizarCruces() throws IOException{
    
        String IP_SERVIDOR=ipS;
        int PUERTO_SERVIDOR=puertoSemaforo;
        String lista[];
        String resultado = null;
        
            try{
                
                String valor="actualizar";                                                               
                actualizar(IP_SERVIDOR, PUERTO_SERVIDOR, valor);
                
            }catch(Exception e){
                System.err.println(e);
            }
            
            System.out.print("Fin Cliente");
            
    }
    
    public static void cambiarVelocidad(int velocidad) throws IOException{
    
        String IP_SERVIDOR=ipS;
        int PUERTO_SERVIDOR=puertoSemaforo;
        String lista[];
        String resultado = null;
                      
            try{
                
                String valor="cambiarVelocidad " + velocidad;                                                               
                resultado = realizar_operacion(IP_SERVIDOR, PUERTO_SERVIDOR, valor);
                
            }catch(Exception e){
                System.err.println(e);
            }
            
            System.out.print("Fin Cliente");
        
    }
    
    public static boolean verificarLuz(int x, int y, int dir, double vel) throws IOException{
    
        String IP_SERVIDOR=ipS;
        int PUERTO_SERVIDOR=puertoSemaforo;
        String lista[];
        String resultado = null;
                      
            try{
                
                String valor="cv " + x + " " + y + " " + dir + " " + vel;                                                               
                resultado = realizar_operacion(IP_SERVIDOR, PUERTO_SERVIDOR, valor);
                
            }catch(Exception e){
                System.err.println(e);
            }
            
            //System.out.print("Fin Cliente");
        
            boolean pase = true;
            
            if(resultado.equalsIgnoreCase("true")){
                pase = true;
            }else if(resultado.equalsIgnoreCase("false")){
                pase = false;                
            }
            
            return pase;
    }
    
    public static void detenerSimulacion() throws IOException{
    
        String IP_SERVIDOR=ipS;
        int PUERTO_SERVIDOR=puertoSemaforo;
        String lista[];
        String resultado = null;
        
            try{
                
                String valor="detenerSimulacion";                                                               
                resultado = realizar_operacion(IP_SERVIDOR, PUERTO_SERVIDOR, valor);
                
                
//                for(Cruce c : listaCruces){
//                    
//                    System.out.println("Pos x: " + c.getPosX() + " Pos y: " + c.getPosY() + " Estado: " + c.getEstadoLuz());
//                }
                
            }catch(Exception e){
                System.err.println(e);
            }
            
            System.out.print("Fin Cliente");
            
    }
    
     private static String realizar_operacion(String host, int puerto, String valor) {
        String respuesta=null;
        try{
            Socket socketEn=new Socket(host, puerto);
            DataOutputStream salida=new DataOutputStream(new BufferedOutputStream(socketEn.getOutputStream()));
            DataInputStream entrada=new DataInputStream(new BufferedInputStream(socketEn.getInputStream()));
                        
            salida.writeUTF(valor);
            salida.flush();
            respuesta=entrada.readUTF();
            try{
                socketEn.close();
            }catch(Exception ex){}
        }catch(Exception e){
            System.err.println(e);
        }
        return respuesta;
    }
          
     private static ArrayList<Cruce> pedirCruces(String host, int puerto, String valor) {
        String respuesta=null;
        ArrayList<Cruce> listaCruces = new ArrayList<Cruce>();
        
        try{
            System.out.println("Creando socket");
            Socket socketEn=new Socket(host, puerto);
            System.out.println("obteniendo DataInputStream");
            
            
            DataOutputStream salida=new DataOutputStream(new BufferedOutputStream(socketEn.getOutputStream()));
            DataInputStream entrada=new DataInputStream(new BufferedInputStream(socketEn.getInputStream()));
            
            salida.writeUTF(valor);
            System.out.println("Listo para enviar valor String");
            salida.flush();
            System.out.println("Esperando respuesta");
            
            System.out.println("se obtuvo DataInputStream");
            ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(socketEn.getInputStream()));
            ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(socketEn.getOutputStream()));
            
            System.out.println("se obtuvo objectStreams");
            
            
            
            System.out.println("Se obtuvo objectInputStream del Socket");
            listaCruces = (ArrayList<Cruce>)is.readObject();
            System.out.println("Se leyo arreglo de Cruces");
            System.out.println( listaCruces.get(0).getEstadoLuz());
            System.out.println( listaCruces.get(1).getEstadoLuz());
            
            
           
            
            try{
                socketEn.close();
            }catch(Exception ex){}
        }catch(Exception e){
            System.out.println(e);
        }
        return listaCruces;
    }
     
    private static void actualizar(String host, int puerto, String valor) {
        String respuesta=null;
        try{
            Socket socketEn=new Socket(host, puerto);
            DataOutputStream salida=new DataOutputStream(new BufferedOutputStream(socketEn.getOutputStream()));
            DataInputStream entrada=new DataInputStream(new BufferedInputStream(socketEn.getInputStream()));
                        
            salida.writeUTF(valor);
            salida.flush();
            //respuesta=entrada.readUTF();
            try{
                socketEn.close();
            }catch(Exception ex){}
        }catch(Exception e){
            System.err.println(e);
        }
    } 
}

