/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.algoritmoGG;



import inf.pucp.edu.pe.algoritmoEntidades.Vehiculo;
import inf.pucp.edu.pe.algoritmoSimulacion.Simulacion;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Espinoza
 */
public class AlgoritmoDP {

    
    
    public static void main(String[] args) {
        
       Simulacion simulacion = new Simulacion(); 
       simulacion.iniCrucesVias();
       try{
       simulacion.listaCarros = Vehiculo.leerInicioDestino("vehiculos.txt");
       
       for(Vehiculo v : simulacion.listaCarros){
           
           v.establecerViaActual(simulacion);
           
       }
       
       
       }catch(Exception e){
           
           System.out.println(e.toString());
           
       }
       
       AlgoritmoGrasp grasp = new AlgoritmoGrasp();
       grasp.iniciarGrasp(simulacion);
       
       
                
        
    }
}
