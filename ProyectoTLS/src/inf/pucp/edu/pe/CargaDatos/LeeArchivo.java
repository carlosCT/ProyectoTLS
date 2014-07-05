/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.CargaDatos;

import inf.pucp.edu.pe.cliente.ClienteSemaforos;
import inf.pucp.edu.pe.cliente.ClienteVehiculos;
import inf.pucp.edu.pe.modelo.Coordernada;
import inf.pucp.edu.pe.modelo.Ruta;
import inf.pucp.edu.pe.modelo.Vehiculo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alejandro
 */


public class LeeArchivo {

    public static ArrayList<Vehiculo> autos = new ArrayList<>();
    public  String s;//"/Users/Alejandro/Documents/PUCP/2014-1/dp1/Archivos2";
    public String archact;
    public static boolean ter= false;
        
       
    
public LeeArchivo(String s){
       this.s=s;
};    

 public  void leerFile(File f) throws IOException {

        String id = null;
        ArrayList<Ruta> rutas = new ArrayList<Ruta>();

        if (f.getName().length() > 11) {
            //String name =f.getName();
            archact=f.getName().substring(4, 10);
            
            // System.out.println(archact);
            id = f.getName().substring(4, 10);
            FileReader entrada = null;
            try {
                entrada = new FileReader(f);
            } catch (FileNotFoundException ex) {
            }

            try {
                BufferedReader in;
                in = new BufferedReader(entrada);
                String data ;
                data = in.readLine();
                int tiempo, x, y;
                String hora, min, seg;

                while (data != null && data.length()>8) {
                    
                    hora = data.substring(0, 2);
                    min = data.substring(3, 5);
                    seg = data.substring(6, 8);

                    tiempo = Integer.parseInt(hora) * 3600 + Integer.parseInt(min) * 60 + Integer.parseInt(seg);
                    data = data.substring(9);
                    ArrayList<Coordernada> listcor = new ArrayList<Coordernada>();
                    while (data.length() > 0) {
                        int pos = data.indexOf(",");
                        x = Integer.parseInt(data.substring(0, pos));
                        data = data.substring(pos + 1);

                        pos = data.indexOf(",");
                        if (pos == -1) {
                            pos = data.indexOf("*");
                            y = Integer.parseInt(data.substring(0, pos));
                            

                        }
                        y = Integer.parseInt(data.substring(0, pos));
                        data = data.substring(pos + 1);
                        Coordernada cor = new Coordernada(x, y);
                        listcor.add(cor);
//        System.out.print(x);
//        System.out.print(",");
//        System.out.print(y);
//        System.out.print("\n");

                    }

//System.out.println(data); 
                    Ruta ruta = new Ruta(tiempo, listcor);
                    rutas.add(ruta);

                    data = in.readLine();
                }

            } catch (IOException e) {
                System.out.println("no se encontro!");
            }
             try {
            entrada.close();
        } catch (IOException ex) {}
        }
        
        Vehiculo vehiculo = new Vehiculo(id, rutas);
        autos.add(vehiculo);
    }

 
 public  void imprimir(){
     for(int i=0;i<autos.size();i++){
         System.out.println(autos.get(i).id);
         for(int j=0;j<autos.get(i).rutas.size();j++){
             System.out.println(autos.get(i).rutas.get(j).horaSalida);
            //System.out.print(" ");
             for(int k=0;k<autos.get(i).rutas.get(j).ruta.size();k++){
              //System.out.print(autos.get(i).rutas.get(j).ruta.get(k).x);  
              //System.out.print(",");
              //System.out.print(autos.get(i).rutas.get(j).ruta.get(k).y); 
              //System.out.print("\n");
             }
         }
         
     }
 }
 
    public void Cargar() throws IOException  {
        File directorio = new File(s);
        String[] listaDirectorio = directorio.list();
        
  if (listaDirectorio == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            for (int x = 1; x <10000; x++)
        //    for (int x = 1; x <listaDirectorio.length; x++) //System.out.println(listaDirectorio[x]);                      
            {
                try {
                    leerFile(new File(s + "/" + listaDirectorio[x]));
                } catch (IOException ex) {
                    Logger.getLogger(LeeArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        this.ter=true;
        
       //ClienteVehiculos.cargarVehiculos(autos);
      
       // ClienteVehiculos.actualizarVehiculos();
       //imprimir();
        
    }
    


     
    }

    /**
     * @return the s
     */
  
    
}
