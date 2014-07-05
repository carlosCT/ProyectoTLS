/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.CargaDatos;

import static inf.pucp.edu.pe.CargaDatos.LeeArchivo.autos;

import inf.pucp.edu.pe.controlador.ControladorPatron;
import inf.pucp.edu.pe.modelo.CoordenadaHist;
import inf.pucp.edu.pe.modelo.Coordernada;
import inf.pucp.edu.pe.modelo.DiaMes;
import inf.pucp.edu.pe.modelo.Hora;
import inf.pucp.edu.pe.modelo.Min;
import inf.pucp.edu.pe.modelo.Ruta;
import inf.pucp.edu.pe.modelo.Seg;
import inf.pucp.edu.pe.modelo.Vehiculo;
import inf.pucp.edu.pe.modelo.VehiculoH;
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



public class LeeArchHist {
      public static ArrayList<VehiculoH> autosH = new ArrayList<>();

public ArrayList<DiaMes> diaMes= null;
    public  String s;//"/Users/Alejandro/Documents/PUCP/2014-1/dp1/ArchivosHistoricos";
    public String archact;
    
    public static boolean ter= false;  
    
    public LeeArchHist(String s){
       this.s=s;
}; 
    
public  void leerFile(File f) throws IOException {

        String id = null;
         String fecha=null;
ArrayList<CoordenadaHist> rutas = new ArrayList<CoordenadaHist>();
        if (f.getName().length() > 11) {
            String name =f.getName().substring(4, 19);;
            archact=f.getName().substring(4, 19);
            
            // System.out.println(archact);
            id = f.getName().substring(4, 10);
             fecha = f.getName().substring(11, 19);
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

                while (data != null && data.length()>5) {
                    
                    hora = data.substring(0, 2);
                    min = data.substring(3, 5);
                    seg = data.substring(6, 8);

                    tiempo = Integer.parseInt(hora) * 3600 + Integer.parseInt(min) * 60 + Integer.parseInt(seg);
                    data = data.substring(9);
                    
                    
                        int pos = data.indexOf(",");
                        x = Integer.parseInt(data.substring(0, pos));
                        data = data.substring(pos + 1);
                        y=Integer.parseInt(data);
                    
                    CoordenadaHist cor = new CoordenadaHist(tiempo,x,y);

                    rutas.add(cor);

                    data = in.readLine();
                }
          VehiculoH vehiculo = new VehiculoH(id, fecha,rutas);
        autosH.add(vehiculo);

            } catch (IOException e) {
                System.out.println("no se encontro!");
            }
             try {
            entrada.close();
        } catch (IOException ex) {}
        }
        

    }

 
 public  void imprimir(){
     System.out.println();
     for(int i=0;i<autosH.size();i++){
         System.out.println(autosH.get(i).id);
         System.out.println(autosH.get(i).fecha);
         for(int j=0; j<autosH.get(i).coord.size();j++){
             System.out.print(autosH.get(i).coord.get(j).hora);
             System.out.print(":");
             System.out.print(autosH.get(i).coord.get(j).x);
             System.out.print(",");
             System.out.println(autosH.get(i).coord.get(j).y);
         }
         System.out.println("---");
         
     }
 }
 
    public void Cargar() throws IOException  {
        File directorio = new File(s);
        String[] listaDirectorio = directorio.list();
        
  if (listaDirectorio == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            //for (int x = 1; x <1000; x++)
            for (int x = 1; x <listaDirectorio.length; x++) //System.out.println(listaDirectorio[x]);                      
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
    
    public void CambiaEstructura(){
        ArrayList<Integer> nodos = new ArrayList<Integer>();
        ArrayList<Seg> segs = new ArrayList<Seg>();

        for (int i = 0; i < 60; i++){
            Seg s=new Seg();
            s.setSeg(i+1);
            s.setCoordenadas(nodos);
        }
        
        ArrayList<Min> mins = new ArrayList<Min>();
        
        for (int j=0; j<60; j++){
            Min m= new Min();
            m.setMin(j+1);
            m.setSeg(segs);
        }
        
        ArrayList<Hora> horas = new ArrayList<Hora>();
     
        for(int k=0; k<24; k++){
            Hora h = new Hora();
            h.setHora(k+1);
            h.setMin(mins);
        }
        
         diaMes = new ArrayList<DiaMes>();
        
        for (int mes=0; mes<12; mes++){
            for (int d=0; d<30; d++){
                DiaMes dM= new DiaMes();
                dM.setDia(d+1);
                dM.setMes(mes+1);
                dM.setHoras(horas);
            }
        }
        
        
        int dia,mes,hora,min,seg,x,y;
       for(int i=0;i<autosH.size();i++){
           mes=Integer.parseInt(autosH.get(i).fecha.substring(5,6));
           dia=Integer.parseInt(autosH.get(i).fecha.substring(7,8));
           for(int j=0; j<autosH.get(i).coord.size();j++){
               hora=autosH.get(i).coord.get(j).hora/3600;
               min=(autosH.get(i).coord.get(j).hora % 3600)/60;
               seg=autosH.get(i).coord.get(j).hora-(min*60);
               x=autosH.get(i).coord.get(j).x;
               y=autosH.get(i).coord.get(j).y;
               diaMes.get(mes*30+dia -1).getHoras().get(hora).getMin().get(min).getSeg().get(seg).getCoordenadas().add(x);
               diaMes.get(mes*30+dia -1).getHoras().get(hora).getMin().get(min).getSeg().get(seg).getCoordenadas().add(y);
               
           }
           
     }
       ControladorPatron cp = new ControladorPatron(diaMes);
    }
    
}
