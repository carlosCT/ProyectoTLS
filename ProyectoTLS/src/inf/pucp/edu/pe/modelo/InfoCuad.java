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
public class InfoCuad {
    private int dia;
    private int mes;
    private int hora;
    private ArrayList<Integer> coord;

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

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public ArrayList<Integer> getCoord() {
        return coord;
    }

    public void setCoord(ArrayList<Integer> coord) {
        this.coord = coord;
    }

    public InfoCuad(int dia, int mes, int hora, ArrayList<Integer> coord) {
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
        this.coord = coord;
    }

        
}
