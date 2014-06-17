/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Ruta implements Serializable{
    
    public int horaSalida;
    public ArrayList<Coordernada> ruta;
    
    public Ruta(){};

    public Ruta(int horaSalida,ArrayList<Coordernada> ruta ){
        this.horaSalida= horaSalida;
        this.ruta = ruta;
    };
    
    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public ArrayList<Coordernada> getRuta() {
        return ruta;
    }

    public void setRuta(ArrayList<Coordernada> ruta) {
        this.ruta = ruta;
    }
} 