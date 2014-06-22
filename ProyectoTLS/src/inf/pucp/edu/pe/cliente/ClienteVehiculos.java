/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.cliente;



import inf.pucp.edu.pe.modelo.Vehiculo;
import java.io.*;
import java.net.*;
import java.util.ArrayList;


/**
 *
 * @author fatima
 */
public class ClienteVehiculos {

    public static String ip = "127.0.0.1";
    public static int puerto = 8001;
    
    public ClienteVehiculos(){
        
    }
    
    private static BufferedReader stdin1=new BufferedReader(new InputStreamReader(System.in));
    private static BufferedReader stdin2=new BufferedReader(new InputStreamReader(System.in));
    
    
    public static void cargarVehiculos(ArrayList<Vehiculo> vehiculos ) throws IOException{
    
        String IP_SERVIDOR=ip;
        int PUERTO_SERVIDOR=puerto;
        String lista[];
        
            try{
                
                String valor="cargarVehiculos";
                lista = valor.split(" ");
                                                                
                enviarVehiculos(IP_SERVIDOR, PUERTO_SERVIDOR, valor, vehiculos);
                System.out.println("Se enviaron los vehiculos");
                                
            }catch(Exception e){
                System.err.println(e);
            }
            
            System.out.print("Fin Cliente");
            
    }
    
    public static ArrayList<Vehiculo> solicitarVehiculos(int xi, int yi, int xf, int yf) throws IOException{
    
        String IP_SERVIDOR=ip;
        int PUERTO_SERVIDOR=puerto;
        String lista[];
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        
            try{
                
                String valor="consultarCuadrante " + xi +" " + yi + " " + xf + " " + yf;
                lista = valor.split(" ");
                                                                
                listaVehiculos = pedirVehiculos(IP_SERVIDOR, PUERTO_SERVIDOR, valor);
                System.out.println("Numero de vehiculos: " + listaVehiculos.size());
                                
            }catch(Exception e){
                System.err.println(e);
            }
            
            System.out.print("Fin Cliente");
        
        return listaVehiculos;
    }
    
        
    public static void actualizarVehiculos() throws IOException{
    
        String IP_SERVIDOR=ip;
        int PUERTO_SERVIDOR=puerto;
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
    
        String IP_SERVIDOR=ip;
        int PUERTO_SERVIDOR=puerto;
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
    
    public static void detenerSimulacion() throws IOException{
    
        String IP_SERVIDOR=ip;
        int PUERTO_SERVIDOR=puerto;
        String lista[];
        String resultado = null;
            try{
                
                String valor="detenerSimulacion";                                                             
                resultado = realizar_operacion(IP_SERVIDOR, PUERTO_SERVIDOR, valor);
                
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
          
     private static ArrayList<Vehiculo> pedirVehiculos(String host, int puerto, String valor) {
        String respuesta=null;
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        
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
            listaVehiculos = (ArrayList<Vehiculo>)is.readObject();
            System.out.println("Se leyo arreglo de Vehiculos");
            
            try{
                socketEn.close();
            }catch(Exception ex){}
        }catch(Exception e){
            System.out.println(e);
        }
        return listaVehiculos;
    }
     
    private static void enviarVehiculos(String host, int puerto, String valor, ArrayList<Vehiculo> listaVehiculos) {
        String respuesta=null;
        
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
            
            System.out.println("Obteniendo ObjectOutputStream");
            //ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(socketEn.getInputStream()));
            ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(socketEn.getOutputStream()));
            System.out.println("Se obtuvo ObjectOutputStream");
            os.writeObject(listaVehiculos);
            System.out.println("Se escribio la lista de vehiculos");
            os.flush();
            System.out.println("Se envio la lista de vehiculos");
            
            try{
                socketEn.close();
            }catch(Exception ex){}
        }catch(Exception e){
            System.out.println(e);
        }
    } 
    
    private static void actualizar(String host, int puerto, String valor) {
        String respuesta=null;
        try{
            Socket socketEn=new Socket(host, puerto);
            DataOutputStream salida=new DataOutputStream(new BufferedOutputStream(socketEn.getOutputStream()));
            DataInputStream entrada=new DataInputStream(new BufferedInputStream(socketEn.getInputStream()));
                        
            salida.writeUTF(valor);
            salida.flush();
            try{
                socketEn.close();
            }catch(Exception ex){}
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
}

