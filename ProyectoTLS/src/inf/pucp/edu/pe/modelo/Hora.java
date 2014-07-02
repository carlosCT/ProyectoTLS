/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.modelo;

import java.util.ArrayList;

/**
 *
 * @author fatima
 */
public class Hora {
    private int hora;
    private ArrayList<Min> min;

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public ArrayList<Min> getMin() {
        return min;
    }

    public void setMin(ArrayList<Min> min) {
        this.min = min;
    }

    public Hora(int hora, ArrayList<Min> min) {
        this.hora = hora;
        this.min = min;
    }
}
