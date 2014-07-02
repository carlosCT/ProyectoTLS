/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.controlador;

import inf.pucp.edu.pe.CargaDatos.LeeArchHist;
import inf.pucp.edu.pe.modelo.DiaMes;
import inf.pucp.edu.pe.modelo.InfoCuad;
import java.util.ArrayList;

/**
 *
 * @author fatima
 */
public class ControladorPatron {

    public ArrayList<InfoCuad> listaCuadrantesPat() {

        ArrayList<DiaMes> infoGps = LeeArchHist.datosCargados();

        ArrayList<InfoCuad> listaCuadrantes = new ArrayList<InfoCuad>();

        for (int i = 0; i < infoGps.size(); i++) {
            for (int j = 0; j < infoGps.get(i).getHoras().size(); j++) {
                for (int k = 0; k < infoGps.get(i).getHoras().get(j).getMin().size(); k++) {

                    //seteo el arreglo de posiciones en 0
                    ArrayList<Integer> arrPos = new ArrayList<Integer>();
                    for (int p = 0; p < 160; p++) {
                        int x = 0;
                        arrPos.add(x);
                    }

                    //se carga el arreglo con los puntos en esa hora
                    for (int l = 0; l < infoGps.get(i).getHoras().get(j).getMin().get(k).getSeg().size(); l++) {
                        int r = 0;
                        while (r < infoGps.get(i).getHoras().get(j).getMin().get(k).getSeg().get(l).getCoordenadas().size()) {
                            int x = infoGps.get(i).getHoras().get(j).getMin().get(k).getSeg().get(l).getCoordenadas().get(r);
                            r++;
                            int y = infoGps.get(i).getHoras().get(j).getMin().get(k).getSeg().get(l).getCoordenadas().get(r);

                            int cuadX = x / 6000;
                            int cuadY = y / 4000;
                            int posArr = cuadX + (cuadY * 40);
                            int elm = arrPos.get(posArr);
                            elm++;
                            arrPos.set(posArr, elm);
                            r++;
                        }
                    }

                    //cargara en el arreglo de cuadrantes las zonas mas congestionadas
                    for (int w = 0; w < arrPos.size(); w++) {
                        if (arrPos.get(w) >= 5000) {
                            int ejeX = w % 40;
                            int ejeY = w / 40;
                            ArrayList<Integer> pos = new ArrayList<Integer>();
                            pos.add(ejeX);
                            pos.add(ejeY);
                            ejeX = ejeX + 6000;
                            ejeY = ejeY + 4000;
                            pos.add(ejeX);
                            pos.add(ejeY);
                            int dia = infoGps.get(i).getDia();
                            int mes = infoGps.get(i).getMes();
                            int hora = infoGps.get(i).getHoras().get(j).getHora();

                            InfoCuad infoP = new InfoCuad(dia,mes, hora, pos);
                            listaCuadrantes.add(infoP);
                        }
                    }
                }
            }
        }

        return listaCuadrantes;
    }
}
