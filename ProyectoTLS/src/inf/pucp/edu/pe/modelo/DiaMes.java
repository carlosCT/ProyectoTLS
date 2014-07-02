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
public class DiaMes {
    private int dia;
    private int mes;
    private ArrayList<Hora> horas;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public ArrayList<Hora> getHoras() {
        return horas;
    }

    public void setHoras(ArrayList<Hora> horas) {
        this.horas = horas;
    }

    public DiaMes(int dia, int mes, ArrayList<Hora> horas) {
        this.dia = dia;
        this.mes = mes;
        this.horas = horas;
    }
}
