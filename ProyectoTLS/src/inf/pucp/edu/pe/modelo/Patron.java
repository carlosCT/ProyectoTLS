/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fatima
 */
public class Patron {

    private int dia;
    private int mes;
    private int anho;
    private int hora;
    private String diaSemana;
    private ArrayList<Integer> confSemaf;  //tiempo verde y rojo de cada uno de los semaforos en el cuadrante del patron
    private ArrayList<Integer> Sem; //posicion X, posicion Y de cada uno de los semaforos en el cuadrante del patron

    public ArrayList<Integer> getSem() {
        return Sem;
    }

    public void setSem(ArrayList<Integer> Sem) {
        this.Sem = Sem;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the diaSemana
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * @param diaSemana the diaSemana to set
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * @return the confSemaf
     */
    public ArrayList<Integer> getConfSemaf() {
        return confSemaf;
    }

    /**
     * @param confSemaf the confSemaf to set
     */
    public void setConfSemaf(ArrayList<Integer> confSemaf) {
        this.confSemaf = confSemaf;
    }

    /**
     * @return the anho
     */
    public int getAnho() {
        return anho;
    }

    /**
     * @param anho the anho to set
     */
    public void setAnho(int anho) {
        this.anho = anho;
    }
}
