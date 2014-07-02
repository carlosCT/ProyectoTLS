/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.controlador;

import inf.pucp.edu.pe.CargaDatos.LeeArchHist;
import inf.pucp.edu.pe.modelo.DiaMes;
import java.util.ArrayList;

/**
 *
 * @author fatima
 */
public class ControladorPatron {
    
    public ArrayList<Integer> listaCuadrantesPat(){
    
        ArrayList<DiaMes> infoGps = LeeArchHist.datosCargados();
        
        ArrayList<Integer> listaCuadrantes= new ArrayList<Integer>();
        
        for(int i=0; i<infoGps.size(); i++){
            for(int j=0; j<infoGps.get(i).getHoras().size();j++){
                for (int k=0; k<infoGps.get(i).getHoras().get(j).getMin().size();k++){
                    
                }
            }
        }
        
        return listaCuadrantes;
    }
}
