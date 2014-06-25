/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class VehiculoH {
   public String id;
  public  String fecha;
   public ArrayList<CoordenadaHist> coord;
    
public   VehiculoH(String id, String fecha, ArrayList<CoordenadaHist> coord){
    this.coord=coord;
    this.fecha=fecha;
    this.id=id;
} 
    
    
}
